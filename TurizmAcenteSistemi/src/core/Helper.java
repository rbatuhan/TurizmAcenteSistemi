package core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    // Tema ayarlarını gerçekleştiren metod
    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }

    // Mesaj kutusu gösteren metod
    public static void showMsg(String str) {
        optionPaneTR();
        String msg;
        String title;
        switch (str) {
            case "fill" -> {
                msg = "Lütfen tüm alanları doldurunuz!";
                title = "HATA!";
            }
            case "done" -> {
                msg = "İşlem Başarılı!";
                title = "Sonuç";
            }
            case "notFound" -> {
                msg = "Kayıt bulunamadı !";
                title = "Bulunamadı";
            }
            case "error" -> {
                msg = "Hatalı işlem yaptınız !";
                title = "Hata!";
            }
            default -> {
                msg = str;
                title = "Mesaj";
            }
        };

        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    // Onay kutusu gösteren metod
    public static boolean confirm(String str){
        optionPaneTR();
        String msg;
        if (str.equals("sure")){
            msg = "Bu işlemi yapmak istediğine emin misin ?";
        }else {
            msg = str;
        }
        // JOptionPane ile onay kutusu göster ve kullanıcının seçimini döndür
        return JOptionPane.showConfirmDialog(null, msg, "Emin misin ?", JOptionPane.YES_NO_OPTION) == 0;
    }

    // JTextField'ın boş olup olmadığını kontrol eden metod
    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    // JTextField listesinin boş bir alan içerip içermediğini kontrol eden metod
    public static boolean isFieldListEmpty(JTextField[] fieldList) {
        for (JTextField field : fieldList) {
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    // Pencerenin konumunu belirleyen metod
    public static int getLocationPoint(String type, Dimension size) {
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };
    }

    // JOptionPane için Türkçe dil ayarlarını gerçekleştiren metod
    public static void optionPaneTR(){
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
    }

}
