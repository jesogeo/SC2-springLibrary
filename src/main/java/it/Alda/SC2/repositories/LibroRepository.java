package it.Alda.SC2.repositories;

import it.Alda.SC2.model.LibroBiblio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {
    private final List<LibroBiblio> libri = new ArrayList<>();

    private Long counter = 0L;

    public List<LibroBiblio>findAll(){
        return new ArrayList<>(libri);
    }
    public LibroBiblio findById(Long id){
        return libri.stream()
                .filter(libroBiblio -> libroBiblio.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public LibroBiblio save(LibroBiblio libroBiblio){

        libroBiblio.setId(++counter);
        libri.add(libroBiblio);
        return libroBiblio;

    }

    public LibroBiblio update(LibroBiblio libroBiblio) {
        int index = libri.indexOf(libroBiblio);
        if (index >= 0) {
            libri.set(index, libroBiblio);
            return libroBiblio;
    }
    return null;
    }

    public void deleteById(Long id){
        libri.removeIf(libroBiblio -> libroBiblio.getId().equals(id));

        }
    }

