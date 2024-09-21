package com.inventorysystem.Backend.service.imp;

import com.inventorysystem.Backend.dto.article.ArticleDTO;

public interface NotificationService {
    void sendLowStockAlert(ArticleDTO article);

}
