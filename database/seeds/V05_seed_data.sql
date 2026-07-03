-- ============================================================
-- SEED DATA: Academic BI
-- ============================================================

-- -----------------------------------------------------------
-- PROGRAMS
-- -----------------------------------------------------------
INSERT INTO programs (name, faculty) VALUES
('Ingeniería de Sistemas', 'Ingeniería'),
('Administración de Empresas', 'Ciencias Económicas'),
('Psicología', 'Ciencias Sociales');

-- -----------------------------------------------------------
-- COURSES
-- -----------------------------------------------------------
INSERT INTO courses (code, name, credits, program_id) VALUES
('IS-101', 'Programación I', 4, 1),
('IS-201', 'Bases de Datos', 3, 1),
('IS-202', 'Estructuras de Datos', 4, 1),
('AE-101', 'Contabilidad General', 3, 2),
('AE-201', 'Marketing Digital', 3, 2),
('AE-202', 'Finanzas Corporativas', 3, 2),
('PS-101', 'Psicología General', 3, 3),
('PS-201', 'Psicología Clínica', 4, 3);

-- -----------------------------------------------------------
-- PERIODS
-- -----------------------------------------------------------
INSERT INTO periods (code, start_date, end_date) VALUES
('2024-1', '2024-02-01', '2024-06-15'),
('2024-2', '2024-08-01', '2024-12-15'),
('2025-1', '2025-02-01', '2025-06-15');

-- -----------------------------------------------------------
-- PROFESSORS
-- -----------------------------------------------------------
INSERT INTO professors (full_name, email, department) VALUES
('Carlos López Ramírez', 'carlos.lopez@academiabi.edu', 'Ingeniería'),
('María García Torres', 'maria.garcia@academiabi.edu', 'Ingeniería'),
('Juan Martínez Ríos', 'juan.martinez@academiabi.edu', 'Ciencias Económicas'),
('Ana Rodríguez Díaz', 'ana.rodriguez@academiabi.edu', 'Ciencias Económicas'),
('Pedro Sánchez Vega', 'pedro.sanchez@academiabi.edu', 'Ciencias Sociales'),
('Laura Herrera Muñoz', 'laura.herrera@academiabi.edu', 'Ciencias Sociales');

-- -----------------------------------------------------------
-- SECTIONS
-- -----------------------------------------------------------
INSERT INTO sections (course_id, period_id, professor_id, group_code, max_capacity) VALUES
(1, 1, 1, 'GRP-A', 30),
(2, 1, 2, 'GRP-A', 25),
(3, 1, 1, 'GRP-A', 25),
(4, 1, 3, 'GRP-A', 30),
(5, 1, 4, 'GRP-A', 25),
(6, 1, 3, 'GRP-A', 25),
(7, 1, 5, 'GRP-A', 35),
(8, 1, 6, 'GRP-A', 20),
-- semestre 2024-2
(1, 2, 1, 'GRP-B', 30),
(2, 2, 2, 'GRP-B', 25),
(4, 2, 3, 'GRP-B', 30),
(7, 2, 5, 'GRP-B', 35);

-- -----------------------------------------------------------
-- STUDENTS
-- -----------------------------------------------------------
INSERT INTO students (student_code, full_name, email, program_id) VALUES
('STU001', 'Andrea Gómez Sánchez', 'andrea.gomez@academiabi.edu', 1),
('STU002', 'Diego Fernández Rojas', 'diego.fernandez@academiabi.edu', 1),
('STU003', 'Camila Torres Pineda', 'camila.torres@academiabi.edu', 1),
('STU004', 'Mateo Vargas López', 'mateo.vargas@academiabi.edu', 2),
('STU005', 'Isabella Ríos Cárdenas', 'isabella.rios@academiabi.edu', 2),
('STU006', 'Sebastián Díaz Morales', 'sebastian.diaz@academiabi.edu', 2),
('STU007', 'Valentina Soto Herrera', 'valentina.soto@academiabi.edu', 3),
('STU008', 'Santiago Ospina León', 'santiago.ospina@academiabi.edu', 3),
('STU009', 'Mariana Cruz Beltrán', 'mariana.cruz@academiabi.edu', 1),
('STU010', 'Emilio Restrepo Gil', 'emilio.restrepo@academiabi.edu', 3);

