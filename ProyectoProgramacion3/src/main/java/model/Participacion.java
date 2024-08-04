package model;

import org.bson.types.ObjectId;

public class Participacion {
    private ObjectId id;
    private ObjectId afiliadoId;
    private ObjectId eventoId;
    private int puesto;

    // Getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getAfiliadoId() {
        return afiliadoId;
    }

    public void setAfiliadoId(ObjectId afiliadoId) {
        this.afiliadoId = afiliadoId;
    }

    public ObjectId getEventoId() {
        return eventoId;
    }

    public void setEventoId(ObjectId eventoId) {
        this.eventoId = eventoId;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }
}
