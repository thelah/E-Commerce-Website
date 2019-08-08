/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.service;

import com.mycompany.graduate_project.common.ConvertData;
import com.mycompany.graduate_project.entities.CategoryEntity;
import com.mycompany.graduate_project.model.Category;
import com.mycompany.graduate_project.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanhhai
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getLstCategory(){
        List<CategoryEntity> lstCategoryEntity = (List<CategoryEntity>) categoryRepository.findAll();
        List<Category> lstCategory = new ArrayList<>();
        if (lstCategoryEntity != null && lstCategoryEntity.size() >0) {
            for (CategoryEntity categoryEntity : lstCategoryEntity) {
                lstCategory.add(ConvertData.convertCategoryFromCategoryEntity(categoryEntity));
            }
        }
        return lstCategory;
    }
    
    public int addNewCategory(Category category){
        CategoryEntity categoryEntity = ConvertData.convertCategoryEntityFromCategory(category);
        categoryRepository.save(categoryEntity);
        int cateId = categoryEntity.getCateId();
        return cateId;
    }
    
    public void deleteCategory(int cateId){
        categoryRepository.delete(cateId);
    }
    
    public Category findCategory(int cateId){
        CategoryEntity categoryEntity = categoryRepository.findOne(cateId);
        Category category = ConvertData.convertCategoryFromCategoryEntity(categoryEntity);
        return category;
    }
}
