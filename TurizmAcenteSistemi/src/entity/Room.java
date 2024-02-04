package entity;

import core.ComboItem;

public class Room {
    private int id;
    private String room_type;
    private int room_stock;
    private int season_id;
    private int room_adult_prc;
    private int room_child_prc;
    private int hotel_id;
    private int pansion_id;
    private int room_square_meter;
    private int room_number_bed;
    private String room_tv;
    private String room_minibar;
    private String room_game_console;
    private String room_kasa;
    private String room_projection;

    public Room(int id, String room_type, int room_stock, int season_id, int room_adult_prc, int room_child_prc,
                int hotel_id, int pansion_id, int room_square_meter, int room_number_bed, String room_tv,
                String room_minibar, String room_game_console, String room_kasa, String room_projection) {
        this.id = id;
        this.room_type = room_type;
        this.room_stock = room_stock;
        this.season_id = season_id;
        this.room_adult_prc = room_adult_prc;
        this.room_child_prc = room_child_prc;
        this.hotel_id = hotel_id;
        this.pansion_id = pansion_id;
        this.room_square_meter = room_square_meter;
        this.room_number_bed = room_number_bed;
        this.room_tv = room_tv;
        this.room_minibar = room_minibar;
        this.room_game_console = room_game_console;
        this.room_kasa = room_kasa;
        this.room_projection = room_projection;
    }

    public Room(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getRoom_stock() {
        return room_stock;
    }

    public void setRoom_stock(int room_stock) {
        this.room_stock = room_stock;
    }

    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public int getRoom_adult_prc() {
        return room_adult_prc;
    }

    public void setRoom_adult_prc(int room_adult_prc) {
        this.room_adult_prc = room_adult_prc;
    }

    public int getRoom_child_prc() {
        return room_child_prc;
    }

    public void setRoom_child_prc(int room_child_prc) {
        this.room_child_prc = room_child_prc;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getPansion_id() {
        return pansion_id;
    }

    public void setPansion_id(int pansion_id) {
        this.pansion_id = pansion_id;
    }

    public int getRoom_square_meter() {
        return room_square_meter;
    }

    public void setRoom_square_meter(int room_square_meter) {
        this.room_square_meter = room_square_meter;
    }

    public int getRoom_number_bed() {
        return room_number_bed;
    }

    public void setRoom_number_bed(int room_number_bed) {
        this.room_number_bed = room_number_bed;
    }

    public String getRoom_tv() {
        return room_tv;
    }

    public void setRoom_tv(String room_tv) {
        this.room_tv = room_tv;
    }

    public String getRoom_minibar() {
        return room_minibar;
    }

    public void setRoom_minibar(String room_minibar) {
        this.room_minibar = room_minibar;
    }

    public String getRoom_game_console() {
        return room_game_console;
    }

    public void setRoom_game_console(String room_game_console) {
        this.room_game_console = room_game_console;
    }

    public String getRoom_kasa() {
        return room_kasa;
    }

    public void setRoom_kasa(String room_kasa) {
        this.room_kasa = room_kasa;
    }

    public String getRoom_projection() {
        return room_projection;
    }

    public void setRoom_projection(String room_projection) {
        this.room_projection = room_projection;
    }

    public String toString(){
        return "Room{" +
                "id=" + id +
                ", room_type=" + room_type + '\'' +
                ", room_stock=" + room_stock + '\'' +
                ", season_id=" + season_id + '\'' +
                ", room_adult_prc=" + room_adult_prc + '\'' +
                ", room_child_prc=" + room_child_prc + '\'' +
                ", hotel_id=" + hotel_id + '\'' +
                ", pansion_id=" + pansion_id + '\'' +
                ", room_number_bed=" + room_number_bed + '\'' +
                ", room_square_meter=" + room_square_meter + '\'' +
                ", room_tv=" + room_tv + '\'' +
                ", room_minibar=" + room_minibar + '\'' +
                ", room_game_console=" + room_game_console + '\'' +
                ", room_kasa=" + room_kasa + '\'' +
                ", room_projection=" + room_projection + '\'' +
                "}";
    }

    public ComboItem getComboItem(){
        return new ComboItem(this.getId(), this.getRoom_type() +" - "+ this.getRoom_stock() +" - "+
                this.getSeason_id() +" - "+ this.getRoom_adult_prc() +" - "+ this.getRoom_child_prc() +" - "+
                this.getHotel_id() +" - "+ this.getPansion_id() +" - "+ this.getRoom_number_bed() +" - "+
                this.getRoom_square_meter() +" - "+ this.getRoom_tv() +" - "+ this.getRoom_minibar() +" - "+
                this.getRoom_game_console() +" - "+ this.getRoom_kasa() +" - "+ this.getRoom_projection());
    }
}