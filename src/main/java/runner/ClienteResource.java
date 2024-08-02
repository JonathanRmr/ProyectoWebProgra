package runner;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import logica.ClienteLogica;
import modelo.Cliente;

import java.util.List;

@Path("/clientes")
public class ClienteResource {
    private ClienteLogica clienteLogica = new ClienteLogica();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes() {
        List<Cliente> clientes = clienteLogica.listarClientes();
        return Response.ok(clientes).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCliente(Cliente cliente) {
        clienteLogica.agregarCliente(cliente);
        return Response.ok(cliente).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCliente(@PathParam("id") String id, Cliente cliente) {
        clienteLogica.modificarCliente(id, cliente);
        return Response.ok(cliente).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCliente(@PathParam("id") String id) {
        clienteLogica.eliminarCliente(id);
        return Response.noContent().build();
    }
}
