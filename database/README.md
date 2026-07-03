# Base de datos
Esta carpeta contiene todos los scripts SQL necesarios para crear y mantener el esquema de la base de datos del proyecto.

## Estructura
```
database/
│
├── README.md
├── migrations/
│   ├── V01_create_enums.sql
│   ├── V02_create_schema.sql
│   ├── V03_add_indexes.sql
│   └── V04_add_capacity_trigger.sql
│
├── seeds/
│   └── V05_seed_data.sql
│
└── diagrams/
    └── mer_diagram.html
```

## Carpetas
### migrations/
Contiene todos los cambios versionados del esquema de base de datos. Cada migración es incremental y debe ejecutarse en orden ascendente.
### seeds/
Contiene datos de prueba para poblar las tablas del sistema.
### diagrams/
Diagramas entidad-relación de la base de datos.

## Scripts
| Archivo | Descripción |
|----------|-------------|
| `migrations/V01_create_enums.sql` | Crea los tipos enum `enrollment_status` y `student_status` |
| `migrations/V02_create_schema.sql` | Crea el esquema inicial con todas las tablas, restricciones y relaciones |
| `migrations/V03_add_indexes.sql` | Crea índices para las columnas con foreign keys |
| `migrations/V04_add_capacity_trigger.sql` | Crea un trigger que evita sobrepasar el aforo máximo en secciones |
| `seeds/V05_seed_data.sql` | Pobla la base de datos con datos de prueba (programas, cursos, periodos, profesores, estudiantes, matrículas, notas y asistencias) |

## Orden de ejecución
Los scripts deben ejecutarse en orden ascendente según su versión:
```
V01_create_enums.sql
V02_create_schema.sql
V03_add_indexes.sql
V04_add_capacity_trigger.sql
V05_seed_data.sql
```

## Convención de nombres
Los scripts siguen el formato `V##_descripcion.sql` donde:
- `V##` corresponde al número de versión
- `descripcion` indica brevemente el propósito de la migración

```
V01_create_enums.sql
V02_create_schema.sql
V03_add_indexes.sql
V04_add_capacity_trigger.sql
V05_seed_data.sql
```

## Requisitos
- PostgreSQL 16 o superior
- Permisos para crear tablas, índices, funciones, triggers y restricciones

## Cómo inicializar la base de datos
1. Crear la base de datos:
```sql
CREATE DATABASE academicabi;
```
2. Conectarse a la base de datos creada.
3. Ejecutar las migraciones en orden ascendente:
```
\i V01_create_enums.sql
\i V02_create_schema.sql
\i V03_add_indexes.sql
\i V04_add_capacity_trigger.sql
```
4. (Opcional) Poblar con datos de prueba:
```
\i V05_seed_data.sql
```