package com.example.universityApp;

import com.example.universityApp.veiw.MenuView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityAppApplication implements CommandLineRunner {
    @Autowired
    private MenuView menuView;

    public static void main(String[] args) {
        SpringApplication.run(UniversityAppApplication.class, args);
    }

    @Override
    public void run(String... args) {
        menuView.menuShow();
    }
}
