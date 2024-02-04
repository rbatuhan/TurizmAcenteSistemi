package view;

import business.ReservationManager;
import core.Helper;
import entity.PansionType;
import entity.Reservation;
import entity.Room;

import javax.swing.*;

public class ReservationView extends Layout {
    private JPanel container;
    private JPanel pnl_rsv_hotel;
    private JPanel pnl_rsv_room;
    private JPanel pnl_rsv_reservation;
    private JLabel lbl_rsv_reservation;
    private JLabel lbl_rsv_hotel;
    private JLabel lbl_rsv_hotel_name;
    private JTextField fld_rsv_hotel_name;
    private JLabel lbl_rsv_hotel_city;
    private JTextField fld_rsv_hotel_city;
    private JLabel lbl_rsv_hotel_star;
    private JTextField fld_rsv_hotel_star;
    private JLabel lbl_rsv_hotel_carpar;
    private JTextField fld_rsv_hotel_carpark;
    private JLabel lbl_rsv_hotel_wifi;
    private JTextField fld_rsv_hotel_wifi;
    private JLabel lbl_rsv_hotel_pool;
    private JTextField fld_rsv_hotel_pool;
    private JLabel lbl_rsv_hotel_fitness;
    private JTextField fld_rsv_hotel_fitness;
    private JLabel lbl_rsv_hotel_concierge;
    private JTextField fld_rsv_hotel_concierge;
    private JLabel lbl_rsv_hotel_spa;
    private JTextField fld_rsv_hotel_spa;
    private JLabel lbl_rsv_hotel_room_service;
    private JTextField fld_rsv_hotel_room_service;
    private JLabel lbl_rsv_roomtype;
    private JTextField fld_rsv_roomtype;
    private JLabel lbl_rsv_room_bed;
    private JTextField fld_rsv_room_bed;
    private PansionType pansionType;
    private JLabel lbl_rsv_room_square_meter;
    private JTextField fld_rsv_room_square_meter;
    private JLabel lbl_rsv_strt_date;
    private JTextField fld_rsv_strt_date;
    private JLabel lbl_rsv_fnsh_date;
    private JTextField fld_rsv_fnsh_date;
    private JLabel lbl_rsv_total_prc;
    private JTextField fld_rsv_total_prc;
    private JTextField fld_rsv_room_tv;
    private JLabel lbl_rsv_room_tv;
    private JLabel lbl_rsv_room_minibar;
    private JTextField fld_rsv_room_minibar;
    private JLabel lbl_rsv_room_game_console;
    private JTextField fld_rsv_room_game_console;
    private JLabel lbl_rsv_room_kasa;
    private JTextField fld_rsv_room_kasa;
    private JLabel lbl_rsv_room_projection;
    private JTextField fld_rsv_room_projection;
    private JLabel lbl_rsv_pansiontype;
    private JTextField fld_rsv_total_customer;
    private JLabel lbl_rsv_total_customer;
    private JLabel lbl_rsv_customer_name;
    private JTextField fld_rsv_customer_name;
    private JLabel lbl_rsv_customer_ssn;
    private JTextField fld_rsv_customer_ssn;
    private JLabel lbl_rsv_customer_mail;
    private JTextField fld_rsv_customer_mail;
    private JLabel lbl_rsv_customer_mpno;
    private JTextField fld_rsv_customer_mpno;
    private JButton btn_rsv_save;
    private JLabel lbl_rsv_room;
    private JTextField fld_rsv_pansiontype;
    private Reservation reservation;
    private ReservationManager reservationManager;
    private Room room;
    private int RoomId;
    private int HotelId;

    public ReservationView (Reservation reservation){
        this.reservation = new Reservation();
        this.reservationManager = new ReservationManager();
        this.room = new Room();
        this.add(container);
        guiInitilaze(850,850);


        // Kaydet butonuna tıklanınca olacaklar
        btn_rsv_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{fld_rsv_total_customer, fld_rsv_customer_name, fld_rsv_customer_ssn,
                    fld_rsv_customer_mail, fld_rsv_customer_mpno})){
                Helper.showMsg("fill");
            }
            boolean result;

            // Gerekli alanlardan bilgileri al
            this.reservation.setTotalPeople(Integer.parseInt(this.fld_rsv_total_customer.getText()));
            this.reservation.setCustomerName(this.fld_rsv_customer_name.getText());
            this.reservation.setCustomerSsn(Integer.parseInt(this.fld_rsv_customer_ssn.getText()));
            this.reservation.setCustomerMail(this.fld_rsv_customer_mail.getText());
            this.reservation.setCustomerMpno(Integer.parseInt(this.fld_rsv_customer_mpno.getText()));

        });
    }

}
