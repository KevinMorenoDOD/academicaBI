# Graph Report - PRY_AcademicaBI  (2026-07-12)

## Corpus Check
- 55 files · ~6,573 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 414 nodes · 671 edges · 45 communities (32 shown, 13 thin omitted)
- Extraction: 95% EXTRACTED · 5% INFERRED · 0% AMBIGUOUS · INFERRED: 33 edges (avg confidence: 0.8)
- Token cost: 0 input · 0 output

## Graph Freshness
- Built from commit: `c7ebe1a6`
- Run `git rev-parse HEAD` and compare to check if the graph is stale.
- Run `graphify update .` after code changes (no API cost).

## Community Hubs (Navigation)
- [[_COMMUNITY_Community 0|Community 0]]
- [[_COMMUNITY_Community 1|Community 1]]
- [[_COMMUNITY_Community 2|Community 2]]
- [[_COMMUNITY_Community 3|Community 3]]
- [[_COMMUNITY_Community 4|Community 4]]
- [[_COMMUNITY_Community 5|Community 5]]
- [[_COMMUNITY_Community 6|Community 6]]
- [[_COMMUNITY_Community 7|Community 7]]
- [[_COMMUNITY_Community 8|Community 8]]
- [[_COMMUNITY_Community 9|Community 9]]
- [[_COMMUNITY_Community 10|Community 10]]
- [[_COMMUNITY_Community 11|Community 11]]
- [[_COMMUNITY_Community 12|Community 12]]
- [[_COMMUNITY_Community 13|Community 13]]
- [[_COMMUNITY_Community 14|Community 14]]
- [[_COMMUNITY_Community 15|Community 15]]
- [[_COMMUNITY_Community 16|Community 16]]
- [[_COMMUNITY_Community 17|Community 17]]
- [[_COMMUNITY_Community 18|Community 18]]
- [[_COMMUNITY_Community 19|Community 19]]
- [[_COMMUNITY_Community 20|Community 20]]
- [[_COMMUNITY_Community 21|Community 21]]
- [[_COMMUNITY_Community 22|Community 22]]
- [[_COMMUNITY_Community 23|Community 23]]
- [[_COMMUNITY_Community 24|Community 24]]
- [[_COMMUNITY_Community 25|Community 25]]
- [[_COMMUNITY_Community 26|Community 26]]
- [[_COMMUNITY_Community 27|Community 27]]
- [[_COMMUNITY_Community 28|Community 28]]
- [[_COMMUNITY_Community 29|Community 29]]
- [[_COMMUNITY_Community 30|Community 30]]
- [[_COMMUNITY_Community 31|Community 31]]
- [[_COMMUNITY_Community 32|Community 32]]
- [[_COMMUNITY_Community 33|Community 33]]
- [[_COMMUNITY_Community 34|Community 34]]
- [[_COMMUNITY_Community 35|Community 35]]
- [[_COMMUNITY_Community 36|Community 36]]
- [[_COMMUNITY_Community 37|Community 37]]
- [[_COMMUNITY_Community 38|Community 38]]
- [[_COMMUNITY_Community 39|Community 39]]
- [[_COMMUNITY_Community 40|Community 40]]

## God Nodes (most connected - your core abstractions)
1. `StudentController` - 9 edges
2. `StudentService` - 9 edges
3. `CourseController` - 8 edges
4. `ProfessorController` - 8 edges
5. `ProgramController` - 8 edges
6. `ResponseEntity` - 8 edges
7. `Student` - 8 edges
8. `CourseService` - 8 edges
9. `ProfessorService` - 8 edges
10. `ProgramService` - 8 edges

## Surprising Connections (you probably didn't know these)
- None detected - all connections are within the same source files.

## Import Cycles
- None detected.

## Communities (45 total, 13 thin omitted)

### Community 0 - "Community 0"
Cohesion: 0.08
Nodes (18): String, List, Professor, String, List, Program, String, List (+10 more)

### Community 1 - "Community 1"
Cohesion: 0.22
Nodes (10): GetMapping, List, PatchMapping, PostMapping, PutMapping, ResponseEntity, String, Student (+2 more)

### Community 2 - "Community 2"
Cohesion: 0.22
Nodes (10): Course, GetMapping, List, PatchMapping, PostMapping, PutMapping, ResponseEntity, String (+2 more)

### Community 3 - "Community 3"
Cohesion: 0.22
Nodes (10): GetMapping, List, PatchMapping, PostMapping, Professor, PutMapping, ResponseEntity, String (+2 more)

