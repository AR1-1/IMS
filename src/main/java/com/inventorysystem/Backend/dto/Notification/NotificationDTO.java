package com.inventorysystem.Backend.dto.Notification;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NotificationDTO {

    private Long id;
    private String message;
    private boolean isRead;

}
