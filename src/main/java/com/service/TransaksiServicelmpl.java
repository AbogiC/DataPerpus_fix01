package com.service;

import com.model.entity.Transaksi;
import com.repository.DendaRepository;
import com.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransaksiServicelmpl implements TransaksiService{
    @Autowired
    private TransaksiRepository transaksiRepository;
    private DendaRepository dendaRepository;
    @Override
    public Transaksi insertDataTransaksi(Transaksi transaksi) {
        return null;
    }


}
