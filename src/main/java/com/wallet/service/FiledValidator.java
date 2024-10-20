package com.wallet.service;

import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class FiledValidator {
    public boolean isValidNationalCode(String NationalNumber) {
        if (!NationalNumber.matches("\\d{10}")) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(NationalNumber.charAt(i)) * (10 - i);
        }

        int remainder = sum % 11;
        int lastDigit = Character.getNumericValue(NationalNumber.charAt(9));

        return (remainder < 2 && lastDigit == remainder) || (remainder >= 2 && lastDigit == 11 - remainder);
    }
    public boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches("^09[0-9]{9}$", phoneNumber);
    }

    public boolean isValidEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email);
    }

    public boolean isValidAccountNumber(String accountnumber) {
        return Pattern.matches("^\\d{10,18}$", accountnumber);
    }

    public boolean isValidShebaNumber(String ShebaNumber) {
        return ShebaNumber.matches("^IR\\d{24}$");
    }
    public boolean isValidWalletAddress(String walletaddress) {
        return walletaddress.matches("^.{10}$");
    }

}
