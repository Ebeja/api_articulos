package com.articulos.crud_articulos.service;

import com.articulos.crud_articulos.exception.ResourceNotFoundException;
import com.articulos.crud_articulos.model.MovimientoStock;
import com.articulos.crud_articulos.repository.MovimientoStockRepository;
import com.articulos.crud_articulos.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoStockService {

    @Autowired
    private MovimientoStockRepository movimientoStockRepository;

    public List<MovimientoStock> getAllMovimientosStock() {
        return movimientoStockRepository.findAll();
    }

    public MovimientoStock getMovimientoStockById(Long movimientoId) {
        return movimientoStockRepository.findById(movimientoId)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento de stock no encontrado con id: " + movimientoId));
    }

    public MovimientoStock createMovimientoStock(MovimientoStock movimientoStock) {
        return movimientoStockRepository.save(movimientoStock);
    }

    public MovimientoStock updateMovimientoStock(Long movimientoId, MovimientoStock movimientoDetails) {
        MovimientoStock movimiento = getMovimientoStockById(movimientoId);
        movimiento.setCantidad(movimientoDetails.getCantidad());
        movimiento.setTipoMovimiento(movimientoDetails.getTipoMovimiento());
        movimiento.setFecha(movimientoDetails.getFecha());
        return movimientoStockRepository.save(movimiento);
    }

    public ApiResponse deleteMovimientoStock(Long movimientoId) {
        MovimientoStock movimiento = getMovimientoStockById(movimientoId);
        movimientoStockRepository.delete(movimiento);
        return new ApiResponse(true, "Movimiento de stock eliminado con éxito");
    }
}

