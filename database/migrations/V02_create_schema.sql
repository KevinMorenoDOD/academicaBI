CREATE TABLE programs(
	id BIGSERIAL PRIMARY KEY,
	name varchar (50) NOT NULL UNIQUE,
	faculty varchar(30) NOT NULL,
	available boolean DEFAULT true,
	created_at timestamp DEFAULT NOW()
 );

CREATE TABLE courses(
	id BIGSERIAL PRIMARY KEY,
	code varchar(20) NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	credits integer NOT NULL,
	program_id bigint NOT NULL REFERENCES programs(id),
	available boolean DEFAULT true
)

CREATE TABLE periods(
	id BIGSERIAL PRIMARY KEY,
	code varchar(20) NOT NULL UNIQUE,
	start_date date,
	end_date date,
	active boolean DEFAULT true
)

CREATE TABLE professors(
	id BIGSERIAL PRIMARY KEY,
	full_name varchar(50) NOT NULL,
	email varchar(100) NOT NULL UNIQUE,
	department varchar(50),
	available boolean DEFAULT true
)

CREATE TABLE sections(
	id BIGSERIAL PRIMARY KEY,
	course_id bigint NOT NULL REFERENCES courses(id),
	period_id bigint NOT NULL REFERENCES periods(id),
	professor_id bigint NOT NULL REFERENCES professors(id),
	group_code varchar(20) NOT NULL,
	max_capacity integer CHECK (max_capacity>=0),
	CONSTRAINT uq_section UNIQUE (course_id, period_id, group_code)
)

CREATE TABLE students(
	id BIGSERIAL PRIMARY KEY,
	student_code varchar(20) NOT NULL UNIQUE,
	full_name varchar(50) NOT NULL,
	email varchar(100)NOT NULL UNIQUE,
	program_id bigint NOT NULL REFERENCES programs(id),
	status varchar(20),
	enrolled_at timestamp DEFAULT NOW()
)

CREATE TABLE enrollments(
	id BIGSERIAL PRIMARY KEY,
	student_id bigint NOT NULL REFERENCES students(id),
	section_id bigint NOT NULL REFERENCES sections(id),
	enrolled_at timestamp DEFAULT NOW(),
	final_grade decimal CHECK (final_grade >= 0.0 AND final_grade <= 5.0),
	status varchar(20)
)

CREATE TABLE grades(
	id BIGSERIAL PRIMARY KEY,
	enrollment_id bigint NOT NULL REFERENCES enrollments(id),
	partial_number integer NOT NULL CHECK (partial_number IN (1,2,3)),
	score decimal CHECK (score >= 0.0 AND score <= 5.0),
	recorded_at timestamp DEFAULT NOW()
)

CREATE TABLE attendance(
	id BIGSERIAL PRIMARY KEY,
	enrollment_id bigint NOT NULL REFERENCES enrollments(id),
	class_date date,
	present boolean
)