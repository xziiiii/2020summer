package edu.bjtu.summer.controller;

import edu.bjtu.summer.model.Book;
import edu.bjtu.summer.service.RecommendService;
import edu.bjtu.summer.util.JsonTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(method = RequestMethod.POST)
public class RecommendController {

    private RecommendService recommendService = new RecommendService();

    @RequestMapping("/recommend/getRecommendBookList")
    public JsonTemplate getRecommendBookList(@RequestParam("user_id") String user_id){
        if (user_id == null || user_id.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        List<Book> recommend_list = recommendService.getRecommendBookList(Integer.parseInt(user_id));
        jsonTemplate.addData("list_size", recommend_list.size());
        jsonTemplate.addData("recommend_list", recommend_list);

        return jsonTemplate;
    }
}
