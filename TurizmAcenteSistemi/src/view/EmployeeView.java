package view;

import business.*;
import entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class EmployeeView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JTabbedPane tabbedPane1;
    private JPanel pnl_hotel;
    private JPanel pnl_room;
    private JPanel pnl_rsv;
    private JTable tbl_hotel;
    private JScrollPane scrl_hotel;
    private JPanel pnl_pansion;
    private JPanel pnl_season;
    private JScrollPane scrl_pansion;
    private JScrollPane scrl_season;
    private JTable tbl_pansion_type;
    private JTable tbl_season;
    private JScrollPane scrl_room;
    private JTable tbl_room;
    private JButton btn_otel_add;
    private JPanel pnl_add_btn;
    private JButton btn_ext;
    private JPanel pnl_up;
    private JPanel pnl_top;
    private JTextField fld_hotel_name;
    private JTextField fld_hotel_city;
    private JFormattedTextField fld_strt_date;
    private JFormattedTextField fld_fnsh_date;
    private JTextField fld_adult_count;
    private JLabel lbl_hotel_name;
    private JLabel lbl_hotel_city;
    private JLabel lbl_strt_date;
    private JLabel lbl_fnsh_date;
    private JLabel lbl_adult_count;
    private JTextField fld_child_count;
    private JLabel lbl_child_count;
    private JButton btn_room_search;
    private JButton btn_room_add;
    private JButton btn_reset;
    private UserManager userManager;
    private HotelManager hotelManager;
    private PansionTypeManager pansionTypeManager;
    private SeasonManager seasonManager;
    private RoomManager roomManager;
    private PansionTypeView pansionTypeView;
    private User user;
    private Object[] col_hotel;
    private Object[] col_pansionType;
    private Object[] col_season;
    private Object[] col_room;
    private JPopupMenu hotel_menu;
    private DefaultTableModel tmdl_hotel = new DefaultTableModel();
    private DefaultTableModel tmdl_pansionType = new DefaultTableModel();
    private DefaultTableModel tmdl_season = new DefaultTableModel();
    private DefaultTableModel tmdl_room = new DefaultTableModel();


    public EmployeeView(User user){
        this.userManager = new UserManager();
        this.hotelManager = new HotelManager();
        this.pansionTypeManager = new PansionTypeManager();
        this.seasonManager = new SeasonManager();
        this.roomManager = new RoomManager();
        this.user = new User();
        this.user = user;
        this.add(container);
        guiInitilaze(1500,1000);

        loadHotelTable(null);

        loadPansionType(null);
        loadHotelComponent();
        loadSeason(null);
        loadRoomTable(null);



        btn_otel_add.addActionListener(e -> {
            HotelView hotelView = new HotelView(null);
            hotelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadHotelTable(null);
                }
            });
        });

        btn_ext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btn_room_add.addActionListener(e -> {
            RoomView roomView = new RoomView(null);
            roomView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadRoomTable(null);
                }
            });
        });
    }


    public void loadHotelTable(ArrayList<Object[]> hotelList) {
        this.col_hotel = new Object[]{"ID", "Otel Adı", "Otel Yıldızı", "Şehir", "Bölge", "Adres", "Mail", "Telefon No",
        "CarPark", "Wifi", "Havuz", "Fitness", "Concierge", "SPA", "Oda Servisi"};
        if (hotelList == null) {
            hotelList = this.hotelManager.getForTable(this.col_hotel.length, this.hotelManager.findAll());
        }
        createTable(this.tmdl_hotel, this.tbl_hotel, col_hotel, hotelList);
    }

    private void loadRoomTable(ArrayList<Object[]> roomList){
        this.col_room = new Object[] {"ID", "Oda Tipi", "Stok", "Sezon", "Yetişkin Fiyatı", "Çocuk Fiyatı", "Otel",
                "Pansiyon", "MetreKare", "Yatak Sayısı", "TV", "Minibar", "Oyun Konsolu", "Kasa", "Projeksiyon"};
        if (roomList == null) {
            roomList = this.roomManager.getForTable(this.col_room.length, this.roomManager.findAll());
        }
        createTable(this.tmdl_room, this.tbl_room, col_room, roomList);
    }

    public void loadPansionType(ArrayList<Object[]> pansionTypeList) {
        this.col_pansionType = new Object[] {"ID", "Pansion Tipi", "Otel ID"};
        if (pansionTypeList == null) {
            pansionTypeList = this.pansionTypeManager.getForTable(this.col_pansionType.length, this.pansionTypeManager.findAll());
        }
        createTable(this.tmdl_pansionType, this.tbl_pansion_type, col_pansionType, pansionTypeList);
    }

    public void loadSeason(ArrayList<Object[]> seasonList){
        this.col_season = new Object[] {"ID", "Sezon Başlangıç Tarihi", "Sezon Bitiş Tarihi", "Otel ID"};
        if (seasonList == null) {
            seasonList = this.seasonManager.getForTable(this.col_season.length, this.seasonManager.findAll());
        }
        createTable(this.tmdl_season, this.tbl_season, col_season, seasonList);
    }

    private void loadHotelComponent(){
        tableRowSelect(this.tbl_hotel);
        this.hotel_menu = new JPopupMenu();
        this.hotel_menu.add("Pansion Tipi Ekle").addActionListener(e -> {
            int selectedUserId = this.getTableSelectedRow(tbl_hotel, 0);
            PansionTypeView pansionTypeView = new PansionTypeView(selectedUserId);
            pansionTypeView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPansionType(null);
                }
            });
        });
        this.hotel_menu.add("Sezon Ekle").addActionListener(e -> {
            int selectedUserId = this.getTableSelectedRow(tbl_hotel, 0);
            SeasonView seasonView = new SeasonView(selectedUserId);
            seasonView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                loadSeason(null);

                }
            });
        });
        this.tbl_hotel.setComponentPopupMenu(hotel_menu);
    }
}
