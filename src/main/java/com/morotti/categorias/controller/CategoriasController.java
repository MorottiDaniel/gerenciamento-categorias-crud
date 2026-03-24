package com.morotti.categorias.controller;


import com.morotti.categorias.entity.CategoriasEntity;
import com.morotti.categorias.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    @Autowired
    private CategoriasService categoriasService;

    @PostMapping
    public ResponseEntity<CategoriasEntity> criarCategoria(@RequestBody CategoriasEntity entity){
        CategoriasEntity categoria = categoriasService.criarCategoria(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriasEntity>> findAll(){
        List<CategoriasEntity> entities = categoriasService.findAll();
        return ResponseEntity.ok().body(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriasEntity> buscarPorId(@PathVariable Long id){
        try {
            CategoriasEntity entity = categoriasService.buscarPorId(id);
            return ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        categoriasService.remover(id);
        return ResponseEntity.noContent().build();
    }

}
