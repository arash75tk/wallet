package com.wallet.repository;

import com.wallet.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {
    User findByNationalNumber(String nationalNumber);
    User findByEmail(String email);
}
