package com.bootapp.rest.restApp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restApp.model.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Integer> {

}
