package cl.julload.vista;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cl.julload.modelo.CategoriaEnum;
import cl.julload.modelo.Cliente;
import cl.julload.servicio.ArchivoServicio;
import cl.julload.servicio.ClienteServicio;
import cl.julload.servicio.ExportadorCsv;
import cl.julload.servicio.ExportadorTxt;
import cl.julload.utilidades.Utilidad;

public class Menu {

	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportarTxt = new ExportadorTxt();
	String fileName = "Clientes";
	String fileName1 = "DBClientes.scv";
	Scanner scString = new Scanner(System.in); //STRING
	Scanner scInt = new Scanner(System.in); //INTEGER
	
	public void iniciarMenu() {

		System.out.println("----------MENU PRINCIPAL----------");
		System.out.println("1.- Listar Clientes");
		System.out.println("2.- Agregar Clientes");
		System.out.println("3.- Editar Clientes");
		System.out.println("4.- Importar Datos");
		System.out.println("5.- Exportar Datos");
		System.out.println("6.- Terminar Programa");
		System.out.println("----------FINAL MENU----------");
		System.out.println("--Ingrese una Opción--");

		//int opcion = Integer.parseInt(scanner.nextLine());
		int opcion = scInt.nextInt();
		
		seleccionMenu(opcion);
	}

	private void seleccionMenu(int opcion) {
		// TODO Auto-generated method stub
		switch (opcion) {
		case 1:
			listarClientes();
			iniciarMenu();
			break;
		case 2:
			agregarClientes();
			iniciarMenu();
			break;
		case 3:
			editarCliente();
			iniciarMenu();
			break;
		case 4:
			importarDatos();
			iniciarMenu();
			break;
		case 5:
			exportarDatos();
			iniciarMenu();
			break;
		case 6:
			terminarPrograma();

			break;

		default:
			System.out.println("¡La Opción Es Incorrecta!");
			break;
		}
	}

	public void listarClientes() {
		clienteServicio.listarClientes();
	}

	public void agregarClientes() {

//		Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
//				CategoriaEnum nombreCategoria)

		String runCliente = ""; // Se inicializa la variable de Rut - Para que funcione While
		do {
			System.out.println("Ingrese RUN del Cliente: (Ej. 12345678-9)");
			runCliente = scString.nextLine();
			if (Utilidad.validaRut(runCliente)) {
				System.out.println("Rut Correcto....");
			} else {
				System.out.println("¡Escriba bien el rut!");
			}
		} while (!Utilidad.validaRut(runCliente));

		System.out.println("Ingrese Nombre Cliente");
		String nombreCliente = scString.nextLine();
		System.out.println("Ingrese Apellido Cliente");
		String apellidoCliente = scString.nextLine();
		System.out.println("Ingrese Años como Cliente");
		String aniosCliente = scString.nextLine();
		
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, CategoriaEnum.ACTIVO);

