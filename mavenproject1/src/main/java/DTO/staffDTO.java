/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author khoan
 */
public class staffDTO {
    String staffID, firstname, lastname, Gender, phonenumber, address, role, img;
    double salary;
    int yearofbirth;

    public staffDTO(){
        
    }

    public staffDTO(String staffID, String firstname, String lastname, String Gender, String phonenumber, String address, double salary, String role, int yearofbirth, String img) {
        this.staffID = staffID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.Gender = Gender;
        this.phonenumber = phonenumber;
        this.address = address;
        this.salary = salary;
        this.role = role;
        this.yearofbirth = yearofbirth;
        this.img = img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getRole() {
        return role;
    }

    public int getYearofbirth() {
        return yearofbirth;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setYearofbirth(int yearofbirth) {
        this.yearofbirth = yearofbirth;
    }
    
    
    
}
