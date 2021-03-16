package ru.geekbrains.spring.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.university.model.dtos.ProductDto;
import ru.geekbrains.spring.university.model.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<ProductDto> findAllByCostGreaterThan(double minCost);
    public List<ProductDto> findAllByCostLessThan(double maxCost);
    public List<ProductDto> findAllByCostBetween(double minCost, double maxCost);
    public List<ProductDto> findAllByTitleContains(String title);
}
