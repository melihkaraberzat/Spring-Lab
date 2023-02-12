package com.LaboratuvarApp;

import com.LaboratuvarApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    User findUserByUsernameAndPassword(String username,Long password);
}
