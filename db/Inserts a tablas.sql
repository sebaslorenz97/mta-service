use mi_taller_automotriz;


-- ---------------------------------------------------------------------------------------------------------------- TABLAS DEL SYSTEMA
SELECT * FROM users;
-- DELETE FROM users;
-- DELETE FROM users WHERE username_pk = "jose.bausan";
-- DELETE FROM users WHERE 1=1;
DESCRIBE users;
INSERT INTO users(username_pk,passwordd,user_name,cargo,email,lockedd,disabled) VALUES("sebaslorenz97","$2y$10$v67qfulL76GvqTrpRew6mObkqp3v6.G.PWNbEBLRC53.7LWaCP/uO","Lorenzo Sebastian","CEO","lorseb97@gmail.com",0,0);
INSERT INTO users(username_pk,passwordd,user_name,cargo,email,lockedd,disabled) VALUES("vanessa97","$2y$10$o2zd1nFoPr15Xih9GTxwGO1IncGspmU58/xcw1nrqnaVLOILlFrfa","Vanessa Herrera","Manager","hrvanne@gmail.com",0,0);
INSERT INTO users(username_pk,passwordd,user_name,cargo,email,lockedd,disabled) VALUES("emily99","$2y$10$yXCyvqYhQQODhlX5usUilO76Zd00bbGjl/NTxV43ebrPwBNBOZA36","Emily Manzewitch","HR","emily.manzwitch@gmail.com",0,0);
INSERT INTO users(username_pk,passwordd,user_name,cargo,email,lockedd,disabled) VALUES("jose.bausan","$2y$10$ZN.xPwxa69LODDEmsks3Juf4Ij9Shlm/N2.maPpIgrKiG2ZZ.3F.m","Jose Bautista","Mecanico","jose@gmail.com",0,0);
INSERT INTO users(username_pk,passwordd,user_name,cargo,email,lockedd,disabled) VALUES("FeRnAnDo3302!","$2y$10$Iilg0g7PeOQnUjozva6IWetWS.JFKzuwND1zktmKGKzCj3N0wemDW","Fernando Ortega","CEO","fernando@gmail.com",0,0);
UPDATE t SET passwordd = "val1" WHERE username_pk = "valX";

SELECT * FROM users_role;
-- DELETE FROM users_role;
-- DELETE FROM users_role WHERE role_user_pk = "EMPLOYEE" AND username_fk = "sebaslorenz97";
-- DELETE FROM users_role WHERE 1=1;
DESCRIBE users_role;
INSERT INTO users_role(role_user_pk,username_fk,granted_date) VALUES("ADMIN","sebaslorenz97","2024-05-29");
INSERT INTO users_role(role_user_pk,username_fk,granted_date) VALUES("MANAGER","vanessa97","2024-05-29");
INSERT INTO users_role(role_user_pk,username_fk,granted_date) VALUES("EMPLOYEE","emily99","2024-05-29");
INSERT INTO users_role(role_user_pk,username_fk,granted_date) VALUES("EMPLOYEE","jose.bausan","2024-05-29");
UPDATE users_role SET role_user_pk = "EMPLOYEE" WHERE role_user_pk = "MANAGER" AND username_fk = "emily99";


-- ------------------------------------------------------------------------------------------------------ TABLAS DEL DOMINIO DE LA APP
SELECT * FROM estados;
-- DELETE FROM estados;
-- DELETE FROM estados WHERE id_estado_pk = 1;
DELETE FROM estados WHERE 1=1;
ALTER TABLE estados AUTO_INCREMENT = 5;
DESCRIBE estados;
INSERT INTO estados(estado) VALUES("Queretaro");
INSERT INTO estados(estado) VALUES("Ciudad De Mexico");
INSERT INTO estados(estado) VALUES("Veracruz");
INSERT INTO estados(estado) VALUES("Guadalajara");

SELECT * FROM municipios;
-- DELETE FROM municipios;
-- DELETE FROM municipios WHERE id_municipio_pk = 1;
DELETE FROM municipios WHERE 1=1;
ALTER TABLE municipios AUTO_INCREMENT = 5;
DESCRIBE municipios;
INSERT INTO municipios(id_estado_fk, municipio) VALUES(1, "Queretaro");
INSERT INTO municipios(id_estado_fk, municipio) VALUES(1, "El Marques");
INSERT INTO municipios(id_estado_fk, municipio) VALUES(1, "Corregidora");
INSERT INTO municipios(id_estado_fk, municipio) VALUES(1, "Huimilpan");

