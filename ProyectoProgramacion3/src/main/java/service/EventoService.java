package service;

import model.Evento;
import persistence.MongoDBManager;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class EventoService {
    private MongoCollection<Document> collection;

    public EventoService() {
        this.collection = MongoDBManager.getDatabase().getCollection("eventos");
    }

    public void addEvento(Evento evento) {
        Document doc = new Document("nombre", evento.getNombre())
                .append("fecha", evento.getFecha())
                .append("lugar", evento.getLugar());
        collection.insertOne(doc);
    }

    public List<Evento> getEventos() {
        List<Evento> eventos = new ArrayList<>();
        for (Document doc : collection.find()) {
            Evento evento = new Evento();
            evento.setId(doc.getObjectId("_id"));
            evento.setNombre(doc.getString("nombre"));
            evento.setFecha(doc.getDate("fecha"));
            evento.setLugar(doc.getString("lugar"));
            eventos.add(evento);
        }
        return eventos;
    }
}
