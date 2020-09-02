package com.company.shopping_cart.form;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

    private String deviceId;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}
