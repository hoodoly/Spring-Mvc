package demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author HODO
 */
@Controller
@RequestMapping
public class DemoController {

    @RequestMapping("/app/demo")
    @ResponseBody
    public String demo() {
        return "test";
    }

    @OpenApi(value = "/api")
    public String demo2() {
        return "test2";
    }

}
