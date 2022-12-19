package com.example.Travel_Website_1.h2database;

import com.example.Travel_Website_1.model.Enum.Gender;
import com.example.Travel_Website_1.model.Enum.MealPlan;
import com.example.Travel_Website_1.model.Enum.Type;
import com.example.Travel_Website_1.model.Hotel;
import com.example.Travel_Website_1.model.Role;
import com.example.Travel_Website_1.model.User;
import com.example.Travel_Website_1.repository.HotelRepository;
import com.example.Travel_Website_1.repository.RoleRepository;
import com.example.Travel_Website_1.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InitialUser  implements ApplicationListener<ContextRefreshedEvent> {

//     Role roleAdmin= new Role();
// declar cele 4 roluri
    // role repository in constructor

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final HotelRepository hotelRepository;

    Role admin= new Role();
    Role travelAgent = new Role();
    Role client = new Role();
    Role hotelEmployee = new Role();


    public InitialUser(UserRepository userRepository, RoleRepository roleRepository, HotelRepository hotelRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.hotelRepository = hotelRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        roleRepository.saveAll(addRols());
        userRepository.saveAll(addUser());
        hotelRepository.saveAll(addHotels());

    }


    public List<Role> addRols()
    {
        List<Role> roles= new ArrayList<>();
        admin.setType(Type.ADMIN);
        travelAgent.setType(Type.TOURIST_AGENT);
        client.setType(Type.CUSTOMER);
        hotelEmployee.setType(Type.HOTEL_EMPLOYEE);

        roles.add(admin);
        roles.add(travelAgent);
        roles.add(client);
        roles.add(hotelEmployee);
        return roles;

    }


    // ad roles si adaug ca la linia 32
    public List<User> addUser()
    {
        List<User> userList= new ArrayList<>();

        User newUser= new User();
        newUser.setRole(admin);
        newUser.setUsername("filipioan_29");
        newUser.setPassword(generatePassword());
        newUser.setCnp("1980929271697");
        newUser.setPhoneNumber("0743301377");

        newUser.setEmail("admin@yahoo.com");

        newUser.setGender(Gender.FEMALE);
        userList.add(newUser);
        return userList;
    }



    public List<Hotel> addHotels()
    {
        List<Hotel> hotels = new ArrayList<>();

        Hotel continental= new Hotel();

        continental.setHotelName("Continental");
        continental.setCity("Bucuresti");
        continental.setImage(null);
        continental.setNumberOfRooms(200);
        continental.setMealPlan(MealPlan.ALL_INCLUSIVE);
        continental.setPricePerNight(170.50);
        continental.setGym(true);
        continental.setSpa(true);
        continental.setTransferAiroport(true);

        hotels.add(continental);
        return hotels;


    }

    public static String generatePassword() {
        String passwordString;
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = "abcdefghijklmnopqrstuvxyz";
        String digits = "0123456789";
        String specialChar = "!@#$%^&*?+";
        String allChars = upperLetters + lowerLetters + digits + specialChar;

        Random random = new Random();
        int length = random.nextInt(6) + 6;
        char[] password = new char[length];

        password[0] = lowerLetters.charAt(random.nextInt(lowerLetters.length()));
        password[1] = upperLetters.charAt(random.nextInt(upperLetters.length()));
        password[2] = specialChar.charAt(random.nextInt(specialChar.length()));
        password[3] = digits.charAt(random.nextInt(digits.length()));

        for (int i = 4; i < length; i++) {
            password[i] = allChars.charAt(random.nextInt(allChars.length()));
        }


        passwordString = String.valueOf(password);
        return passwordString;
    }


}
