INSERT INTO SOCIAL_STATUS VALUES 
    (1, 'дети'),
    (2, 'рабочий'),
    (3, 'начальник'),
    (4, 'безработный');

INSERT INTO LOCATION VALUES
    (1, 'остров'),
    (2, 'город'),
    (3, 'пустыня');

INSERT INTO PERSON VALUES
    (1, 'Хардинг', 2, 3),
    (2, 'Оуэнз', 2, 3),
    (3, 'Эд Реджис', 1, 2);

INSERT INTO TASKS VALUES
    (1, 1, MAKE_DATE(1999, 1, 1), 'Серьезное дело на острове'), 
    (2, 2, MAKE_DATE(1999, 2, 3), 'Уволить половину работников завода');