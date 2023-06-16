SELECT ved_types."ИД", ved."ЧЛВК_ИД"
FROM "Н_ВЕДОМОСТИ" ved INNER JOIN "Н_ТИПЫ_ВЕДОМОСТЕЙ" ved_types ON ved."ТВ_ИД" = ved_types."ИД"
WHERE "НАИМЕНОВАНИЕ" > 'Ведомость' AND "ЧЛВК_ИД" > 163249 AND "ЧЛВК_ИД" < 142390;

SELECT p."ИМЯ", e."ЧЛВК_ИД", st."НАЧАЛО"
FROM "Н_ЛЮДИ" p RIGHT JOIN "Н_ОБУЧЕНИЯ" e ON p."ИД" = e."ЧЛВК_ИД"
                RIGHT JOIN "Н_УЧЕНИКИ" st ON e."ЧЛВК_ИД" = st."ЧЛВК_ИД"
WHERE p."ОТЧЕСТВО" > 'Сергеевич' AND e."НЗК" < '933232';

EXPLAIN ANALYZE SELECT ved_types."ИД", ved."ЧЛВК_ИД"
FROM "Н_ВЕДОМОСТИ" ved INNER JOIN "Н_ТИПЫ_ВЕДОМОСТЕЙ" ved_types ON ved."ТВ_ИД" = ved_types."ИД"
WHERE "НАИМЕНОВАНИЕ" > 'Ведомость' AND "ЧЛВК_ИД" > 163249 AND "ЧЛВК_ИД" < 142390;

EXPLAIN ANALYZE SELECT p."ИМЯ", e."ЧЛВК_ИД", st."НАЧАЛО"
FROM "Н_ЛЮДИ" p RIGHT JOIN "Н_ОБУЧЕНИЯ" e ON p."ИД" = e."ЧЛВК_ИД"
                RIGHT JOIN "Н_УЧЕНИКИ" st ON e."ЧЛВК_ИД" = st."ЧЛВК_ИД"
WHERE p."ОТЧЕСТВО" > 'Сергеевич' AND e."НЗК" < '933232';