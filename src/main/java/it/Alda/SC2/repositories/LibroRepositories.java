package it.Alda.SC2.repositories;

import it.Alda.SC2.model.LibroBiblio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepositories {
    private final List<LibroBiblio> libroBiblio =new ArrayList<>();

    public List<LibroBiblio>findAll(){
        return new ArrayList<>(libroBiblio);
    }
    public LibroBiblio findById(Long id){
        return libroBiblio.stream()
                .filter(libroBiblio -> libroBiblio.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public LibroBiblio save(LibroBiblio libroBiblio){
        if (libroBiblio.getId() == null){
            libroBiblio.setId(counter.incrementAndGet());
            libroBiblio.add(libroBiblio);
        }else {
            return update (libroBiblio);
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
        libroBiblio.removeIf(libroBiblio.getId().equals(id));

        }
    }

