package com.finalgastos.gastosApi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gastos")
public class Gasto {

    @Id
    private String id;
    private String descripcion;
    private double monto;
    private String categoria;

    public Gasto() {}

    public Gasto(String descripcion, double monto, String categoria) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}