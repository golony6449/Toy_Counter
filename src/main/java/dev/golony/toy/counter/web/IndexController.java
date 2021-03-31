package dev.golony.toy.counter.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {
    @GetMapping("/")
    String index(){
        return "index";
    }

    @GetMapping("/slot/register")
    String registerSlot() { return "popup/register_slot"; }

    @GetMapping("/user/find")
    String findUser() { return "popup/search_user"; }
}
