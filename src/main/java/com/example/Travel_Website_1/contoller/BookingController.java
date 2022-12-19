package com.example.Travel_Website_1.contoller;


import com.example.Travel_Website_1.Dtos.BookingDTO;
import com.example.Travel_Website_1.model.Booking;
import com.example.Travel_Website_1.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BookingController {


    @Autowired
    private BookingService service;


    // add booking

//    @PostMapping("/booking/{userId}/{hotelId}")
////    public Booking createBooking(@RequestBody Booking booking,
////                                 @PathVariable("userId") Long userId,
////                                 @PathVariable("hotelId") Long hotelId)
////    {
////        return service.createBooking(booking,userId,hotelId);
////    }


    @PostMapping("/create/{userId}/{hotelId}")
    public Booking createReservation(@RequestBody BookingDTO reservation, @PathVariable Long userId,
                                         @PathVariable Long hotelId){
        return service.createReservation(reservation,userId,hotelId);
    }

    // update Booking

    @PutMapping("/booking/{bookingId}")

    public Booking updateBooking(@PathVariable("bookingId") Long bookingId, @RequestBody Booking booking) {
        return service.updateBooking(bookingId, booking);
    }


    // delete booking
    @DeleteMapping("/booking/{bookingId}")

            public String deleteBookingById(@PathVariable("bookingId") Long bookingId)
    {

          service.deleteBookingById(bookingId);

          return "Booking delete Successfully";
    }
    // show  all booking

     @GetMapping("/showBooking")

    public List<Booking> showAllBookings()
     {
         return service.showAllBookings();
     }

     @GetMapping("/allReservationById/{userId}")
    public List<Booking> showBookingById(@PathVariable Long userId)
     {
         return service.showBookingById(userId);
     }


     @GetMapping("/booking/price/{userId}")

    public Double getTotalPriceForUser(@PathVariable("userId") Long userId)
     {
         return service.getTotalPriceForUser(userId);
     }

     @GetMapping("/booking/getAllBookings/{hotelId}")

    public ResponseEntity<Set<Booking>> getBookingByHotelId
             (@PathVariable("hotelId")Long hotelId)
     {
         return ResponseEntity.ok
                 (service.getgetBookingByHotelId(hotelId));
     }


}
