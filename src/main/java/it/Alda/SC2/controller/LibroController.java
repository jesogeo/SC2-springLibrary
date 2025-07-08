package it.Alda.SC2.controller;


import it.Alda.SC2.exception.LibroNotFoundException;
import it.Alda.SC2.model.LibroBiblio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libri")
public class LibroController {
    private final LibroRepositories libroRepositories;

    public LibroController(LibroRepositories libroRepositories){
        this.libroRepositories= libroRepositories;
    }

    @GetMapping
    public List<LibroBiblio> getAllLibroBiblio() {
        return libroRepositories.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroBiblio> getLibroBiblioRepositoriesById(@PathVariable Long id) {
        LibroBiblio LibroBiblio = libroRepositories.findById(id);
        if (libroBiblio == null) {
            throw new LibroNotFoundException(id);
        }
        return ResponseEntity.ok(libroBiblio);
    }

    @PostMapping
    public ResponseEntity<LibroBiblio> createLibro(@RequestBody LibroBiblio libroBiblio) {
        LibroBiblio savedLibroBiblio = libroRepository.save(libroBiblio);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLibroBiblio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroBiblio> updateLibro(@PathVariable Long id, @RequestBody LibroBiblio libroBiblio) {
        if (!id.equals(libroBiblio.getId())) {
            return ResponseEntity.badRequest().build();
        }

        LibroBiblio existingLibroBiblio = libroRepositories.findById(id);
        if (existingLibroBiblio == null) {
            throw new LibroNotFoundException(id);
        }

        LibroBiblio updatedLibroBiblio = libroRepositories.save(libroBiblio);
        return ResponseEntity.ok(updatedLibroBiblio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibroBiblio(@PathVariable Long id) {
        LibroBiblio libroBiblio = libroRepositories.findById(id);
        if (libroBiblio == null) {
            throw new LibroNotFoundException(id);
        }

        libroRepositories.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

