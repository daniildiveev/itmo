SELECT P.ИД, S.ДАТА
FROM Н_СЕССИЯ S RIGHT JOIN Н_ЛЮДИ P ON S.СЭС_ИД=P.ИД;

SELECT *
FROM Н_СЕССИЯ;

SELECT *
FROM Н_ЛЮДИ;
