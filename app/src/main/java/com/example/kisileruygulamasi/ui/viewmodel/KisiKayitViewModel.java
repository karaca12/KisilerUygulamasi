package com.example.kisileruygulamasi.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.repository.KisiDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KisiKayitViewModel extends ViewModel {
    public KisiDaoRepository kisiDaoRepository ;

    @Inject
    public KisiKayitViewModel(KisiDaoRepository kisiDaoRepository){
        this.kisiDaoRepository = kisiDaoRepository;
    }

    public void kaydet(String kisi_ad, String kisi_tel) {
        kisiDaoRepository.kaydet(kisi_ad, kisi_tel);
    }


}
