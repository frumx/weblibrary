package com.ksmk.service;

import com.ksmk.model.Rent;
import com.ksmk.model.User;

import java.util.List;

public interface RentService {
    List<Rent> findByUser(User user);

    void save(Rent rent);

    Rent findById(Long id);

}
