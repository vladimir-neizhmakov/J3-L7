package ru.geekbrains.spring.university.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.spring.university.model.Product;
import ru.geekbrains.spring.university.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getAll(Sort.Direction sort, int page, int size) {
        if (page < 0) {page = 0;}
        int totalpage = productRepository.findAll(PageRequest.of(page, size)).getTotalPages();
        if (page >= totalpage) {page = totalpage-1;}

        try {
            if (sort.isAscending()) {
                return productRepository.findAll(PageRequest.of(page, size, Sort.by("cost").ascending())).toList();
            }
            if (sort.isDescending()) {
                return productRepository.findAll(PageRequest.of(page, size, Sort.by("cost").descending())).toList();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return productRepository.findAll(PageRequest.of(page, size)).toList();
    }

    public List<Product> getAllByCostGreaterThan(double minCost){return productRepository.findAllByCostGreaterThan(minCost);}
    public List<Product> getAllByCostLessThan(double maxCost){return productRepository.findAllByCostLessThan(maxCost);}
    public List<Product> getAllByCostBetween(double minCost, double maxCost){return productRepository.findAllByCostBetween(minCost, maxCost);}

    public List<Product> getAllByTitleContains(String title){return productRepository.findAllByTitleContains(title);}

    public Product getById(long id){return productRepository.getOne(id);}

    public Product save(Product product){return productRepository.save(product);}

    public void deleteById(long id){productRepository.deleteById(id);}
}
