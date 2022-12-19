package com.example.Travel_Website_1.service;


import com.example.Travel_Website_1.model.Booking;
import com.example.Travel_Website_1.model.Hotel;

import java.util.List;

public interface HotelInterface {


  public   Hotel addhotel(Hotel hotel);

   public List<Hotel> fetchBookingList();

    Hotel fetchHotelById(Long hotelId);
}
