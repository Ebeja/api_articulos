package com.articulos.crud_articulos.service;

import com.articulos.crud_articulos.model.Articulo;
import com.articulos.crud_articulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository; // Inyecta el repositorio

    // Método para obtener todos los artículos
    public List<Articulo> obtenerTodosLosArticulos() {
        return articuloRepository.findAll(); // Obtiene todos los artículos de la base de datos
    }

    // Método para obtener un artículo por ID
    public Optional<Articulo> obtenerArticuloPorId(Long id) {
        return articuloRepository.findById(id); // Busca el artículo por ID
    }

}
