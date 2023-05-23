INSERT INTO spheres_of_work VALUES
    (DEFAULT, 'связи с общественностью'),
    (DEFAULT, 'химическая промышленность'),
    (DEFAULT, 'IT');

INSERT INTO education_level VALUES
    (DEFAULT, 'профессор'),
    (DEFAULT, 'студент'),
    (DEFAULT, 'школьник'),
    (DEFAULT, 'бакалавр');

INSERT INTO profession VALUES
    (DEFAULT, 'ген подрядчик'),
    (DEFAULT, 'рабочий завода'),
    (DEFAULT, 'охранник'),
    (DEFAULT, 'помощник');

INSERT INTO health_status VALUES
    (DEFAULT, 'здоровый'),
    (DEFAULT, 'мертв'),
    (DEFAULT, 'болеющий');

INSERT INTO location VALUES
    (DEFAULT, 'остров'),
    (DEFAULT, 'город'),
    (DEFAULT, 'пустыня'),
    (DEFAULT, 'завод');

INSERT INTO person (id, name, age, sphere, physical_condition, profession, education_level) VALUES
    (DEFAULT, 'Хардинг', 37, 1, 1, 1, 4),
    (DEFAULT, 'Оуэнз', 34, 1, 2, 1, 4),
    (DEFAULT, 'Эд Реджис', 40, 2, 1, 2, 4),
    (DEFAULT, 'Вадик', 7, null, 1, null, 3),
    (DEFAULT, 'Костик', 8, null, 1, null, 3);

INSERT INTO person_location VALUES
    (DEFAULT, 3, 1, make_interval(0, 7)),
    (DEFAULT, 2, 4, make_interval(0, 0, 0, 0, 1));

INSERT INTO tasks (id, task_date, description) VALUES
    (DEFAULT, make_date(1999, 1, 1), 'Серьезное дело на острове'),
    (DEFAULT, make_date(1999, 2, 3), 'Уволить половину работников завода'),
    (DEFAULT, make_date(1999, 3, 3), 'Экскурсия с детьми');

INSERT INTO person_task VALUES
    (DEFAULT, 1, 1),
    (DEFAULT, 2, 1),
    (DEFAULT, 3, 1),
    (DEFAULT, 2, 2),
    (DEFAULT, 3, 3);

INSERT INTO problems VALUES
    (DEFAULT, 'Не понимать что ты профессионал!'),
    (DEFAULT, 'Приближающаеся наводнение'),
    (DEFAULT, 'Не хватает одного ребенка!');

INSERT INTO problem_person VALUES
    (DEFAULT, 1, 1),
    (DEFAULT, 2, 1),
    (DEFAULT, 3, 3),
    (DEFAULT, 1, 2),
    (DEFAULT, 2, 2),
    (DEFAULT, 3, 2);

INSERT INTO limbs VALUES
    (DEFAULT, 'голова'),
    (DEFAULT, 'нога'),
    (DEFAULT, 'рука');

INSERT INTO limbs_person VALUES
    (DEFAULT, 4, 1),
    (DEFAULT, 4, 2),
    (DEFAULT, 4, 3),
    (DEFAULT, 5, 2),
    (DEFAULT, 5, 3);