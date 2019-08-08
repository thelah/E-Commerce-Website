/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.service;

import com.mycompany.graduate_project.common.ConvertData;
import com.mycompany.graduate_project.entities.ImagesEntity;
import com.mycompany.graduate_project.model.Image;
import com.mycompany.graduate_project.repository.ImageRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanhhai
 */
@Service
public class ImageService {
    
    @Autowired
    private ImageRepository imageRepository;
    
    public List<Image> getLstImage(){
        List<ImagesEntity> lstImagesEntity =  (List<ImagesEntity>) imageRepository.findAll();
        List<Image> lstImage = new ArrayList<>();
        if(lstImagesEntity != null && lstImagesEntity.size() >0){
            for (ImagesEntity imagesEntity : lstImagesEntity) {
                lstImage.add(ConvertData.convertImageFromImageEntity(imagesEntity));
            }
        }
        return lstImage;
    }
    
    public int addImage(Image image){
        ImagesEntity imagesEntity = ConvertData.convertImageEntityFromImage(image);
        imageRepository.save(imagesEntity);
        int imgId = 0;
        if (imagesEntity.getImageId() != 0) {
            imgId = imagesEntity.getImageId();
        }
        return imgId;
    }
    
    public void deleteImage(int imageId){
        imageRepository.delete(imageId);
    }
    
    public Image findImageById(int id){
        ImagesEntity imagesEntity = imageRepository.findOne(id);
        Image image = ConvertData.convertImageFromImageEntity(imagesEntity);
        return image;
    }
}
