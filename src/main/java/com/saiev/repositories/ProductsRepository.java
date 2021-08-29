package com.saiev.repositories;

import com.saiev.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Component
public class ProductsRepository {
    private Map<Integer, Product> products;
    private static int id = 1;

    @Autowired
    public void setProducts(){
        products = new HashMap<>();

        Product p1 = new Product();
        p1.setId(id++);
        p1.setTitle("Компьютер");
        p1.setCost(35000);

        Product p2 = new Product();
        p2.setId(id++);
        p2.setTitle("Телевизор");
        p2.setCost(70000);

        products.put(p1.getId(), p1);
        products.put(p2.getId(), p2);
    }

    public Product getProductById(int id){
        return products.get(id);
    }

    public List<Product> getProducts(){
        return new ArrayList<>(products.values());
    }

    public void addProduct(Product newProduct){
        newProduct.setId(id++);
        products.put(newProduct.getId(), newProduct);
    }
}
