package com.example.security.Controller;

import com.example.security.Jwt.JwtUtil;
import com.example.security.Security.SecurityUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SecurityRedirect {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @GetMapping("/")
    public String redirectNormal(HttpServletRequest request, HttpServletResponse response) {
        SecurityUtils utils = new SecurityUtils();
        System.out.println(utils.getRoles());
        return JwtUtil.generateToken(utils.getUsername(), utils.getRoles());
    }
}

