package com.dulsystems.mta.util;

public class Queries {
	//CUSTOMER CRUD SQLS
	public static final String Q_CUSTOMERS_SEARCH_BY_ID = "SELECT * FROM clientes WHERE id_cliente_pk = ?;";
	public static final String Q_CUSTOMERS_REMOVE_BY_ID = "DELETE FROM clientes WHERE id_cliente_pk = ?";
	public static final String Q_CUSTOMERS_SAVE = "INSERT INTO clientes(id_estado_fk, id_municipio_fk, nombre, particular_o_empresa, referencia, rfc, cp, email, telefono) VALUES(?,?,?,?,?,?,?,?,?);";
	public static final String Q_CUSTOMERS_UPDATE_BY_ID = "UPDATE clientes SET id_estado_fk = ?, id_municipio_fk = ?, nombre = ?, particular_o_empresa = ?, referencia = ?, rfc = ?, cp = ?, email = ?, telefono = ? WHERE id_cliente_pk = ?";
	
	//STATE CRUD SQLS
	public static final String Q_STATES_SEARCH_BY_ID = "SELECT * FROM estados WHERE id_estado_pk = ?;";
	public static final String Q_STATES_SEARCH_BY_STATE = "SELECT * FROM estados WHERE estado = ?;";
	public static final String Q_STATES_REMOVE_BY_STATE = "DELETE FROM estados WHERE estado = ?";
	public static final String Q_STATES_SAVE = "INSERT INTO estados(estado) VALUES(?);";
	public static final String Q_STATES_UPDATE_BY_STATE = "UPDATE estados SET estado = ? WHERE estado = ?";
	
	//MUNICIPALITY CRUD SQLS
	public static final String Q_MUNICIPALITIES_SEARCH_BY_ID = "SELECT * FROM municipios WHERE id_municipio_pk = ?;";
	public static final String Q_MUNICIPALITIES_SEARCH_BY_MUNICIPALITY = "SELECT * FROM municipios WHERE municipio = ?;";
	public static final String Q_MUNICIPALITIES_REMOVE_BY_MUNICIPALITY = "DELETE FROM municipios WHERE municipio = ?";
	public static final String Q_MUNICIPALITIES_SAVE = "INSERT INTO municipios(id_estado_fk, municipio) VALUES(?,?);";
	public static final String Q_MUNICIPALITIES_UPDATE_BY_MUNICIPALITY = "UPDATE municipios SET id_estado_fk = ?, municipio = ? WHERE municipio = ?";
	
	//VEHICLE CRUD SQLS
	public static final String Q_VEHICLES_SEARCH_BY_PLATE = "SELECT * FROM vehiculos WHERE placas = ?;";
	public static final String Q_VEHICLES_REMOVE_BY_PLATE = "DELETE FROM vehiculos WHERE placas = ?";
	public static final String Q_VEHICLES_SAVE = "INSERT INTO vehiculos(id_cliente_fk, id_marca_fk, id_modelo_fk, id_c_years_fk, color, placas, kilometraje_inicial) VALUES(?,?,?,?,?,?,?);";
	public static final String Q_VEHICLES_UPDATE_BY_PLATE = "UPDATE vehiculos SET id_cliente_fk = ?, id_marca_fk = ?, id_modelo_fk = ?, id_c_years_fk = ?, color = ?, placas = ?, kilometraje_inicial = ? WHERE placas = ?";
	
	//VEHICLE LINE CRUD SQLS
	public static final String Q_VEHICLES_LINE_SEARCH_BY_ID = "SELECT * FROM marcas WHERE id_marca_pk = ?;";
	public static final String Q_VEHICLES_LINE_SEARCH_BY_LINE = "SELECT * FROM marcas WHERE marca = ?;";
	public static final String Q_VEHICLES_LINE_REMOVE_BY_LINE = "DELETE FROM marcas WHERE marca = ?;";
	public static final String Q_VEHICLES_LINE_SAVE = "INSERT INTO marcas(marca) VALUES(?);";
	public static final String Q_VEHICLES_LINE_UPDATE_BY_LINE = "UPDATE marcas SET marca = ? WHERE marca = ?";
	
	//VEHICLE MODEL CRUD SQLS
	public static final String Q_VEHICLES_MODEL_SEARCH_BY_ID = "SELECT * FROM modelos WHERE id_modelo_pk = ?;";
	public static final String Q_VEHICLES_MODEL_SEARCH_BY_MODEL = "SELECT * FROM modelos WHERE modelo = ?;";
	public static final String Q_VEHICLES_MODEL_REMOVE_BY_MODEL = "DELETE FROM modelos WHERE modelo = ?;";
	public static final String Q_VEHICLES_MODEL_SAVE = "INSERT INTO modelos(id_marca_fk, modelo) VALUES(?,?);";
	public static final String Q_VEHICLES_MODEL_UPDATE_BY_MODEL = "UPDATE modelos SET id_marca_fk = ?, modelo = ? WHERE modelo = ?";
	
