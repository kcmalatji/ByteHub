package com.Rootcore.bytehub_dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DashboadController {

    @GetMapping("/dashboard")
    String dashboard(){

        return "Dashboard";
    }
}
