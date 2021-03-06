package com.ecam.atsnum.Repository.Interfaces;

import java.util.List;

import com.ecam.atsnum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User findOneByUserId(int id);
}
