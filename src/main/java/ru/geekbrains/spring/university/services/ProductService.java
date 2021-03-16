package ru.geekbrains.spring.university.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.spring.university.model.dtos.ProductDto;
import ru.geekbrains.spring.university.model.entities.Product;
import ru.geekbrains.spring.university.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<ProductDto> getAll(Sort.Direction sort, int page, int size) {
        if (page < 0) {
            page = 0;
        }
        int totalpage = productRepository.findAll(PageRequest.of(page, size)).getTotalPages();
        if (page >= totalpage) {
            page = totalpage - 1;
        }
        try {
            if (sort.isAscending()) {
                return productRepository.findAll(PageRequest.of(page, size, Sort.by("cost").ascending())).map(ProductDto::new).toList();
            }
            if (sort.isDescending()) {
                return productRepository.findAll(PageRequest.of(page, size, Sort.by("cost").descending())).map(ProductDto::new).toList();
            }
        } catch (NullPointerException e) { e.printStackTrace();}
        return productRepository.findAll(PageRequest.of(page, size)).map(ProductDto::new).toList();}

    public List<ProductDto> getAllByCostGreaterThan(double minCost){return productRepository.findAllByCostGreaterThan(minCost);}
    public List<ProductDto> getAllByCostLessThan(double maxCost){return productRepository.findAllByCostLessThan(maxCost);}
    public List<ProductDto> getAllByCostBetween(double minCost, double maxCost){return productRepository.findAllByCostBetween(minCost, maxCost);}
    public List<ProductDto> getAllByTitleContains(String title){return productRepository.findAllByTitleContains(title);}
    public Optional<ProductDto> getById(long id){return productRepository.findById(id).map(ProductDto::new);}

    public Product save(Product product){return productRepository.save(product);}

    public void deleteById(long id){productRepository.deleteById(id);}
}
