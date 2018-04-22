package App.Service;

import App.Model.Category;
import App.Model.Product;
import App.Repository.CategoryRepository;
import App.Repository.ProductRepository;
import App.Util.IterableConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product insert(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> getAll() {
        return IterableConverter.toList(this.productRepository.findAll());
    }

    public Product find(Integer id) {
        return this.productRepository.findOne(id);
    }
}
