package com.wallet.controllerTest;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.model.Gender;
import com.wallet.model.MilitaryState;
import com.wallet.model.User;
import com.wallet.model.userConvert;
import com.wallet.repository.UserRepo;
import com.wallet.service.RandomStringGen;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class userControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserRepo userRepo;
    @Autowired
    ObjectMapper objectMapper;

    // userConvert userConv;

    @Test
    public void create_user()  throws Exception{
        userConvert userConv = new userConvert();
        userConv.setEmailAddress("test@example.com");
        userConv.setBirthDate("13752704");
        userConv.setGender(0);
        userConv.setMilitaryState(0);
        String nationalCode = RandomStringGen.generateNumericRandomString(10);
        userConv.setNationalNumber(nationalCode);
        userConv.setPassword("ABab12#$");
        userConv.setPhoneNumber("09185949761");

        String jsonValue = objectMapper.writeValueAsString(userConv);
        ResultActions result = mockMvc.perform(post("/auth/registeruser")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonValue)); 
        result.andExpect(status().isOk())
        .andExpect(jsonPath("$.phoneNumber", is("09185949761"))) // Verify the response contains the correct username
        .andExpect(jsonPath("$.emailAddress", is("test@example.com")))
        .andExpect(jsonPath("$.birthDate", is("13752704")))
        .andExpect(jsonPath("$.gender", is(Gender.Man.toString())))
        .andExpect(jsonPath("$.militaryState", is(MilitaryState.Done.toString())))
        .andExpect(jsonPath("$.nationalNumber", is(nationalCode)));

    }


}
