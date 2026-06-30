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
│   └── V##_##.sql
│
├── seeds/
│   ├── ##.sql
│   ├── ##.sql
│   └── ##.sql
│
└── diagrams/
    └── mer_diagram.html
```

## Carpetas
### migrations/
Contiene todos los cambios versionados del esquema.
### seeds/
Datos iniciales del sistema (students, programs, professors).
### diagrams/
Diagramas entidad-relación de la base de datos.

## Scripts
| Archivo | Descripción |
|----------|-------------|
| `migrations/V01_create_enums.sql` | Crea los enums principales para enrrolments y students |
| `migrations/V02_create_schema.sql` | Crea el esquema inicial de la base de datos (tablas, restricciones, índices, etc.). |
| `migrations/V03_add_indexes.sql` | Crea los index para las foreign keys |

## Orden de ejecución
Los scripts deben ejecutarse en orden ascendente según su versión.
```
V01_create_enums.sql
V02_create_schema.sql
V03_add_indexes.sql
```

## Convención de nombres
Los scripts siguen el formato:
V##_descripcion.sql
donde:
- `V##` corresponde al número de versión.
- `descripcion` indica brevemente el propósito de la migración.
Ejemplos:
```
V01_create_enums.sql
V02_create_schema.sql
V03_add_indexes.sql
V04_insert_catalogs.sql
V05_create_views.sql
```

## Requisitos
- PostgreSQL 16 o superior.
- Permisos para crear tablas, índices y restricciones.

## Cómo inicializar la base de datos
1. Crear la base de datos.
```sql
CREATE DATABASE nombre_bd;
```
2. Conectarse a la base de datos creada.
3. Ejecutar las migraciones en orden ascendente.
```
V01_create_enums.sql
V02_create_schema.sql
V03_add_indexes.sql
...
```