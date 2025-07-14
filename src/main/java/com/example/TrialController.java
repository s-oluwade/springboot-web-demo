package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrialController {

    @GetMapping("/trial")
    public String trial() {
        return "trial";  // maps to trial.jsp
    }
}
