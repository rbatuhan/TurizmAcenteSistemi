package view;

import business.*;
import core.Helper;
import entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
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
    private JScrollPane scrl_reservation;
    private JTable tbl_reservation;
    private UserManager userManager;
    private HotelManager hotelManager;
    private PansionTypeManager pansionTypeManager;
    private SeasonManager seasonManager;
    private RoomManager roomManager;
    private ReservationManager reservationManager;
    private PansionTypeView pansionTypeView;
    private User user;
    private Object[] col_hotel;
    private Object[] col_pansionType;
    private Object[] col_season;
    private Object[] col_room;
    private Object[] col_reservation;
    private JPopupMenu hotel_menu;
    private JPopupMenu reservation_menu;
    private DefaultTableModel tmdl_hotel = new DefaultTableModel();
    private DefaultTableModel tmdl_pansionType = new DefaultTableModel();
    private DefaultTableModel tmdl_season = new DefaultTableModel();
    private DefaultTableModel tmdl_room = new DefaultTableModel();
    private DefaultTableModel tmdl_reservation = new DefaultTableModel();


    public EmployeeView(User user){
        this.userManager = new UserManager();
        this.hotelManager = new HotelManager();
        this.pansionTypeManager = new PansionTypeManager();
        this.seasonManager = new SeasonManager();
        this.roomManager = new RoomManager();
        this.reservationManager = new ReservationManager();
        this.user = new User();
        this.user = user;
        this.add(container);
        guiInitilaze(1500,1000);

        // Tabloları yükle
        loadHotelTable(null);
        loadHotelComponent();

        loadPansionType(null);
        loadSeason(null);

        loadRoomTable(null);

        loadReservationTable(null);
        loadReservationComponent();

        // Otel ekleme butonuna tıklanınca
        btn_otel_add.addActionListener(e -> {
            HotelView hotelView = new HotelView(null);
            hotelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadHotelTable(null);
                }
            });
        });
        // Çıkış butonuna tıklanınca
        btn_ext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        // Oda ekleme butonuna tıklanınca
        btn_room_add.addActionListener(e -> {
            RoomView roomView = new RoomView(null);
            roomView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadRoomTable(null);
                }
            });
        });
        //aramaları sonrası tabloyu komple geri getiren reset butonu
        btn_reset.addActionListener(e -> loadRoomTable(null));
        // oda filtre arama butonu
        btn_room_search.addActionListener(e -> loadRoomFilter());
    }

    // Otel tablosunu yükleme metodu
    public void loadHotelTable(ArrayList<Object[]> hotelList) {
        // Otel tablosunun sütun başlıklarını tanımlandı
        this.col_hotel = new Object[]{"ID", "Otel Adı", "Otel Yıldızı", "Şehir", "Bölge", "Adres", "Mail", "Telefon No",
        "CarPark", "Wifi", "Havuz", "Fitness", "Concierge", "SPA", "Oda Servisi"};
        if (hotelList == null) {
            hotelList = this.hotelManager.getForTable(this.col_hotel.length, this.hotelManager.findAll());
        }
        // Tabloyu oluştur ve doldur
        createTable(this.tmdl_hotel, this.tbl_hotel, col_hotel, hotelList);
    }

    // Rezervasyon tablosunu yükleme metodu
    public void loadReservationTable(ArrayList<Object[]> reservtionList) {
        // Rezervasyon tablosunun sütun başlıklarını tanımlandı
        this.col_reservation = new Object[]{"ID", "Misafir Adı", "Telefon", "Mail", "Giriş Tarihi", "Çıkış Tarihi",
                "Oda", "Toplam Ücret", "Misafir Sayısı", "Misafir TC"};
        if (reservtionList == null) {
            reservtionList = this.reservationManager.getForTable(this.col_reservation.length, this.reservationManager.findAll());
        }
        // Tabloyu oluştur ve doldur
        createTable(this.tmdl_reservation, this.tbl_reservation, col_reservation, reservtionList);
    }

    // Oda tablosunu yükleme metodu
    private void loadRoomTable(ArrayList<Object[]> roomList){
        // Oda tablosunun sütun başlıklarını tanımlandı
        this.col_room = new Object[] {"ID", "Oda Tipi", "Stok", "Sezon", "Yetişkin Fiyatı", "Çocuk Fiyatı", "Otel",
                "Pansiyon", "MetreKare", "Yatak Sayısı", "TV", "Minibar", "Oyun Konsolu", "Kasa", "Projeksiyon"};
        if (roomList == null) {
            roomList = this.roomManager.getForTable(this.col_room.length, this.roomManager.findAll());
        }
        // Tabloyu oluştur ve doldur
        createTable(this.tmdl_room, this.tbl_room, col_room, roomList);
    }

    // Pansiyon tipi tablosunu yükleme metodu
    public void loadPansionType(ArrayList<Object[]> pansionTypeList) {
        // Pansiyon tipi tablosunun sütun başlıklarını tanımlandı
        this.col_pansionType = new Object[] {"ID", "Pansion Tipi", "Otel ID"};
        if (pansionTypeList == null) {
            pansionTypeList = this.pansionTypeManager.getForTable(this.col_pansionType.length, this.pansionTypeManager.findAll());
        }
        // Tabloyu oluştur ve doldur
        createTable(this.tmdl_pansionType, this.tbl_pansion_type, col_pansionType, pansionTypeList);
    }

    // Sezon tablosunu yükleme metodu
    public void loadSeason(ArrayList<Object[]> seasonList){
        // Sezon tablosunun sütun başlıklarını tanımla
        this.col_season = new Object[] {"ID", "Sezon Başlangıç Tarihi", "Sezon Bitiş Tarihi", "Otel ID"};
        if (seasonList == null) {
            seasonList = this.seasonManager.getForTable(this.col_season.length, this.seasonManager.findAll());
        }
        // Tabloyu oluştur ve doldur
        createTable(this.tmdl_season, this.tbl_season, col_season, seasonList);
    }

    // Otel bileşenlerini yükleme metodu
    private void loadHotelComponent(){
        // Otel tablosunda bir satır seçildiğinde
        tableRowSelect(this.tbl_hotel);
        this.hotel_menu = new JPopupMenu();

        // Pansiyon tipi ekle seçeneği
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

        // Sezon ekle seçeneği
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
        // Otel tablosuna sağ tık menüyü ekle
        this.tbl_hotel.setComponentPopupMenu(hotel_menu);
    }

    // Oda filtreleme işlemini gerçekleştiren metot
    public void loadRoomFilter(){
        // Gerekli filtreleme parametrelerini al
        String hotel_name = this.fld_hotel_name.getText();
        String hotel_city = this.fld_hotel_city.getText();
        String strt_date = this.fld_strt_date.getText();
        String fnsh_date = this.fld_fnsh_date.getText();
        int adult_count = 5;
        int child_count = 5;

        // Oda filtreleme işlemini gerçekleştir ve sonuçları al
        ArrayList<Room> result = this.roomManager.searchForTable(hotel_name, hotel_city,
                strt_date, fnsh_date, adult_count, child_count);
    }

    // Arayüzdeki tarih alanlarını oluşturan metot
    private void createUIComponents() throws ParseException {
        this.fld_strt_date = new JFormattedTextField(new MaskFormatter("####/##/##"));
        this.fld_strt_date.setText(null);
        this.fld_fnsh_date = new JFormattedTextField(new MaskFormatter("####/##/##"));
        this.fld_fnsh_date.setText(null);
    }

    // Rezervasyon bileşenlerini yükleme metodu
    private void loadReservationComponent(){
        // Oda tablosunda bir satır seçildiğinde
        tableRowSelect(this.tbl_room);
        this.reservation_menu = new JPopupMenu();

        // Yeni rezervasyon ekle seçeneği
        this.reservation_menu.add("Yeni").addActionListener(e -> {
            ReservationView reservationView = new ReservationView(new Reservation());
            reservationView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadReservationTable(null);
                }
            });
        });
        // Oda tablosuna sağ tık menüyü ekle
        this.tbl_room.setComponentPopupMenu(reservation_menu);
    }
}
