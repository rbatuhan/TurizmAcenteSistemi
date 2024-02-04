package view;

import business.UserManager;
import core.Helper;
import dao.UserDao;
import entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class LoginView extends Layout {
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcome;
    private JLabel lbl_username;
    private JTextField fld_username;
    private JLabel lbl_password;
    private JTextField fld_password;
    private JButton btn_login;
    private JButton btn_ext;
    private final UserManager userManager;
    private final User user;
    private final UserDao userDao;
    private Connection con;

    //Login Ekranının tasarımsal özellikleri
    public LoginView() {

        this.user = new User();
        this.userManager = new UserManager();
        this.userDao = new UserDao();
        this.add(container);
        guiInitilaze(400, 400);

        //Logine basıldıgında çalışacak metot
        btn_login.addActionListener(e -> {
            JTextField[] checkFieldList = {this.fld_username, this.fld_password};
            if (Helper.isFieldListEmpty(checkFieldList)) {
                Helper.showMsg("fill");
            } else {
                User loginUser = this.userManager.findByLogin(this.fld_username.getText(), this.fld_password.getText());
                if (loginUser == null) {
                    Helper.showMsg("notFound");
                } else {
                    // Kullanıcı Rol Kontrolü
                    switch (loginUser.getRole()){
                        case "admin":
                            AdminView adminView = new AdminView(loginUser);
                            dispose();
                            break;
                        case "employee":
                            EmployeeView employeeView = new EmployeeView(loginUser);
                            employeeView.setVisible(true);
                            dispose();
                            break;
                    }
                    dispose();
                }
            }
        });

        //Çıkış butonuna basıldıgında yazacak buton
        btn_ext.addActionListener(e -> {
            dispose();
        });
    }
}
