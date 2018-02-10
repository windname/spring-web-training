package cf.spring.springweb;

import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    @PostMapping(value = "/ex1_6/")
    public ResponseEntity<String> ex1_5(HttpEntity<Book> httpEntity, Model model) {
        return ResponseEntity.ok().body("book: " + httpEntity.getBody() + " and headre response is "
                + httpEntity.getHeaders().getContentType());
    }

    @PostMapping(value = "/ex3_1/")
    @ResponseStatus(HttpStatus.CREATED)
    public void ex3_1(@RequestBody Book book) {
        System.out.print("Insert new book" + book);
    }

    @PostMapping(value = "/ex3_2/")
    public HttpEntity<String>  ex3_2(@RequestBody Book book) {
        System.out.print("Insert new book" + book);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("Cache-Control", Arrays.asList("max-age=3600"));

        HttpEntity<String> responseEntity = new HttpEntity<>("my response body", headers);
        return responseEntity;
    }

    @GetMapping(value = "/ex3_3/")
    @ResponseBody
    public Book ex3_3() {
        return new Book().addName("Peter Pan");
    }

    @GetMapping(value = "/ex3_3_1/", produces = MediaType.APPLICATION_XML_VALUE)
//    @ResponseBody Optional for rest controller
    public Book ex3_3_1() {
        return new Book().addName("Peter Pan").addId(2);
    }

    @GetMapping(value = "/ex3_4/")
    @ResponseBody
    public ResponseEntity<Book> ex3_4() {
        return ResponseEntity.ok().body(new Book().addName("Peter Pan"));
    }

    @GetMapping(value = "/ex3_5/")
    @ResponseBody
    public ModelAndView ex3_5() {
        List<Book> list = new ArrayList<>();
        list.add(new Book().addName("Peter Pan"));
        list.add(new Book().addName("Tom Sawer"));
        return new ModelAndView("books").addObject("bookList", list);
    }


}
