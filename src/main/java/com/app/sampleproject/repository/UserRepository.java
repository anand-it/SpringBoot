package com.app.sampleproject.repository;

import com.app.sampleproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
