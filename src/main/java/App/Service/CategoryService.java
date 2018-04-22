package App.Service;

import App.Model.Category;
import App.Model.Employee;
import App.Repository.CategoryRepository;
import App.Repository.EmployeeRepository;
import App.Util.IterableConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category insert(Category category) {
        return this.categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return IterableConverter.toList(this.categoryRepository.findAll());
    }

    public Category find(Integer id) {
        return this.categoryRepository.findOne(id);
    }
}
