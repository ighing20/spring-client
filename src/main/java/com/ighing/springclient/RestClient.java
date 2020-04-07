package com.ighing.springclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ighing.springclient.model.Cliente;

public class RestClient {

	private static String RESOURCE_URL = "http://40.76.10.97:8080/spring-mvc-rest/clientes";

	private static final RestTemplate REST_TEMPLATE = new RestTemplate();

	public static void main(String[] args) {

		System.out.println(finOne(1));
		
		Cliente cliente = new Cliente();
		cliente.setNombre("Juan");
		cliente.setDireccion("Main Street");
		cliente.setTelefono("555-555-5555");
		
		addCliente(cliente);

	}

	public static ResponseEntity<Cliente> finOne(int id) {
		return REST_TEMPLATE.getForEntity(RESOURCE_URL + "/" + id, Cliente.class);
	}

	public static void addCliente(Cliente cliente) {
		HttpEntity<Cliente> request = new HttpEntity<>(cliente);
		REST_TEMPLATE.postForObject(RESOURCE_URL, request, Cliente.class);
	}
}
