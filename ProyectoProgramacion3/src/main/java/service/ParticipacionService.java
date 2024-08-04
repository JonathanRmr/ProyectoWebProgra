package service;

import model.Participacion;
import persistence.MongoDBManager;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class ParticipacionService {
    private MongoCollection<Document> collection;

    public ParticipacionService() {
        this.collection = MongoDBManager.getDatabase().getCollection("participaciones");
    }

    public void addParticipacion(Participacion participacion) {
        Document doc = new Document("afiliadoId", participacion.getAfiliadoId())
                .append("eventoId", participacion.getEventoId())
                .append("puesto", participacion.getPuesto());
        collection.insertOne(doc);
    }

    public List<Participacion> getParticipaciones() {
        List<Participacion> participaciones = new ArrayList<>();
        for (Document doc : collection.find()) {
            Participacion participacion = new Participacion();
            participacion.setId(doc.getObjectId("_id"));
            participacion.setAfiliadoId(doc.getObjectId("afiliadoId"));
            participacion.setEventoId(doc.getObjectId("eventoId"));
            participacion.setPuesto(doc.getInteger("puesto"));
            participaciones.add(participacion);
        }
        return participaciones;
    }
}
