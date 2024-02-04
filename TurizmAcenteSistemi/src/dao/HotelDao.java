package dao;

import core.Db;
import entity.Hotel;

import java.sql.*;
import java.util.ArrayList;

public class HotelDao {
    private final Connection conn;

    public HotelDao() {
        this.conn = Db.getInstance();
    }

    public Hotel getById(int id) {
        Hotel obj = null;
        String query = "SELECT * FROM public.hotel WHERE hotel_id = ?";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) obj = this.match(rs);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }

    public ArrayList<String> getByName() {
        ArrayList<String> hotelList = new ArrayList<>();
        String query = "SELECT hotel_name FROM public.hotel ORDER BY hotel_name ASC";
        try {
            Statement st = this.conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String hotelName = rs.getString("hotel_name");
                hotelList.add(hotelName);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return hotelList;
    }

    public ArrayList<Hotel> findAll() {
        return this.selectByQuery("SELECT * FROM public.hotel ORDER BY hotel_id ASC");
    }

    public ArrayList<Hotel> selectByQuery(String query) {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        try {
            ResultSet rs = this.conn.createStatement().executeQuery(query);
            while (rs.next()) {
                hotelList.add(this.match(rs));
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return hotelList;
    }

    public Hotel match(ResultSet rs) throws Exception {
        Hotel obj = new Hotel();
        obj.setId(rs.getInt("hotel_id"));
        obj.setHotel_name(rs.getString("hotel_name"));
        obj.setHotel_star(rs.getString("hotel_star"));
        obj.setHotel_city(rs.getString("hotel_city"));
        obj.setHotel_region(rs.getString("hotel_region"));
        obj.setHotel_address(rs.getString("hotel_address"));
        obj.setHotel_mail(rs.getString("hotel_mail"));
        obj.setHotel_mpno(rs.getString("hotel_mpno"));
        obj.setHotel_features_carpark(rs.getString("hotel_features_carpark"));
        obj.setHotel_features_wifi(rs.getString("hotel_features_wifi"));
        obj.setHotel_features_pool(rs.getString("hotel_features_pool"));
        obj.setHotel_features_fitness(rs.getString("hotel_features_fitness"));
        obj.setHotel_features_concierge(rs.getString("hotel_features_concierge"));
        obj.setHotel_features_spa(rs.getString("hotel_features_spa"));
        obj.setHotel_features_room_service(rs.getString("hotel_features_room_service"));

        return obj;
    }

    public boolean save(Hotel hotel) {
        String query = "INSERT INTO public.hotel " +
                "(" +
                "hotel_name, " +
                "hotel_star, " +
                "hotel_city, " +
                "hotel_region, " +
                "hotel_address, " +
                "hotel_mail, " +
                "hotel_mpno, " +
                "hotel_features_carpark, " +
                "hotel_features_wifi, " +
                "hotel_features_pool, " +
                "hotel_features_fitness, " +
                "hotel_features_concierge, " +
                "hotel_features_spa, " +
                "hotel_features_room_service" +
                ")" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setString(1, hotel.getHotel_name());
            pr.setString(2, hotel.getHotel_star());
            pr.setString(3, hotel.getHotel_city());
            pr.setString(4, hotel.getHotel_region());
            pr.setString(5, hotel.getHotel_address());
            pr.setString(6, hotel.getHotel_mail());
            pr.setString(7, hotel.getHotel_mpno());
            pr.setString(8, hotel.getHotel_features_carpark());
            pr.setString(9, hotel.getHotel_features_wifi());
            pr.setString(10, hotel.getHotel_features_pool());
            pr.setString(11, hotel.getHotel_features_fitness());
            pr.setString(12, hotel.getHotel_features_concierge());
            pr.setString(13, hotel.getHotel_features_spa());
            pr.setString(14, hotel.getHotel_features_room_service());
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
