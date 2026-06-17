package com.donaton.logistica.controller;

import com.donaton.logistica.model.Catalogo;
import com.donaton.logistica.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo")
@CrossOrigin(origins = "*")
public class CatalogoController {

    @Autowired
    private CatalogoRepository catalogoRepository;

    @GetMapping
    public List<Catalogo> obtenerTodos() {
        return catalogoRepository.findAll();
    }

    @PostMapping
    public Catalogo crear(@RequestBody Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        catalogoRepository.deleteById(id);
    }
}