package view;

import core.Helper;
import entity.*;
import business.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SeasonView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JFormattedTextField fld_strt_date;
    private JFormattedTextField fld_fnsh_date;
    private JButton btn_season_save;
    private JLabel lbl_hotel_id;
    private JLabel lbl_strt_date;
    private JLabel lbl_fnsh_date;
    private JTextField fld_hotel_id;
    private Season season;
    private Hotel hotel;
    private SeasonManager seasonManager;
    private int hotelId;



    public SeasonView (int hotelId ){
        this.season = new Season();
        this.seasonManager = new SeasonManager();
        this.hotelId = hotelId;
        this.hotel = new Hotel();

        this.add(container);
        guiInitilaze(400,400);

        // Otel ID'sini yazar
        lbl_hotel_id.setText("Otel ID : " + hotelId);

        // Sezonu kaydet butonuna tıklandığında gerçekleşecek olayları tanımlayan kod bloğu
        btn_season_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{fld_strt_date, fld_fnsh_date})){
                Helper.showMsg("fill");
            }else {
                boolean result = true;

                // Sezon nesnesinin başlangıç ve bitiş tarihlerini ve otel ID'sini günceller
                this.season.setStrt_date(LocalDate.parse( fld_strt_date.getText(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                this.season.setFnsh_date(LocalDate.parse( fld_fnsh_date.getText(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                this.season.setHotel_id(Integer.parseInt(String.valueOf(this.hotelId)));

            }
            // Sezonu kaydedip sonucu değerlendirir
            if (this.seasonManager.save(season)){
                Helper.showMsg("done");
                dispose();
            } else {
                Helper.showMsg("error");
            }


        });
    }
    private void createUIComponents() throws ParseException {
        // Maske biçimine sahip başlangıç tarih ve bitiş tarih alanını oluşturur ve varsayılan bir tarihle doldurur
        this.fld_strt_date = new JFormattedTextField(new MaskFormatter("####/##/##"));
        this.fld_strt_date.setText("2024/01/01");
        this.fld_fnsh_date = new JFormattedTextField(new MaskFormatter("####/##/##"));
        this.fld_fnsh_date.setText("2030/12/12");
    }
}
