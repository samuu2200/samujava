package es.samujava.bbdd.ejercicios;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.samujava.pruebas.utilidades.Utilidades;
import es.samujava.utils.UtilidadesBaseDeDatos;

public class MainEmpleados {
    private static final Logger logger = LoggerFactory.getLogger(MainEmpleados.class);
    private static final String CONSULTA_BBDD = "SELECT * FROM empleados ORDER BY id ASC";
    private static final String CONSULTA_EQUIPOS = "SELECT e.id, e.nombre, e.NOMBRE, e.EDAD_EMPLEADO, e.SALARIO_EMPLEADO, e.ID_DEPARTAMENTO, e.FECHA_CONTRATACION, e.ID_EQUIPO, eq.nombre_equipo FROM empleados e JOIN equipos eq ON e.id = eq.id";

    public static void main(String[] args) {
        MainEmpleados me = new MainEmpleados();
        // Llamamos al método que crea la conexión con la bbdd
        Connection conex = UtilidadesBaseDeDatos.creaConexion();
        List<Empleados> listadoEmpleados = UtilidadesBaseDeDatos.listadoEmpleados(CONSULTA_BBDD, conex);
        Map<String, List<Empleados>> mapa = UtilidadesBaseDeDatos.consultaEquipos(CONSULTA_EQUIPOS, conex);
        me.ejecutar(mapa, conex);
    }

    /**
     * Método el cual le pasamos una lista y una conexión y nos permite ejecutar todo lo que nos venga por un lista
     * @param listadoEmpleados
     * @param conex
     */
    public void ejecutar(List<Empleados> listadoEmpleados, Connection conex) {
        tamanioLista(listadoEmpleados);
        int edad = Utilidades.pideDatoInt("Introduce la edad por la que quieras filtrar ");
        String CONSULTA_EDAD = "SELECT ID, NOMBRE, SALARIO_EMPLEADO, EDAD_EMPLEADO, ID_DEPARTAMENTO, FECHA_CONTRATACION FROM EMPLEADOS WHERE EDAD_EMPLEADO > " + edad ;
        UtilidadesBaseDeDatos.consultaEdad(CONSULTA_EDAD, conex, edad);
    }

    /**
     * Método el cual le pasamos un mapa y una conexión y nos permite ejecutar todo lo que nos venga por un mapa
     * @param mapa
     * @param conex
     */
    public void ejecutar(Map<String, List<Empleados>> mapa, Connection conex) {
        recorriendoMapa(mapa);
        UtilidadesBaseDeDatos.consultaEquipos(CONSULTA_EQUIPOS, conex);
    }

    private void recorriendoMapa(Map<String, List<Empleados>> mapa) {
        Set<String> claves = mapa.keySet();
        for (String clave : claves) {
            List<Empleados> valores = mapa.get(clave);
            for (Empleados valor : valores) {
                System.out.println("*** Empleado " + valor.getNombre() + " ***");
                System.out.println("Nombre equipo: " + clave);
                System.out.println("Empleado: " + valor);
            }
        }
    }

    public void tamanioLista(List<Empleados> listadoEmpleados) {
        int contadorRegistro = 0;
        for (int i = 0; i < listadoEmpleados.size(); i++) {
            contadorRegistro++;
        }
        System.out.println("Listado de registros: " + contadorRegistro);
    }

}
