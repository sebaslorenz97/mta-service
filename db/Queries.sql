use mi_taller_automotriz;
-- USUARIO PRINCIPAL: FeRnAnDo3302!
-- PASSWORD DEL USUARIO PRINCIPAL: @FeRnAnDo$3302!


DESCRIBE users;
SELECT * FROM users;
SELECT * FROM users WHERE username_pk = "sebaslorenz97";
SELECT * FROM users WHERE username_pk = "Gregis24$";

DESCRIBE users_role;
SELECT * FROM users_role;
SELECT * FROM users_role WHERE username_fk = "sebaslorenz97";
SELECT * FROM users_role WHERE username_fk = "emily99";
SELECT * FROM users_role WHERE username_fk = "Gregis24$";

DESCRIBE estados;
SELECT * FROM estados;
ALTER TABLE estados AUTO_INCREMENT = 5;

DESCRIBE municipios;
SELECT * FROM municipios;
ALTER TABLE municipios AUTO_INCREMENT = 5;

DESCRIBE clientes;
SELECT * FROM clientes;
ALTER TABLE clientes AUTO_INCREMENT = 5;
SELECT * FROM clientes WHERE nombre LIKE'%duls%';
SELECT * FROM vehiculos WHERE placas LIKE'%29%';

DESCRIBE marcas;
SELECT * FROM marcas;
ALTER TABLE marcas AUTO_INCREMENT = 5;

DESCRIBE modelos;
SELECT * FROM modelos;
ALTER TABLE modelos AUTO_INCREMENT = 5;

DESCRIBE c_years;
SELECT * FROM c_years;
ALTER TABLE c_years AUTO_INCREMENT = 5;

DESCRIBE vehiculos;
SELECT * FROM vehiculos;
ALTER TABLE vehiculos AUTO_INCREMENT = 5;

DESCRIBE cotizaciones;
SELECT * FROM cotizaciones;
ALTER TABLE cotizaciones AUTO_INCREMENT = 6;

DESCRIBE cotizaciones_detalle;
SELECT * FROM cotizaciones_detalle;
ALTER TABLE cotizaciones_detalle AUTO_INCREMENT = 9;
SELECT * FROM cotizaciones_detalle WHERE id_cotizacion_fk = 32;


-- -----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------- JOIN PARA OBTENER LOS ROLES DE UN USUARIO
SELECT users.username_pk, users_role.role_user_pk, users_role.granted_date
FROM users
INNER JOIN users_role ON users.username_pk = users_role.username_fk
-- WHERE users.username_pk = "sebaslorenz97";
 WHERE users.username_pk = "vanessa97";
-- WHERE users.username_pk = "emily99";

-- -------------------------------------------------------------------------------- DISTINC PARA OBTENER LOS TIPOS DE ROLES EXISTENTES
SELECT DISTINCT(role_user_pk) FROM users_role;

-- ---------------------------------------------------------------------------------------------------------------- JOINS PARA SEARCHS
-- JOIN PARA CUSTOMER SEARCH
DESCRIBE clientes;
DESCRIBE estados;

SELECT clientes.id_cliente_pk, clientes.id_estado_fk, estados.estado, clientes.id_municipio_fk, municipios.municipio, clientes.nombre, clientes.particular_o_empresa, clientes.referencia, clientes.rfc, clientes.cp, clientes.email, clientes.telefono
FROM clientes
INNER JOIN estados ON clientes.id_estado_fk = estados.id_estado_pk
INNER JOIN municipios ON clientes.id_municipio_fk = municipios.id_municipio_pk
WHERE clientes.nombre = "Uziel Lorenzo";

-- JOIN PARA VEHICLE SARCH
DESCRIBE vehiculos;
DESCRIBE clientes;
DESCRIBE marcas;
DESCRIBE modelos;
DESCRIBE c_years;

SELECT vehiculos.id_vehiculo_pk, vehiculos.id_cliente_fk, clientes.nombre, vehiculos.id_marca_fk, marcas.marca, vehiculos.id_modelo_fk, modelos.modelo, vehiculos.id_c_years_fk, c_years.c_year, vehiculos.color, vehiculos.placas, vehiculos.kilometraje_inicial
FROM vehiculos
INNER JOIN clientes ON vehiculos.id_cliente_fk = clientes.id_cliente_pk
INNER JOIN marcas ON vehiculos.id_marca_fk = marcas.id_marca_pk
INNER JOIN modelos ON vehiculos.id_modelo_fk = modelos.id_modelo_pk
INNER JOIN c_years ON vehiculos.id_c_years_fk = c_years.id_c_year_pk
WHERE vehiculos.placas = "UNK-529-D";

