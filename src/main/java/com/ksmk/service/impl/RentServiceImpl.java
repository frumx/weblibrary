package com.ksmk.service.impl;

import com.ksmk.dao.RentRepository;
import com.ksmk.model.Rent;
import com.ksmk.model.User;
import com.ksmk.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Override
    public List<Rent> findByUser(User user) {
        return rentRepository.findByUser(user);
    }

    @Override
    public void save(Rent rent) {
        rentRepository.save(rent);
    }

    @Override
    public Rent findById(Long id) {
        return rentRepository.findOne(id);
    }

}
