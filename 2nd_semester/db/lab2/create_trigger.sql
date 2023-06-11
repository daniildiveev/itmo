CREATE TABLE IF NOT EXISTS person_history(
    id SERIAL PRIMARY KEY,
    person_id INT,
    name VARCHAR(40) NOT NULL,
    age INT,
    sphere INT,
    physical_condition INT,
    profession INT,
    education_level INT,
    record_time TIMESTAMP,
    trigger_operation varchar(10)
);


CREATE OR REPLACE FUNCTION record_person_change()
RETURNS TRIGGER AS $$
    DECLARE time TIMESTAMP DEFAULT NOW();
    BEGIN
        INSERT INTO person_history
        VALUES (DEFAULT, OLD.id, OLD.name, OLD.age, OLD.sphere, OLD.physical_condition, OLD.profession, OLD.education_level, time, tg_op);
        RETURN NEW;
    END;
    $$ LANGUAGE plpgsql;

CREATE TRIGGER TR_person_change_BU
BEFORE UPDATE ON person
FOR EACH ROW
EXECUTE FUNCTION record_person_change();