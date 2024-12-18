package com.evilcorp.connect;

import java.util.Objects;

public class Connect {

    /**
     * Send email
     * @param email email address of the recipient
     * @param subject subject of the email
     * @param message body of the email
     */
    public static void sendMail(String email,String subject, String message){
        Objects.requireNonNull(email);
        System.out.println("Sending email to "+email+" with content "+message);
    }

    /**
     * Send SMS
     * @param phoneNumber
     * @param message
     */
    public static void sendSMS(String phoneNumber,String message){
        Objects.requireNonNull(phoneNumber);
        System.out.println("Sending SMS to "+phoneNumber+" with content "+message);
    }

    /**
     * Send Tweet. If the message is too long the message is sent in several tweets
     * @param twitter username of the twitter account
     * @param message
     */
    public static void sendTweet(String twitter,String message){
        Objects.requireNonNull(twitter);
        System.out.println("Sending tweet to "+twitter+" with content "+message);
    }
}
