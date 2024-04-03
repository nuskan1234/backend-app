package com.restaurant.authentication.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository <Auth, Integer>{
    boolean existsByNameAndPassword(String name, String password);
}
