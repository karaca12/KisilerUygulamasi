package com.example.kisileruygulamasi.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kisileruygulamasi.data.entity.Kisi;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface KisiDao {
    @Query("SELECT * FROM kisi")
    Single<List<Kisi>> kisileriYukle();

    @Insert
    Completable kaydet(Kisi kisi);

    @Update
    Completable guncelle(Kisi kisi);

    @Delete
    Completable sil(Kisi kisi);

    @Query("SELECT * FROM kisi WHERE kisi_ad like '%' || :aramaKelimesi || '%'")
    Single<List<Kisi>> ara(String aramaKelimesi);
}
