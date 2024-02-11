CREATE TABLE IF NOT EXISTS "FormEducation" (
    id SERIAL PRIMARY KEY,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "_nameForm" TEXT
);

CREATE TABLE IF NOT EXISTS "Qualification" (
    id SERIAL PRIMARY KEY,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "_nameQualification" TEXT
);

CREATE TABLE IF NOT EXISTS "Group" (
    id SERIAL PRIMARY KEY,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "_idSpeciality" TEXT,
    "_idQualification" TEXT,
    "_idFormEducation" TEXT,
    "_idFaculty" TEXT,
    "_idName" TEXT,
    "_idCourse" TEXT,
    "_idCountStudent" TEXT,
    "_idCountSubgroup" TEXT,
    FOREIGN KEY ("_idSpeciality") REFERENCES "Speciality" (id),
    FOREIGN KEY ("_idQualification") REFERENCES "Qualification" (id),
    FOREIGN KEY ("_idFormEducation") REFERENCES "FormEducation" (id)
);

CREATE TABLE IF NOT EXISTS "Speciality" (
    id SERIAL PRIMARY KEY,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "_nameSpeciality" TEXT,
    "_profile" TEXT
);