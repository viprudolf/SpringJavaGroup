-- Вставка базовых данных в таблицу "FormEducation"
INSERT INTO "FormEducation" ("_nameForm")
VALUES ('Форма обучения 1'),
       ('Форма обучения 2'),
       ('Форма обучения 3');

-- Вставка базовых данных в таблицу "Qualification"
INSERT INTO "Qualification" ("_nameQualification")
VALUES ('Квалификация 1'),
       ('Квалификация 2'),
       ('Квалификация 3');

-- Вставка базовых данных в таблицу "Group"
INSERT INTO "Group" ("_idSpeciality", "_idQualification", "_idFormEducation", "_idFaculty", "_idName", "_idCourse", "_idCountStudent", "_idCountSubgroup")
VALUES ('1', '1', '1', 'Факультет 1', 'Группа 1', '1 курс', '100', '2'),
       ('2', '2', '2', 'Факультет 2', 'Группа 2', '2 курс', '80', '1'),
       ('3', '3', '3', 'Факультет 3', 'Группа 3', '3 курс', '120', '3');

-- Вставка базовых данных в таблицу "Speciality"
INSERT INTO "Speciality" ("_nameSpeciality", "_profile")
VALUES ('Специальность 1', 'Профиль 1'),
       ('Специальность 2', 'Профиль 2'),
       ('Специальность 3', 'Профиль 3');