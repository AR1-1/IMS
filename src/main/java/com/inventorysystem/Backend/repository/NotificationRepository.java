package com.inventorysystem.Backend.repository;

import com.inventorysystem.Backend.model.Article;
import com.inventorysystem.Backend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByIsRead(boolean isRead);  // Add a boolean parameter to specify the value

    @Query(value = "Select count(n) FROM Notification n WHERE n.articleId = :articleId and n.isRead = false" )
    Long countNotificationByArticleId(@Param("articleId") Long articleId);

}
