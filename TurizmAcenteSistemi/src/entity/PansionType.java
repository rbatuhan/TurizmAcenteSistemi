package entity;

import core.ComboItem;

public class PansionType {
    private int id;
    private String pansionType;
    private int hotelId;

    public PansionType(int id, String pansionType, int hotelId) {
        this.id = id;
        this.pansionType = pansionType;
        this.hotelId = hotelId;
    }


    public PansionType(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPansionType() {
        return pansionType;
    }

    public void setPansionType(String pansionType) {
        this.pansionType = pansionType;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String toString(){
        return "PansionType{" +
                "id=" + id +
                ", pansionType=" + pansionType + '\'' +
                ", hotelId=" + hotelId + '\'' +
                "}";
    }

    public ComboItem getComboItem(){
        return new ComboItem(this.getId(), this.getPansionType() +" - "+ this.getHotelId());
    }
}
