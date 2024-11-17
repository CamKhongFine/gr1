package com.example.image.Controller;

import com.example.image.DAO.ImageDAO;
import com.example.image.Entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private Environment env;

    @Autowired
    private ImageDAO imageDAO;

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/images")
    public List<Image> getImages() {
        List<Image> images = imageDAO.findAll();
        return images;
    }
}