-- JOIN PARA QUOTE SEARCH
DESCRIBE cotizaciones;
DESCRIBE vehiculos;

SELECT cotizaciones.id_cotizacion_pk, cotizaciones.id_vehiculo_fk, vehiculos.placas, cotizaciones.fecha_orden, cotizaciones.fecha_entrega, cotizaciones.estatus_auto, cotizaciones.metodo_pago, cotizaciones.estatus_pago, cotizaciones.adelanto_pago, cotizaciones.factura
FROM cotizaciones
INNER JOIN vehiculos ON cotizaciones.id_vehiculo_fk = vehiculos.id_vehiculo_pk
WHERE cotizaciones.id_cotizacion_pk = "1";

-- JOIN PARA MUNICIPALITY SEARCH
DESCRIBE municipios;
DESCRIBE estados;

SELECT municipios.id_municipio_pk, municipios.id_estado_fk, estados.estado, municipios.municipio
FROM municipios
INNER JOIN estados ON municipios.id_estado_fk = estados.id_estado_pk
WHERE municipios.id_municipio_pk = 3;

-- GUIA PARA SEARCH JOINS
DESCRIBE t_main;
DESCRIBE t_fk1;
DESCRIBE t_fk2;

SELECT t_main.colX, t_fk1.colY, t_fk2.colZ
FROM t_main
INNER JOIN t_fk1 ON t_main.colFk = t_fk1.colPk
INNER JOIN t_fk2 ON t_main.colFk = t_fk2.colPk
WHERE t_main.searchBy = "";

-- --------------------------------------------------------------------------------------------- SELECT TO GET THE LAST QUOTE CREATED
DESCRIBE cotizaciones;
SELECT * FROM vehiculos;

SELECT * 
FROM cotizaciones 
INNER JOIN vehiculos ON cotizaciones.id_vehiculo_fk = vehiculos.id_vehiculo_pk 
	WHERE cotizaciones.fecha_orden = (SELECT MAX(cotizaciones.fecha_orden) FROM cotizaciones 
		WHERE cotizaciones.id_Vehiculo_fk = 1 AND cotizaciones.fecha_orden = "2024-05-10 12:00:00" AND cotizaciones.fecha_entrega = "2024-05-10 12:00:00");
        
SELECT * FROM cotizaciones WHERE cotizaciones.id_Vehiculo_fk = 1 AND cotizaciones.fecha_entrega = "2024-05-10 12:00:00";
        
-- --------------------------------------------------------------------------------------------- SELECT TO GET THE LAST QUOTE DETAILS CREATED
DESCRIBE cotizaciones_detalle;
SELECT * FROM cotizaciones_detalle;
SELECT * FROM cotizaciones_detalle WHERE id_cotizacion_fk = 2;
SELECT *
FROM cotizaciones_detalle
	WHERE id_cotizacion_detalle_pk = (SELECT MAX(id_cotizacion_detalle_pk) FROM cotizaciones_detalle
		WHERE id_cotizacion_fk=2);
			-- ORDER BY usuario_id;
            
-- ---------------------------------------------------------------------------------------------------- SEARCHS VEHICLES OF A CUSTOMER
SELECT * FROM vehiculos;
SELECT * FROM clientes;
DESCRIBE vehiculos;
DESCRIBE marcas;
DESCRIBE modelos;
DESCRIBE c_years;

SELECT vehiculos.color, vehiculos.placas, vehiculos.kilometraje_inicial, marcas.marca, modelos.modelo, c_years.c_year
	FROM vehiculos 
    INNER JOIN marcas ON vehiculos.id_marca_fk = marcas.id_marca_pk
    INNER JOIN modelos ON vehiculos.id_modelo_fk = modelos.id_modelo_pk
    INNER JOIN c_years ON vehiculos.id_c_years_fk = c_years.id_c_year_pk
		WHERE id_cliente_fk = 1;
        
-- ---------------------------------------------------------------------------------------------------------- SEARCHS QUOTES OF A VEHICLE
DESCRIBE cotizaciones;
SELECT * FROM cotizaciones;

SELECT * FROM cotizaciones
INNER JOIN vehiculos ON cotizaciones.id_vehiculo_fk = vehiculos.id_vehiculo_pk
	WHERE id_vehiculo_fk = 1;

-- ---------------------------------------------------------------------------------------------------------- SEARCHS USER ROLES BY USER
DESCRIBE users_role;
SELECT role_user_pk FROM users_role WHERE username_fk = "emily99";
SELECT * FROM users_role;

-- ------------------------------------------------------------------------------------------------------ SEARCH THE MAX MEC ID NUMBER
DESCRIBE users;
SELECT username_pk, mec_id FROM users;
SELECT MAX(mec_id) FROM users;