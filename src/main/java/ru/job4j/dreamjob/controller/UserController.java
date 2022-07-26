package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.service.UserService;

import java.util.Optional;


@Controller
public class UserController {

    private static final String FAIL_MESSAGE = "Пользователь с такой почтой уже существует";
    private static final String SUCCESS_MESSAGE = "Пользователь зарегестрирован успешно";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute User user) {
        Optional<User> regUser = userService.add(user);
        if (regUser.isEmpty()) {
            return "redirect:/fail";
        }
        return "redirect:/success";
    }

    @GetMapping("/formRegistration")
    public String formRegistration() {
        return "registration";
    }

    @GetMapping("/success")
    public String success(Model model) {
        model.addAttribute("message", SUCCESS_MESSAGE);
        return "success";
    }

    @GetMapping("/fail")
    public String fail(Model model) {
        model.addAttribute("message", FAIL_MESSAGE);
        return "fail";
    }

}
