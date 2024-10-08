package com.inventorysystem.Backend.mapper;

import com.inventorysystem.Backend.dto.article.ArticleDTO;
import com.inventorysystem.Backend.model.Article;
import com.inventorysystem.Backend.model.Category;
import com.inventorysystem.Backend.model.Provider;
import com.inventorysystem.Backend.repository.CategoryRepository;
import com.inventorysystem.Backend.repository.ProviderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProviderMapper providerMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    public ArticleDTO articleToDTO(Article article) {
        if (article == null) {
            return null; // Handle null article
        }

        ArticleDTO convertedArticle = modelMapper.map(article, ArticleDTO.class);

        Provider foundProvider = providerRepository.getProviderById(article.getProviderId());
        Category foundCategory = categoryRepository.getCategoryById(article.getCategoryId());

        convertedArticle.setProvider(providerMapper.providerToDTO(foundProvider));
        convertedArticle.setCategory(categoryMapper.categoryToDTO(foundCategory));

        return convertedArticle;
    }
}
