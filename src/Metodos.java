import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Metodos {


	public void iniciar() {
		
		validarMenu();
	}
	
	private void validarMenu() {
		Map<String, List<String>> ciudadMap = new HashMap<>();

		Scanner scanner = new Scanner(System.in);
		int codMenu;

		do {
			System.out.println("Selecciona una opción:");
			System.out.println("1. Registrar país");
			System.out.println("2. Registrar ciudad");
			System.out.println("3. Consultar lista de ciudades por país");
			System.out.println("4. Consultar ciudad");
			System.out.println("5. Salir");

			codMenu = scanner.nextInt();

			switch (codMenu) {
			case 1:registrarPais(ciudadMap, scanner);break;
			case 2:registrarCiudad(ciudadMap, scanner);break;
			case 3:imprimir(ciudadMap, scanner);break;
			case 4:buscarCiudad(ciudadMap, scanner);break;
			case 5:System.out.println("chao chao");break;
			default:System.out.println("Ingrese una opción valida \n");break;
			}
		} while (codMenu != 5);
		
	}

	private void registrarPais(Map<String, List<String>> ciudadMap, Scanner scanner) {

		System.out.println("Ingrese el nombre del país:");
		String pais = scanner.next();

		if (!ciudadMap.containsKey(pais)) {
			ciudadMap.put(pais, new ArrayList<>());
			System.out.println("País registrado exitosamente.");
		} else {
			System.out.println("El país ya está registrado.");
		}
	}
	
	private void registrarCiudad(Map<String, List<String>> ciudadMap, Scanner scanner) {
		
		System.out.println("Ingrese el nombre de la ciudad: ");
		String ciudad = scanner.next();

		System.out.println("Ingrese el nombre del país al que pertenece la ciudad: ");
		String ciud = scanner.next();

		List<String> Ciudades = ciudadMap.get(ciud);
		if (Ciudades != null) {
			Ciudades.add(ciudad);
			System.out.println("Ciudad registrada. ");
		} else {
			System.out.println("no se pudo registrar la ciudad \n debe registrar primero el pais.");
		}
	}
	
	
private void imprimir (Map<String, List<String>> ciudadMap, Scanner scanner) {
		
		System.out.println("Ingrese el nombre del país:");
		String pais = scanner.next();

		List<String> ciudades = ciudadMap.get(pais);
		if (ciudades != null) {
			System.out.println( pais + " tiene como ciudades: ");
			for (String ciudad : ciudades) {
				System.out.println(ciudad);
			}
		} else {
			System.out.println("El país no está registrado.");
		}
	}
private void buscarCiudad(Map<String, List<String>> ciudadMap, Scanner scanner) {
	
	System.out.println("Ingrese el nombre de la ciudad:");
	String ciudad = scanner.next();

	for (Map.Entry<String, List<String>> buscar : ciudadMap.entrySet()) {
		
		String pais = buscar.getKey();
		List<String> ciudades = buscar.getValue();
		
		if (ciudades.contains(ciudad)) {
			System.out.println(ciudad + " está en " + pais);
			return;
		}
	}

	System.out.println("La ciudad no está registrada en ningún país.");
}
}




