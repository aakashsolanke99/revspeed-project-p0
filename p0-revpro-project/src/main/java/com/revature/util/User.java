package com.revature.util;

public class User {


        private int userId;
        private String firstName;
        private String lastName;
        private String email;
        private String passWord;
        private String phoneNumber;
        private String address;

    public User() {
    }

    public User(int userId, String firstName, String lastName, String email, String passWord, String phoneNumber, String address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User(String firstName, String lastName, String email, String password, String phNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = password;
        this.phoneNumber = phNumber;
        this.address = address;
    }

        public int getUserId() {
        return userId;
    }

        public void setUserId(int userId) {
        this.userId = userId;
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

        public String getEmail() {
        return email;
    }

        public void setEmail(String email) {
        this.email = email;
    }

        public String getPassWord() {
        return passWord;
    }

        public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

        public String getPhoneNumber() {
        return phoneNumber;
    }

        public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

        public String getAddress() {
        return address;
    }

        public void setAddress(String address) {
        this.address = address;
    }


    }
