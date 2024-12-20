package com.example.gallery.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class GalleryController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Environment env;

    @GetMapping("/")
    public List<Object> getImages() {
        List images = restTemplate.getForObject("http://image-server/images", List.class);
        return images;
    }

    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }
}
