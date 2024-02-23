create table if not exists Form_education (
    id identity primary key,
    created_At timestamp not null,
    name_Form varchar(50) not null
);

create table if not exists Qualification (
    id identity primary key,
    created_At timestamp not null,
    name_Qualification varchar(50) not null
);

create table if not exists Speciality (
    id identity primary key,
    created_At timestamp not null,
    name_Speciality varchar(50) not null,
    profile varchar(50) not null
);

create table if not exists GGroup (
    id identity primary key,
    created_At timestamp not null,
    id_Speciality varchar(50) not null,
    id_Qualification varchar(50) not null,
    id_FormEducation varchar(50) not null,
    id_Faculty varchar(50) not null,
    id_Name varchar(50) not null,
    id_Course varchar(50) not null,
    id_CountStudent varchar(50) not null,
    id_CountSubgroup varchar(50) not null,

    foreign key (id_Speciality) references Speciality (id),
    foreign key (id_Qualification) references Qualification (id),
    foreign key (id_FormEducation) references Form_education (id)
);