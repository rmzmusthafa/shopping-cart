package com.company.shopping_cart.form;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AppSignUpRequest {

    private String name;


    @Size(min = 1, max = 40)
    private String firstName;


    @Size(min = 1, max = 40)
    private String lastName;

    @NotBlank
    @Size(min = 1, max = 40)
    private String userName;

    @NotBlank
    @Size(max = 40)
    @Email
    private String emailId;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    private Long roleId;

    private Long clinicId;

    private Long ownerId;

    @NotBlank
    @Size(min = 10, max = 10)
    private String mobile;

    private String deviceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getRoleId() { return roleId; }

    public void setRoleId(Long roleId) { this.roleId = roleId; }

    public Long getClinicId() { return clinicId; }

    public void setClinicId(Long clinicId) { this.clinicId = clinicId; }

    public Long getOwnerId() { return ownerId; }

    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
