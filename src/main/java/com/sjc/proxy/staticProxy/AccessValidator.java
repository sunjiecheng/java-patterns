package com.sjc.proxy.staticProxy;

public class AccessValidator {
    public boolean vaidateUser(String userId) {
        if (userId.equals("Admin")) {
            return true;
        } else {
            return false;
        }
    }
}