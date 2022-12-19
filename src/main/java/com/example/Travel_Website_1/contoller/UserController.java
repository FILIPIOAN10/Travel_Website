package com.example.Travel_Website_1.contoller;


import com.example.Travel_Website_1.model.User;

import com.example.Travel_Website_1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

//     creare user
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {

            return service.addUser(user);

    }
//
//     afisare user

    @GetMapping("/users")
    public List<User> getAllUsers( )
    {

        return service.getAllUsers();
    }


    // editare user dupa id

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable("userId") Long userId, @RequestBody User user)
    {
        return service.updateUser(userId,user);
    }
 //
//    @GetMapping("/list")
//
//    public String listUsers(Model model)
//    {
//        model.addAttribute("users",service.getAllUsers());
//        return "user-list";
//    }

//   @GetMapping("/users")
//    public String getUsers(Model model) {
//
//        model.addAttribute("users", service.getAllUsers());
//        return "users";
//    }

//
//    @GetMapping("/")
//
//    public String index()
//    {
//        return "index";
//    }


//    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
//
//    public ModelAndView save(@ModelAttribute User user)
//    {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("user_information");
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }
//


    @RequestMapping(value = "hello", method = {RequestMethod.GET,RequestMethod.POST})

   public String hello(@RequestParam String name , Model model)
    {
       String greetings="Hello , " + name + "!";
       model.addAttribute("greeting",greetings);
       return "hello";
    }

    @GetMapping("form")
    public String helloForm()
    {
        return "form";
    }



}
