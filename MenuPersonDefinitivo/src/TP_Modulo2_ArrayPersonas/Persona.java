package TP_Modulo2_ArrayPersonas;

public class Persona {
	private String nombre, apellido, localidad;
	private int edad, dni, telefono;
	
	public Persona(String nombre, String apellido, String localidad, int edad, int dni, int telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.localidad = localidad;
		this.edad = edad;
		this.dni = dni;
		this.telefono = telefono;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	public String toString() {
		return  "------------------------------------- \n"
			  + "-NOMBRE Y APELLIDO: " + nombre + " " + apellido + "\n"
			  + "-LOCALIDAD: "+ localidad + "\n"
			  + "-EDAD: " + edad + "\n"
			  + "-DNI " + dni + "\n"
			  + "-TELEFONO: " + telefono + "\n"
			  + "-------------------------------------";
	}
	
	public void mostrarDatos() {
		System.out.println("------------------------------------- \n"
						 + "-NOMBRE Y APELLIDO: " + getNombre() + " " +  getApellido() + "\n"
				 		 + "-DNI: " + getDni() + "\n"
				 		 + "-TELEFONO: " + getTelefono() + "\n"
				 		 + "-------------------------------------");
	}
	
	public void mostrarDatosxLocalidad() {
		System.out.println("------------------------------------- \n"
						 + "-NOMBRE Y APELLIDO: " + getNombre() + " " +  getApellido() + "\n"
						 + "-DNI: " + getDni() + "\n"
						 + "-EDAD: " + getEdad() + "\n"
						 + "-TELEFONO: " + getTelefono() + "\n"
						 + "-------------------------------------");
	}
	
	public void mostrarDatosxDNI() {
		System.out.println("------------------------------------- \n"
						 + "NOMBRE Y APELLIDO: " + getNombre() + " " + getApellido() + "\n"
				 		 + "DNI: " + getDni() + "\n"
				 		 + "-------------------------------------");
	}
}