package cl.julload.servicio;

import java.util.List;

import cl.julload.modelo.Cliente;

public abstract class Exportador   {


	public abstract void exportar(String fileName, List<Cliente> listaClientes);
	
}
