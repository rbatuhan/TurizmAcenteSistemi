package entity;

import core.ComboItem;

public class Hotel {
    private int id;
    private String hotel_name;
    private String hotel_star;
    private String hotel_city;
    private String hotel_region;
    private String hotel_address;
    private String hotel_mail;
    private String hotel_mpno;
    private String hotel_features_carpark;
    private String hotel_features_wifi;
    private String hotel_features_pool;
    private String hotel_features_fitness;
    private String hotel_features_concierge;
    private String hotel_features_spa;
    private String hotel_features_room_service;

    public Hotel(int id, String hotel_name, String hotel_star, String hotel_city, String hotel_region,
                 String hotel_address, String hotel_mail, String hotel_mpno, String hotel_feature_carpark,
                 String hotel_feature_wifi, String hotel_feature_pool, String hotel_feature_fitness,
                 String hotel_feature_concierge, String hotel_feature_spa, String hotel_feature_room_service) {
        this.id = id;
        this.hotel_name = hotel_name;
        this.hotel_star = hotel_star;
        this.hotel_city = hotel_city;
        this.hotel_region = hotel_region;
        this.hotel_address = hotel_address;
        this.hotel_mail = hotel_mail;
        this.hotel_mpno = hotel_mpno;
        this.hotel_features_carpark = hotel_feature_carpark;
        this.hotel_features_wifi = hotel_feature_wifi;
        this.hotel_features_pool = hotel_feature_pool;
        this.hotel_features_fitness = hotel_feature_fitness;
        this.hotel_features_concierge = hotel_feature_concierge;
        this.hotel_features_spa = hotel_feature_spa;
        this.hotel_features_room_service = hotel_feature_room_service;
    }

    public Hotel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_star() {
        return hotel_star;
    }

    public void setHotel_star(String hotel_star) {
        this.hotel_star = hotel_star;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public String getHotel_region() {
        return hotel_region;
    }

    public void setHotel_region(String hotel_region) {
        this.hotel_region = hotel_region;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_mail() {
        return hotel_mail;
    }

    public void setHotel_mail(String hotel_mail) {
        this.hotel_mail = hotel_mail;
    }

    public String getHotel_mpno() {
        return hotel_mpno;
    }

    public void setHotel_mpno(String hotel_mpno) {
        this.hotel_mpno = hotel_mpno;
    }

    public String getHotel_features_carpark() {
        return hotel_features_carpark;
    }

    public void setHotel_features_carpark(String hotel_features_carpark) {
        this.hotel_features_carpark = hotel_features_carpark;
    }

    public String getHotel_features_wifi() {
        return hotel_features_wifi;
    }

    public void setHotel_features_wifi(String hotel_features_wifi) {
        this.hotel_features_wifi = hotel_features_wifi;
    }

    public String getHotel_features_pool() {
        return hotel_features_pool;
    }

    public void setHotel_features_pool(String hotel_features_pool) {
        this.hotel_features_pool = hotel_features_pool;
    }

    public String getHotel_features_fitness() {
        return hotel_features_fitness;
    }

    public void setHotel_features_fitness(String hotel_features_fitness) {
        this.hotel_features_fitness = hotel_features_fitness;
    }

    public String getHotel_features_concierge() {
        return hotel_features_concierge;
    }

    public void setHotel_features_concierge(String hotel_features_concierge) {
        this.hotel_features_concierge = hotel_features_concierge;
    }

    public String getHotel_features_spa() {
        return hotel_features_spa;
    }

    public void setHotel_features_spa(String hotel_features_spa) {
        this.hotel_features_spa = hotel_features_spa;
    }

    public String getHotel_features_room_service() {
        return hotel_features_room_service;
    }

    public void setHotel_features_room_service(String hotel_features_room_service) {
        this.hotel_features_room_service = hotel_features_room_service;
    }

    public String toString(){
        return "Hotel{" +
                "id=" + id +
                ", hotel_name=" + hotel_name + '\'' +
                ", hotel_star=" + hotel_star + '\'' +
                ", hotel_city=" + hotel_city + '\'' +
                ", hotel_region=" + hotel_region + '\'' +
                ", hotel_address=" + hotel_address + '\'' +
                ", hotel_mail=" + hotel_mail + '\'' +
                ", hotel_mpno=" + hotel_mpno + '\'' +
                ", hotel_carpark=" + hotel_features_carpark + '\'' +
                ", hotel_wifi=" + hotel_features_wifi + '\'' +
                ", hotel_pool=" + hotel_features_pool + '\'' +
                ", hotel_fitness=" + hotel_features_fitness + '\'' +
                ", hotel_concierge=" + hotel_features_concierge + '\'' +
                ", hotel_spa=" + hotel_features_spa +  '\'' +
                ", hotel_room_service=" + hotel_features_room_service + '\'' +
                "}";
    }

    public ComboItem getComboItem(){
        return new ComboItem(this.getId(), this.getHotel_name() +" - "+ this.hotel_star +" - "+ this.hotel_city +" - "+
                this.hotel_region +" - "+ this.hotel_address +" - "+ this.hotel_mail +" - "+ this.hotel_mail +" - "+
                this.hotel_mpno +" - "+ this.hotel_features_carpark +" - "+ this.hotel_features_wifi +" - "+
                this.hotel_features_pool +" - "+ this.hotel_features_fitness +" - "+ this.hotel_features_concierge +" - "+
                this.hotel_features_spa +" - "+ this.hotel_features_room_service);
    }

    public ComboItem getComboItemRoom(){
        return new ComboItem(this.getId(), this.getHotel_name());
    }

}



