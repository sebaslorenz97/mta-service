create database mi_taller_automotriz;
drop database mi_taller_automotriz;
use mi_taller_automotriz;


-- ---------------------------------------------------------------------------------------------------------------- TABLAS DEL SYSTEMA
-- TABLA USUARIOS
CREATE TABLE users (
    username_pk VARCHAR(30) PRIMARY KEY NOT NULL,
	passwordd VARCHAR(300) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    cargo VARCHAR(25) NOT NULL,
    email VARCHAR(70) NOT NULL,
    lockedd TINYINT NOT NULL,
    disabled TINYINT NOT NULL
);
DESCRIBE users;
SELECT * FROM users;


-- TABLA ROLES DE USUARIO
CREATE TABLE users_role (
    role_user_pk VARCHAR(30) NOT NULL,
    username_fk VARCHAR(30) NOT NULL,
    granted_date DATETIME NOT NULL,
    PRIMARY KEY(role_user_pk, username_fk),
    FOREIGN KEY (username_fk) REFERENCES users(username_pk)
);
DESCRIBE users_role;
SELECT * FROM users_role;


-- ------------------------------------------------------------------------------------------------------ TABLAS DEL DOMINIO DE LA APP
-- TABLA ESTADOS (CATALOGO)
CREATE TABLE estados (
    id_estado_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    estado VARCHAR(35) NOT NULL
);
DESCRIBE estados;
SELECT * FROM estados;

-- TABLA MUNICIPIOS (CATALOGO)
CREATE TABLE municipios (
    id_municipio_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_estado_fk INT UNSIGNED NOT NULL,
    municipio VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_estado_fk) REFERENCES estados(id_estado_pk)
);
DESCRIBE municipios;
SELECT * FROM municipios;

-- TABLA CLIENTES
CREATE TABLE clientes (
    id_cliente_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_estado_fk INT UNSIGNED NOT NULL,
    id_municipio_fk INT UNSIGNED NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    particular_o_empresa BOOLEAN NOT NULL,
    referencia VARCHAR(50) NOT NULL,
    rfc VARCHAR(14) NOT NULL,
    cp VARCHAR(7) NOT NULL,
    email VARCHAR(256) NOT NULL,
    telefono INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_estado_fk) REFERENCES estados(id_estado_pk),
    FOREIGN KEY (id_municipio_fk) REFERENCES municipios(id_municipio_pk)
);
DESCRIBE clientes;
SELECT * FROM clientes;

-- TABLA MARCAS (CATALOGO)
CREATE TABLE marcas (
    id_marca_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    marca VARCHAR(35) NOT NULL
);
DESCRIBE marcas;
SELECT * FROM marcas;

-- TABLA MODELOS (CATALOGO)
CREATE TABLE modelos (
    id_modelo_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_marca_fk INT UNSIGNED NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_marca_fk) REFERENCES marcas(id_marca_pk)
);
DESCRIBE modelos;
SELECT * FROM modelos;

-- TABLA AÑOS = YEARS (CATALOGO)
CREATE TABLE c_years (
    id_c_year_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    c_year INT UNSIGNED NOT NULL
);
DESCRIBE c_years;
SELECT * FROM c_years;

-- TABLA VEHICULOS
CREATE TABLE vehiculos (
    id_vehiculo_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_cliente_fk INT UNSIGNED NOT NULL,
    id_marca_fk INT UNSIGNED NOT NULL,
    id_modelo_fk INT UNSIGNED NOT NULL,
    id_c_years_fk INT UNSIGNED NOT NULL,
    color VARCHAR(20) NOT NULL,
    placas VARCHAR(12) NOT NULL,
    kilometraje_inicial INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_cliente_fk) REFERENCES clientes(id_cliente_pk),
    FOREIGN KEY (id_marca_fk) REFERENCES marcas(id_marca_pk),
    FOREIGN KEY (id_modelo_fk) REFERENCES modelos(id_modelo_pk),
    FOREIGN KEY (id_c_years_fk) REFERENCES c_years(id_c_year_pk)
);
DESCRIBE vehiculos;
SELECT * FROM vehiculos;

-- TABLA COTIZACIONES
CREATE TABLE cotizaciones (
    id_cotizacion_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_vehiculo_fk INT UNSIGNED NOT NULL,
    fecha_orden DATE NOT NULL,
    fecha_entrega DATE NOT NULL,
    estatus_auto VARCHAR(10) NOT NULL,
    metodo_pago BOOLEAN NOT NULL DEFAULT 0,
    estatus_pago BOOLEAN NOT NULL DEFAULT 0,
    adelanto_pago INT UNSIGNED NOT NULL,
    factura BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (id_vehiculo_fk) REFERENCES vehiculos(id_vehiculo_pk)
);
DESCRIBE cotizaciones;
SELECT * FROM cotizaciones;

-- TABLA COTIZACIONES DETALLE
CREATE TABLE cotizaciones_detalle (
    id_cotizacion_detalle_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_cotizacion_fk INT UNSIGNED NOT NULL,
    mec INT UNSIGNED NOT NULL,
    mano_obra_refacciones VARCHAR(150) NOT NULL,
    importe INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_cotizacion_fk) REFERENCES cotizaciones(id_cotizacion_pk)
);
DESCRIBE cotizaciones_detalle;
SELECT * FROM cotizaciones_detalle;


-- -----------------------------------------------------------------------------------------------------------------------------------
-- TABLA T1 DE GUIA PARA CREAR
CREATE TABLE t1 (
    id_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_fk INT UNSIGNED NOT NULL,
    N INT UNSIGNED NOT NULL,
    S VARCHAR(30) NOT NULL,
    FOREIGN KEY (id_fk) REFERENCES t2(id_pk)
);

-- SQL PARA MODIFICAR TABLAS
DESCRIBE _table_name;
ALTER TABLE _table_name DROP FOREIGN KEY _table_name_ibfk_N; -- ESTE SQL SE USA SOLO SI LA COLUMNA QUE QUIERES ELIMINAR ES FK
ALTER TABLE _table_name DROP COLUMN _column_name;
ALTER TABLE _table_name ADD COLUMN _new_column_name VARCHAR(50) NOT NULL AFTER _column_N;
SELECT * FROM _table_name;