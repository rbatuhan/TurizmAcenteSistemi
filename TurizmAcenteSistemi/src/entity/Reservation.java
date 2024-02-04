package entity;

import core.ComboItem;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private int room_id;
    private LocalDate strt_date;
    private LocalDate fnsh_date;
    private int totalPrc;
    private int totalPeople;
    private String customerName;
    private String customerMail;
    private int customerMpno;
    private int customerSsn;


    public Reservation(int id, int room_id, LocalDate strt_date, LocalDate fnsh_date, int totalPrc, int totalPeople,
                       String customerName, String customerMail, int customerMpno, int customerSsn) {
        this.id = id;
        this.room_id = room_id;
        this.strt_date = strt_date;
        this.fnsh_date = fnsh_date;
        this.totalPrc = totalPrc;
        this.totalPeople = totalPeople;
        this.customerName = customerName;
        this.customerMail = customerMail;
        this.customerMpno = customerMpno;
        this.customerSsn = customerSsn;
    }

    public Reservation(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
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

    public int getTotalPrc() {
        return totalPrc;
    }

    public void setTotalPrc(int totalPrc) {
        this.totalPrc = totalPrc;
    }

    public int getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(int totalPeople) {
        this.totalPeople = totalPeople;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public int getCustomerMpno() {
        return customerMpno;
    }

    public void setCustomerMpno(int customerMpno) {
        this.customerMpno = customerMpno;
    }

    public int getCustomerSsn() {
        return customerSsn;
    }

    public void setCustomerSsn(int customerSsn) {
        this.customerSsn = customerSsn;
    }

    public String toString() {
        return "Season{" +
                "id=" + id +
                ", room_id =" + room_id + '\'' +
                ", rsv-strt_date =" + strt_date + '\'' +
                ", rsv_fnsh_date=" + fnsh_date + '\'' +
                ", rsv_price=" + totalPrc + '\'' +
                ", rsv_total_customer=" + totalPeople + '\'' +
                ", rsv_name=" + customerName + '\'' +
                ", rsv_mail=" + customerMail + '\'' +
                ", rsv_mpno=" + customerMpno +  '\'' +
                ", rsv_customer_ssn=" + customerSsn +  '\'' +
                "}";
    }

    public ComboItem getComboItem() {
        return new ComboItem(this.getId(), this.room_id + " - " + this.getStrt_date() + " - " +
                this.getFnsh_date() + " - " + this.getTotalPrc() + " - " + this.getTotalPeople() + " - " +
                this.getCustomerName() + " - " + this.getCustomerMail() + " - " + this.getCustomerMpno() + " - " +
                this.getCustomerSsn());
    }
}
