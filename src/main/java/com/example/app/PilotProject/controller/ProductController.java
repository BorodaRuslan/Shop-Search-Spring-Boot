package com.example.app.PilotProject.controller;

import com.example.app.PilotProject.entity.Product;
import com.example.app.PilotProject.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;

    // Get first page
    @GetMapping
    public String startPage(Model model){
        model.addAttribute("result", Collections.EMPTY_LIST);
        return "firstPage";


    }

    // Get second page
    @GetMapping("/search")
    public String searchProducts(@RequestParam String keywordValue, Model model){
        List<Product> resultList = new ArrayList<>();
        try {
            resultList = service.searchProducts(keywordValue);
            if (!resultList.isEmpty()){
                log.info(">>> Get a search result: {}", resultList);
            model.addAttribute("result", resultList);
            return "firstPage";
            }
        } catch (Exception e) {
            log.error(">>> Failed to connect to database: " + e);
        }
        // Обработка случая, когда результат отсутствует.
        log.info("No such products {}", keywordValue);
        model.addAttribute("result", resultList);
        return "secondPage";
    }
}
