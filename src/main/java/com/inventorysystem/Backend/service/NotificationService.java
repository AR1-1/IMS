package com.inventorysystem.Backend.service;

import com.inventorysystem.Backend.dto.Notification.NotificationDTO;
import java.util.List;

public interface NotificationService {
   // List<NotificationDTO> getUnreadNotification();
    List<NotificationDTO> getUnreadNotifications();
//    // List<NotificationDTO> getAllNotifications();
//    void markAsRead(Long id);

    void markAsRead(Long id);

}
