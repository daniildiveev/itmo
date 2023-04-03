CREATE TABLE IF NOT EXISTS spheres_of_work(
    id SERIAL primary key,
    name VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS education_level(
    id SERIAL primary key,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS profession(
    id SERIAL primary key,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS health_status(
    id SERIAL primary key,
    status VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS location(
    id SERIAL primary key,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS person(
    id SERIAL primary key,
    name VARCHAR(40) NOT NULL,
    location INT REFERENCES LOCATION(ID),
    age INT,
    sphere INT REFERENCES SPHERES_OF_WORK(ID),
    physical_condition INT REFERENCES HEALTH_STATUS(ID),
    profession INT REFERENCES PROFESSION(ID),
    education_level INT REFERENCES EDUCATION_LEVEL(ID)
);

CREATE TABLE IF NOT EXISTS person_location(
    person INT REFERENCES PERSON(ID),
    location INT REFERENCES LOCATION(ID),
    how_long_have_been INTERVAL
);

CREATE TABLE IF NOT EXISTS tasks(
    id SERIAL primary key,
    task_date DATE,
    description VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS person_task(
    person INT REFERENCES PERSON(ID),
    task INT REFERENCES TASKS(ID)
);

CREATE TABLE IF NOT EXISTS problems(
    id SERIAL primary key,
    description VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS problem_person(
    person INT REFERENCES PERSON(ID),
    problem INT REFERENCES PROBLEMS(ID)
);

CREATE TABLE IF NOT EXISTS limbs(
    id SERIAL primary key,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS limbs_person(
    person INT REFERENCES person(ID),
    limb INT REFERENCES limbs(ID)
);