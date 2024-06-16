package com.booted.springy.respository;

import com.booted.springy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,Long>{
}
