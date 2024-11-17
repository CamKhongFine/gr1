package com.example.security.Controller;

import com.netflix.discovery.converters.Auto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class SecurityRedirect {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @GetMapping("/")
    public void redirectNormal(HttpServletResponse response) {
        // Use the load-balanced RestTemplate to resolve the service URL dynamically
        try {
            response.sendRedirect("http://localhost:8762/confirmed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Redirect to the URL resolved by RestTemplate
    }
}

