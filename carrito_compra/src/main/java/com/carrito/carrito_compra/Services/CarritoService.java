package com.carrito.carrito_compra.Services;
import com.carrito.carrito_compra.Models.Carrito;
import com.carrito.carrito_compra.Repositories.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    public void saveCarrito(Carrito carrito) {
        carritoRepository.save(carrito);
    }

    public List<Carrito> getAllCarritos() {
        return carritoRepository.findAll();
    }

    public Optional<Carrito> getCarritoById(Integer id) {
        return carritoRepository.findById(id);
    }

    public void deleteCarritoById(Integer id) {
        carritoRepository.deleteById(id);
    }


}
