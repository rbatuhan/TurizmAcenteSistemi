package business;

import core.Helper;
import dao.HotelDao;
import dao.PansionTypeDao;
import entity.Hotel;
import entity.PansionType;

import java.util.ArrayList;

public class PansionTypeManager {
    private final PansionTypeDao pansionTypeDao;

    // Belirli bir ID'ye sahip pansion tipini getiren metot.
    public PansionType getByID(int id){return this.pansionTypeDao.getById(id);}

    // Tüm pansion tiplerini getiren metot.
    public ArrayList<PansionType> findAll() {return this.pansionTypeDao.findAll();}

    // PansionType nesnelerini tabloya dönüştüren metot.
    public ArrayList<Object[]> getForTable(int size, ArrayList<PansionType> pansionTypeList) {
        ArrayList<Object[]> pansionTypeObjList = new ArrayList<>();
        for (PansionType obj : pansionTypeList) {
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getPansionType();
            rowObject[i++] = obj.getHotelId();
            pansionTypeObjList.add(rowObject);
        }
        return pansionTypeObjList;
    }

    public PansionTypeManager(){
        this.pansionTypeDao = new PansionTypeDao();
    }

    // Yeni bir pansion tipi ekleyen metot.
    public boolean save(PansionType pansionType){
        if (this.getByID(pansionType.getId()) != null){
            Helper.showMsg("error");
            return false;
        }
        return this.pansionTypeDao.save(pansionType);
    }
}
