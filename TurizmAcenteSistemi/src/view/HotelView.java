package view;

import business.*;
import core.*;
import entity.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelView extends Layout {
    private JPanel container;
    private JPanel pnl_hotel_menu;
    private JPanel pnl_hotel;
    private JPanel pnl_hotel_features;
    private JPanel pnl_welcome;
    private JPanel pnl_hotel_save;
    private JLabel lbl_welcome;
    private JButton btn_hotel_save;
    private JTextField fld_hotel_name;

    private JLabel lbl_hotel_name;
    private JLabel lbl_hotel_features_carpark;

    private JLabel lbl_hotel_star;
    private JLabel lbl_hotel_features_wifi;

    private JTextField fld_hotel_city;
    private JLabel lbl_hotel_city;
    private JLabel lbl_hotel_features_pool;

    private JTextField fld_hotel_region;
    private JLabel lbl_hotel_region;
    private JLabel lbl_hotel_features_fitness;

    private JTextField fld_hotel_address;
    private JLabel lbl_hotel_address;
    private JLabel lbl_hotel_features_concierge;

    private JTextField fld_hotel_mail;
    private JLabel lbl_hotel_mail;
    private JLabel lbl_hotel_features_spa;
    private JComboBox cmb_hotel_features_room_service;
    private JComboBox cmb_hotel_features_spa;
    private JComboBox cmb_hotel_features_concierge;
    private JComboBox cmb_hotel_features_fitness;
    private JComboBox cmb_hotel_features_pool;
    private JComboBox cmb_hotel_star;
    private JComboBox cmb_hotel_features_wifi;
    private JComboBox cmb_hotel_features_carpark;
    private JTextField fld_hotel_mpno;
    private JLabel lbl_hotel_mpno;
    private JLabel lbl_hotel_features_room_service;
    private HotelManager hotelManager;
    private Hotel hotel;

    public HotelView(Hotel hotel) {
        this.hotelManager = new HotelManager();
        this.hotel = new Hotel();
        this.add(container);
        guiInitilaze(600, 500);

        // Otel bilgileri varsa, alanları doldur
        if (this.hotel.getId() != 0){
            ComboItem selectItem = hotel.getComboItem();
            this.cmb_hotel_star.getModel().setSelectedItem(selectItem);
            this.fld_hotel_name.setText(hotel.getHotel_name());
            this.fld_hotel_city.setText(hotel.getHotel_city());
            this.fld_hotel_region.setText(hotel.getHotel_region());
            this.fld_hotel_address.setText(hotel.getHotel_address());
            this.fld_hotel_mail.setText(hotel.getHotel_mail());
            this.fld_hotel_mpno.setText(hotel.getHotel_mpno());

        }

        // Kaydet butonuna basıldığında çalışacak metot
        btn_hotel_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{fld_hotel_name, fld_hotel_city, fld_hotel_region, fld_hotel_address,
                    fld_hotel_mail, fld_hotel_mpno})) {
                Helper.showMsg("fill");
            } else {
                boolean result;

                // Seçilen özelliklerin değerleri
                String selectedStar = this.cmb_hotel_star.getSelectedItem().toString();
                String selectedCarPark = this.cmb_hotel_features_carpark.getSelectedItem().toString();
                String selectedWifi = this.cmb_hotel_features_wifi.getSelectedItem().toString();
                String selectedPool = this.cmb_hotel_features_pool.getSelectedItem().toString();
                String selectedFitness = this.cmb_hotel_features_fitness.getSelectedItem().toString();
                String selectedConcierge = this.cmb_hotel_features_concierge.getSelectedItem().toString();
                String selectedSpa = this.cmb_hotel_features_spa.getSelectedItem().toString();
                String selectedRoomService = this.cmb_hotel_features_room_service.getSelectedItem().toString();

                // Otel nesnesinin değerlerini set et
                this.hotel.setHotel_name(this.fld_hotel_name.getText());
                this.hotel.setHotel_star(selectedStar);
                this.hotel.setHotel_city(this.fld_hotel_city.getText());
                this.hotel.setHotel_region(this.fld_hotel_region.getText());
                this.hotel.setHotel_address(this.fld_hotel_address.getText());
                this.hotel.setHotel_mail(this.fld_hotel_mail.getText());
                this.hotel.setHotel_mpno(this.fld_hotel_mpno.getText());
                this.hotel.setHotel_features_carpark(selectedCarPark);
                this.hotel.setHotel_features_wifi(selectedWifi);
                this.hotel.setHotel_features_pool(selectedPool);
                this.hotel.setHotel_features_fitness(selectedFitness);
                this.hotel.setHotel_features_concierge(selectedConcierge);
                this.hotel.setHotel_features_spa(selectedSpa);
                this.hotel.setHotel_features_room_service(selectedRoomService);

                // Otel bilgilerini veritabanına kaydet
                result = hotelManager.save(this.hotel);
                if (result){
                    Helper.showMsg("done");
                    dispose();
                }else {
                    Helper.showMsg("error");
                }
            }
        });
    }
}
