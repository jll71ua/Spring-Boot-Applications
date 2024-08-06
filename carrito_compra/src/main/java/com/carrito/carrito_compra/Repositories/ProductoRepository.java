package com.carrito.carrito_compra.Repositories;

import com.carrito.carrito_compra.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
