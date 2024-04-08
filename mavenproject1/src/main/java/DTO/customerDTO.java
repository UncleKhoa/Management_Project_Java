package DTO;

public class customerDTO {
    private String cusID, firstName, lastName, gender, phoneNumber, gmail, address;
    
    public customerDTO() {
        
    }
    
    public customerDTO(String cusID, String firstName, String lastName, String gender, String phoneNumber, String gmail, String address) {
        this.cusID = cusID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.gmail = gmail;
        this.address = address;
    }
    
    public String getCusID() {
        return cusID;
    }
    
    public void setCusID(String cusID) {
        this.cusID = cusID;
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
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getGmail() {
        return gmail;
    }
    
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}