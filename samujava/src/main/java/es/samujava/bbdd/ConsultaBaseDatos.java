package es.samujava.bbdd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.samujava.utils.UtilidadesBaseDeDatos;

public class ConsultaBaseDatos {
    private static final String CONSULTA_EMPLEADOS = "SELECT ID, SALARIO_EMPLEADO EDAD_EMPLEADO FROM EMPLEADOS WHERE EDAD_EMPLEADO > 30 ORDEN BY SALARIO_EMPLEADO DESC";
    public static void main(String[] args) {

        Connection conexion = UtilidadesBaseDeDatos.creaConexion();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(CONSULTA_EMPLEADOS);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                int edad = rs.getInt("EDAD_EMPLEADO");
                int salario = rs.getInt("SALARIO_EMPLEADO");

                System.out.printf("""
                        %n*** EMPLEADO ***
                        ID: %d,
                        NOMBRE: %s,
                        EDAD: %d,
                        SALARIO: %d
                        """, id, nombre, edad, salario);

            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("TERMINA");
    }

}
