package es.samujava.pruebas.alumnos;

public class Alumnos {
    private String nombre;
	private String apellidos;
	private int edad;
	private double notaMedia;
	private String email;
	private String [] asignaturas;
	
	public Alumnos() {
		
	}
	
	public Alumnos(String nombre, String apellidos, int edad, double notaMedia, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.notaMedia = notaMedia;
		this.email = email;
	}
	
	public Alumnos(String nombre, String apellidos, int edad, double notaMedia, 
			String email, String[] asignaturas) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.notaMedia = notaMedia;
		this.email = email;
		this.asignaturas = asignaturas;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(String[] asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
	public void estudiar () {
		if (this.notaMedia==0) {
			System.out.println("No ha estudiado nada");
		}else if (notaMedia<5) {
			System.out.println("Ha estudiado muy poco");
		}else if (notaMedia<7) {
			System.out.println("Es buen estudiante");
		}else if (notaMedia<10) {
			System.out.println("Ha estudiado mucho");
		}else if (notaMedia==10) {
			System.out.println("Es un genio");
		}
	}

    // Mostrar información del alumnos
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ").append(nombre + "\n");
        sb.append("Apellido: ").append(apellidos + "\n");
        sb.append("Edad: ").append(edad + "\n");
        sb.append("Nota media: ").append(notaMedia + "\n");
        sb.append("Correo: ").append(email + "\n");
        return sb.toString();
    }

    // Método que nos dice la información de cada alumno
    public void mostrarInformacion() {
		System.out.println(toString());
		System.out.println("==============");
    }
    
}
