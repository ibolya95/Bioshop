package com.example.bioshop.controllers;

import com.example.bioshop.models.Product;
import com.example.bioshop.repositories.ProductRepository;
import com.example.bioshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bioshop")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        model.addAttribute("items", productService.findByName(name));
        return "index";
    }

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("items", productService.products());
        return "index";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/store")
    public String store(Product product) {
        productService.saveProduct(product);
        return "redirect:/bioshop";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        model.addAttribute("product", productService.findProduct(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam Long id, @ModelAttribute Product product) {
        productService.updateProduct(id, product);
        return "redirect:/bioshop";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        productService.deleteProduct(id);
        return "redirect:/bioshop";
    }
}
