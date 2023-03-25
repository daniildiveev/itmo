INSERT INTO spheres_of_work VALUES
    (1, 'связи с общественностью'),
    (2, 'химическая промышленность'),
    (3, 'IT');

INSERT INTO education_level VALUES
    (1, 'профессор'),
    (2, 'студент'),
    (3, 'школьник'),
    (4, 'бакалавр');

INSERT INTO profession VALUES
    (1, 'ген подрядчик'),
    (2, 'рабочий завода'),
    (3, 'охранник'),
    (4, 'помощник');

INSERT INTO health_status VALUES
    (1, 'здоровый'),
    (2, 'мертв'),
    (3, 'болеющий');

INSERT INTO location VALUES
    (1, 'остров'),
    (2, 'город'),
    (3, 'пустыня'),
    (4, 'завод');

INSERT INTO person (id, name, location, age, sphere, physical_condition, profession, education_level) VALUES
    (1, 'Хардинг', 2, 37, 1, 1, 1, 4),
    (2, 'Оуэнз', 2, 34, 1, 2, 1, 4),
    (3, 'Эд Реджис', 1, 40, 2, 1, 2, 4);

INSERT INTO person_location VALUES
    (3, 1, make_interval(0, 7)),
    (2, 4, make_interval(0, 0, 0, 0, 1));

INSERT INTO tasks (id, date, description) VALUES
    (1, make_date(1999, 1, 1), 'Серьезное дело на острове'),
    (2, make_date(1999, 2, 3), 'Уволить половину работников завода'),
    (3, make_date(1999, 3, 3), 'Экскурсия с детьми');

INSERT INTO person_task VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (2, 2),
    (3, 3);

INSERT INTO problems VALUES
    (1, 'Не понимать что ты профессионал!'),
    (2, 'Приближающаеся наводнение'),
    (3, 'Не хватает одного ребенка!');

INSERT INTO problem_person VALUES
    (1, 1),
    (2, 1),
    (3, 3),
    (1, 2),
    (2, 2),
    (3, 2);

