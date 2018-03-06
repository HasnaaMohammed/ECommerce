package model.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class User  implements Serializable {

    private String fullName;
    private String email ;
    private LocalDate birthDate;
    private String address;
    private String job ;
    private int credit ;
    private int role;
    private String password;


    public User() { }

    public String getFullName() {
        return fullName;
    }

    public User(String fullName, String email, LocalDate birthDate, String address, String job, int credit, int role, String password) {
        this.fullName = fullName;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.job = job;
        this.credit = credit;
        this.role = role;
        this.password = password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    
}

