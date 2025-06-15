package com.vipul.expense.repo;

import com.vipul.expense.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
