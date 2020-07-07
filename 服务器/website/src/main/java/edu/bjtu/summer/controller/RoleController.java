package edu.bjtu.summer.controller;

import edu.bjtu.summer.model.Role;
import edu.bjtu.summer.service.RoleService;
import edu.bjtu.summer.util.JsonTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/", method = RequestMethod.POST)
public class RoleController {

    private RoleService roleService = new RoleService();

    @RequestMapping("/getRoleList")
    public JsonTemplate getRoleList(){
        JsonTemplate jsonTemplate = new JsonTemplate(1);
        jsonTemplate.addData("role_list", roleService.getAllRole());

        return jsonTemplate;
    }

    @RequestMapping("/addRole")
    public JsonTemplate addRole(@RequestBody Role role){
        int role_id = roleService.addRole(role);
        if (role_id != -1){
            JsonTemplate jsonTemplate = new JsonTemplate(1);
            jsonTemplate.addData("role_id", role_id);

            return jsonTemplate;
        }else{
            return new JsonTemplate(0);
        }
    }

    @RequestMapping("/updateRoleInfo")
    public JsonTemplate updateRoleInfo(@RequestBody Role role){
        if (role == null){
            return new JsonTemplate(0);
        }

        if (roleService.updateRole(role)){
            return new JsonTemplate(1);
        }else{
            return new JsonTemplate(0);
        }
    }

    @RequestMapping("/deleteRole")
    public JsonTemplate deleteRole(@RequestParam(value = "role_id", required = false) String role_id){
        if (role_id == null || role_id.equals("")){
            return new JsonTemplate(0);
        }

        if (roleService.deleteRole(Integer.parseInt(role_id))){
            return new JsonTemplate(1);
        }else{
            return new JsonTemplate(0);
        }
    }
}
