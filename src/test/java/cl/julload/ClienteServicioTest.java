package cl.julload;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cl.julload.modelo.CategoriaEnum;
import cl.julload.modelo.Cliente;
import cl.julload.servicio.ClienteServicio;

public class ClienteServicioTest {

	private static ClienteServicio clienteServicio;
	private static Cliente cliente;
	
	//public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
//			CategoriaEnum nombreCategoria) {
	
	@BeforeAll
	public static void setUp() {
		
		cliente = new Cliente();
		clienteServicio = new ClienteServicio();
	}
	
	@Test
	public void agrearClienteTest() {
		String runCliente = "16.953.343-8";
		String nombreCliente = "Pedro";
		String apellidoCliente = "Picapiedra";
		String aniosCliente = "52";
		CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO;
		
		Cliente c1 = new Cliente();
		//Estamos setiando los datos al Cliente
		c1.setRunCliente(runCliente);
		c1.setNombreCliente(nombreCliente);
		c1.setApellidoCliente(apellidoCliente);
		c1.setAniosCliente(aniosCliente);
		c1.setNombreCategoria(nombreCategoria);
		
		clienteServicio.agregarCliente(c1);
		
		assertEquals(clienteServicio.getListaClientes().get(0).getNombreCliente(), "Pedro");
		assertNull(clienteServicio.getListaClientes().get(0).getNombreCliente(), null);
	}
	
}
