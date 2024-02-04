package entity;

import core.ComboItem;

import java.time.LocalDate;

public class Season {
    private int id;
    private LocalDate strt_date;
    private LocalDate fnsh_date;
    private int hotel_id;

    public Season(int id, LocalDate strt_date, LocalDate fnsh_date, int hotel_id) {
        this.id = id;
        this.strt_date = strt_date;
        this.fnsh_date = fnsh_date;
        this.hotel_id = hotel_id;
    }

    public Season(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getStrt_date() {
        return strt_date;
    }

    public void setStrt_date(LocalDate strt_date) {
        this.strt_date = strt_date;
    }

    public LocalDate getFnsh_date() {
        return fnsh_date;
    }

    public void setFnsh_date(LocalDate fnsh_date) {
        this.fnsh_date = fnsh_date;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String toString(){
        return "Season{" +
                "id=" + id +
                ", season_strt_date=" + strt_date +
                ", season_fnsh_date=" + fnsh_date +
                ", hotel_id=" + hotel_id +
                "}";
    }

    public ComboItem getComboItemSeason(){
        return new ComboItem(this.getId(), this.getStrt_date().toString());
    }
}
