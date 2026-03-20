package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    List<Product> list = new ArrayList<>();

    //crud之create
    public void add(String name, double price){
        Product p = new Product(name,price);
        list.add(p);
    }

    //crud之read
    public List<Product> getAll(){
        return list;
    }

    public Product getId(int id){
        return list.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    //crud之delete
    public void delete(int id){
        list.removeIf(p -> p.getId() == id);
    }

}
