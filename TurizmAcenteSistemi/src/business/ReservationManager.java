package business;

import core.Helper;
import dao.ReservationDao;
import dao.RoomDao;
import entity.Reservation;
import entity.Room;

import java.util.ArrayList;

public class ReservationManager {
    private  RoomDao roomDao;

    private final ReservationDao reservationDao;

    // ID'ye göre rezervasyon getiren metot.
    public Reservation getById(int id) {
        return this.reservationDao.getById(id);
    }

    // Tüm rezervasyonları getiren metot.
    public ArrayList<Reservation> findAll() {return this.reservationDao.findAll();}

    // Rezervasyon listesini tablo formatına çeviren metot.
    public ArrayList<Object[]>getForTable(int size, ArrayList<Reservation> reservationList){
        ArrayList<Object[]> reservationObjList = new ArrayList<>();
        for (Reservation obj : reservationList){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getCustomerName();
            rowObject[i++] = obj.getCustomerMpno();
            rowObject[i++] = obj.getCustomerMail();
            rowObject[i++] = obj.getStrt_date();
            rowObject[i++] = obj.getFnsh_date();
            rowObject[i++] = obj.getRoom_id();
            rowObject[i++] = obj.getTotalPrc();
            rowObject[i++] = obj.getTotalPeople();
            rowObject[i++] = obj.getCustomerSsn();

            reservationObjList.add(rowObject);
        }
        return reservationObjList;
    }

    public ReservationManager(){
        this.reservationDao = new ReservationDao();
    }

    // Yeni bir rezervasyon ekleyen metot.
    public boolean save(Reservation reservation){
        if (this.getById(reservation.getId()) != null){
            Helper.showMsg("error");
            return false;
        }
        return this.reservationDao.save(reservation);
    }

    // Varolan bir rezervasyonu güncelleyen metot.
    public boolean update(Reservation reservation){
        if (this.getById(reservation.getId()) == null){
            Helper.showMsg(reservation.getId() + "ID kayıtlı kullanıcı bulunamadı");
            return false;
        }
        return this.reservationDao.update(reservation);
    }

    // Belirli bir ID'ye sahip rezervasyonu silen metot.
    public boolean delete(int id){
        if (this.getById(id) == null){
            Helper.showMsg(id + " ID kayıtlı kullanıcı bulunamadı");
            return false;
        }
        return this.reservationDao.delete(id);
    }

    // Oda stoğunu güncelleyen metot.
    public void updateStock(Room room){
        roomDao = new RoomDao();
        // Eğer oda mevcut değilse hata mesajı gösterir ve işlemi sonlandırır.
        if (this.getById(room.getId()) != null){
            Helper.showMsg(room.getRoom_stock() + "ID kayıtlı oda bulunamadı");
            return;
        } else {
            // Aksi halde oda stoğunu günceller.
            this.roomDao.updateStock(room);
        }
    }
}
