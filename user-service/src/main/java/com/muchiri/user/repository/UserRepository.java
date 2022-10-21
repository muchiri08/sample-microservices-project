package com.muchiri.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muchiri.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
