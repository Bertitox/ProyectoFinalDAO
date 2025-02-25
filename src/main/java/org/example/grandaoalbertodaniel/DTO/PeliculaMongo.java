package org.example.grandaoalbertodaniel.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "peliculas", schema = "CineClub")

public class PeliculaMongo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;

    @Size(max = 255)
    @NotNull
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Size(max = 100)
    @NotNull
    @Column(name = "director", nullable = false, length = 100)
    private String director;

    @Size(max = 50)
    @Column(name = "genero", length = 50)
    private String genero;

    @NotNull
    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "estreno")
    private LocalDate estreno;

    public PeliculaMongo() {
    }

    public PeliculaMongo(String titulo, String director, String genero, Integer duracion, LocalDate estreno) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.estreno = estreno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public LocalDate getEstreno() {
        return estreno;
    }

    public void setEstreno(LocalDate estreno) {
        this.estreno = estreno;
    }
}
