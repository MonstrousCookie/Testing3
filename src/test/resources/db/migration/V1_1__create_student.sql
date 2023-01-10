DROP TABLE IF EXISTS student;

CREATE TABLE student (
id bigint,
name varchar(255) NOT NULL,
average double precision,
PRIMARY KEY (id)
);
