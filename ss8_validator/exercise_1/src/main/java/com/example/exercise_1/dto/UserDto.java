package com.example.exercise_1.dto;



import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    private int id;

    @Size(min = 5, max = 45, message = "Độ dài tối thiểu 5, tối đa là 45")
    private String firstName;

    @Size(min = 5, max = 45, message = "Độ dài tối thiểu 5, tối đa là 45")
    private String lastname;
    @Pattern(regexp = "^(0[3578]\\d{8}|0[1-9]\\d{7,8})$",message = "Nhập sai định dạng")
    private String numberPhone;
    @Min(value = 18,message = "Tuổi phải lớn hơn 18")
    private int ages;
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",message = "Nhập sai định dạng")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastname, String numberPhone, int ages, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.numberPhone = numberPhone;
        this.ages = ages;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}


