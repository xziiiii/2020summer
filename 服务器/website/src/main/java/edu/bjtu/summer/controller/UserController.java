package edu.bjtu.summer.controller;

import edu.bjtu.summer.model.Role;
import edu.bjtu.summer.model.TestModel;
import edu.bjtu.summer.model.User;
import edu.bjtu.summer.service.RoleService;
import edu.bjtu.summer.service.UserService;
import edu.bjtu.summer.util.JsonTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public JsonTemplate login(@RequestParam(value = "user_id", required = false) String userId,
                              @RequestParam(value = "password", required = false) String password){
        if (userId == null || userId.equals("") || password == null || password.equals("")){
            return new JsonTemplate(0);
        }else{
            int user_id = Integer.parseInt(userId);

            UserService userService = new UserService();
            if (!userService.judgeLogin(user_id, password)){
                return new JsonTemplate(0);
            }

            JsonTemplate jsonTemplate = new JsonTemplate(1);
            RoleService roleService = new RoleService();
            Role role = roleService.getRoleByUserId(user_id);
            jsonTemplate.addData("role", role);

            return jsonTemplate;
        }
    }

    @RequestMapping(value = "/admin/getUserListWithLimit", method = RequestMethod.POST)
    public JsonTemplate getUserListWithLimit(@RequestParam(value = "left", required = false) String left,
                                             @RequestParam(value = "right", required = false) String right){
        if (left == null || left.equals("") || right == null || right.equals("")){
            return new JsonTemplate(0);
        }else{
            UserService userService = new UserService();
            JsonTemplate jsonTemplate = new JsonTemplate(1);
            List<User> userList = userService.getUserListWithLimit(Integer.parseInt(left), Integer.parseInt(right));
            int listSize = userList.size();
            jsonTemplate.addData("user_list", userList);
            jsonTemplate.addData("list_size", listSize);

            return jsonTemplate;
        }
    }

    @RequestMapping(value = "/admin/updateUserInfo", method = RequestMethod.POST)
    public JsonTemplate updateUserInfo(@RequestBody User user){
        UserService userService = new UserService();

        if (userService.updateUser(user)){
            return new JsonTemplate(1);
        }else{
            return new JsonTemplate(0);
        }
    }



//    @RequestMapping(value = "/admin/updateUserInfo", method = RequestMethod.POST)
//    public JsonTemplate updateUserInfo(@RequestParam(value = "user_id", required = false) String user_id,
//                                       @RequestParam(value = "nickname", required = false) String nickname,
//                                       @RequestParam(value = "password", required = false) String password,
//                                       @RequestParam(value = "gender", required = false) String gender,
//                                       @RequestParam(value = "email", required = false) String email,
//                                       @RequestParam(value = "phone", required = false) String phone,
//                                       @RequestParam(value = "zip_code", required = false) String zip_code,
//                                       @RequestParam(value = "location", required = false) String location,
//                                       @RequestParam(value = "age", required = false) String age,
//                                       @RequestParam(value = "country", required = false) String country,
//                                       @RequestParam(value = "detail_address", required = false), String detail_)

}
