package cl.julload.servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cl.julload.main.Main;
import cl.julload.modelo.CategoriaEnum;
import cl.julload.modelo.Cliente;
import cl.julload.vista.Menu;

public class ArchivoServicio extends Exportador {
	//Menu menu1 =new Menu();
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Cliente> cargarDatos(String directorio, String fileName) {
		//D:\Documentos\Eclipse\Prueba_SistemaClientes\src
		File archivo = new File(directorio+File.separator+fileName);
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String lineaArchivo = br.readLine();
			
			ArrayList<String> lineaCliente = new ArrayList<String>();
			
			
			while (lineaArchivo!=null) {
				ArrayList<String> camposCliente = new ArrayList<String>(Arrays.asList(lineaArchivo.split(",")));
				//(String articulo, String precio, String descripcion, String codigo, String talla, String marca,
						//String color)
				
				Cliente cliente = new Cliente(camposCliente.get(0),camposCliente.get(1),camposCliente.get(2),
						camposCliente.get(3),CategoriaEnum.valueOf(camposCliente.get(4).toUpperCase()));
				
				listaClientes.add(cliente);
				lineaArchivo=br.readLine();
			}
			System.out.println(listaClientes);
			br.close();
			System.out.println("Datos cargados.");
			
		}	catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Error al cargar datos");
			//menu1.importarDatos();
			Main.menu.importarDatos();
		}
		return listaClientes;

	}
	

}
