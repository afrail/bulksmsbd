package com.shopnobazz.bulksmsbd.smsSend;


import javax.validation.constraints.NotBlank;

public class SmsRequest {

   
    private  String phoneNumber; // destination


    private  String message;

    public SmsRequest(  String phoneNumber,
             String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
