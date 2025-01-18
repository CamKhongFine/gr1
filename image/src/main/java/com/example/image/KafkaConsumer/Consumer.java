package com.example.image.KafkaConsumer;

import com.example.image.DAO.ImageDAO;
import com.example.image.Entity.Image;
import com.example.image.TelegramService.Telegram;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Consumer {
    private final ImageDAO imageDAO;

    @Autowired
    public Consumer(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }

    @KafkaListener(topics = "request-topic", groupId = "image-consumer")
    public void consumeEvent(ConsumerRecord<String, String> record) {
        StringBuilder messageBuilder = new StringBuilder(record.value());
        List<Image> images = imageDAO.findAll();
        images.forEach(image -> messageBuilder.append(image.getId())
                .append(". ")
                .append(image.getTitle())
                .append(" - ")
                .append(image.getUrl())
                .append("\n"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Telegram.sendMessage(messageBuilder.toString());
    }
}
