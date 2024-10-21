package com.wallet.service;

import com.wallet.model.User;
import com.wallet.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    UserRepo userRepo;
    public User getUser(String nationalNumber) {
        try {
            return userRepo.findByNationalNumber(nationalNumber);
        }
        catch (
                EntityNotFoundException e) {
            throw new CustomExceptionHandler("user with nationalNumber " + nationalNumber + " not found.", e);
        }
    }
    public User createUser(User user) {
        try{
            return userRepo.save(user);
        }catch (DataIntegrityViolationException e) {
            throw new CustomExceptionHandler("Data integrity violation while saving User.", e);
        } catch (Exception e) {
            throw new CustomExceptionHandler("An error occurred while creating the User.", e);
        }
    }
    public String updateUser(String nationalNumber, User user) {
        try {
               User findeduser = userRepo.findByNationalNumber(nationalNumber);
               findeduser.UpdateUserFeilds(user);
               return "User updated successfully";
        }catch (Exception e) {
            // Handle other general exceptions
            throw new CustomExceptionHandler("An error occurred while Updating the User.", e);
        }
    }
    public String deleteUser(String nationalNumber) {
        try{
            userRepo.delete(getUser(nationalNumber));
            return "User deleted successfully";
        }
        catch (Exception e) {
            throw new CustomExceptionHandler("An error occurred while deleting the User.", e);
        }
    }


}
