package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by RLuchinsky on 24.05.2018.
 */
@Controller
public class UserRestController {
    @GetMapping("/")
    public String root() {
        return "index";
    }
}
