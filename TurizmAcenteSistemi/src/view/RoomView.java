package view;

import business.*;
import core.ComboItem;
import core.Helper;
import dao.HotelDao;
import entity.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RoomView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_room_left;
    private JPanel pnl_room_right;
    private JComboBox cmb_hotel;
    private JLabel lbl_hotel;
    private JComboBox cmb_pansion;
    private JComboBox cmb_season;
    private JComboBox cmb_room_type;
    private JLabel lbl_pansion;
    private JLabel lbl_season;
    private JLabel lbl_room_type;
    private JTextField fld_room_stock;
    private JTextField fld_room_adult_prc;
    private JLabel lbl_room_stock;
    private JLabel lbl_room_adult_prc;
    private JLabel lbl_room_child_prc;
    private JTextField fld_room_child_prc;
    private JTextField fld_room_number_bed;
    private JLabel lbl_room_number_bed;
    private JTextField fld_room_square_meter;
    private JLabel lbl_room_square_meter;
    private JComboBox cmb_room_tv;
    private JComboBox cmb_room_minibar;
    private JComboBox cmb_room_game_console;
    private JLabel lbl_room_tv;
    private JLabel lbl_room_minibar;
    private JLabel lbl_room_game_console;
    private JComboBox cmb_room_kasa;
    private JComboBox cmb_room_projection;
    private JLabel lbl_room_kasa;
    private JLabel lbl_room_projection;
    private JButton btn_room_save;

    private RoomManager roomManager;
    private HotelManager hotelManager;
    private PansionTypeManager pansionTypeManager;
    private SeasonManager seasonManager;
    private Room room;
    private Hotel hotel;
    private PansionType pansionType;
    private Season season;
    private HotelDao hotelDao;

    public RoomView(Room room) {
        this.room = new Room();
        this.hotelManager = new HotelManager();
        this.roomManager = new RoomManager();
        this.pansionTypeManager = new PansionTypeManager();
        this.seasonManager = new SeasonManager();
        this.hotel = new Hotel();
        this.pansionType = new PansionType();
        this.season = new Season();
        this.hotelDao = new HotelDao();
        this.add(container);
        guiInitilaze(650, 650);


        loadHotelFilter();
        loadPansionFilter();
        loadSeasonFilter();

        btn_room_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{this.fld_room_adult_prc, this.fld_room_child_prc, this.fld_room_stock,
                    this.fld_room_number_bed, this.fld_room_square_meter})) {
                Helper.showMsg("fill");
            } else {
                boolean result;

                String selectHotel = this.cmb_hotel.getSelectedItem().toString();
                String selectHotelName = this.cmb_hotel.getSelectedItem().toString();
                String selectPansion =  this.cmb_pansion.getSelectedItem().toString();
                String selectSeason =  this.cmb_season.getSelectedItem().toString();
                String selectRoomType = this.cmb_room_type.getSelectedItem().toString();
                String selectRoomTv = this.cmb_room_tv.getSelectedItem().toString();
                String selectRoomMinibar = this.cmb_room_minibar.getSelectedItem().toString();
                String selectRoomGameConsole = this.cmb_room_game_console.getSelectedItem().toString();
                String selectRoomKasa = this.cmb_room_kasa.getSelectedItem().toString();
                String selectRoomProjection = this.cmb_room_projection.getSelectedItem().toString();

                this.room.setHotel_id(Integer.parseInt(selectHotel));
                this.room.setPansion_id(pansionType.getId());
                this.room.setSeason_id(season.getId());
                this.room.setRoom_type(selectRoomType);
                this.room.setRoom_stock(Integer.parseInt(fld_room_stock.getText()));
                this.room.setRoom_adult_prc(Integer.parseInt(fld_room_adult_prc.getText()));
                this.room.setRoom_child_prc(Integer.parseInt(fld_room_child_prc.getText()));
                this.room.setRoom_number_bed(Integer.parseInt(fld_room_number_bed.getText()));
                this.room.setRoom_square_meter(Integer.parseInt(fld_room_square_meter.getText()));
                this.room.setRoom_tv(selectRoomTv);
                this.room.setRoom_minibar(selectRoomMinibar);
                this.room.setRoom_game_console(selectRoomGameConsole);
                this.room.setRoom_kasa(selectRoomKasa);
                this.room.setRoom_projection(selectRoomProjection);

                result = this.roomManager.save(this.room);
                if (result) {
                    Helper.showMsg("done");
                    dispose();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
    }

    public void loadHotelFilter() {
        this.cmb_hotel.removeAllItems();
        for (Hotel obj : hotelManager.findAll()) {
            this.cmb_hotel.addItem(new ComboItem(obj.getId(), obj.getHotel_name()));
        }

        this.cmb_hotel.setSelectedItem(null);
    }

    public void loadPansionFilter() {
        this.cmb_pansion.removeAllItems();
        for (PansionType obj : pansionTypeManager.findAll()) {
            this.cmb_pansion.addItem(new ComboItem(obj.getHotelId(), obj.getPansionType()));
        }
        this.cmb_pansion.setSelectedItem(null);
    }

    public void loadSeasonFilter() {
        this.cmb_season.removeAllItems();
        for (Season obj : seasonManager.findAll()) {
            this.cmb_season.addItem(new ComboItem(obj.getHotel_id(), obj.getStrt_date().toString() + " / " + obj.getFnsh_date().toString()));
        }
        this.cmb_season.setSelectedItem(null);
    }
}
