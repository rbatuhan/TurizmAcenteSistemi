package view;

import business.*;
import core.*;
import dao.RoomDao;
import entity.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
    private JLabel lbl_rsv_fnsh_date;
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
    private JTextField fld_rsv_strt_date;
    private JTextField fld_rsv_fnsh_date;
    private Reservation reservation;
    private ReservationManager reservationManager;
    private HotelManager hotelManager;
    private RoomManager roomManager;
    private Hotel hotel;
    private  RoomDao roomDao;
    private Room room;
    private int roomId;

    public ReservationView(Reservation reservation, int selectRoom, String strtDate, String fnshDate, int adultCount, int childCount) {
        this.add(container);
        guiInitilaze(900, 900);

        if (reservation == null) {
            this.reservation = new Reservation();
        } else {
            this.reservation = reservation;
        }

        this.reservationManager = new ReservationManager();
        this.roomManager = new RoomManager();
        this.roomDao = new RoomDao();
        this.roomId = selectRoom;
        this.room = roomManager.getByID(roomId);

        // Oteli ve odayı gösteren bilgileri doldurur
        this.fld_rsv_hotel_name.setText(this.room.getHotel().getHotel_name());
        this.fld_rsv_hotel_city.setText(this.room.getHotel().getHotel_city());
        this.fld_rsv_hotel_star.setText(this.room.getHotel().getHotel_star());
        this.fld_rsv_hotel_wifi.setText(this.room.getHotel().getHotel_features_wifi());
        this.fld_rsv_hotel_spa.setText(this.room.getHotel().getHotel_features_spa());
        this.fld_rsv_hotel_fitness.setText(this.room.getHotel().getHotel_features_fitness());
        this.fld_rsv_hotel_pool.setText(this.room.getHotel().getHotel_features_pool());
        this.fld_rsv_hotel_carpark.setText(this.room.getHotel().getHotel_features_carpark());
        this.fld_rsv_hotel_concierge.setText(this.room.getHotel().getHotel_features_concierge());
        this.fld_rsv_hotel_room_service.setText(this.room.getHotel().getHotel_features_room_service());

        this.fld_rsv_pansiontype.setText(this.room.getPansionType().getPansionType());

        this.fld_rsv_roomtype.setText(this.room.getRoom_type());
        this.fld_rsv_room_square_meter.setText(String.valueOf(this.room.getRoom_square_meter()));
        this.fld_rsv_room_projection.setText(String.valueOf(this.room.getRoom_projection()));
        this.fld_rsv_room_tv.setText(String.valueOf(this.room.getRoom_tv()));
        this.fld_rsv_room_game_console.setText(String.valueOf(this.room.getRoom_game_console()));
        this.fld_rsv_room_minibar.setText(String.valueOf(this.room.getRoom_minibar()));
        this.fld_rsv_room_kasa.setText(String.valueOf(this.room.getRoom_kasa()));
        this.fld_rsv_room_bed.setText(String.valueOf(this.room.getRoom_number_bed()));

        // Rezervasyon tarihlerini ve fiyatını hesaplar // 17. Değerlendirme Kriteri
        this.fld_rsv_strt_date.setText(String.valueOf(strtDate));
        this.fld_rsv_fnsh_date.setText(String.valueOf(fnshDate));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate entryDate = LocalDate.parse(strtDate, formatter);
        LocalDate extDate = LocalDate.parse(fnshDate, formatter);

        long days = ChronoUnit.DAYS.between(entryDate, extDate);

        int totalPrice = (int) (days * ((adultCount * room.getRoom_adult_prc()) + (childCount * room.getRoom_child_prc())));

        this.fld_rsv_total_prc.setText(String.valueOf(totalPrice));
        this.fld_rsv_total_customer.setText(String.valueOf(adultCount + childCount));

        // Eğer rezervasyon varsa, rezervasyon bilgilerini doldurur
        if (this.reservation.getId() !=0 ) {
            this.fld_rsv_customer_name.setText(this.reservation.getCustomerName());
            this.fld_rsv_customer_ssn.setText(String.valueOf(this.reservation.getCustomerSsn()));
            this.fld_rsv_customer_mpno.setText(String.valueOf(this.reservation.getCustomerMpno()));
            this.fld_rsv_customer_mail.setText(this.reservation.getCustomerMail());
            this.btn_rsv_save.setText("Rezervasyonu Güncelle");
        }

        // Kaydet butonuna tıklandığında
        btn_rsv_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{this.fld_rsv_customer_name, this.fld_rsv_customer_ssn,
                    this.fld_rsv_customer_mpno, this.fld_rsv_customer_mail})){
                Helper.showMsg("fill");
            } else {
                boolean result;

                // Rezervasyon bilgilerini günceller
                reservation.setCustomerName(fld_rsv_customer_name.getText());
                reservation.setCustomerMail(fld_rsv_customer_mail.getText());
                reservation.setCustomerMpno(Integer.parseInt(fld_rsv_customer_mpno.getText()));
                reservation.setCustomerSsn(Integer.parseInt(fld_rsv_customer_ssn.getText()));
                reservation.setRoom_id(roomId);
                reservation.setTotalPeople(Integer.parseInt(fld_rsv_total_customer.getText()));
                reservation.setTotalPrc(Integer.parseInt(fld_rsv_total_prc.getText()));
                reservation.setStrt_date(entryDate);
                reservation.setFnsh_date(extDate);

                // Eğer rezervasyon varsa günceller, yoksa yeni bir rezervasyon ekler
                if (this.reservation.getId() != 0){
                    result = this.reservationManager.update(this.reservation);
                } else {
                    result = this.reservationManager.save(this.reservation);
                    // 19. Değerlendirme kriteri
                    this.room.setRoom_stock(this.room.getRoom_stock() - 1);
                    this.reservationManager.updateStock(room);
                }
                if (result){
                    Helper.showMsg("done");
                    dispose();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
    }

    // Tarih alanlarını formatlar
    private void createUIComponents() throws ParseException {
        this.fld_rsv_strt_date = new JFormattedTextField(new MaskFormatter("####/##/##"));
        this.fld_rsv_fnsh_date = new JFormattedTextField(new MaskFormatter("####/##/##"));
    }
}

