package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
