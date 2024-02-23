insert into Form_education (created_At, name_Form)
values
    (CURRENT_TIMESTAMP, 'Form 1'),
    (CURRENT_TIMESTAMP, 'Form 2'),
    (CURRENT_TIMESTAMP, 'Form 3'),
    (CURRENT_TIMESTAMP, 'Form 4'),
    (CURRENT_TIMESTAMP, 'Form 5');

insert into Qualification (created_At, name_Qualification)
values
    (CURRENT_TIMESTAMP, 'Qualification 1'),
    (CURRENT_TIMESTAMP, 'Qualification 2'),
    (CURRENT_TIMESTAMP, 'Qualification 3'),
    (CURRENT_TIMESTAMP, 'Qualification 4'),
    (CURRENT_TIMESTAMP, 'Qualification 5');

insert into Speciality (created_At, name_Speciality, profile)
values
    (CURRENT_TIMESTAMP, 'Speciality 1', 'Profile 1'),
    (CURRENT_TIMESTAMP, 'Speciality 2', 'Profile 2'),
    (CURRENT_TIMESTAMP, 'Speciality 3', 'Profile 3'),
    (CURRENT_TIMESTAMP, 'Speciality 4', 'Profile 4'),
    (CURRENT_TIMESTAMP, 'Speciality 5', 'Profile 5');

INSERT INTO GGroup (created_At, id_Speciality, id_Qualification, id_FormEducation, id_Faculty, id_Name, id_Course, id_CountStudent, id_CountSubgroup)
SELECT
            CURRENT_TIMESTAMP,
            (SELECT id FROM Speciality ORDER BY RAND() LIMIT 1),
            (SELECT id FROM Qualification ORDER BY RAND() LIMIT 1),
            (SELECT id FROM Form_education ORDER BY RAND() LIMIT 1),
            CONCAT('Faculty ', FLOOR(RAND() * 10) + 1),
            CONCAT('Name ', FLOOR(RAND() * 10) + 1),
            CONCAT('Course ', FLOOR(RAND() * 5) + 1),
            CONCAT('CountStudent ', FLOOR(RAND() * 100) + 1),
            CONCAT('CountSubgroup ', FLOOR(RAND() * 5) + 1)
FROM
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5) AS t;