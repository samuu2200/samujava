package es.samujava.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.samujava.bbdd.ejercicios.Empleados;
import es.samujava.ficheros.ejercicios.pojos.Eventos;

public class UtilidadesBaseDeDatos {
	private static final String URL_BD_ORACLE = "jdbc:oracle:thin:samuu/password@localhost:1522:XE";
	private static final String URL_BD_ORACLE2 = "jdbc:oracle:thin:@localhost:1522:XE";
	private static final String USERNAME = "samuu";
	private static final String PASSWORD = "password";
	private static Connection conex = null;
	private static String error = "";

	private static final Logger logger = LoggerFactory.getLogger(UtilidadesBaseDeDatos.class);

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
			logger.info(error);
			// e.printStackTrace();
		}
		return conex;
	}

	public static void cierraConexion(Connection conex) {
		try {
			conex.close();
		} catch (SQLException e) {
			error = "Ha habido un error al cerrar la conexión: " + e.getMessage();
		}
	}

	public static Map<String, List<Empleados>> consultaEquipos(String consulta, Connection conex) {
		Map<String, List<Empleados>> mapa = new HashMap<>();
		List<Empleados> listadoEmpleados = new ArrayList<>();

		try {
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				String nombre = rs.getString("NOMBRE");
				String nombreEquipo = rs.getString("NOMBRE_EQUIPO");
				int id = rs.getInt("ID");
				double salario = rs.getInt("SALARIO_EMPLEADO");
				int idDepartamento = rs.getInt("ID_DEPARTAMENTO");
				Date fechaContratacion = rs.getDate("FECHA_CONTRATACION");

				Empleados empleado = new Empleados(idDepartamento, nombreEquipo, id, salario, idDepartamento,
						fechaContratacion);

				mapa.putIfAbsent(nombreEquipo, new ArrayList<>());

				if (mapa.get(nombreEquipo) == null) {
					listadoEmpleados.add(empleado);
					mapa.put(nombreEquipo, listadoEmpleados);
				} else
					mapa.get(nombreEquipo).add(empleado);
			}


			st.close();
			rs.close();
		} catch (SQLException e) {
			logger.error("Error en la consulta: ", e.getMessage());
		}
		return mapa;
	}

	public static void consultaEdad(String consulta, Connection conex, int edad) {
		listadoEmpleados(consulta, conex);
		List<Empleados> listaEmpleados = new ArrayList<>();

		try {
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("NOMBRE");
				edad = rs.getInt("EDAD_EMPLEADO");
				double salario = rs.getInt("SALARIO_EMPLEADO");
				int idDepartamento = rs.getInt("ID_DEPARTAMENTO");
				Date fechaContratacion = rs.getDate("FECHA_CONTRATACION");

				rs.toString();

				System.out.printf("""
						%n*** Empleados ***
						id: %d
						Nombre: %s
						Edad: %d
						Salario: %.2f
						Id departamento: %d
						Fecha de contratación: %s
						""", id, nombre, edad, salario, idDepartamento, fechaContratacion);
			}

			st.close();
			rs.close();
		} catch (SQLException e) {
			logger.error("Error en la consulta: ", e.getMessage());
		}
	}

	public static void consulta(String consulta, Connection conex, int edad) {

		List<Empleados> listaEmpleados = new ArrayList<>();

		try {
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("NOMBRE");
				edad = rs.getInt("EDAD_EMPLEADO");
				double salario = rs.getInt("SALARIO_EMPLEADO");
				int idDepartamento = rs.getInt("ID_DEPARTAMENTO");
				Date fechaContratacion = rs.getDate("FECHA_CONTRATACION");

				System.out.printf("""
						%n*** Empleados ***
						id: %d
						Nombre: %s
						Edad: %d
						Salario: %.2f
						Id departamento: %d
						Fecha de contratación: %s
						""", id, nombre, edad, salario, idDepartamento, fechaContratacion);
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			logger.error("Error en la consulta: ", e.getMessage());
		}
	}

	public static List<Empleados> listadoEmpleados(String consulta, Connection conex) {
		List<Empleados> listaEmpleados = new ArrayList<>();

		try {
			Statement st = conex.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("NOMBRE");
				int edad = rs.getInt("EDAD_EMPLEADO");
				double salario = rs.getInt("SALARIO_EMPLEADO");
				int idDepartamento = rs.getInt("ID_DEPARTAMENTO");
				Date fechaContratacion = rs.getDate("FECHA_CONTRATACION");

				Empleados empleado = new Empleados(id, nombre, edad, salario, idDepartamento, fechaContratacion);
				listaEmpleados.add(empleado);
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			logger.error("Error en la consulta: ", e.getMessage());
		}

		return listaEmpleados;
	}

}
