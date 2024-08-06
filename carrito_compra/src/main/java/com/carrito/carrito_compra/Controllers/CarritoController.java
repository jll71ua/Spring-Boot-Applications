package com.carrito.carrito_compra.Controllers;

import com.carrito.carrito_compra.Models.Carrito;
import com.carrito.carrito_compra.Services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    // Crear un nuevo carrito
    @PostMapping("/create")
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito) {
        carritoService.saveCarrito(carrito);
        return ResponseEntity.ok(carrito);
    }

    // Obtener todos los carritos
    @GetMapping
    public ResponseEntity<List<Carrito>> obtenerTodosLosCarritos() {
        List<Carrito> carritos = carritoService.getAllCarritos();
        return ResponseEntity.ok(carritos);
    }

    // Obtener un carrito por ID
    @GetMapping("/{id}")
    public ResponseEntity<Carrito> obtenerCarritoPorId(@PathVariable Integer id) {
        Optional<Carrito> carrito = carritoService.getCarritoById(id);
        return carrito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Comprobar
    // Actualizar un carrito
    @PutMapping("/update/{id}")
    public ResponseEntity<Carrito> actualizarCarrito(@PathVariable Integer id, @RequestBody Carrito carritoDetalles) {
        Optional<Carrito> carritoOpt = carritoService.getCarritoById(id);
        if (carritoOpt.isPresent()) {
            Carrito carrito = carritoOpt.get();
            // Actualiza los campos necesarios
            carrito.setProductos(carritoDetalles.getProductos());
            carritoService.saveCarrito(carrito);
            return ResponseEntity.ok(carrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un carrito
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Integer id) {
        carritoService.deleteCarritoById(id);
        return ResponseEntity.noContent().build();
    }
}
