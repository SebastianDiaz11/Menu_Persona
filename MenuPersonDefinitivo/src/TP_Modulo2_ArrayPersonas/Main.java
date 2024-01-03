package TP_Modulo2_ArrayPersonas;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner (System.in);
	static Persona[] p;
	static Persona [] p_copia;
	static int personaNro = 0;
	static int listaSize = 0;
	
	public static void main(String[] args) {
		boolean rangoLista;
		boolean salir = false;
		
		do {
			System.out.println("Ingrese la cantidad de personas que contenga la lista (entre 10 y 20)");
			listaSize = entrada_int();
			rangoLista = listaSize > 10 && listaSize < 20;
			
			if (!rangoLista) {
				System.out.println("El numero ingresado no se encuentra dentro del rango admitido");
			} 
		} while (!rangoLista);
		
		p = new Persona [listaSize];
		p_copia= new Persona [listaSize];
		
		do {
			menuPrincipal();
			int opcion = entrada_int();
			
			switch (opcion) {
				case 1: {
					cargarPersona();
					break;
				}
				case 2: {
					if (p[0] != null) {
						mostrarPersona();
					}
					else {
						System.out.println("No se encuentran personas cargadas para realizar esta operacion \n");
					}
					break;
				}
				case 3: {
					if (p[0] != null) {
						mostrarPersonaMayor();
					}
					else {
						System.out.println("No se encuentran personas cargadas para realizar esta operacion \n");
					}
					break;
				}
				case 4: {
					if (p[0] != null) {
						mostrarPersonaxLocalidad();
					}
					else {
						System.out.println("No se encuentran personas cargadas para realizar esta operacion \n");
					}
					break;
				}
				case 5: {
					if (p[0] != null) {
						buscarPersonaxDNI();
					}
					else {
						System.out.println("No se encuentran personas cargadas para realizar esta operacion \n");
					}
					break;
				}
				case 6: {
					System.out.println("Ingrese la operacion que desee realizar: \n"
									 + "1- Ordenar DNI de mayor a menor \n" 
									 + "2- Ordenar DNI de menor a mayor \n");
					int opcion1 = entrada_int();
					switch(opcion1) {
						case 1: {
							if (p[0] != null && p[1] != null) {
								ordenarxDNI_creciente();
								mostrarPersona();
							}
							else {
								System.out.println("No se encuentran suficientes personas cargadas para realizar esta operacion \n");
							}
							
							break;
						}
						case 2: {
							if (p[0] != null && p[1] != null) {
								ordenarxDNI_decreciente();
								mostrarPersona();
							}
							else {
								System.out.println("No se encuentran suficientes personas cargadas para esta operacion \n");
							}
						}
						default:
							System.out.println("valor invalido");
							break;
					}
					break;
				}
				case 7: {
					char opcionSalida;
					do {
						System.out.println("Ingrese N si no quiere salir \n"
										 + "Ingrese S para salir");
						
						opcionSalida = scanner.next().charAt(0);
						
						switch (opcionSalida) {
							case 'N': {
								break;
							}
							case 'S': {
								salir = true;
								break;
							}
							default:
								System.out.println("valor invalido");
								break;
						}
					} while (opcionSalida != 'S' && opcionSalida != 'N');	
					break;
				}
				default:
					System.out.println("valor invalido");
					break;
			}
		} while(salir == false);
		
		System.out.println("saliste");
	} 

	
	public static void cargarPersona() {
		if (personaNro < listaSize) {
			String nombre = entrada_str("ingrese el nombre: ");
			String apellido = entrada_str("ingrese el apellido: ");
			String localidad = elegirLocalidad();
			int edad = entrada_int("ingrese la edad: ");
			int dni = entrada_int("ingrese el DNI: ");
			int telefono = entrada_int("ingrese el telefono: ");
			
			p[personaNro] = new Persona(nombre, apellido, localidad, edad, dni, telefono);
			p_copia[personaNro] = new Persona(nombre, apellido, localidad, edad, dni, telefono);
			++personaNro;
		} else {
			System.out.println("---Limite de carga alcanzado--- \n");
		}
	}
	
	public static String elegirLocalidad() {
		String localidad = null;
		
		while (localidad == null) {
			System.out.println(
					"Elija la localidad: \n" 
					+ "1- Haedo \n"
					+ "2- Ramos Mejia \n"
					+ "3- San Justo \n"
					+ "4- Moron");
			
			int opcion = entrada_int();
			
			switch (opcion) {
				case 1: 
					localidad = "Haedo";
					break;
				case 2: 
					localidad = "Ramos Mejia";
					break;
				case 3: 
					localidad = "San Justo";
					break;
				case 4: 
					localidad = "Moron";
					break;
				default:
					System.out.println("valor invalido");
					break;
			}
		}
		return localidad;
	}
	
	
	public static void menuPrincipal() {
		System.out.println(
				"Elija la operacion que desee realizar: \n"
				+ "1- Cargar una persona \n"
				+ "2- Mostrar personas \n"
				+ "3- Mostrar la persona mayor \n"
				+ "4- Mostrar personas por localidad a eleccion \n"
				+ "5- Buscar persona por DNI \n"
				+ "6- Ordenar personas por DNI \n"
				+ "7- Salir \n"
		);
	}
	
	public static String entrada_str(String mensaje) {
		System.out.println(mensaje);
		String entradaStr = scanner.nextLine();
		return entradaStr;
	}
	
	public static String entrada_str() {
		String entradaStr = scanner.nextLine();
		return entradaStr;
	}

	public static int entrada_int(String mensaje) {
		boolean error = false;
		int entradaInt = 0;
		
		do {
			error = false;
			System.out.println(mensaje);
			try {
				entradaInt = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("no es un valor valido, vuelva a intentar");
				error = true;
				scanner.next();
			}
		} while (error == true);
		
		return entradaInt;
	}
	
	public static int entrada_int() {
		boolean error = false;
		int entradaInt = 0;
		
		do {
			error = false;
			try {
				entradaInt = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("no es un valor valido, vuelva a intentar");
				error = true;
				scanner.next();
			}
		} while (error == true);
		
		return entradaInt;
	}
	
	public static void mostrarPersonaxLocalidad() {
		String localidad = elegirLocalidad();
		
		for (int i = 0 ; i < personaNro ; i++) {
			if (p[i].getLocalidad() == localidad) {
				p[i].mostrarDatosxLocalidad();
			}	
		}
	}
	
	public static void mostrarPersona() {
		for (int i = 0; i < personaNro ; i++) {
			p[i].mostrarDatos();
		}
	}
	
	public static void mostrarPersonaMayor() {
		ordenarxDNI_creciente();
		p_copia[0].mostrarDatosxDNI();
	}
	
	public static void ordenarxDNI_creciente() {
		//ordenamiento burbuja
		for (int i = 0 ; i < (personaNro - 1) ; i++) {
			for (int j = 0 ; j < (personaNro - 1) ; j++) {
				if (p_copia[j].getDni() < p_copia[j+1].getDni() ) {
					Persona aux = p[j];
					p_copia[j] = p_copia[j+1];
					p_copia[j+1] = aux;
				}
			}
		}
	}
	
	public static void ordenarxDNI_decreciente() {
		//ordenamiento burbuja
		for (int i = 0 ; i < (personaNro - 1) ; i++) {
			for (int j = 0 ; j < (personaNro - 1) ; j++) {
				if (p_copia[j].getDni() > p_copia[j+1].getDni() ) {
					Persona aux = p_copia[j];
					p_copia[j] = p_copia[j+1];
					p_copia[j+1] = aux;
				}
			}
		}
	}
	
	public static void buscarPersonaxDNI() {
		System.out.println("Ingrese el dni de la persona que desee buscar: ");
		int dni = entrada_int();
		boolean flag = false;
		int i = 0;
				
		//busqueda secuencial
		while (i < personaNro && flag == false) {
			if ( p[i].getDni() == dni) {
				System.out.println(p[i].toString() );
				flag = true;
			}
			i++;
		}
		
		if (flag == false) {
			System.out.println("La persona deseada no se encuentra cargada en el sistema \n");
		} 
	}
}
