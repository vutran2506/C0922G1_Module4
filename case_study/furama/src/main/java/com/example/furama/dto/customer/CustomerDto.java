package com.example.furama.dto.customer;


import com.example.furama.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto {
    private int id;
    @NotNull(message = "Không được để null ")
    @NotBlank(message = "Không được nhập toàn dấu cách")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$" , message = "Nhập tên không đúng định dạng")
    private String name;
@NotBlank(message = "Ngày sinh không được để trống")
    private String dateOfBirth;
    private boolean gender;
    @NotNull(message = "Không được để null ")
    @NotBlank(message = "Không được nhập toàn dấu cách")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^\\d{12}|\\d{10}$", message = "Số căn cước công dân phải 10  hoặc 12 số")
    private String iDCard;
    @NotNull(message = "Không được để null ")
    @NotBlank(message = "Không được nhập toàn dấu cách")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^\\d{10}|\\d{11}$", message = " Số điện thoại phải 10 hoặc 11 số")
    private String phoneNumber;
    @NotNull(message = "Không được để null ")
    @NotBlank(message = "Không được nhập toàn dấu cách")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Email không hợp lệ")
    private String email;
    @NotNull(message = "Không được để null ")
    @NotBlank(message = "Không được nhập toàn dấu cách")
    @NotEmpty(message = "Không được để trống")
    private String address;
    private CustomerType customerType;

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getiDCard() {
        return iDCard;
    }

    public void setiDCard(String iDCard) {
        this.iDCard = iDCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }


}
