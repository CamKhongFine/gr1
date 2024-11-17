package com.example.image.DAO;

import com.example.image.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDAO extends JpaRepository<Image, Integer> {
}
