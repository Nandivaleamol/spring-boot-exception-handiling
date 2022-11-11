package com.handling.exception.exception_handling.controller;

import com.handling.exception.exception_handling.entity.Product;
import com.handling.exception.exception_handling.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {

    private static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("101");
        honey.setName("Honey");
        productRepo.put(honey.getId(),honey);

        Product almond = new Product();
        almond.setId("102");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);

        Product sugar = new Product();
        sugar.setName("Sugar");
        sugar.setId("103");
        productRepo.put(sugar.getId(), sugar);

    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){

        if (!productRepo.containsKey(id))
            throw new ProductNotFoundException();

        productRepo.remove(id);
        product.setId(id);
        Product put = productRepo.put(id, product);
        System.out.println(product.getId()+"  " + product.getName());

        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }
}
