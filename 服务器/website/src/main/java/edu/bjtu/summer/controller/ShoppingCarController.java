package edu.bjtu.summer.controller;

import edu.bjtu.summer.model.ShoppingCarDetail;
import edu.bjtu.summer.service.ShoppingCarService;
import edu.bjtu.summer.util.JsonTemplate;
import org.apache.ibatis.annotations.Insert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shopping_car/", method = RequestMethod.POST)
public class ShoppingCarController {

    private ShoppingCarService carService = new ShoppingCarService();

    @RequestMapping("/getUserCarInfo")
    public JsonTemplate getUserCarInfo(@RequestParam(required = false) String user_id){
        if (user_id == null || user_id.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        List<ShoppingCarDetail> detailList = carService.getUserCarInfo(Integer.parseInt(user_id));
        jsonTemplate.addData("list_size", detailList.size());
        jsonTemplate.addData("car_list", detailList);

        return jsonTemplate;
    }

    @RequestMapping("/addBook")
    public JsonTemplate addBook(@RequestParam(required = false) String user_id,
                                @RequestParam(required = false) String book_id,
                                @RequestParam(required = false) String amount,
                                @RequestParam(required = false) String unit_price){
        if (user_id == null || user_id.equals("") || book_id == null || book_id.equals("")
                || amount == null || amount.equals("") || unit_price == null || unit_price.equals("")){
            return new JsonTemplate(0);
        }

        boolean result = carService.addBook(Integer.parseInt(user_id), Long.parseLong(book_id),
                Integer.parseInt(amount), Double.parseDouble(unit_price));
        if (result){
            return new JsonTemplate(1);
        }else{
            return new JsonTemplate(0);
        }
    }

    @RequestMapping("/deleteBook")
    public JsonTemplate deleteBook(@RequestParam(required = false) String user_id,
                                   @RequestParam(required = false) String book_id){
        if (user_id == null || user_id.equals("") || book_id == null || book_id.equals("")){
            return new JsonTemplate(0);
        }

        if (carService.deleteBook(Integer.parseInt(user_id), Long.parseLong(book_id))){
            return new JsonTemplate(1);
        }else{
            return new JsonTemplate(0);
        }
    }

    @RequestMapping("/clearCar")
    public JsonTemplate clearCar(@RequestParam(required = false) String user_id){
        if (user_id == null || user_id.equals("")){
            return new JsonTemplate(0);
        }

        if (carService.clearCar(Integer.parseInt(user_id))){
            return new JsonTemplate(1);
        }else{
            return new JsonTemplate(0);
        }
    }
}
