# AcademicaBI — Backend Summary

**Stack:** Spring Boot 4.1.0 / Java 21 / PostgreSQL / Lombok / JPA (Hibernate) / Maven

---

## Entities (9 tablas)

| Entidad | Tabla | FK | Referencia |
|---------|-------|----|------------|
| **Program** | `programs` | — | standalone |
| **Course** | `courses` | `program_id` | Program |
| **Period** | `periods` | — | standalone |
| **Professor** | `professors` | — | standalone |
| **Section** | `sections` | `course_id`, `period_id`, `professor_id` | Course, Period, Professor |
| **Student** | `students` | `program_id` | Program |
| **Enrollment** | `enrollments` | `student_id`, `section_id` | Student, Section |
| **Grade** | `grades` | `enrollment_id` | Enrollment |
| **Attendance** | `attendance` | `enrollment_id` | Enrollment |

### Relaciones (texto)
```
Program ──< Course
Program ──< Student
Course  ──< Section
Period  ──< Section
Professor─< Section
Section ──< Enrollment
Student ──< Enrollment
Enrollment ─< Grade
Enrollment ─< Attendance
```

### Columnas compartidas
Todas las entidades tienen: `id` (PK auto), `created_at`/`updated_at` (`@PrePersist`/`@PreUpdate`).  
Snake_case en BD → camelCase en Java con `@Column(name = "snake_case")`.

### Enums
- `EnrollmentStatus`: ACTIVE, DROPPED, COMPLETED
- `StudentStatus`: ENROLLED, ON_LEAVE, GRADUATED, SUSPENDED

---

## Capas

### Repository (`@Repository`)
- 9 interfaces extendiendo `JpaRepository<Entity, Long>`
- Métodos `findBy*` para campos únicos y travesía de FKs
- `@Query` para métodos con `OrderBy` en campos conflictivos (classDate, partialNumber)

### Service (`@Service`)
- 9 clases con inyección de constructor
- Métodos: CRUD estándar + `getAll*()` + búsquedas por FK
- Lanza `ResourceNotFoundException` cuando no encuentra entidad

### Controller (`@RestController`)
- 9 controladores con `@RequestMapping("/api/v1/...")`
- Endpoints RESTful (`GET`, `GET /{id}`, `POST`, `PUT /{id}`, `DELETE /{id}`)

### Exception handling
- `GlobalExceptionHandler` (`@ControllerAdvice`): maneja `ResourceNotFoundException`, `MethodArgumentNotValidException`, `DataIntegrityViolationException`, `HttpMessageNotReadableException`
- `ErrorResponse` DTO con `status`, `message`, `timestamp`

---

## Endpoints

| Controller | Path | Endpoints |
|-----------|------|-----------|
| Program | `/api/v1/programs` | 5 |
| Course | `/api/v1/courses` | 5 |
| Period | `/api/v1/periods` | 5 |
| Professor | `/api/v1/professors` | 5 |
| Section | `/api/v1/sections` | 5 |
| Student | `/api/v1/students` | 5 |
| Enrollment | `/api/v1/enrollments` | 5 |
| Grade | `/api/v1/grades` | 5 |
| Attendance | `/api/v1/attendance` | 5 |

**Total: 45 endpoints** (GET all, GET by id, POST create, PUT update, DELETE delete)

---

## BD (PostgreSQL)

- **DB:** `academicabi` en `localhost:5432`
- **Migraciones Flyway:** `database/migrations/V01..V04`
  - V01: tipos enum
  - V02: schema completo (CREATE TABLE + FKs)
  - V03: índices
  - V04: trigger de capacidad de sección
- **Seed:** `database/seeds/V05_seed_data.sql` (3 programas, 8 cursos, 3 periodos, 6 profesores, 12 secciones, 10 estudiantes, 22 matrículas, 33 notas, 13 asistencias)

---

## Dependencias clave (pom.xml)
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-validation`
- `spring-boot-starter-webmvc`
- `postgresql` (runtime)
- `lombok` (optional)
