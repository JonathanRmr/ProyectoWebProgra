package logica;

import modelo.Cliente;
import persistencia.ClienteDAO;

import java.util.List;

public class ClienteLogica {
    private ClienteDAO clienteDAO;

    public ClienteLogica() {
        clienteDAO = new ClienteDAO();
    }

    public void agregarCliente(Cliente cliente) {
        clienteDAO.insertarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.obtenerClientes();
    }

    public void modificarCliente(String id, Cliente cliente) {
        clienteDAO.actualizarCliente(id, cliente);
    }

    public void eliminarCliente(String id) {
        clienteDAO.eliminarCliente(id);
    }
}
