package business;

import core.Helper;
import dao.RoomDao;
import entity.Hotel;
import entity.Room;

import java.util.ArrayList;

public class RoomManager {
    private final RoomDao roomDao;

    public RoomManager(){
        this.roomDao = new RoomDao();
    }
    public Room getByID(int id){return this.roomDao.getById(id);}

    public ArrayList<Room> findAll() {return this.roomDao.findAll();}

    public ArrayList<Object[]> getForTable(int size, ArrayList<Room> roomList){
        ArrayList<Object[]> roomObjList = new ArrayList<>();
        for (Room obj : roomList){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getRoom_type();
            rowObject[i++] = obj.getRoom_stock();
            rowObject[i++] = obj.getSeason_id();
            rowObject[i++] = obj.getRoom_adult_prc();
            rowObject[i++] = obj.getRoom_child_prc();
            rowObject[i++] = obj.getHotel_id();
            rowObject[i++] = obj.getPansion_id();
            rowObject[i++] = obj.getRoom_square_meter();
            rowObject[i++] = obj.getRoom_number_bed();
            rowObject[i++] = obj.getRoom_tv();
            rowObject[i++] = obj.getRoom_minibar();
            rowObject[i++] = obj.getRoom_game_console();
            rowObject[i++] = obj.getRoom_kasa();
            rowObject[i++] = obj.getRoom_projection();

            roomObjList.add(rowObject);
        }
        return roomObjList;
    }

    public boolean save(Room room){
        if (this.getByID(room.getId()) != null){
            Helper.showMsg("error");
            return false;
        }
        return this.roomDao.save(room);
    }
}