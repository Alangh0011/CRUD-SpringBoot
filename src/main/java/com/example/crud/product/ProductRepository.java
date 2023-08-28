package com.example.crud.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository//Permite que trabaje desde services con la informacion de la base de datos
public interface ProductRepository extends JpaRepository<Product,Long> {//Modelo y tipo de dato <>

    //@Query("SELECT * FROM products WHERE p.nombre= ?1")
    Optional<Product> findProductByNombre(String nombre);
}
