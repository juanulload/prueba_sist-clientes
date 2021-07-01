package cl.julload.servicio;

import java.util.ArrayList;
import java.util.List;

import cl.julload.modelo.Cliente;


public class ClienteServicio {

	//
	private List<Cliente> listaClientes;
	
	//Constructores
	public ClienteServicio() {
		listaClientes = new ArrayList<>(); 
	}
	
	//Getters & Setters
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}



	//Metodos
	public void listarClientes() {
		
		if (listaClientes != null && listaClientes.size() != 0 ) {
			for (Cliente clienteTemp : listaClientes) {
				System.out.println(clienteTemp);
			}
			System.out.println("* * * * * * * * * *");	
		} else {
			System.out.println("No se han encontrado Clientes");
			System.out.println("");
		}
			
	}
	
	public void agregarCliente(Cliente cliente) {
		
		
		if (listaClientes != null) {
		listaClientes.add(cliente);
		
		}else {
			listaClientes = new ArrayList<>();
			listaClientes.add(cliente);
	
		}
		System.out.println("* * * * * Cliente Agregado * * * * *");
		
	}
	
	public void editarCliente(Cliente cliente) {
		
	}
}
