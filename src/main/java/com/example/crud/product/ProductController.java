package com.example.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// esta clase sera un controlador y lo hace una api
@RequestMapping(path = "api/v1/products")//control de versiones
//inyeccion de dependencias
public class ProductController {
    private final ProductService productService;
    @Autowired //este es para inyectar en el constructor
    public ProductController(ProductService productService) {// se lama a si mismo el constructor
        this.productService = productService;
    }
    //Lo de arriva es la conexion
    @GetMapping
    public List<Product> getProducts(){//retorna lo que esta en productservices
        return this.productService.getProducts();
    }
    @PostMapping
    public ResponseEntity<Object> registrarProducto(@RequestBody Product product){

        return this.productService.newProduct(product);
    }

    @PutMapping
    public ResponseEntity<Object> actualziarProducto(@RequestBody Product product){
        return this.productService.newProduct(product);
    }

}
