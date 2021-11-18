package com.example.dietbalanceapplication.ContactsList;

/**
 * @author Devika Krishnan
 * This class contains all the items to be displayed on the listView
 */
public class Contacts {
    private int contactIcon;
    private String contactMode;
    private String contactDesc;

    /**
     * Constructor for initialising the properties
     * @param contactIcon
     * @param contactMode
     * @param contactDesc
     */
    public Contacts(int contactIcon, String contactMode, String contactDesc) {
        this.contactIcon = contactIcon;
        this.contactMode = contactMode;
        this.contactDesc = contactDesc;
    }

    /**
     * To get ContactIcon
     * @return contactIcon
     */
    public int getContactIcon() {
        return contactIcon;
    }

    /**
     * Set ContactIcon
     * @param contactIcon
     */
    public void setContactIcon(int contactIcon) {
        this.contactIcon = contactIcon;
    }

    /**
     * To get ContactMode
     * @return contactMode
     */
    public String getContactMode() {
        return contactMode;
    }

    /**
     * Set ContactMode
     * @param contactMode
     */
    public void setContactMode(String contactMode) {
        this.contactMode = contactMode;
    }

    /**
     * To get ContactDescription
     * @return contactDesc
     */
    public String getContactDesc() {
        return contactDesc;
    }

    /**
     * Set contactDescription
     * @param contactDesc
     */
    public void setContactDesc(String contactDesc) {
        this.contactDesc = contactDesc;
    }
}
