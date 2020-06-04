-- CREATE TABLE PERSON (
--     ID         INTEGER PRIMARY KEY,
--     NAME_FIRST VARCHAR(20) NOT NULL,
--     NAME_LAST  VARCHAR(20) NOT NULL
-- );
--
-- CREATE TABLE PRINCIPAL (
--     ID                  INTEGER PRIMARY KEY,
--     ID_PERSON_OWNER     INTEGER      NOT NULL,
--     NAME                VARCHAR(256) NOT NULL,
--     DATETIME_CREATED    DATETIME     NOT NULL,
--     DATETIME_SUPERSEDED DATETIME,
--     FOREIGN KEY (ID_PERSON_OWNER) REFERENCES PERSON(ID),
--     UNIQUE (ID_PERSON_OWNER, NAME)
-- );
--
-- CREATE TABLE APPLICATION (
--     ID         INTEGER PRIMARY KEY,
--     NAME       VARCHAR(256) NOT NULL,
--     IDENTIFIER VARCHAR(256) NOT NULL,
-- );
--
-- CREATE TABLE REPO (
--     ID                  INTEGER PRIMARY KEY,
--     NAME                VARCHAR(256) NOT NULL,
--     ID_APPLICATION      INTEGER      NOT NULL,
--     DATETIME_CREATED    DATETIME     NOT NULL,
--     DATETIME_SUPERSEDED DATETIME,
--     FOREIGN KEY (ID_APPLICATION) REFERENCES APPLICATION(ID)
-- );
--
-- CREATE TABLE MAP_PRINCIPAL_REPO (
--     ID                  INTEGER PRIMARY KEY,
--     ID_PRINCIPAL        INTEGER      NOT NULL,
--     ID_REPO             INTEGER      NOT NULL,
--     PERMISSION          VARCHAR(256) NOT NULL,
--     PERMISSION_BITS     INTEGER      NOT NULL,
--     DATETIME_CREATED    DATETIME     NOT NULL,
--     DATETIME_SUPERSEDED DATETIME
-- );
--


INSERT
INTO PERSON (ID, NAME_FIRST, NAME_LAST)
VALUES (1, 'Alex', 'Megremis'),
       (2, 'Zoe', 'Megremis'),
       (3, 'Thomas', 'Megremis'),
       (4, 'Watson', 'Megremis'),
       (5, 'Olive', 'Megremis'),
       (11, 'Alex', 'Nguyen'),
       (12, 'Zoe', 'Nguyen'),
       (13, 'Thomas', 'Nguyen'),
       (14, 'Watson', 'Nguyen'),
       (15, 'Olive', 'Nguyen');

INSERT
INTO PRINCIPAL(ID, ID_PERSON_OWNER, NAME, DATETIME_CREATED, DATETIME_SUPERSEDED)
VALUES (1, 1, 'amegremis', '2020-01-15', NULL),
       (2, 1, 'alexam', '2020-01-29', NULL),
       (3, 2, 'cnguyen', '2020-02-01', NULL),
       (4, 3, 'oktomas', '2020-02-01', NULL),
       (11, 1, 'anguyen', '2020-01-15', NULL),
       (12, 1, 'alexan', '2020-01-29', NULL),
       (13, 2, 'ctnguyen', '2020-02-01', NULL),
       (14, 3, 'beetroottomas', '2020-02-01', NULL);

INSERT
INTO APPLICATION(ID, NAME, IDENTIFIER)
VALUES (1, 'Core Application', 'CORE01'),
       (2, 'Front end', 'FRONT01'),
       (3, 'Persistence', 'PERSISTENCE01'),
       (4, 'Old Crap', 'OLDCRAP01');

INSERT
INTO REPO (ID, ID_APPLICATION, NAME, DATETIME_CREATED, DATETIME_SUPERSEDED)
VALUES (1, 1, 'REPO01', '2020-01-15', NULL),
       (2, 2, 'UI-BASE', '2020-01-22', NULL),
       (3, 1, 'MYPOC', '2020-01-23', NULL),
       (4, 4, 'REPO02', '2020-02-15', NULL),
       (5, 4, 'REPO03', '2020-03-22', NULL),
       (6, 3, 'REPO12', '2020-04-23', NULL);

INSERT
INTO MAP_PRINCIPAL_REPO(ID, ID_PRINCIPAL, ID_REPO, PERMISSION, PERMISSION_BITS, DATETIME_CREATED, DATETIME_SUPERSEDED)
VALUES (1, 1, 1,  'WRITE', 2, '2020-01-15', '2020-01-20'),
       (2, 1, 1,  'ADMIN', 4, '2020-01-20', NULL),
       (3, 2, 1,  'WRITE', 2, '2020-01-20', NULL),
       (4, 1, 2,  'ADMIN', 4, '2020-01-22', NULL),
       (5, 1, 3,  'ADMIN', 4, '2020-02-23', NULL),
       (6, 3, 1,  'READ',  1, '2020-02-27', NULL),
       (7, 3, 2,  'READ',  1, '2020-02-27', NULL),
       (8, 3, 3,  'READ',  1, '2020-02-27', NULL),
       (9, 4, 1,  'WRITE', 2, '2020-02-27', NULL),
       (10, 14, 2, 'WRITE', 4,  '2020-02-27', NULL),
       (11, 11, 1,  'WRITE', 2, '2020-01-15', '2020-01-20'),
       (12, 11, 1,  'ADMIN', 4, '2020-01-20', NULL),
       (13, 12, 1,  'WRITE', 2, '2020-01-20', NULL),
       (14, 11, 2,  'ADMIN', 4, '2020-01-22', NULL),
       (15, 11, 3,  'ADMIN', 4, '2020-02-23', NULL),
       (16, 13, 1,  'READ',  5, '2020-02-27', NULL),
       (17, 13, 2,  'READ',  1, '2020-02-27', NULL),
       (18, 13, 3,  'READ',  6, '2020-02-27', NULL),
       (19, 14, 1,  'WRITE', 2, '2020-02-27', NULL),
       (20, 14, 2, 'WRITE', 4,  '2020-02-27', NULL);