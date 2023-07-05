package com.codegym.formvalidate.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import javax.validation.constraints.Size;

public class RegisterDto implements Validator {
    @Size(min = 5, max = 45, message = "có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstName;
    @Size(min = 5, max = 45, message = "có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;
    private String phone;
    private Integer age;
    private String email;

    public RegisterDto() {
    }

    public RegisterDto(String firstName, String lastName, String phone, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
        RegisterDto registerDto = (RegisterDto) target;

        if (!errors.hasFieldErrors("firstName")) {
            if (registerDto.getFirstName().trim().isEmpty()) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", null, "Không được để trống");
            }
        }

        if (!errors.hasFieldErrors("lastName")) {
            if (registerDto.getLastName().isEmpty()) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", null, "Không được để trống");
            }
        }

        if (!errors.hasFieldErrors("phone")) {
            if (registerDto.getPhone().isEmpty()) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", null, "Không được để trống");
            } else if (!registerDto.getPhone().matches("^[\\d]{10,11}$")) {
                errors.rejectValue("phone", null, "Nhập sai định dạng số điện thoại");
            }
        }

        if (!errors.hasFieldErrors("age")) {
            if (registerDto.getAge() == null) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", null, "Không được để trống");
            } else if (registerDto.getAge() <= 18) {
                errors.rejectValue("age", null, "Tuổi phải lớn hơn hoặc bằng 18.");
            } else if (registerDto.getAge() >= 120) {
                errors.rejectValue("age", null, "Tuổi của bạn quá lớn! Vui lòng nhập lại.");
            }
        }

        if (!errors.hasFieldErrors("email")) {
            if (registerDto.getEmail().isEmpty()) {
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "Không được để trống");
            }
        }
    }
}
