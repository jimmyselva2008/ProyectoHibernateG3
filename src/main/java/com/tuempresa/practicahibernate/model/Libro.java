package com.tuempresa.practicahibernate.model;

import com.tuempresa.practicahibernate.model.Categoria;
import jakarta.persistence.*;
import java.math.BigDecimal;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "libro", schema = "catalogos")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @Column(name = "anio_publicaciones", nullable = false)
    private int anioPublicaciones;

    @Column(name = "precio", nullable = false, precision = 12, scale = 2)
    private BigDecimal precio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Libro() {
    }

    public Libro(String titulo, String autor, int anioPublicacion, BigDecimal precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicaciones = anioPublicacion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicaciones() {
        return anioPublicaciones;
    }

    public void setAnioPublicaciones(int anioPublicacion) {
        this.anioPublicaciones = anioPublicacion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}