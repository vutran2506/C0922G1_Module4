package com.example.repository;

import com.example.model.Settings;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SettingRepository implements ISettingRepository{
  static  List<Settings> list= new ArrayList<>();
    static {
        list.add(new Settings(1,"English","5",true,"a"));
        list.add(new Settings(2,"Japanese","10",true,"b"));
        list.add(new Settings(3,"Vietnamese","25",true,"c"));
    }
    @Override
    public List<Settings> findAll() {
        return list;
    }

    @Override
    public void update(Settings setting) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId()==setting.getId()){
                list.set(i,setting);
            }
        }
    }

    @Override
    public Settings findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId()==id){
                return list.get(i);
            }
        }
        return null;
    }
}
