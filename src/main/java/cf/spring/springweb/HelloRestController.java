package cf.spring.springweb;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vgrigoriev - 2/10/2018
 */
@RestController
public class HelloRestController {

    @RequestMapping(value = "/hello-rest", method = RequestMethod.GET)
    public ResponseEntity<String> handle(Model model) {
        model.addAttribute("message", "Hello World!");
        return ResponseEntity.ok().body("Hello");
    }
}
