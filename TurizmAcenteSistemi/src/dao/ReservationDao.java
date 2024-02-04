package dao;

import core.Db;
import entity.Reservation;
import entity.Room;
import entity.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReservationDao {
    private final Connection conn;
    private RoomDao roomDao;
    private HotelDao hotelDao;

    public ReservationDao(){
        this.conn = Db.getInstance();
        this.roomDao = new RoomDao();
        this.hotelDao = new HotelDao();
    }

    // ID'ye göre rezervasyon getiren metot.
    public Reservation getById(int id) {
        Reservation obj = null;
        String query = "SELECT * FROM public.reservation WHERE rsv_id = ?";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
    // Tüm rezervasyonları getiren metot.
    public ArrayList<Reservation> findAll() {
        return this.selectByQuery("SELECT * FROM public.reservation ORDER BY rsv_id ASC");
    }

    // Belirli bir query sorgusuna göre rezervasyonları getiren metot.
    public ArrayList<Reservation> selectByQuery(String query) {
        ArrayList<Reservation> reservationList = new ArrayList<>();
        try {
            ResultSet rs = this.conn.createStatement().executeQuery(query);
            while (rs.next()) {
                reservationList.add(this.match(rs));
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return reservationList;
    }

    // Veritabanından gelen ResultSet'i Reservation nesnesine dönüştüren metot.
    public Reservation match(ResultSet rs) throws Exception {
        Reservation obj = new Reservation();
        obj.setId(rs.getInt("rsv_id"));
        obj.setRoom_id(rs.getInt("room_id"));
        obj.setStrt_date(LocalDate.parse(rs.getString("rsv_start_date")));
        obj.setFnsh_date(LocalDate.parse(rs.getString("rsv_fnsh_date")));
        obj.setTotalPrc(rs.getInt("rsv_price"));
        obj.setTotalPeople(rs.getInt("rsv_total_customer"));
        obj.setCustomerName(rs.getString("rsv_name"));
        obj.setCustomerMail(rs.getString("rsv_mail"));
        obj.setCustomerMpno(rs.getInt("rsv_mpno"));
        obj.setCustomerSsn(rs.getInt("rsv_customer_ssn"));
        return obj;
    }
    // Yeni bir rezervasyon ekleyen metot
    public boolean save(Reservation reservation) {
        String query = "INSERT INTO public.reservation " +
                "(" +
                "rsv_name," +
                "rsv_mpno," +
                "rsv_mail," +
                "rsv_strt_date," +
                "rsv_fnsh_date," +
                "room_id," +
                "rsv_price," +
                "rsv_total_customer," +
                "rsv_customer_ssn," +
                ")" +
                " VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setString(1, reservation.getCustomerName());
            pr.setInt(2, reservation.getCustomerMpno());
            pr.setString(3, reservation.getCustomerMail());
            pr.setDate(4, Date.valueOf(reservation.getStrt_date()));
            pr.setDate(5, Date.valueOf(reservation.getFnsh_date()));
            pr.setInt(6, reservation.getRoom_id());
            pr.setInt(7, reservation.getTotalPrc());
            pr.setInt(8, reservation.getTotalPeople());
            pr.setInt(9, reservation.getCustomerSsn());

            return pr.executeUpdate() != -1;

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }

    // Varolan bir rezervasyonu güncelleyen metot.
    public boolean update(Reservation reservation){
        String query = "UPDATE public.reservation SET " +
                "rsv_name = ?," +
                "rsv_mpno = ?," +
                "rsv_mail = ?," +
                "rsv_strt_date = ?," +
                "rsv_fnsh_date = ?," +
                "room_id = ?," +
                "rsv_price = ?," +
                "rsv_total_customer = ?," +
                "rsv_customer_ssn = ?" +
                " WHERE rsv_id = ?";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setString(1, reservation.getCustomerName());
            pr.setInt(2, reservation.getCustomerMpno());
            pr.setString(3, reservation.getCustomerMail());
            pr.setDate(4, Date.valueOf(reservation.getStrt_date()));
            pr.setDate(5, Date.valueOf(reservation.getFnsh_date()));
            pr.setInt(6, reservation.getRoom_id());
            pr.setInt(7, reservation.getTotalPrc());
            pr.setInt(8, reservation.getTotalPeople());
            pr.setInt(9, reservation.getCustomerSsn());
            pr.setInt(10, reservation.getId());

            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }

    // Belirli bir ID'ye sahip rezervasyonu silen metot.
    public boolean delete(int id){
        String query = "DELETE FROM public.reservation WHERE rsv_id = ?";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate() != -1;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return true;
    }
}
