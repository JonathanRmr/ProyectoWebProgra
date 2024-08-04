package service;

import model.Disciplina;
import persistence.MongoDBManager;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaService {
    private MongoCollection<Document> collection;

    public DisciplinaService() {
        this.collection = MongoDBManager.getDatabase().getCollection("disciplinas");
    }

    public void addDisciplina(Disciplina disciplina) {
        Document doc = new Document("nombre", disciplina.getNombre())
                .append("tipo", disciplina.getTipo());
        collection.insertOne(doc);
    }

    public List<Disciplina> getDisciplinas() {
        List<Disciplina> disciplinas = new ArrayList<>();
        for (Document doc : collection.find()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setId(doc.getObjectId("_id"));
            disciplina.setNombre(doc.getString("nombre"));
            disciplina.setTipo(doc.getString("tipo"));
            disciplinas.add(disciplina);
        }
        return disciplinas;
    }
}
