package com.inventorysystem.Backend.controller;

import com.inventorysystem.Backend.model.Notification;
import com.inventorysystem.Backend.repository.NotificationRepository;
import com.inventorysystem.Backend.service.NotificationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/unread")
    public ResponseEntity<List<Notification>> getUnreadNotifications() {
//        List<NotificationDTO> notifications = notificationService.getUnreadNotifications();
        List<Notification> unreadNotifications = notificationRepository.findByIsRead(false);


        return ResponseEntity.ok(unreadNotifications);

    }

    @PostMapping("/markAsRead/{id}")
    public ResponseEntity<String> markNotificationAsRead(@PathVariable("id") Long id) {
        try {
            notificationService.markAsRead(id); // Assuming this service method updates the notification as read
            return ResponseEntity.ok("SUCCESS");
        } catch (EntityNotFoundException e) { // Handle specific exception if the notification ID doesn't exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notification not found");
        } catch (Exception e) { // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error marking notification as read");
        }
    }

}
