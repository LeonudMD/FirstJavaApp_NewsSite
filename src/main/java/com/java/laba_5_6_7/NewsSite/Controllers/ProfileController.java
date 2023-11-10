// ProfileController.java
package com.java.laba_5_6_7.NewsSite.Controllers;

import com.java.laba_5_6_7.NewsSite.Models.User;
import com.java.laba_5_6_7.NewsSite.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userProfile(Model model) {
        // Предполагается, что метод getUserByPrincipal возвращает текущего аутентифицированного пользователя
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUserByPrincipal(auth);
        model.addAttribute("user", currentUser);
        return "profile";
    }

    @GetMapping("/edit")
    public String editProfileForm(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUserByPrincipal(auth);
        model.addAttribute("user", currentUser);
        return "edit-profile";
    }

    @PostMapping("/edit")
    public String editProfileSubmit(@ModelAttribute User user, Authentication authentication) {
        // В вашем текущем UserService нет метода getById, так что я использую getUserByPrincipal для демонстрации
        User currentUser = userService.getUserByPrincipal(authentication);
        System.out.println("Current user ID: " + currentUser.getId() + " - Form user ID: " + user.getId());
        // Проверяем, что пользователь редактирует свой собственный профиль
        if (currentUser != null && currentUser.getId().equals(user.getId())) {
            userService.updateUser(user);
            return "redirect:/profile";
        } else {
            // В случае если пользователь не совпадает, можно редиректить на страницу ошибки или выводить сообщение
            return "redirect:/profile/edit?error=notauthorized";
        }
    }
}