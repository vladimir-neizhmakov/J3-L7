package ru.geekbrains.spring.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.university.model.entities.Product;
import ru.geekbrains.spring.university.services.BasketService;


import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping
    public List<Product> getAll(){
        return basketService.basket;
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){basketService.deleteById(id);}

    @GetMapping("/add/{id}")
    public void save(@PathVariable long id){basketService.save(id);}
}
