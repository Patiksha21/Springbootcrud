package com.example.Bootexample.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.Bootexample.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
