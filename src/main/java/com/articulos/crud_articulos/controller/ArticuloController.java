package com.articulos.crud_articulos.controller;

import com.articulos.crud_articulos.dto.ApiResponse;
import com.articulos.crud_articulos.dto.ApiResponseWithData;
import com.articulos.crud_articulos.model.Articulo;
import com.articulos.crud_articulos.repository.ArticuloRepository;
import com.articulos.crud_articulos.exception.ResourceNotFoundException;
import com.articulos.crud_articulos.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private ArticuloRepository articuloRepository; // Inyectar ArticuloRepository

    // Obtener todos los artículos
    @GetMapping
    public ResponseEntity<List<Articulo>> listarArticulos() {
        List<Articulo> articulos = articuloService.obtenerTodosLosArticulos();
        return ResponseEntity.ok(articulos);
    }


    //articulo por id
    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerArticuloPorId(@PathVariable Long id) {
        Optional<Articulo> articulo = articuloService.obtenerArticuloPorId(id);

        if (articulo.isPresent()) {
            // Devuelve el artículo encontrado como JSON
            return ResponseEntity.ok(articulo.get());
        } else {
            // Devuelve un 404 Not Found con un mensaje de error
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Artículo no encontrado con id: " + id));
        }
    }




    // Crear un nuevo artículo
    @PostMapping
    public ResponseEntity<ApiResponse> crearArticulo(@RequestBody Articulo articulo) {
        if (articulo.getPrecioProducto() == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(false, "El campo 'precio_producto' no puede ser nulo."));
        }

        articuloRepository.save(articulo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(true, "Artículo creado exitosamente"));
    }

    // Actualizar un artículo existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> actualizarArticulo(@PathVariable Long id, @RequestBody Articulo detallesArticulo) {
        Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artículo no encontrado con id: " + id));

        articulo.setNombre(detallesArticulo.getNombre());
        articulo.setDescripcion(detallesArticulo.getDescripcion());
        articulo.setPrecioProducto(detallesArticulo.getPrecioProducto());
        articulo.setStock(detallesArticulo.getStock());

        articuloRepository.save(articulo);
        return ResponseEntity.ok(new ApiResponse(true, "Artículo actualizado con éxito"));
    }

    // Actualizar parcialmente un artículo (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse> actualizarParcialmenteArticulo(@PathVariable Long id, @RequestBody Map<String, Object> cambios) {
        Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artículo no encontrado con id: " + id));

        // Iterar sobre el mapa de cambios y actualizar solo los campos proporcionados
        cambios.forEach((campo, valor) -> {
            switch (campo) {
                case "nombre":
                    articulo.setNombre((String) valor);
                    break;
                case "descripcion":
                    articulo.setDescripcion((String) valor);
                    break;
                case "precio_producto":
                    articulo.setPrecioProducto(Double.valueOf(valor.toString()));
                    break;
                case "stock":
                    articulo.setStock((Integer) valor);
                    break;
                default:
                    throw new IllegalArgumentException("Campo no permitido: " + campo);
            }
        });

        articuloRepository.save(articulo);
        return ResponseEntity.ok(new ApiResponse(true, "Artículo actualizado con éxito"));
    }

    // Eliminar un artículo
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> eliminarArticulo(@PathVariable Long id) {
        Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artículo no encontrado con id: " + id));

        articuloRepository.delete(articulo);
        return ResponseEntity.ok(new ApiResponse(true, "Artículo eliminado exitosamente"));
    }
}
