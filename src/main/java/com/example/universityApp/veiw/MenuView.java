package com.example.universityApp.veiw;

import com.example.universityApp.controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuView {
    @Autowired
    private MainController mainController;

    public void menuShow() {
        while (true) {
            System.out.println("___________________________________");
            Scanner in = new Scanner(System.in);
            String request = in.nextLine();
            mainController.requestWork(request);
        }
    }
}
