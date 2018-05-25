package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Created by RLuchinsky on 25.05.2018.
 */
@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "index";
    }
}
