CREATE TABLE IF NOT EXISTS "FormEducation"
(
    id          SERIAL PRIMARY KEY,
    createdAt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "_nameForm" VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS "Qualification"
(
    id                   SERIAL PRIMARY KEY,
    createdAt            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "_nameQualification" VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS "Group"
(
    id                 SERIAL PRIMARY KEY,
    createdAt          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "_idSpeciality"    VARCHAR(255),
    "_idQualification" VARCHAR(255),
    "_idFormEducation" VARCHAR(255),
    "_idFaculty"       VARCHAR(255),
    "_idName"          VARCHAR(255),
    "_idCourse"        VARCHAR(255),
    "_idCountStudent"  VARCHAR(255),
    "_idCountSubgroup" VARCHAR(255),
    FOREIGN KEY ("_idSpeciality") REFERENCES "Speciality" (id),
    FOREIGN KEY ("_idQualification") REFERENCES "Qualification" (id),
    FOREIGN KEY ("_idFormEducation") REFERENCES "FormEducation" (id)
);

CREATE TABLE IF NOT EXISTS "Speciality"
(
    id                SERIAL PRIMARY KEY,
    createdAt         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "_nameSpeciality" VARCHAR(255),
    "_profile"        VARCHAR(255)
);