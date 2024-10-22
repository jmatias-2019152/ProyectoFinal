package com.finalgastos.gastosApi.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingresos")
public class Ingreso {

    @Id
    private String id;
    private String descripcion;
    private double monto;

    public Ingreso() {}

    public Ingreso(String descripcion, double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}