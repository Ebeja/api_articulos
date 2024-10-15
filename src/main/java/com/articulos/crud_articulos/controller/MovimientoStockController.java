package com.articulos.crud_articulos.controller;

import com.articulos.crud_articulos.model.MovimientoStock;
import com.articulos.crud_articulos.service.MovimientoStockService;
import com.articulos.crud_articulos.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos_stock")
public class MovimientoStockController {

    @Autowired
    private MovimientoStockService movimientoStockService;

    @GetMapping
    public List<MovimientoStock> getAllMovimientosStock() {
        return movimientoStockService.getAllMovimientosStock();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoStock> getMovimientoStockById(@PathVariable(value = "id") Long movimientoId) {
        MovimientoStock movimiento = movimientoStockService.getMovimientoStockById(movimientoId);
        return ResponseEntity.ok().body(movimiento);
    }

    @PostMapping
    public MovimientoStock createMovimientoStock(@RequestBody MovimientoStock movimientoStock) {
        return movimientoStockService.createMovimientoStock(movimientoStock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimientoStock> updateMovimientoStock(@PathVariable(value = "id") Long movimientoId, @RequestBody MovimientoStock movimientoDetails) {
        MovimientoStock updatedMovimiento = movimientoStockService.updateMovimientoStock(movimientoId, movimientoDetails);
        return ResponseEntity.ok(updatedMovimiento);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteMovimientoStock(@PathVariable(value = "id") Long movimientoId) {
        return movimientoStockService.deleteMovimientoStock(movimientoId);
    }
}
