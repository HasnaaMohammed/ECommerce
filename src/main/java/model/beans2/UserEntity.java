package model.beans2;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "ECommerce", catalog = "")
public class UserEntity {
    private Integer id;
    private String email;
    private String password;
    private String fullName;
    private Date birthdate;
    private String address;
    private String job;
    private Integer creditLimit;
    private Byte role;
    private Collection<CartEntity> cartsById;
    private Collection<UserCategoriesEntity> userCategoriesById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Full_Name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Birthdate")
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Job")
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "Credit_Limit")
    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Basic
    @Column(name = "Role")
    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(birthdate, that.birthdate) &&
                Objects.equals(address, that.address) &&
                Objects.equals(job, that.job) &&
                Objects.equals(creditLimit, that.creditLimit) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, password, fullName, birthdate, address, job, creditLimit, role);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<CartEntity> getCartsById() {
        return cartsById;
    }

    public void setCartsById(Collection<CartEntity> cartsById) {
        this.cartsById = cartsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserCategoriesEntity> getUserCategoriesById() {
        return userCategoriesById;
    }

    public void setUserCategoriesById(Collection<UserCategoriesEntity> userCategoriesById) {
        this.userCategoriesById = userCategoriesById;
    }
}
