package dao;

import core.Db;
import entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDao {
    private final Connection conn;

    public RoomDao() {
        this.conn = Db.getInstance();
    }

    public Room getById(int id) {
        Room obj = null;
        String query = "SELECT * FROM public.room WHERE room_id = ?";
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

    public ArrayList<Room> findAll() {
        return this.selectByQuery("SELECT * FROM public.room ORDER BY room_id ASC");
    }

    public ArrayList<Room> selectByQuery(String query) {
        ArrayList<Room> roomList = new ArrayList<>();
        try {
            ResultSet rs = this.conn.createStatement().executeQuery(query);
            while (rs.next()) {
                roomList.add(this.match(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return roomList;
    }

    public Room match(ResultSet rs) throws Exception {
        Room obj = new Room();
        obj.setId(rs.getInt("room_id"));
        obj.setRoom_type(rs.getString("room_type"));
        obj.setRoom_stock(rs.getInt("room_stock"));
        obj.setSeason_id(rs.getInt("season_id"));
        obj.setRoom_adult_prc(rs.getInt("room_adult_prc"));
        obj.setRoom_child_prc(rs.getInt("room_child_prc"));
        obj.setId(rs.getInt("hotel_id"));
        obj.setId(rs.getInt("pansion_id"));
        obj.setRoom_square_meter(rs.getInt("room_square_meter"));
        obj.setRoom_number_bed(rs.getInt("room_number_bed"));
        obj.setRoom_tv(rs.getString("room_tv"));
        obj.setRoom_minibar(rs.getString("room_minibar"));
        obj.setRoom_game_console(rs.getString("room_game_console"));
        obj.setRoom_kasa(rs.getString("room_kasa"));
        obj.setRoom_projection(rs.getString("room_projection"));
        return obj;
    }

    public boolean save(Room room) {
        String query = "INSERT INTO public.room" +
                "(" +
                "room_type," +
                "room_stock," +
                "season_id," +
                "room_adult_prc," +
                "room_child_prc," +
                "hotel_id," +
                "pansion_id," +
                "room_square_meter," +
                "room_number_bed," +
                "room_tv," +
                "room_minibar," +
                "room_game_console," +
                "room_kasa," +
                "room_projection" +
                ")" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = this.conn.prepareStatement(query);
            pr.setString(1, room.getRoom_type());
            pr.setInt(2, room.getRoom_stock());
            pr.setInt(3, room.getSeason_id());
            pr.setInt(4, room.getRoom_adult_prc());
            pr.setInt(5, room.getRoom_child_prc());
            pr.setInt(6, room.getHotel_id());
            pr.setInt(7, room.getPansion_id());
            pr.setInt(8, room.getRoom_square_meter());
            pr.setInt(9, room.getRoom_number_bed());
            pr.setString(10, room.getRoom_tv());
            pr.setString(11, room.getRoom_minibar());
            pr.setString(12, room.getRoom_game_console());
            pr.setString(13, room.getRoom_kasa());
            pr.setString(14, room.getRoom_projection());

            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}