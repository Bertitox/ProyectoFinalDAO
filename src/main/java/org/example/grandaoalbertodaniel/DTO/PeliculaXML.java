package org.example.grandaoalbertodaniel.DTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@XmlRootElement(name = "pelicula")
public class PeliculaXML {
    private String id;
    private String titulo;
    private String director;
    private String genero;
    private Integer duracion;
    private String estreno;

    public PeliculaXML() {}

    public PeliculaXML(String id, String titulo, String director, String genero, Integer duracion, String estreno) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.estreno = estreno;
    }

    @XmlElement
    public String getId() {
        return id;
    }

    @XmlElement
    public String getTitulo() {
        return titulo;
    }

    @XmlElement
    public String getDirector() {
        return director;
    }

    @XmlElement
    public String getGenero() {
        return genero;
    }

    @XmlElement
    public Integer getDuracion() {
        return duracion;
    }

    @XmlElement
    public String getEstreno() { // Convertir LocalDate a String
        return estreno;
    }

    public void setEstreno(String estreno) { // Convertir String a LocalDate
        this.estreno = estreno;
    }
}