SELECT * FROM clientes;
-- DELETE FROM clientes;
-- DELETE FROM clientes WHERE id_cliente_pk = 13;
DELETE FROM clientes WHERE 1=1;
ALTER TABLE clientes AUTO_INCREMENT = 1;
DESCRIBE clientes;
INSERT INTO clientes(id_estado_fk, id_municipio_fk, nombre, particular_o_empresa, referencia, rfc, cp, email, telefono) VALUES(1, 2,"DULSystems",1,"Uziel Lorenzo", "LOSD971125", "76116","uziellorenzo.97@gmail.com", "4426775176");
INSERT INTO clientes(id_estado_fk, id_municipio_fk, nombre, particular_o_empresa, referencia, rfc, cp, email, telefono) VALUES(1, 2,"Diana Argueyes",0,"", "DASLS001125", "76116","dianaargs@gmail.com", "4426775176");
INSERT INTO clientes(id_estado_fk, id_municipio_fk, nombre, particular_o_empresa, referencia, rfc, cp, email, telefono) VALUES(1, 2,"Grecia Lorenzo",0,"", "XINA001125", "76116","grecials@gmail.com", "4426775176");
INSERT INTO clientes(id_estado_fk, id_municipio_fk, nombre, particular_o_empresa, referencia, rfc, cp, email, telefono) VALUES(1, 2,"Adilene Lorenzo",0,"", "IGLS001125", "76116","adils@gmail.com", "4426775176");

SELECT * FROM marcas;
-- DELETE FROM marcas;
-- DELETE FROM marcas WHERE id_marca_pk = 1;
DELETE FROM marcas WHERE 1=1;
ALTER TABLE marcas AUTO_INCREMENT = 5;
DESCRIBE marcas;
INSERT INTO marcas(marca) VALUES("Nissan");
INSERT INTO marcas(marca) VALUES("Volkswagen");
INSERT INTO marcas(marca) VALUES("Chevrolet");
INSERT INTO marcas(marca) VALUES("Audi");

SELECT * FROM modelos;
-- DELETE FROM marcas;
-- DELETE FROM modelos WHERE id_modelo_pk=5;
DELETE FROM modelos WHERE 1=1;
ALTER TABLE modelos AUTO_INCREMENT = 5;
DESCRIBE modelos;
INSERT INTO modelos(id_marca_fk, modelo) VALUES(1,"Versa Exclusive");
INSERT INTO modelos(id_marca_fk, modelo) VALUES(1,"X-Trail Advance");
INSERT INTO modelos(id_marca_fk, modelo) VALUES(1,"Altima Advance");
INSERT INTO modelos(id_marca_fk, modelo) VALUES(2,"Jetta");

SELECT * FROM c_years;
-- DELETE FROM c_years;
-- DELETE FROM c_years WHERE id_c_year_pk=1;
DELETE FROM c_years WHERE 1=1;
ALTER TABLE c_years AUTO_INCREMENT = 5;
DESCRIBE c_years;
UPDATE c_years SET c_year = 2023 WHERE id_c_year_pk = 2;
INSERT INTO c_years(c_year) VALUES(2024);
INSERT INTO c_years(c_year) VALUES(2023);
INSERT INTO c_years(c_year) VALUES(2022);
INSERT INTO c_years(c_year) VALUES(2021);

SELECT * FROM vehiculos;
-- DELETE FROM vehiculos;
-- DELETE FROM vehiculos WHERE id_vehiculo_pk=16;
DELETE FROM vehiculos WHERE 1=1;
ALTER TABLE vehiculos AUTO_INCREMENT = 1;
DESCRIBE vehiculos;
INSERT INTO vehiculos(id_cliente_fk, id_marca_fk, id_modelo_fk, id_c_years_fk, color, placas, kilometraje_inicial) VALUES(1,1,1,1,"Naranja","UNK-529-D",55789);
INSERT INTO vehiculos(id_cliente_fk, id_marca_fk, id_modelo_fk, id_c_years_fk, color, placas, kilometraje_inicial) VALUES(1,2,1,1,"Rojo","UNK-339-D",3789);
INSERT INTO vehiculos(id_cliente_fk, id_marca_fk, id_modelo_fk, id_c_years_fk, color, placas, kilometraje_inicial) VALUES(2,1,1,1,"Azul","UNK-229-D",35789);
INSERT INTO vehiculos(id_cliente_fk, id_marca_fk, id_modelo_fk, id_c_years_fk, color, placas, kilometraje_inicial) VALUES(3,2,2,2,"Plata","UNK-429-D",85789);

