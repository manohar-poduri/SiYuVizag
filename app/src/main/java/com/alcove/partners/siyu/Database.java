package com.alcove.partners.siyu;

public class Database {

    private String Name, Phone, Email, Feedback,FeedbackName;
    private String ContactName, ContactPhone, ContactEmail, ContactMessage;

    public Database() {
    }


    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactPhone() {
        return ContactPhone;
    }

    public void setContactPhone(String contactPhone) {
        ContactPhone = contactPhone;
    }

    public String getContactEmail() {
        return ContactEmail;
    }

    public void setContactEmail(String contactEmail) {
        ContactEmail = contactEmail;
    }

    public String getContactMessage() {
        return ContactMessage;
    }

    public void setContactMessage(String contactMessage) {
        ContactMessage = contactMessage;
    }

    public String getFeedbackName() {
        return FeedbackName;
    }

    public void setFeedbackName(String feedbackName) {
        FeedbackName = feedbackName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }
}
