package com.example.kisileruygulamasi.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.repository.KisiDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KisiDetayViewModel extends ViewModel {

    public KisiDaoRepository kisiDaoRepository;

    @Inject
    public KisiDetayViewModel(KisiDaoRepository kisiDaoRepository){
        this.kisiDaoRepository = kisiDaoRepository;
    }

    public void guncelle(int kisi_id, String kisi_ad, String kisi_tel) {
        kisiDaoRepository.guncelle(kisi_id, kisi_ad, kisi_tel);
    }
}
