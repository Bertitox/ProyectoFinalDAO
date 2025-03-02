package org.example.grandaoalbertodaniel.DAOs.DAOXML;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.example.grandaoalbertodaniel.DTO.PeliculaXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PeliculaXMLDAO {
    private static final String FILE_PATH = "src/main/resources/peliculas.xml";

    public void guardarPeliculas(List<PeliculaXML> peliculas) {
        try {
            PeliculasWrapper wrapper = new PeliculasWrapper(peliculas);
            JAXBContext context = JAXBContext.newInstance(PeliculasWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(FILE_PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public List<PeliculaXML> leerPeliculas() {
        List<PeliculaXML> peliculas = new ArrayList<>();
        try {
            JAXBContext context = JAXBContext.newInstance(PeliculasWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PeliculasWrapper wrapper = (PeliculasWrapper) unmarshaller.unmarshal(new File(FILE_PATH));
            if (wrapper != null) {
                peliculas = wrapper.getPeliculas();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    public void agregarPelicula(PeliculaXML pelicula) {
        List<PeliculaXML> peliculas = leerPeliculas();
        peliculas.add(pelicula);
        guardarPeliculas(peliculas);
    }
}

@XmlRootElement(name = "peliculas")
class PeliculasWrapper {
    private List<PeliculaXML> peliculas;

    public PeliculasWrapper() {
        this.peliculas = new ArrayList<>();
    }

    public PeliculasWrapper(List<PeliculaXML> peliculas) {
        this.peliculas = peliculas;
    }

    @XmlElement(name = "pelicula")
    public List<PeliculaXML> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<PeliculaXML> peliculas) {
        this.peliculas = peliculas;
    }
}
