package es.samujava.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class ConexionBaseDatos {
	public static void main(String[] args) {

		conectaOracle2();
	}

	/*
	 * Pasos para conectar a una base de datos
	 * 1. La url para acceder a la base de datos(tenemos que saber a que bbdd vamos
	 * para saber que url vamos a meter)
	 * 2.
	 */

	private static void conectaOracle() {
		String url_oracle = "jdbc:oracle:thin:samuu/password@localhost:1522:XE"; // Url de conexión a bbdd
		String url_oracle2 = "jdbc:oracle:thin:@localhost:1522:XE";
		String username = "samuu";
		String password = "password";

		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver"); // Quiero utilizar esta
			// clase y quiero aplicarla dentro de
			// nuestro proyecto
			Connection connection = DriverManager.getConnection(url_oracle2, username, password);
			if (connection != null) {
				System.out.println("Conexion establecida");
			}

		} catch (SQLException e) {
			System.err.println("Ha habido un error " + e.getMessage());
			// e.printStackTrace();
		} /*
			 * catch (ClassNotFoundException e) {
			 * e.printStackTrace();
			 * }
			 */

	}

	private static void conectaOracle2() {
		String url_oracle = "jdbc:oracle:thin:samuu/password@localhost:1522:XE";
		String url_oracle2 = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "samuu";
		String password = "password";

		Connection connection = null;
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL(url_oracle);

			connection = ods.getConnection();
			if (connection != null) {
				System.out.println("Conexion establecida");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