### Community 4 - "Community 4"
Cohesion: 0.22
Nodes (10): GetMapping, List, PatchMapping, PostMapping, Program, PutMapping, ResponseEntity, String (+2 more)

### Community 5 - "Community 5"
Cohesion: 0.23
Nodes (9): Enrollment, GetMapping, List, PatchMapping, PostMapping, PutMapping, ResponseEntity, EnrollmentController (+1 more)

### Community 6 - "Community 6"
Cohesion: 0.23
Nodes (9): GetMapping, List, PatchMapping, Period, PostMapping, PutMapping, ResponseEntity, PeriodController (+1 more)

### Community 7 - "Community 7"
Cohesion: 0.26
Nodes (8): AttendanceService, Attendance, GetMapping, List, PostMapping, PutMapping, ResponseEntity, AttendanceController

### Community 8 - "Community 8"
Cohesion: 0.26
Nodes (8): GetMapping, Grade, List, PostMapping, PutMapping, ResponseEntity, GradeController, GradeService

### Community 9 - "Community 9"
Cohesion: 0.26
Nodes (8): GetMapping, List, PostMapping, PutMapping, ResponseEntity, Section, SectionController, SectionService

### Community 10 - "Community 10"
Cohesion: 0.26
Nodes (5): Course, List, String, CourseRepository, CourseService

### Community 11 - "Community 11"
Cohesion: 0.33
Nodes (6): Course, Integer, List, Optional, String, CourseRepository

### Community 12 - "Community 12"
Cohesion: 0.17
Nodes (11): Base de datos, Carpetas, Convención de nombres, Cómo inicializar la base de datos, diagrams/, Estructura, migrations/, Orden de ejecución (+3 more)

### Community 13 - "Community 13"
Cohesion: 0.36
Nodes (6): Enrollment, Integer, List, Optional, String, EnrollmentRepository

### Community 14 - "Community 14"
Cohesion: 0.36
Nodes (6): Integer, List, Optional, String, Student, StudentRepository

### Community 15 - "Community 15"
Cohesion: 0.31
Nodes (4): Enrollment, List, EnrollmentRepository, EnrollmentService

### Community 16 - "Community 16"
Cohesion: 0.31
Nodes (4): List, Period, PeriodRepository, PeriodService

### Community 17 - "Community 17"
Cohesion: 0.33
Nodes (4): AttendanceRepository, Attendance, List, AttendanceService

### Community 18 - "Community 18"
Cohesion: 0.40
Nodes (5): List, Optional, Program, String, ProgramRepository

### Community 19 - "Community 19"
Cohesion: 0.33
Nodes (4): Grade, List, GradeRepository, GradeService

### Community 20 - "Community 20"
Cohesion: 0.33
Nodes (4): List, Section, SectionRepository, SectionService

### Community 21 - "Community 21"
Cohesion: 0.42
Nodes (5): List, Optional, Professor, String, ProfessorRepository

### Community 22 - "Community 22"
Cohesion: 0.53
Nodes (4): Integer, List, Section, SectionRepository

### Community 23 - "Community 23"
Cohesion: 0.39
Nodes (6): ResponseEntity, ErrorResponse, GlobalExceptionHandler, ExceptionHandler, HttpServletRequest, ResourceNotFoundException

### Community 24 - "Community 24"
Cohesion: 0.46
Nodes (5): Attendance, Integer, List, Query, AttendanceRepository

### Community 25 - "Community 25"
Cohesion: 0.46
Nodes (5): Grade, Integer, List, Query, GradeRepository

### Community 26 - "Community 26"
Cohesion: 0.60
Nodes (3): List, Period, PeriodRepository

### Community 27 - "Community 27"
Cohesion: 0.40
Nodes (4): Getting Started, Guides, Maven Parent overrides, Reference Documentation

## Knowledge Gaps
- **59 isolated node(s):** `String`, `PostMapping`, `PutMapping`, `String`, `PostMapping` (+54 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **13 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Are the 29 inferred relationships involving `RuntimeException` (e.g. with `.getAttendanceById()` and `.updateAttendance()`) actually correct?**
  _`RuntimeException` has 29 INFERRED edges - model-reasoned connections that need verification._
- **What connects `String`, `PostMapping`, `PutMapping` to the rest of the system?**
  _59 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Community 0` be split into smaller, more focused modules?**
  _Cohesion score 0.08080808080808081 - nodes in this community are weakly interconnected._