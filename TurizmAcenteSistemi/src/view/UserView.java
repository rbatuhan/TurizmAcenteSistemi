package view;

import business.UserManager;
import core.ComboItem;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JLabel lbl_username;
    private JTextField fld_username;
    private JLabel lbl_password;
    private JTextField fld_password;
    private JLabel lbl_user_rol;
    private JComboBox cmb_user_role;
    private JButton btn_save;
    private User user;
    private UserManager userManager;

    public UserView(User user) {
        this.user = user;
        this.userManager = new UserManager();
        this.add(container);
        this.guiInitilaze(400, 400);


        if (this.user.getId() != 0) {
            this.fld_username.setText(this.user.getUsername());
            this.fld_password.setText(this.user.getPassword());

        }


        this.btn_save.addActionListener(e -> {
            if (Helper.isFieldListEmpty(new JTextField[]{fld_username, fld_password})) {
                Helper.showMsg("fill");
            } else {
                boolean result;
                String selectedRole = this.cmb_user_role.getSelectedItem().toString();

                this.user.setRole(selectedRole);
                this.user.setUsername(this.fld_username.getText());
                this.user.setPassword(this.fld_password.getText());

                if (this.user.getId() != 0) {
                    result = this.userManager.update(this.user);
                } else {
                    result = this.userManager.save(this.user);
                }
                if (result) {
                    Helper.showMsg("done");
                    dispose();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
    }

}
