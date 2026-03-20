package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //查看所有商品
    @GetMapping
    public List<Product> getProducts(){
        return  productService.getAll();
    }

    //查看对应商品
    @GetMapping("/{userId}")
    public Product getProduct(@PathVariable int userId){
        return productService.getId(userId);
    }

    record ProductDTO(String name, double price){}//JSON参数必须给record包进去

    //添加商品
    @PostMapping
    public void addProduct(@RequestBody ProductDTO dto){
        productService.add(dto.name(), dto.price());
    }

    //删除指定商品
    @DeleteMapping("/{userId}")//删除要用DELETE注释
    public void deleteProduct(@PathVariable int userId){
        productService.delete(userId);
    }

}
