package com.articulos.crud_articulos.repository;


import com.articulos.crud_articulos.model.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoStockRepository extends JpaRepository<MovimientoStock, Long> {
}
