package com.example.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;


import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service//este sera el servicio que se pone a la disposicion del controlador
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired//Lo inyectamos del Repository
    //Ahora podemos usar todas las formas del CRUD de forma directa
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product) {//Registrar product
        Optional<Product> res = productRepository.findProductByNombre(product.getNombre());//Metodo personalizado de Reporter
        //El optional es porque puede que no venga ningun producto

        HashMap<String, Object> datos = new HashMap<>();//se utiliza para acceder a su valor correspondiente.


        //Si encuentra una respuesta lanzara una ecxepcion ilegal
        if(res.isPresent()){
            datos.put("message", "Ya existe un producto con ese nombre");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        productRepository.save(product);//Si no existe lo guardamos
        datos.put("message", "Se guardo con exito");
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
//    public List<Product> getProducts() {
//        return List.of(
//                new Product(
//                        2547L,
//                        "Laptop",
//                        500,
//                        LocalDate.of(2025, Month.MARCH,5),
//                        2
//                )
//        );
//    }
}
