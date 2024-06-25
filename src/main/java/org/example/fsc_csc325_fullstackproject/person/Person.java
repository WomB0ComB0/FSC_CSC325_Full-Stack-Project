package org.example.fsc_csc325_fullstackproject.person;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty department;
    private final StringProperty major;
    private final StringProperty email;
    private final StringProperty imageURL;

    public Person(String firstName, String lastName, String department, String major, String email, String imageURL) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.department = new SimpleStringProperty(department);
        this.major = new SimpleStringProperty(major);
        this.email = new SimpleStringProperty(email);
        this.imageURL = new SimpleStringProperty(imageURL);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public StringProperty majorProperty() {
        return major;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty imageURLProperty() {
        return imageURL;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public String getMajor() {
        return major.get();
    }

    public void setMajor(String major) {
        this.major.set(major);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getImageURL() {
        return imageURL.get();
    }

    public void setImageURL(String imageURL) {
        this.imageURL.set(imageURL);
    }
}
