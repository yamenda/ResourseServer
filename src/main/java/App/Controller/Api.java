package App.Controller;


import App.Model.Category;
import App.Model.Product;
import App.Service.CategoryService;
import App.Service.ProductService;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class Api {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/allcategories", method = RequestMethod.GET)
    @PreAuthorize("hasRole('SYSTEMADMIN')")
    public List<Category> showCategories() {
        List<Category> categories = this.categoryService.getAll();
        return categories;
    }

    @RequestMapping(value = "/allproducts", method = RequestMethod.GET)
    @PreAuthorize("hasRole('SYSTEMADMIN')")
    public List<Product> showProducts() {
        List<Product> products = this.productService.getAll();
        return products;
    }

    @RequestMapping(value = "/showproduct", method = RequestMethod.POST)
    @PreAuthorize("hasRole('SYSTEMADMIN')")
    public Product showProductDetails(@RequestBody java.util.Map<String, Object> map) {

        if(!map.containsKey("id")) {
            return null;
        }else {
            int id = (int) map.get("id");
            Product product = this.productService.find(id);
            return product;
        }

    }

}
