DROP TABLE IF EXISTS students;

CREATE TABLE students (
    student_id SERIAL,
    sur_name varchar(100) not null,
    given_name varchar(100) not null,
    patronymic varchar(100) not null,
    group_name varchar(100) not null,
    date_of_birth date not null
);

INSERT INTO students (sur_name, given_name, patronymic, group_name, date_of_birth)
VALUES
('Маслов', 'Максим', 'Вячеславович', 'А-14м-20', '1998-05-06'),
('Шубин', 'Кирилл', 'Александрович', 'А-08м-20', '1998-10-12'),
('Тюрин', 'Иван', 'Сергеевич', 'А-07м-20', '1998-03-20');