	//VEHICLE YEAR CRUD SQLS
	public static final String Q_VEHICLES_YEAR_SEARCH_BY_ID = "SELECT * FROM c_years WHERE id_c_year_pk = ?;";
	public static final String Q_VEHICLES_YEAR_SEARCH_BY_YEAR = "SELECT * FROM c_years WHERE c_year = ?;";
	public static final String Q_VEHICLES_YEAR_REMOVE_BY_YEAR = "DELETE FROM c_years WHERE c_year = ?;";
	public static final String Q_VEHICLES_YEAR_SAVE = "INSERT INTO c_years(c_year) VALUES(?);";
	public static final String Q_VEHICLES_YEAR_UPDATE_BY_YEAR = "UPDATE c_years SET c_year = ? WHERE c_year = ?";
	
	//QUOTES CRUD SQLS
	public static final String Q_QUOTES_SEARCH_BY_ID = "SELECT * FROM cotizaciones WHERE id_cotizacion_pk = ?;";
	public static final String Q_QUOTES_REMOVE_BY_ID = "DELETE FROM cotizaciones WHERE id_cotizacion_pk = ?;";
	public static final String Q_QUOTES_SAVE = "INSERT INTO cotizaciones(id_vehiculo_fk,fecha_orden,fecha_entrega,estatus_auto,metodo_pago,estatus_pago,adelanto_pago,factura) VALUES(?,?,?,?,?,?,?,?);";
	public static final String Q_QUOTES_UPDATE_BY_ID = "UPDATE cotizaciones SET id_vehiculo_fk = ?, fecha_orden = ?, fecha_entrega = ?, estatus_auto = ?, metodo_pago = ?, estatus_pago = ?, adelanto_pago = ?, factura = ? WHERE id_cotizacion_pk = ?";
		
	//DETAIL QUOTES CRUD SQLS
	public static final String Q_QUOTE_DETAILS_SEARCH_BY_ID = "SELECT * FROM cotizaciones_detalle WHERE id_cotizacion_fk = ?;";
	public static final String Q_QUOTE_DETAILS_REMOVE_BY_ID = "DELETE FROM cotizaciones_detalle WHERE id_cotizacion_detalle_pk = ?;";
	public static final String Q_QUOTE_DETAILS_SAVE = "INSERT INTO cotizaciones_detalle(id_cotizacion_fk,mec,mano_obra_refacciones,importe) VALUES(?,?,?,?);";
	public static final String Q_QUOTE_DETAILS_UPDATE_BY_ID = "UPDATE cotizaciones_detalle SET id_cotizacion_fk = ?, mec = ?, mano_obra_refacciones = ?, importe = ? WHERE id_cotizacion_detalle_pk = ?";

	//USERS CRUD SQLS
	public static final String Q_USERS_SEARCH_BY_USER_1 = "SELECT * FROM users WHERE username_pk = ?;";
	public static final String Q_USERS_SEARCH_BY_USER_2 = "SELECT username_pk, user_name, cargo, email, lockedd, disabled FROM users WHERE username_pk = ?;";
	public static final String Q_USERS_REMOVE_BY_USER = "DELETE FROM users WHERE username_pk = ?;";
	public static final String Q_USERS_SAVE = "INSERT INTO users(username_pk,passwordd,user_name,cargo,email,lockedd,disabled) VALUES(?,?,?,?,?,?,?);";
	public static final String Q_USERS_UPDATE_ALL_EXCEPT_PASSWORD_AND_EMAIL_BY_USER = "UPDATE users SET username_pk = ?, user_name = ?, cargo = ?, lockedd = ?, disabled = ? WHERE username_pk = ?";
	/*FALTA CONTROLLER PARA ESTE SQL*/public static final String Q_USERS_UPDATE_PASSWORD_BY_USER = "UPDATE users SET passwordd = ? WHERE username_pk = ?";
	/*FALTA CONTROLLER PARA ESTE SQL*/public static final String Q_USERS_UPDATE_EMAIL_BY_USER = "UPDATE users SET email = ? WHERE username_pk = ?";
	//USERS INNER JOIN USER ROLES CRUD SQLS
	public static final String Q_USERS_INNER_USER_ROLES_BY_USER = "SELECT users.username_pk, users_role.role_user_pk, users_role.granted_date\r\n"
																	+ "FROM users\r\n"
																	+ "INNER JOIN users_role ON users.username_pk = users_role.username_fk\r\n"
																	+ "WHERE users.username_pk = ?;";

	//USER ROLES CRUD SQLS
	public static final String Q_USER_ROLES_SEARCH_BY_ROLE_AND_USER = "SELECT * FROM users_role WHERE role_user_pk = ? AND username_fk =?;";
	public static final String Q_USER_ROLES_REMOVE_BY_ROLE_AND_USER = "DELETE FROM users_role WHERE role_user_pk = ? AND username_fk =?;";
	public static final String Q_USER_ROLES_SAVE = "INSERT INTO users_role(role_user_pk,username_fk,granted_date) VALUES(?,?,?);";
	public static final String Q_USER_ROLES_UPDATE_BY_ROLE_AND_USER = "UPDATE users_role SET role_user_pk = ?, username_fk = ?, granted_date = ? WHERE role_user_pk = ? AND username_fk = ?;";

}
