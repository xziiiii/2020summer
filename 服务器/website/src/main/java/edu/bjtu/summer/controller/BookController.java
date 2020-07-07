package edu.bjtu.summer.controller;

import edu.bjtu.summer.model.Book;
import edu.bjtu.summer.service.BookService;
import edu.bjtu.summer.util.JsonTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book/", method = RequestMethod.POST)
public class BookController {

    BookService bookService = new BookService();

    @RequestMapping("/addBook")
    public JsonTemplate addBook(@RequestBody Book book){
        long book_id = bookService.addBook(book);

        if (book_id != -1){
            JsonTemplate jsonTemplate = new JsonTemplate(1);
            jsonTemplate.addData("book_id", book_id);

            return jsonTemplate;
        }else{
            return new JsonTemplate(0);
        }
    }
}
