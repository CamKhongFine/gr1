package com.example.gallery.Controller;

import com.example.gallery.KafkaProducer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GalleryController {
    private final Producer producer;

    @Autowired
    public GalleryController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/")
    public String getImages() {
        producer.produceEvent();
        return "Successful, check your Telegram message!";
    }

}