-- -----------------------------------------------------------
-- ENROLLMENTS
-- -----------------------------------------------------------
INSERT INTO enrollments (student_id, section_id, status, final_grade) VALUES
-- Andrea (IS)
(1, 1, 'active', NULL),
(1, 2, 'completed', 4.5),
(1, 3, 'active', NULL),
-- Diego (IS)
(2, 1, 'completed', 3.8),
(2, 2, 'completed', 4.2),
(2, 3, 'completed', 3.5),
-- Camila (IS)
(3, 1, 'active', NULL),
(3, 2, 'withdrawn', NULL),
-- Mateo (AE)
(4, 4, 'completed', 4.0),
(4, 5, 'completed', 3.7),
(4, 6, 'active', NULL),
-- Isabella (AE)
(5, 4, 'completed', 3.2),
(5, 5, 'active', NULL),
(5, 6, 'active', NULL),
-- Sebastián (AE)
(6, 4, 'completed', 4.8),
(6, 5, 'completed', 4.1),
-- Valentina (PS)
(7, 7, 'completed', 4.3),
(7, 8, 'active', NULL),
-- Santiago (PS)
(8, 7, 'completed', 3.9),
(8, 8, 'active', NULL),
-- Mariana (IS) - 2024-2
(9, 9, 'active', NULL),
(9, 10, 'active', NULL),
-- Emilio (PS) - 2024-2
(10, 12, 'active', NULL);

-- -----------------------------------------------------------
-- GRADES (partial 1, 2, 3 for completed enrollments)
-- -----------------------------------------------------------
INSERT INTO grades (enrollment_id, partial_number, score) VALUES
-- Diego -> section 1 (Programación I) - completed 3.8
(4, 1, 3.5), (4, 2, 4.0), (4, 3, 3.8),
-- Diego -> section 2 (Bases de Datos) - completed 4.2
(5, 1, 4.5), (5, 2, 4.0), (5, 3, 4.2),
-- Diego -> section 3 (Estructuras de Datos) - completed 3.5
(6, 1, 3.0), (6, 2, 3.8), (6, 3, 3.5),
-- Andrea -> section 2 (Bases de Datos) - completed 4.5
(2, 1, 4.8), (2, 2, 4.5), (2, 3, 4.2),
-- Mateo -> section 4 (Contabilidad) - completed 4.0
(9, 1, 3.8), (9, 2, 4.2), (9, 3, 4.0),
-- Mateo -> section 5 (Marketing) - completed 3.7
(10, 1, 3.5), (10, 2, 4.0), (10, 3, 3.7),
-- Isabella -> section 4 (Contabilidad) - completed 3.2
(12, 1, 3.0), (12, 2, 3.5), (12, 3, 3.2),
-- Sebastián -> section 4 (Contabilidad) - completed 4.8
(16, 1, 5.0), (16, 2, 4.5), (16, 3, 5.0),
-- Sebastián -> section 5 (Marketing) - completed 4.1
(17, 1, 4.0), (17, 2, 4.5), (17, 3, 3.8),
-- Valentina -> section 7 (Psicología General) - completed 4.3
(18, 1, 4.5), (18, 2, 4.0), (18, 3, 4.5),
-- Santiago -> section 7 (Psicología General) - completed 3.9
(20, 1, 4.0), (20, 2, 3.5), (20, 3, 4.2);

-- -----------------------------------------------------------
-- ATTENDANCE (sample data for active enrollments)
-- -----------------------------------------------------------
INSERT INTO attendance (enrollment_id, class_date, present) VALUES
-- Andrea - Programación I
(1, '2024-02-05', true),
(1, '2024-02-12', true),
(1, '2024-02-19', false),
-- Diego - Programación I
(4, '2024-02-05', true),
(4, '2024-02-12', true),
(4, '2024-02-19', true),
-- Camila - Programación I
(7, '2024-02-05', true),
(7, '2024-02-12', true),
(7, '2024-02-19', true),
-- Valentina - Psicología General
(18, '2024-02-07', true),
(18, '2024-02-14', true),
-- Santiago - Psicología General
(20, '2024-02-07', true),
(20, '2024-02-14', false);
