/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graduate_project.service;

import com.mycompany.graduate_project.common.ConvertData;
import com.mycompany.graduate_project.entities.CoursesEntity;
import com.mycompany.graduate_project.model.Course;
import com.mycompany.graduate_project.repository.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thanhhai
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getLstCourse() {
        List<CoursesEntity> lstCoursesEntity = (List<CoursesEntity>) courseRepository.findAll();
        List<Course> lstCourses = new ArrayList<>();
        if (lstCoursesEntity != null && lstCoursesEntity.size() > 0) {
            for (CoursesEntity coursesEntity : lstCoursesEntity) {
                lstCourses.add(ConvertData.convertCourseFromCourseEntity(coursesEntity));
            }
        }
        return lstCourses;
    }

    public List<Course> getLstCourseByCategory(String categoryName) {
        List<CoursesEntity> lstCoursesEntity = (List<CoursesEntity>) courseRepository.findAll();
        List<Course> lstCourses = new ArrayList<>();
        if (lstCoursesEntity != null && lstCoursesEntity.size() > 0) {
            for (CoursesEntity coursesEntity : lstCoursesEntity) {
                if (coursesEntity.getCategory().getCateName().equalsIgnoreCase(categoryName)) {
                    lstCourses.add(ConvertData.convertCourseFromCourseEntity(coursesEntity));
                }
            }
        }
        return lstCourses;
    }

    public Course addNewCourse(Course course) {
        CoursesEntity coursesEntity = ConvertData.convertCourseEntityFromCourse(course);
        courseRepository.save(coursesEntity);
        Course obj = new Course();
        if (coursesEntity.getCourseId() != 0) {
            obj = ConvertData.convertCourseFromCourseEntity(coursesEntity);
        }
        return obj;

    }

    public Course findCourseById(int id) {
        CoursesEntity coursesEntity = courseRepository.findOne(id);
        Course course = ConvertData.convertCourseFromCourseEntity(coursesEntity);
        return course;
    }

    public void deleteCourse(int courseId) {
        courseRepository.delete(courseId);
    }
}
