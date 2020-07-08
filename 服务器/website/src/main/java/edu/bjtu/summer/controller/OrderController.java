package edu.bjtu.summer.controller;

import edu.bjtu.summer.model.OrderDetail;
import edu.bjtu.summer.model.OrderShipping;
import edu.bjtu.summer.model.User;
import edu.bjtu.summer.service.OrderService;
import edu.bjtu.summer.util.JsonTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(method = RequestMethod.POST)
public class OrderController {

    private OrderService orderService = new OrderService();

    @RequestMapping("/order/getStoreOrderListWithLimit")
    public JsonTemplate getStoreOrderListWithLimit(@RequestParam(required = false) String store_id,
                                                   @RequestParam(required = false) String left,
                                                   @RequestParam(required = false) String right){
        if (store_id == null || store_id.equals("")
                || left == null || left.equals("") || right == null || right.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        List<OrderDetail> orderDetailList = orderService.getStoreOrderListWithLimit(Integer.parseInt(store_id),
                Integer.parseInt(left), Integer.parseInt(right));
        jsonTemplate.addData("list_size", orderDetailList.size());
        jsonTemplate.addData("order_list", orderDetailList);

        return jsonTemplate;
    }

    @RequestMapping("/order/getOrderUser")
    public JsonTemplate getOrderUser(@RequestParam(required = false) String order_id){
        if (order_id == null || order_id.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        User user = orderService.getOrderUser(order_id);
        jsonTemplate.addData("user", user);

        return jsonTemplate;
    }

    @RequestMapping("/order/getOrderShipping")
    public JsonTemplate getOrderShipping(@RequestParam(required = false) String order_id){
        if (order_id == null || order_id.equals("")){
            return  new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        OrderShipping shipping = orderService.getOrderShipping(order_id);
        jsonTemplate.addData("order_shipping", shipping);

        return jsonTemplate;
    }
}
