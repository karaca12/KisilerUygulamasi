package com.example.kisileruygulamasi.room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.kisileruygulamasi.data.entity.Kisi;

@Database(entities = {Kisi.class},version = 1)
public abstract class Veritabani extends RoomDatabase {
    public abstract KisiDao getKisiDao();
}
