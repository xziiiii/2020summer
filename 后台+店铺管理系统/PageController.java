package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {


    //后台管理系统
    @RequestMapping("/admin_login")
    public String admin_login(){
        return "后台登录";
    }
    @RequestMapping("/admin_index")
    public String admin_index(){
        return "后台管理";
    }

    @RequestMapping("/admin_userlist")
    public String admin_userlist(){
        return "用户列表";
    }
    @RequestMapping("/admin_adduser")
    public String admin_adduser(){
        return "添加用户";
    }
    @RequestMapping("/admin_edituser")
    public String admin_edituser(){
        return "编辑用户";
    }

    @RequestMapping("/admin_rolelist")
    public String admin_rolelist(){
        return "角色列表";
    }
    @RequestMapping("/admin_addrole")
    public String admin_addrole(){
        return "新建角色";
    }
    @RequestMapping("/admin_editrole")
    public String admin_editrole(){
        return "编辑角色";
    }

    @RequestMapping("/admin_privilegelist")
    public String admin_privilegelist(){
        return "权限列表";
    }

    @RequestMapping("/admin_storelist")
    public String admin_storelist(){
        return "店铺列表";
    }
    @RequestMapping("/admin_addstore")
    public String admin_addstore(){
        return "添加店铺";
    }
    @RequestMapping("/admin_editstore")
    public String admin_editstore(){
        return "编辑店铺";
    }


    //店铺管理系统
    @RequestMapping("/store_login")
    public String store_login(){
        return "店铺管理登录";
    }
    @RequestMapping("/store_register")
    public String store_register(){
        return "店铺管理注册";
    }

    @RequestMapping("/store_index")
    public String store_index(){
        return "店铺管理";
    }
    @RequestMapping("/store_storelist")
    public String store_storelist(){
        return "店铺列表_店铺";
    }
    @RequestMapping("/store_addstore")
    public String store_addstore(){
        return "添加店铺_店铺";
    }
    @RequestMapping("/store_editstore")
    public String store_editstore(){
        return "编辑店铺_店铺";
    }

    @RequestMapping("/store_booklist")
    public String store_booklist(){
        return "图书列表";
    }
    @RequestMapping("/store_addbook")
    public String store_addbook(){
        return "添加图书";
    }
    @RequestMapping("/store_editbook")
    public String store_editbook(){
        return "编辑图书";
    }

    @RequestMapping("/store_orderlist")
    public String store_orderlist(){
        return "订单列表";
    }
    @RequestMapping("/store_orderuser")
    public String store_orderuser(){
        return "购买用户信息";
    }
    @RequestMapping("/store_ordershipping")
    public String store_ordershipping(){
        return "快递信息";
    }

}

