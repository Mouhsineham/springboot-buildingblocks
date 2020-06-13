package com.stacksimplify.restservices.hello;


public class personne {

    private  String   name;
    private  String   prenom;
    private  String   phone;
    private  String   address;

    public personne(String name, String prenom, String phone, String address) {
        this.name = name;
        this.prenom = prenom;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "personne{" +
                "name='" + name + '\'' +
                ", prenom='" + prenom + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
