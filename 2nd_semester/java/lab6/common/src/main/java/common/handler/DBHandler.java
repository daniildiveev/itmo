package common.handler;

import common.entities.Route;
import common.exceptions.UserException;
import common.network.User;

import java.sql.*;
import java.util.PriorityQueue;

public class DBHandler {
    private static final String jdbcUrl = System.getenv("DATABASE_URL");
    private static final String username = System.getenv("DATABASE_USERNAME");
    private static final String password = System.getenv("DATABASE_PASSWORD");

    static {
        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            try(Statement stmt = connection.createStatement()){
                String createUsersTable = "CREATE TABLE IF NOT EXISTS users" +
                                           "(username VARCHAR(100), password VARCHAR(64));";

                stmt.execute(createUsersTable);

                String createRoutesTable = "CREATE TABLE IF NOT EXISTS routes" +
                                           "(id SERIAL PRIMARY KEY, route_name TEXT, " +
                                           "coordinates_x INT, coordinates_y INT," +
                                           "date_created TIMESTAMP, " +
                                           "from_x INT, from_y FLOAT, from_z DOUBLE, from_name TEXT," +
                                           "to_x INT, to_y FLOAT, to_z DOUBLE, to_name TEXT," +
                                           "distance INT, username TEXT);";

                stmt.execute(createRoutesTable);
            }
        } catch (SQLException e){
            IOHandler.println(e.getMessage());
            System.exit(0);
        }
    }

    public static Connection getConnection(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e){
            IOHandler.println("Could not connect to database: " + e.getMessage());
            System.exit(0);
        }

        return connection;
    }

    public static User checkUserPresence(User user){
        Connection connection = getConnection();

        String selectUserQuery = "SELECT * FROM users WHERE username = ? LIMIT 1";

        try (PreparedStatement stmt = connection.prepareStatement(selectUserQuery)){
            stmt.setString(1, user.getUsername());

            try (ResultSet resultSet = stmt.executeQuery()){
                if (resultSet.next()){
                    return new User(resultSet.getString(1), resultSet.getString(2));
                }
            }
        } catch (SQLException e){
            IOHandler.println(e.getMessage());
        }

        return null;
    }

    public static User createUser(User user) throws UserException {
        if(checkUserPresence(user) != null){
            throw new UserException("user already exists");
        }

        String addUserQuery = "INSERT INTO users VALUES(?, ?);";

        try(Connection connection = getConnection()){
            try (PreparedStatement stmt = connection.prepareStatement(addUserQuery)){
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());

                stmt.executeUpdate();
            }
        } catch (SQLException e){
            return null;
        }

        return user;
    }

    public static boolean checkUserPassword(User userToCheck) throws UserException{
        User user = checkUserPresence(userToCheck);

        if (user != null){
            return user.getPassword().equals(userToCheck.getPassword());
        } else{
            throw new UserException("user does not exist");
        }
    }

    public static Route createRoute(Route route, User user){
        String addRouteQuery = "INSERT INTO routes(id, route_name, coordinates_x, coordinates_y, date_created, from_x, from_y, from_z, from_name," +
                                "to_x, to_y, to_z, to_name, distance, username) VALUES (DEFAULT, ?,?,?, CURRENT_TIMESTAMP,?,?,?,?,?,?,?,?,?,?)" +
                                "RETURNING id, date_created;";

        try(Connection connection = getConnection()){
            try (PreparedStatement stmt = connection.prepareStatement(addRouteQuery)){
                stmt.setString(1, route.getName());
                stmt.setInt(2, route.getCoordinates().getX().intValue());
                stmt.setInt(3, route.getCoordinates().getY());
                stmt.setInt(4, route.getFrom().getX());

                if (route.getFrom().getY() == null){
                    stmt.setNull(5, Types.DOUBLE);
                } else {
                    stmt.setFloat(5, route.getFrom().getY());
                }

                if (route.getFrom().getZ() == null){
                    stmt.setNull(6, Types.FLOAT);
                } else {
                    stmt.setDouble(6, route.getFrom().getZ());
                }

                stmt.setString(7, route.getFrom().getLocationName());
                stmt.setInt(8, route.getTo().getX());

                if (route.getTo().getY() == null){
                    stmt.setNull(9, Types.DOUBLE);
                } else {
                    stmt.setFloat(9, route.getFrom().getY());
                }

                if (route.getTo().getZ() == null){
                    stmt.setNull(10, Types.FLOAT);
                } else {
                    stmt.setDouble(10, route.getFrom().getZ());
                }

                stmt.setString(11, route.getTo().getLocationName());
                stmt.setInt(12, (int) route.getDistance());
                stmt.setString(13, user.getUsername());

                try (ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        route.setId(rs.getInt(1));
                        route.setCreationDate(rs.getTimestamp(2).toLocalDateTime());

                        return route;
                    }
                }
            }
        } catch (SQLException e){
            IOHandler.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            return null;
        }

        return null;
    }

    public static PriorityQueue<Route> loadCollectionToMemory(){
        String getAllRoutesQuery = "SELECT * FROM routes;";
        PriorityQueue<Route> collection = new PriorityQueue<>();

        try(Connection connection = getConnection()){
            try(PreparedStatement stmt = connection.prepareStatement(getAllRoutesQuery)){
                try(ResultSet rs = stmt.executeQuery()){
                    while(rs.next()){
                        Route route = new Route(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getLong(3),
                                rs.getInt(4),
                                rs.getTimestamp(5).toLocalDateTime(),
                                rs.getInt(6),
                                rs.getFloat(7),
                                rs.getDouble(8),
                                rs.getString(9),
                                rs.getInt(10),
                                rs.getFloat(11),
                                rs.getDouble(12),
                                rs.getString(13),
                                rs.getLong(14)
                        );

                        collection.add(route);
                    }

                    return collection;
                }
            }
        } catch (SQLException e){
            IOHandler.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        return null;
    }
}
