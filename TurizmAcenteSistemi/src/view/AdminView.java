package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminView extends Layout {
    private JPanel container;
    private JLabel lbl_welcome;
    private JButton btn_ext;
    private JPanel pnl_users;
    private JScrollPane scrl_users;
    private JLabel lbl_role;
    private JButton btn_search;
    private JButton btn_user_add;
    private JComboBox cmb_role;
    private JTable tbl_admin;
    private JButton btn_reset;
    private DefaultTableModel tmdl_admin = new DefaultTableModel();
    private Object[] col_admin;
    private UserManager userManager;
    private JPopupMenu user_menu;
    private User user;

    public AdminView(User user) {
        this.userManager = new UserManager();
        this.user = new User();
        this.add(container);
        guiInitilaze(1000, 600);

        if (this.user == null) {
            dispose();
        }
        this.lbl_welcome.setText("Admin Paneline Hoşgeldin :  " + user.getUsername());

        loadUserTable(null);
        loadUserComponent();

    }


    public void loadUserTable(ArrayList<Object[]> userList) {
        this.col_admin = new Object[]{"ID", "Kullanıcı Adı", "Şifre", "Rol"};
        if (userList == null) {
            userList = this.userManager.getForTable(this.col_admin.length, this.userManager.findAll());
        }
        createTable(this.tmdl_admin, this.tbl_admin, col_admin, userList);
    }

    private void loadUserComponent() {
        tableRowSelect(this.tbl_admin);
        this.user_menu = new JPopupMenu();
        this.user_menu.add("Yeni").addActionListener(e -> {
            UserView userView = new UserView(new User());
            userView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadUserTable(null);
                }
            });
        });

        this.user_menu.add("Güncelle").addActionListener(e -> {
            int selectedUserId = this.getTableSelectedRow(tbl_admin, 0);
            UserView userView = new UserView(this.userManager.getById(selectedUserId));
            userView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadUserTable(null);
                }
            });
        });

        this.user_menu.add("Sil").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectUserID = this.getTableSelectedRow(tbl_admin, 0);
                if (this.userManager.delete(selectUserID)) {
                    Helper.showMsg("done");
                    loadUserTable(null);
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_admin.setComponentPopupMenu(user_menu);

        //Çıkış yapmak için kullanılan buton
        btn_ext.addActionListener(e -> {
            dispose();
        });
        //Kullanıcı ekleme işlemini gerçekleştiren buton
        btn_user_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserView userView = new UserView(new User());
                userView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadUserTable(null);
                    }
                });
            }
        });

        //Filtreleme İşlemini gerçekleştiren buton
        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userSearchRole = (String) cmb_role.getSelectedItem();
                ArrayList<User> searchedUserList = userManager.findByRole(userSearchRole);
                ArrayList<Object[]> searchedUserRowList = userManager.getForTable(col_admin.length, searchedUserList);
                loadUserTable(searchedUserRowList);
            }
        });

        //Filtrelemeyi Resetleyen Buton İşlevi
        btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadUserTable(null);
            }
        });
    }
}
