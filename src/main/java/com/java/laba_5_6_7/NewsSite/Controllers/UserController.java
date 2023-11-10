package com.java.laba_5_6_7.NewsSite.Controllers;

import com.java.laba_5_6_7.NewsSite.Models.User;
import com.java.laba_5_6_7.NewsSite.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.laba_5_6_7.NewsSite.Services.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userSevice;
    private final UserRepository userRepository;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/registration")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam("avatarFile") MultipartFile avatarFile,
                             Model model) {
        if (!userSevice.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
            return "registration";
        }

        if (!avatarFile.isEmpty()) {
            try {
                String avatarFileName = UUID.randomUUID().toString() + "_" + avatarFile.getOriginalFilename();
                String rootPath = System.getProperty("user.dir"); // Получить текущую директорию, где находится приложение
                String uploadDir = rootPath + File.separator + "uploads";
                String filePath = Paths.get(uploadDir, avatarFileName).toString();

                // Создаем папку, если она не существует
                File uploadFolder = new File(uploadDir);
                if (!uploadFolder.exists()) {
                    uploadFolder.mkdirs();
                }

                // Сохраняем файл на сервере
                avatarFile.transferTo(new File(filePath));

                // Устанавливаем путь к аватару в сущности пользователя
                String relativePath = "/uploads/" + avatarFileName; // Вот такой будет относительный путь
                user.setAvatarPath(relativePath);
                userRepository.save(user);
            } catch (IOException e) {
                e.printStackTrace();
                // Обработка ошибки при загрузке аватара
            }
        }

        return "redirect:login";
    }
}
