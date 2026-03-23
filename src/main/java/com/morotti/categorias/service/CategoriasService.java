package com.morotti.categorias.service;

import com.morotti.categorias.entity.CategoriasEntity;
import com.morotti.categorias.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService {
    @Autowired
    private CategoriasRepository categoriasRepository;

    public CategoriasEntity criarCategoria(CategoriasEntity entity){
        return categoriasRepository.save(entity);
    }

    public List<CategoriasEntity> findAll(){
        return categoriasRepository.findAll();
    }

    public CategoriasEntity buscarPorId(Long id){
        return categoriasRepository.findById(id).get();
    }

    public void remover(Long id){
        categoriasRepository.deleteById(id);
    }
}
