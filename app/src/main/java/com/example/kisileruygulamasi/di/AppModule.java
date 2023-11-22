package com.example.kisileruygulamasi.di;


import android.content.Context;

import androidx.room.Room;

import com.example.kisileruygulamasi.data.repository.KisiDaoRepository;
import com.example.kisileruygulamasi.room.KisiDao;
import com.example.kisileruygulamasi.room.Veritabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public KisiDaoRepository provideKisiDaoRepository(KisiDao kisiDao) {
        return new KisiDaoRepository(kisiDao);
    }

    @Provides
    @Singleton
    public KisiDao provideKisiDao(@ApplicationContext Context context) {
        Veritabani vt = Room.databaseBuilder(context, Veritabani.class, "rehber.sqlite")
                .createFromAsset("rehber.sqlite").build();
        return vt.getKisiDao();
    }
}
