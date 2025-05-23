package models;

import java.sql.Date;

public class Driver {
    private String driverId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String address;
    private String phone;
    private String email;

    public Driver() {}

    public Driver(String driverId, String firstName, String lastName, Date birthDate,
                  String address, String phone, String email) {
        setDriverId(driverId);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
    }

    public String getDriverId() {
        return driverId; }

    public void setDriverId(String driverId) {
        this.driverId = driverId; }

    public String getFirstName() {
        return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName; }

    public String getLastName() {
        return lastName; }

    public void setLastName(String lastName) {
        this.lastName = lastName; }

    public Date getBirthDate() {
        return birthDate; }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate; }

    public String getAddress() {
        return address; }

    public void setAddress(String address) {
        this.address = address; }

    public String getPhone() {
        return phone; }

    public void setPhone(String phone) {
        this.phone = phone; }

    public String getEmail() {
        return email; }

    public void setEmail(String email) {
        this.email = email; }
}
