package com.restaurent.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    boolean existsByEmailAndPassword(String email, String password);

    default Users findByEmail(String email) {
        return null;
    }
}
