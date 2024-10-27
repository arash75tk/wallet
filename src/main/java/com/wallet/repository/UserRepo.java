package com.wallet.repository;

import com.wallet.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
    public User findByNationalNumber(String nationalNumber);
    public User findByEmailAddress(String email);
}
