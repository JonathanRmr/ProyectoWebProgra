package model;

import org.bson.types.ObjectId;

public class Disciplina {
    private ObjectId id;
    private String nombre;
    private String tipo; // "individual" o "grupal"

    public Disciplina() {
        // Constructor sin argumentos
    }

    // Getters y setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
