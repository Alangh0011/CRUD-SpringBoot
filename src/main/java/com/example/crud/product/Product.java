package com.example.crud.product;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)//Campo unico
    private String nombre;
    private float precio;
    private LocalDate fecha;
    @Transient
    private int antiguedad;//Campo calculado

    //constructor vacio
    public Product() {
    }
    //Contructor con id
    public Product(long id, String nombre, float precio, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }
    //Contructor sin id
    public Product(String nombre, float precio, LocalDate fecha) {
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getAntiguedad() {
        return Period.between(this.fecha,LocalDate.now()).getYears();
        //Le pasamos la fecha en que se agrego en años y lo comparamos con la fecha actual
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}


