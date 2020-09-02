package com.company.shopping_cart.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserForm {

    private String name;

    private String mobile;

    private String emailId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
