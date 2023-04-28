package com.tailor.Shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailor.Shop.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
