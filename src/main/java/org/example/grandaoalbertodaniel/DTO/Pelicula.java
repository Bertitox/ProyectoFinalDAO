package org.example.grandaoalbertodaniel.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "peliculas", schema = "CineClub")
@Data
public class Pelicula {
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

}