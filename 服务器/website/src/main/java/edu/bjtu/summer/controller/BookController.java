package edu.bjtu.summer.controller;

import edu.bjtu.summer.model.Book;
import edu.bjtu.summer.model.BookCategory;
import edu.bjtu.summer.service.BookService;
import edu.bjtu.summer.util.JsonTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/book/", method = RequestMethod.POST)
public class BookController {

    private BookService bookService = new BookService();

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

    @RequestMapping("/getStoreBookListWithLimit")
    public JsonTemplate getStoreBookList(@RequestParam(required = false) String store_id,
                                         @RequestParam(required = false) String left,
                                         @RequestParam(required = false) String right){
        if (store_id == null || store_id.equals("")
                || left == null || left.equals("")
                || right == null || right.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        List<Book> bookList = bookService.getStoreBookList(Integer.parseInt(store_id),
                Integer.parseInt(left), Integer.parseInt(right));

        jsonTemplate.addData("list_size", bookList.size());
        jsonTemplate.addData("book_list", bookList);
        return jsonTemplate;
    }

    @RequestMapping("/deleteBook")
    public JsonTemplate deleteBook(@RequestParam(required = false) String book_id){
        if (book_id == null || book_id.equals("")){
            return new JsonTemplate(0);
        }

        if (bookService.deleteBook(Long.parseLong(book_id))){
            return new JsonTemplate(1);
        }else{
            return new JsonTemplate(0);
        }
    }

    @RequestMapping("/getBookCategoryList")
    public JsonTemplate getBookCategoryList(){
        JsonTemplate jsonTemplate = new JsonTemplate(1);

        List<BookCategory> categoryList = bookService.getBookCategoryList();
        jsonTemplate.addData("category_list", categoryList);
        jsonTemplate.addData("list_size", categoryList.size());

        return jsonTemplate;
    }

    @RequestMapping("/getCategoryBookListWithLimit")
    public JsonTemplate getCategoryBookListWithLimit(@RequestParam(required = false) String cate_id,
                                                     @RequestParam(required = false) String left,
                                                     @RequestParam(required = false) String right){
        if (cate_id == null || cate_id.equals("")
                || left == null || left.equals("") || right == null || right.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        List<Book> bookList = bookService.getCategoryBookListWithLimit(Integer.parseInt(cate_id),
                Integer.parseInt(left), Integer.parseInt(right));
        jsonTemplate.addData("book_list", bookList);
        jsonTemplate.addData("list_size", bookList.size());

        return jsonTemplate;
    }

    @RequestMapping("/getBookListByKeywordWithLimit")
    public JsonTemplate getBookListByKeywordWithLimit(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false) String left,
                                                      @RequestParam(required = false) String right){
        if (keyword == null || keyword.equals("")
                || left == null || left.equals("") || right == null || right.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        List<Book> bookList = bookService.getBookListByKeywordWithLimit(keyword,
                Integer.parseInt(left), Integer.parseInt(right));
        jsonTemplate.addData("book_list", bookList);
        jsonTemplate.addData("list_size", bookList.size());

        return jsonTemplate;
    }

    @RequestMapping("/getBookAverageRating")
    public JsonTemplate getBookRating(@RequestParam(required = false) String book_id){
        if (book_id == null || book_id.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        Map<String, String> map = bookService.getBookAverageRating(Long.parseLong(book_id));
        jsonTemplate.addData("avg_rating", map.get("rating"));
        jsonTemplate.addData("number", map.get("number"));

        return jsonTemplate;
    }

    @RequestMapping("/getBookRankListByRatingWithLimit")
    public JsonTemplate getBookRankListByRatingWithLimit(@RequestParam(required = false) String left,
                                                         @RequestParam(required = false) String right){
        if (left == null || left.equals("") || right == null || right.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        List<Map<String, String>> mapList
                = bookService.getBookRankListByRatingWithLimit(Integer.parseInt(left), Integer.parseInt(right));
        jsonTemplate.addData("list_size", mapList.size());
        jsonTemplate.addData("rank_list", mapList);

        return jsonTemplate;
    }
}
