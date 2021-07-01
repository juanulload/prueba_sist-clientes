package cl.julload.servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cl.julload.modelo.CategoriaEnum;
import cl.julload.modelo.Cliente;

public class ExportadorTxt  extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		if (listaClientes == null) {
			System.out.println("La lista no contiene datos de clientes");
		} else {
			System.out.println("Se exportaran los datos a un archivo .csv");
			System.out.println("Señale ruta para nuevo archivo");
			Scanner sc = new Scanner(System.in);
			String ruta = sc.nextLine();
			//String nomArch = "DBClientes.csv";
			crearArchivo(ruta, fileName);
			escribir(listaClientes, ruta, fileName);
		}
	}

	private void crearArchivo(String ruta, String nomArch) {
		// TODO Auto-generated method stub
		File archivo = new File(ruta + nomArch);
		if (archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void crearDirectorio(String ruta) {
		
		File directorio = new File(ruta);
		if (directorio.exists()) {
			directorio.mkdir();
		}
	}
	
	private static void escribir(List<Cliente> clientes, String ruta, String nomArch) {
		File archivo = new File(ruta + nomArch);
		try {
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Cliente cliente : clientes) {
//				String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
//				CategoriaEnum nombreCategoria
				bw.write(cliente.getRunCliente()
						+","+cliente.getNombreCliente()
						+","+cliente.getApellidoCliente()
						+","+cliente.getAniosCliente()
						+","+cliente.getNombreCategoria()
						+"\n");
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
