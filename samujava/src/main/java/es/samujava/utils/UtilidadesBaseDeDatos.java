package es.samujava.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilidadesBaseDeDatos {
	private static final String URL_BD_ORACLE = "jdbc:oracle:thin:samuu/password@localhost:1522:XE";
    private static final String URL_BD_ORACLE2 = "jdbc:oracle:thin:@localhost:1522:XE";
    private static final String USERNAME = "samuu";
    private static final String PASSWORD = "password";
    private static Connection conex = null;
    private static String error = "";
	public static void main(String[] args) {
		creaConexion();
	}

	public static Connection creaConexion() {
		// Llamamos al método creaConexión y así evitamos repetir código
		conex = creaConexion(URL_BD_ORACLE, USERNAME, PASSWORD);

		return conex;
	}

	public static Connection creaConexion(String url, String user, String password) {
		try {
			conex = DriverManager.getConnection(url, user, password);
			if (conex != null) {
				System.out.println("Conexion establecida");
			}

		} catch (SQLException e) {
			error = "Ha habido un error " + e.getMessage();
			// e.printStackTrace();
		} 
		return conex;
	}

	public static void  cierraConexion(Connection conex) {
		try {
			conex.close();
		} catch (SQLException e) {
			error = "Ha habido un error al cerrar la conexión: " + e.getMessage();
		}
	}

}
