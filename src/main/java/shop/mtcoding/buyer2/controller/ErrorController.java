package shop.mtcoding.buyer2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/missing")
    public String missing() {
        return "error/error";
    }
}
