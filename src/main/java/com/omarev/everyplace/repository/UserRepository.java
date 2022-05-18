package com.omarev.everyplace.repository;

import com.omarev.everyplace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
