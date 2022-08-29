package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String fullName;
    private String groupNumber;
    private Date dateOfReceipt;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Date getDateOfRreceipt() {
        return dateOfReceipt;
    }

    public void setDateOfRreceipt(Date dateOfRreceipt) {
        this.dateOfReceipt = dateOfRreceipt;
    }
}
