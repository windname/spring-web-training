package cf.spring.springweb;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author vgrigoriev - 2/10/2018
 */
@RestController
@SessionAttributes("loginTime")
public class HelloRestController {

    @RequestMapping(value = "/hello-rest", method = RequestMethod.GET)
    public ResponseEntity<String> handle(Model model) {
        return ResponseEntity.ok().body("Hello2");
    }

    // process incomming parameters

    @RequestMapping(value = "/ex1/{bookId}", method = RequestMethod.GET)
    public ResponseEntity<String> ex1(@PathVariable("bookId") String bookId, Model model) {
        return ResponseEntity.ok().body("book: " + bookId);
    }

    @RequestMapping(value = "/ex1_1/", method = RequestMethod.POST)
    public ResponseEntity<String> ex1_1(@RequestParam String bookId, Model model) {
        return ResponseEntity.ok().body("book: " + bookId);
    }

    @RequestMapping(value = "/ex1_2/", method = RequestMethod.POST)
    public ResponseEntity<String> ex1_2(@CookieValue(value = "JSESSIONID", defaultValue = "10.02.2018") String lastVisitTime, Model model) {
        return ResponseEntity.ok().body("lastVisitTime: " + lastVisitTime);
    }

    @GetMapping(value = "/ex1_3/")
    public ResponseEntity<String> ex1_3(@RequestHeader("Accept-Encoding") String encoding) {

        return ResponseEntity.ok().body("header values: " + encoding);
    }

    @GetMapping(value = "/ex1_4/")
    public ResponseEntity<String> ex1_4(@RequestParam String loginTime, Model model) {
        model.addAttribute("loginTime", loginTime + "_" + System.currentTimeMillis());
        return ResponseEntity.ok().body("loginTime: " + loginTime);
    }

    @GetMapping(value = "/ex1_4_1/")
    public ResponseEntity<String> ex1_4_1(@SessionAttribute String loginTime, Model model) {
        return ResponseEntity.ok().body("loginTime: " + loginTime);
    }

    @PostMapping(value = "/ex1_5/")
    public ResponseEntity<String> ex1_5(@RequestBody Book book, Model model) {
        return ResponseEntity.ok().body("book: " + book);
    }

    @GetMapping(value = "/ex3_1/")
    @ResponseBody
    public Book ex3_1() {
        return new Book().addName("Peter Pan");
    }




}
