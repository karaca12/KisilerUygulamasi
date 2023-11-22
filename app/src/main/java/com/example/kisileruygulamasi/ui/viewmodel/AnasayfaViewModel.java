package com.example.kisileruygulamasi.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kisileruygulamasi.data.entity.Kisi;
import com.example.kisileruygulamasi.data.repository.KisiDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    public KisiDaoRepository kisiDaoRepository;
    public MutableLiveData<List<Kisi>> kisisList;

    @Inject
    public AnasayfaViewModel(KisiDaoRepository kisiDaoRepository) {
        this.kisiDaoRepository = kisiDaoRepository;
        kisiYukle();
        kisisList = kisiDaoRepository.kisisList;
    }

    public void ara(String aramaKelimesi) {
        kisiDaoRepository.ara(aramaKelimesi);
    }

    public void sil(int kisi_id) {
        kisiDaoRepository.sil(kisi_id);
    }

    public void kisiYukle() {
        kisiDaoRepository.kisiYukle();
    }
}