		clienteServicio.agregarCliente(cliente);
	}

	public void editarCliente() {
		
		
		System.out.println("------------- Editar Cliente -------------");

		listarClientes();

		boolean condicion = true;
		String capturaRun = "";

		while (condicion) {
			System.out.println("Ingrese RUN del Cliente a editar: (Ej. 12123456-0)");
			capturaRun = scString.nextLine();
			//scString.nextLine();
			for (Cliente clienteTemp : clienteServicio.getListaClientes()) {
				if (capturaRun.equalsIgnoreCase(clienteTemp.getRunCliente())) {
					condicion = false;
					break;
				}
			}

		} 

		System.out.println("Seleccione una opción:");
		System.out.println("1. -Cambiar el estado del cliente.");
		System.out.println("2. -Editar los datos ingresados del Cliente.");
		System.out.println("3. -Retornar al menú principal.");
		System.out.println(" ");
		System.out.println("Ingrese opción: ");
		
		//int entrada = ;
		
		int opcionEditarCliente = scInt.nextInt();

		System.out.println("------------------------------------------");
		System.out.println(" ");

		seleccionMenuEditarCliente(opcionEditarCliente, capturaRun);
	}

	private void seleccionMenuEditarCliente(int opcionEditarCliente, String capturaRun) {
		switch (opcionEditarCliente) {
		
		case 1:
			actualizarCategoriaCliente(capturaRun);
			break;
		
		case 2:
			menuEditarCliente(capturaRun);
			break;

		case 3:
			iniciarMenu();// Esta opción es de recursividad y volverá a llamar al menú después de la
							// selección de la opción.
			break;
			
		default:
			System.out.println("La opción seleccionada es incorrecta.");
			iniciarMenu();// Esta opción es de recursividad y volverá a llamar al menú después de la
							// selección de la opción.
			break;
		}

	}

	private void menuEditarCliente(String capturaRun) {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente();
		
		for (Cliente clienteTemp : clienteServicio.getListaClientes()) {
			if (capturaRun.equalsIgnoreCase(clienteTemp.getRunCliente())) {
				cliente = clienteTemp;
			}
		}
		
		System.out.println(" - - - - - MENU EDITAR CLIENTE- - - - - - ");
		System.out.println("Elija Campo de Cliente a Editar:");
		System.out.println("1.- RUT de Cliente " + cliente.getRunCliente());
		System.out.println("2.- NOMBRE de Cliente " + cliente.getNombreCliente());
		System.out.println("3.- APELLIDO de Cliente " + cliente.getApellidoCliente());
		System.out.println("4.- AÑOS de Cliente " + cliente.getAniosCliente());
		System.out.println("5.- CATEGORIA de Cliente " + cliente.getNombreCategoria());
		System.out.println("6. - Desea volver al menu principal o seguir editando clientes?");
		System.out.println(" - - - - - - - - - - - ");
		System.out.println("Elija una opción: ");
		//int opcion = Integer.parseInt(scanner.nextLine());
		int opcion = scInt.nextInt();
		
		switch (opcion) {
		case 1:
			System.out.println("Ingrese el Nuevo Rut: ");
			cliente.setRunCliente(scString.nextLine());
			break;
		case 2:
			System.out.println("Ingrese el Nuevo Nombre: ");
			cliente.setNombreCliente(scString.nextLine());

			break;
		case 3:
			System.out.println("Ingrese el Nuevo Apellido: ");
			cliente.setApellidoCliente(scString.nextLine());
			break;
		case 4:
			System.out.println("Ingrese la nueva cantidad de Años: ");
			cliente.setAniosCliente(scString.nextLine()); //Este es diferente, pero funciona igual que los demas
			break;
		case 5:
			System.out.println("Ingrese la Nueva Categoria: ");
			seleccionMenuEditarCliente(1, cliente.getRunCliente()); // llama al metodo seleccionMenuEditarCliente 
			menuEditarCliente(capturaRun);
			break;
		case 6:
			System.out.println("¿Desea volver al menu principal o seguir editando clientes?");
			System.out.println("1.- Menu Principal");
			System.out.println("2.- Editar Clientes");
			opcion = scInt.nextInt();
			if (opcion == 1) {
				iniciarMenu();
			} else if (opcion == 2 ){
				editarCliente();
			} else {
				System.out.println("Opcion Invalida. Retornando al Menú Principal ..... ");
				menuEditarCliente(capturaRun);
			}
			
			break;
			
		default:
			System.out.println("Opción no válida. Volviendo a menú");
			menuEditarCliente(capturaRun);
			break;
		}
	}

	public void importarDatos() {
		
		System.out.println("Ingrese ruta de archivo DBClientes.csv");
		String ruta = scString.nextLine();
		for (Cliente clienteTemp : archivoServicio.cargarDatos(ruta, "DBClientes.csv")) {
			clienteServicio.getListaClientes().add(clienteTemp);
		}
	}

	public void exportarDatos() {
		System.out.println("Elija formato de exportación de datos: \n1.- Extensión .csv\n2.- Extensión .txt");
		Scanner sc = new Scanner(System.in);
		int opcExp = sc.nextInt();
		
		if (opcExp == 1) {
			ExportadorCsv exportarCsv = new ExportadorCsv();
			exportarCsv.exportar("DBClientes.csv", clienteServicio.getListaClientes());
		} else if (opcExp == 2) {
			ExportadorTxt exportarTxt = new ExportadorTxt();
			exportarTxt.exportar("DBClientes.txt", clienteServicio.getListaClientes());
		} else {
			System.out.println("Ingrese una opción válida");
			
		}
		
		
	}

	public void terminarPrograma() {

	}
	
	public void actualizarCategoriaCliente(String capturaRun) {
		
		clienteServicio.getListaClientes();
		for (Cliente clienteTemp : clienteServicio.getListaClientes()) {
			if (capturaRun.equalsIgnoreCase(clienteTemp.getRunCliente())) {

				System.out.println(" 1.- Cambiar a estado ACTIVO \n 2.- Cambiar a estado INACTIVO");
				String respuesta = scString.nextLine();

				if (respuesta.equalsIgnoreCase("1")) {
					clienteTemp.setNombreCategoria(CategoriaEnum.ACTIVO);
				} else if (respuesta.equalsIgnoreCase("2")) {
					clienteTemp.setNombreCategoria(CategoriaEnum.INACTIVO);
				} else {
					System.out.println("¡Opción Invalida!/n");
					actualizarCategoriaCliente(capturaRun);
				}
			}

		}
		editarCliente();
		
	}
	
	
}
