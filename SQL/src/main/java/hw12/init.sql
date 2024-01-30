CREATE table IF NOT EXISTS Homework (
     id SERIAL PRIMARY KEY,
     name varchar (255),
     description varchar (255));

CREATE table IF NOT EXISTS Lesson (
     id SERIAL PRIMARY KEY,
     name varchar (255),
     updatedAt varchar (255),
     homework_id int,
     FOREIGN KEY (homework_id) REFERENCES Homework(id));

CREATE table IF NOT EXISTS Schedule (
     id SERIAL PRIMARY KEY,
     name varchar (255),
     updatedAt varchar (255),
     lessons int,
     FOREIGN KEY (lessons) REFERENCES Lesson(id));