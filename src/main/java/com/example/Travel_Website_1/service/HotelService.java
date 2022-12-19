package com.example.Travel_Website_1.service;


import com.example.Travel_Website_1.model.Booking;
import com.example.Travel_Website_1.model.Hotel;
import com.example.Travel_Website_1.repository.BookingRepository;
import com.example.Travel_Website_1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService implements HotelInterface {



    @Autowired

    public HotelRepository hotelRepository;


    @Override
    public Hotel addhotel(Hotel hotel) {

        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> fetchBookingList() {
        return (List<Hotel>) hotelRepository.findAll();
    }

    @Override
    public Hotel fetchHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId).get();
    }
}
