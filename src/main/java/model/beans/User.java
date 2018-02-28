package model.beans;

import java.time.LocalDate;

public class User {

    private String fullName;
    private String password;
    private String email ;
    private LocalDate birthDate;
    private String address;
    private String job ;
    private int credit ;
    private int role;

    public User(String fullName, String password , String email, LocalDate birthDate, String address, String job, int credit, int role) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.job = job;
        this.credit = credit;
        this.role = role;
    }
    
    public User() { }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
