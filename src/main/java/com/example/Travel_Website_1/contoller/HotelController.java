package com.example.Travel_Website_1.contoller;


import com.example.Travel_Website_1.model.Booking;
import com.example.Travel_Website_1.model.Hotel;
import com.example.Travel_Website_1.service.HotelInterface;
import com.example.Travel_Website_1.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {


    @Autowired
    private HotelService hotelInterface;

   //adding hotel
    @PostMapping("/hotel")
    public Hotel addHotel(@RequestBody Hotel hotel)
    {
        return hotelInterface.addhotel(hotel);
    }

    // show all hotels

    @GetMapping("/hotel")
    public List<Hotel> fetchBookingList()
    {
        return hotelInterface.fetchBookingList();
    }


    // show hotels by id

    @GetMapping("/hotel/{hotelId}")
    public Hotel fetchHotelById(@PathVariable("hotelId") Long hotelId)
    {
        return hotelInterface.fetchHotelById(hotelId);
    }
}
