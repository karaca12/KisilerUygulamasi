package com.example.kisileruygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisileruygulamasi.data.entity.Kisi;
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding;
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel;
import com.example.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KisiDetayFragment extends Fragment {

    private FragmentKisiDetayBinding binding;
    private KisiDetayViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentKisiDetayBinding.inflate(inflater, container, false);

        KisiDetayFragmentArgs bundle = KisiDetayFragmentArgs.fromBundle(getArguments());
        Kisi gelenKisi = bundle.getKisi();

        binding.editTextKisiAd.setText(gelenKisi.getKisi_ad());
        binding.editTextKisiTel.setText(gelenKisi.getKisi_tel());

        binding.buttonGuncelle.setOnClickListener(v -> {
            String kisi_ad = binding.editTextKisiAd.getText().toString();
            String kisi_tel = binding.editTextKisiTel.getText().toString();

            viewModel.guncelle(gelenKisi.getKisi_id(), kisi_ad, kisi_tel);
        });

        return binding.getRoot();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiDetayViewModel.class);
    }
}