SELECT * FROM cotizaciones;
-- DELETE FROM cotizaciones;
-- DELETE FROM cotizaciones WHERE id_cotizacion_pk=7;
DELETE FROM cotizaciones WHERE 1=1;
ALTER TABLE cotizaciones AUTO_INCREMENT = 1;
DESCRIBE cotizaciones;
INSERT INTO cotizaciones(id_vehiculo_fk,fecha_orden,fecha_entrega,estatus_auto,metodo_pago,estatus_pago,adelanto_pago,factura) VALUES(1,"2024-04-24 16:44:30","2024-05-01 12:00:00","Pendiente",false,false,2300,false);
INSERT INTO cotizaciones(id_vehiculo_fk,fecha_orden,fecha_entrega,estatus_auto,metodo_pago,estatus_pago,adelanto_pago,factura) VALUES(4,"2024-04-27 15:44:30","2024-05-02 12:00:00","En proceso",false,false,20000,false);
INSERT INTO cotizaciones(id_vehiculo_fk,fecha_orden,fecha_entrega,estatus_auto,metodo_pago,estatus_pago,adelanto_pago,factura) VALUES(2,"2024-04-29 18:44:30","2024-05-02 12:00:00","Pendiente",false,false,3000,false);
INSERT INTO cotizaciones(id_vehiculo_fk,fecha_orden,fecha_entrega,estatus_auto,metodo_pago,estatus_pago,adelanto_pago,factura) VALUES(3,"2024-04-29 19:44:30","2024-05-10 12:00:00","Pendiente",false,false,0,false);
INSERT INTO cotizaciones(id_vehiculo_fk,fecha_orden,fecha_entrega,estatus_auto,metodo_pago,estatus_pago,adelanto_pago,factura) VALUES(3,"2024-05-04 13:44:30","2024-05-10 12:00:00","Pendiente",false,false,0,false);

SELECT * FROM cotizaciones_detalle;
-- DELETE FROM cotizaciones_detalle;
-- DELETE FROM cotizaciones_detalle WHERE id_cotizacion_detalle_pk = 14;
DELETE FROM cotizaciones_detalle WHERE 1=1;
ALTER TABLE cotizaciones_detalle AUTO_INCREMENT = 1;
DESCRIBE cotizaciones_detalle;
INSERT INTO cotizaciones_detalle(id_cotizacion_fk,mec,mano_obra_refacciones,importe) VALUES(1,1,"Afinacion",10000);
INSERT INTO cotizaciones_detalle(id_cotizacion_fk,mec,mano_obra_refacciones,importe) VALUES(1,2,"Aceite",800);
INSERT INTO cotizaciones_detalle(id_cotizacion_fk,mec,mano_obra_refacciones,importe) VALUES(1,3,"Filtros",2000);
INSERT INTO cotizaciones_detalle(id_cotizacion_fk,mec,mano_obra_refacciones,importe) VALUES(2,1,"Afinacion",3000);
INSERT INTO cotizaciones_detalle(id_cotizacion_fk,mec,mano_obra_refacciones,importe) VALUES(2,2,"Filtros",1500);
INSERT INTO cotizaciones_detalle(id_cotizacion_fk,mec,mano_obra_refacciones,importe) VALUES(2,3,"Aceite",4000);
INSERT INTO cotizaciones_detalle(id_cotizacion_fk,mec,mano_obra_refacciones,importe) VALUES(4,1,"Cambuo Aceite",800);
INSERT INTO cotizaciones_detalle(id_cotizacion_fk,mec,mano_obra_refacciones,importe) VALUES(3,2,"Cambio Aceite",800);


-- -----------------------------------------------------------------------------------------------------------------------------------
-- GUIA PARA INSERTS Y UPDATES
SELECT * FROM t;
-- DELETE FROM t;
-- DELETE FROM t WHERE col_1 = ?;
DELETE FROM t WHERE 1=1;
ALTER TABLE t AUTO_INCREMENT = 5;
DESCRIBE t;
INSERT INTO t() VALUES();
UPDATE t SET col_1 = "val1", col_2 = "val2", col_3 = "val3", col_N = "valN" WHERE col_X = "valX";