package it.Alda.SC2.repositories;

import it.Alda.SC2.model.LibroBiblio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LibroRepositories {
    private final List<LibroBiblio> libri = new ArrayList<>();

    public List<LibroBiblio>findAll(){
        return new ArrayList<>(libri);
    }
    public LibroBiblio findById(Long id){
        return libri.stream()
                .filter(libroBiblio -> libroBiblio.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public LibroBiblio save(LibroBiblio libroBiblio) {
        if (libroBiblio.getId() == null) {
            libroBiblio.setId(UUID.randomUUID().toString());
            libroBiblio.add(libroBiblio);
            return libroBiblio;
        }
    }

    public LibroBiblio update(LibroBiblio libroBiblio) {
        int index = libroBiblio.indexOf(libroBiblio);
        if (index >= 0) {
            libroBiblio.set(index, libroBiblio);
            return libroBiblio;
    }
    return null;
    }

    public void deleteById(Long id){
        libri.removeIf(libri.getId().equals(id));

        }
    }

