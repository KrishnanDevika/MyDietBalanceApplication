package com.example.dietbalanceapplication.ContactsList;

public class Contacts {
    private int contactIcon;
    private String contactMode;
    private String contactDesc;

    public Contacts(int contactIcon, String contactMode, String contactDesc) {
        this.contactIcon = contactIcon;
        this.contactMode = contactMode;
        this.contactDesc = contactDesc;
    }

    public int getContactIcon() {
        return contactIcon;
    }

    public void setContactIcon(int contactIcon) {
        this.contactIcon = contactIcon;
    }

    public String getContactMode() {
        return contactMode;
    }

    public void setContactMode(String contactMode) {
        this.contactMode = contactMode;
    }

    public String getContactDesc() {
        return contactDesc;
    }

    public void setContactDesc(String contactDesc) {
        this.contactDesc = contactDesc;
    }
}
