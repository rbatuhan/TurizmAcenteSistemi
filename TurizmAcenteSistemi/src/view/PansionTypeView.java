package view;

import business.*;
import core.ComboItem;
import entity.*;
import core.Helper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PansionTypeView extends Layout {
    private JPanel container;
    private JPanel pbl_pansion_type;
    private JLabel lbl_welcome;
    private JLabel lbl_pansion_type;
    private JComboBox cmb_pansion_type;
    private JLabel lbl_hotel_id;
    private JTextField fld_hotel_id;
    private JButton btn_pansion_type_save;
    private PansionType pansionType;
    private PansionTypeManager pansionTypeManager;
    private HotelView hotelView;
    private Hotel hotel;
    private int hotelId;

    public PansionTypeView(int hotelId) {
        this.pansionType = new PansionType();
        this.pansionTypeManager = new PansionTypeManager();
        this.hotel = new Hotel();
        this.hotelId = hotelId;
        this.add(container);
        guiInitilaze(300, 300);

        // Otel ID'sini yazar
        lbl_hotel_id.setText("Otel ID : " + hotelId);

        // Pansiyon türü kaydet butonuna tıklandığında gerçekleşecek olayları tanımlayan kod bloğu
        btn_pansion_type_save.addActionListener(e -> {
            boolean result = true;
            // Seçilen pansiyon türünü alır
            String selectPansionType = this.cmb_pansion_type.getSelectedItem().toString();

            // PansionType nesnesini günceller
            this.pansionType.setPansionType(selectPansionType);
            this.pansionType.setHotelId(Integer.parseInt(String.valueOf(this.hotelId)));

            // Pansion türünü kaydeder
            this.pansionTypeManager.save(this.pansionType);

            //Sonuca göre bilgi mesajı gösterir
            if (result) {
                Helper.showMsg("done");
                dispose();
            } else {
                Helper.showMsg("error");
            }
        });
    }
}
