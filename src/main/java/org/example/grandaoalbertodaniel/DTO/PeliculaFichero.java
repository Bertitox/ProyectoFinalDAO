package org.example.grandaoalbertodaniel.DTO;

import java.io.Serializable;
import java.time.LocalDate;

public class PeliculaFichero implements Serializable {

    private static final long serialVersionUID = 1L;  // Identificador único para la serialización

    private String id;
    private String titulo;
    private String director;
    private String genero;
    private Integer duracion;
    private LocalDate estreno;

    public PeliculaFichero(String id, String titulo, String director, String genero, Integer duracion, LocalDate estreno) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.estreno = estreno;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }

    public LocalDate getEstreno() { return estreno; }
    public void setEstreno(LocalDate estreno) { this.estreno = estreno; }
}
