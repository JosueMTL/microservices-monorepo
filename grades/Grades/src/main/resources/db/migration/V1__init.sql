CREATE TABLE IF NOT EXISTS Grades (
    id SERIAL PRIMARY KEY,
    course_name VARCHAR(100),
    grade DECIMAL(3, 2)
);
