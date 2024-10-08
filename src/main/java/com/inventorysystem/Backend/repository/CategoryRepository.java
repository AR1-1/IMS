package com.inventorysystem.Backend.repository;

import com.inventorysystem.Backend.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    @Procedure(procedureName = "Proc_get_all_categories")
    List<Category> getAllCategories();

    @Procedure(procedureName = "Proc_get_category_by_id")
    Category getCategoryById(@Param("Ip_category_id") Long categoryId);

    @Procedure(procedureName = "Proc_insert_category", outputParameterName = "Op_category_id")
    Long createCategory(@Param("Ip_name") String name);

    @Procedure(procedureName = "Proc_update_category")
    void updateCategory(
            @Param("Ip_category_id") Long categoryId,
            @Param("Ip_name") String name
    );

    @Procedure(procedureName = "Proc_delete_category")
    void deleteCategory(@Param("Ip_category_id") Long categoryId);

  Page<Category> findAll(Specification<Category> categorySpecification, Pageable pageable);

  //  Page<Category> findByUserId(Long userId, Pageable pageable);

}
