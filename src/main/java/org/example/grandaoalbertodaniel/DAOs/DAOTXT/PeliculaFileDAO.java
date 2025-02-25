package org.example.grandaoalbertodaniel.DAOs.DAOTXT;

import org.example.grandaoalbertodaniel.DTO.PeliculaFichero;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaFileDAO {
    private static final String FILE_PATH = "src/main/resources/peliculas.txt";

    public void guardarPeliculas(List<PeliculaFichero> peliculas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(peliculas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<PeliculaFichero> leerPeliculas() {
        List<PeliculaFichero> peliculas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            peliculas = (List<PeliculaFichero>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    public void agregarPelicula(PeliculaFichero pelicula) {
        List<PeliculaFichero> peliculas = leerPeliculas();
        peliculas.add(pelicula);
        guardarPeliculas(peliculas);
    }
}
