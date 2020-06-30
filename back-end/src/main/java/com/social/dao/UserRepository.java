package com.social.dao;

import com.social.entities.Question;
import com.social.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String  email);
    User findById(long id);

}
