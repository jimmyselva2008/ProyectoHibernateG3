package com.tuempresa.practicahibernate.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias", schema = "catalogos")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "descripcion", nullable = false, unique = true, length = 250)
    private String descripcion;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<com.tuempresa.practicahibernate.model.Libro> libros = new ArrayList<com.tuempresa.practicahibernate.model.Libro>();

    public Categoria() {
    }

    public List<com.tuempresa.practicahibernate.model.Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<com.tuempresa.practicahibernate.model.Libro> libros) {
        this.libros = libros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
