package ru.geekbrains.spring.university.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.university.model.entities.Product;
import ru.geekbrains.spring.university.repository.ProductRepository;

import java.util.List;

@Service
public class BasketService {
    public List<Product> basket;

    @Autowired
    private ProductRepository productRepository;

    public void save(long id){
        try{
            basket.add(productRepository.getOne(id));
        } catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    public void deleteById(long id){
        basket.remove(id);
    }

}
