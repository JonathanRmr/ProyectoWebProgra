package persistencia;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import modelo.Cliente;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public ClienteDAO() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDatabase("gestionClientes");
        collection = database.getCollection("clientes");
    }

    public void insertarCliente(Cliente cliente) {
        Document document = new Document("nombre", cliente.getNombre())
                .append("email", cliente.getEmail());
        collection.insertOne(document);
    }

    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (Document doc : collection.find()) {
            Cliente cliente = new Cliente();
            cliente.setId(doc.getObjectId("_id").toString());
            cliente.setNombre(doc.getString("nombre"));
            cliente.setEmail(doc.getString("email"));
            clientes.add(cliente);
        }
        return clientes;
    }

    public void actualizarCliente(String id, Cliente cliente) {
        Document query = new Document("_id", id);
        Document update = new Document("$set", new Document("nombre", cliente.getNombre())
                .append("email", cliente.getEmail()));
        collection.updateOne(query, update);
    }

    public void eliminarCliente(String id) {
        Document query = new Document("_id", id);
        collection.deleteOne(query);
    }
}
