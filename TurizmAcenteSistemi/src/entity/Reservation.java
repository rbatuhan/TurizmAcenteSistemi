package entity;

import core.ComboItem;

public class Reservation {
    private int id;
    private String seasonName;
    private String strt_date;
    private String fnsh_date;
    private int hotelId;

    public Reservation(int id, String seasonName, String strt_date, String fnsh_Date, int hotelId) {
        this.id = id;
        this.seasonName = seasonName;
        this.strt_date = strt_date;
        this.fnsh_date = fnsh_Date;
        this.hotelId = hotelId;
    }

    public Reservation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getStrt_date() {
        return strt_date;
    }

    public void setStrt_date(String strt_date) {
        this.strt_date = strt_date;
    }

    public String getFnsh_date() {
        return fnsh_date;
    }

    public void setFnsh_date(String fnsh_date) {
        this.fnsh_date = fnsh_date;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String toString() {
        return "Season{" +
                "id=" + id +
                ", season_name =" + seasonName + '\'' +
                ", season_strt_date=" + strt_date + '\'' +
                ", season_fnsh_date=" + fnsh_date + '\'' +
                ", hotel_id" + hotelId + '\'' +
                "}";
    }

    public ComboItem getComboItem(){
        return new ComboItem(this.getId(), this.getSeasonName() +" - "+ this.getStrt_date() +" - "+
                this.getFnsh_date() +" - "+ this.hotelId);
    }
}
