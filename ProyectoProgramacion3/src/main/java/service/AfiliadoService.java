package service;

import model.Afiliado;
import persistence.MongoDBManager;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class AfiliadoService {
    private MongoCollection<Document> collection;

    public AfiliadoService() {
        this.collection = MongoDBManager.getDatabase().getCollection("afiliados");
    }

    public void addAfiliado(Afiliado afiliado) {
        Document doc = new Document("nombre", afiliado.getNombre())
                .append("fechaNacimiento", afiliado.getFechaNacimiento())
                .append("email", afiliado.getEmail())
                .append("telefono", afiliado.getTelefono());
        collection.insertOne(doc);
    }

    public List<Afiliado> getAfiliados() {
        List<Afiliado> afiliados = new ArrayList<>();
        for (Document doc : collection.find()) {
            Afiliado afiliado = new Afiliado();
            afiliado.setId(doc.getObjectId("_id"));
            afiliado.setNombre(doc.getString("nombre"));
            afiliado.setFechaNacimiento(doc.getDate("fechaNacimiento"));
            afiliado.setEmail(doc.getString("email"));
            afiliado.setTelefono(doc.getString("telefono"));
            afiliados.add(afiliado);
        }
        return afiliados;
    }
}
