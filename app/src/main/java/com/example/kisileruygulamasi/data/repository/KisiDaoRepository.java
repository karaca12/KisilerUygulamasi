package com.example.kisileruygulamasi.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisileruygulamasi.data.entity.Kisi;
import com.example.kisileruygulamasi.room.KisiDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class KisiDaoRepository {

    public MutableLiveData<List<Kisi>> kisisList = new MutableLiveData<>();

    private KisiDao kisiDao;

    public KisiDaoRepository(KisiDao kisiDao) {
        this.kisiDao = kisiDao;
    }

    public void ara(String aramaKelimesi) {
        kisiDao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisi>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(List<Kisi> kisis) {
                        kisisList.setValue(kisis);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void kaydet(String kisi_ad, String kisi_tel) {
        Kisi yeniKisi = new Kisi(0,kisi_ad,kisi_tel);
        kisiDao.kaydet(yeniKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void guncelle(int kisi_id, String kisi_ad, String kisi_tel) {
        Kisi guncellenenKisi = new Kisi(kisi_id,kisi_ad,kisi_tel);
        kisiDao.guncelle(guncellenenKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void sil(int kisi_id) {
        Kisi silinenKisi = new Kisi(kisi_id,"","");
        kisiDao.sil(silinenKisi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {
                        kisiYukle();
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void kisiYukle(){
        kisiDao.kisileriYukle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Kisi>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(List<Kisi> kisis) {
                        kisisList.setValue(kisis);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }
}
