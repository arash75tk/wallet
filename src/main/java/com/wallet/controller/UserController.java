package com.wallet.controller;


import com.wallet.model.User;
import com.wallet.model.userConvert;
import com.wallet.repository.UserRepo;
import com.wallet.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserServices userServices;

    @PostMapping("/updateuser")
    @ResponseBody
    public String updateuser(@RequestParam String nationalCode, @RequestBody userConvert input) {
        User user = input.convertToEntity(input);
        return userServices.updateUser(nationalCode,user);
    }

    @PostMapping("/deleteuser")
    @ResponseBody
    public String deleteuser(@RequestBody String nationalCode) {
        return userServices.deleteUser(nationalCode);
    }
    @GetMapping("/getuser")
    @ResponseBody
    public User getuser(@RequestBody String nationalCode){
        return userServices.getUser(nationalCode);
    }



}
