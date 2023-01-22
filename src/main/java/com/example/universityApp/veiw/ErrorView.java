package com.example.universityApp.veiw;

import org.springframework.stereotype.Component;

@Component
public class ErrorView {
    public void error(String request) {
        System.out.println("Your request: \"" + request + "\" is invalid");
    }
}
