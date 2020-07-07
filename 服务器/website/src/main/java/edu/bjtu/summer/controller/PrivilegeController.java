package edu.bjtu.summer.controller;

import edu.bjtu.summer.model.Privilege;
import edu.bjtu.summer.service.PrivilegeService;
import edu.bjtu.summer.util.JsonTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/", method = RequestMethod.POST)
public class PrivilegeController {

    private PrivilegeService privilegeService = new PrivilegeService();

    @RequestMapping("/getPrivilegeListWithLimit")
    public JsonTemplate getPrivilegeListWithLimit(@RequestParam(value = "left", required = false) String left,
                                                  @RequestParam(value = "right", required = false) String right){
        if (left == null || left.equals("") || right == null || right.equals("")){
            return  new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        List<Privilege> privilegeList = privilegeService
                .getPrivilegeListWithLimit(Integer.parseInt(left), Integer.parseInt(right));

        jsonTemplate.addData("list_size", privilegeList.size());
        jsonTemplate.addData("privilege_list", privilegeList);
        return jsonTemplate;
    }

    @RequestMapping("/getRolePrivilege")
    public JsonTemplate getRolePrivilege(@RequestParam(value = "role_id", required = false) String role_id){
        if (role_id == null || role_id.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        List<Privilege> privilegeList = privilegeService.getRolePrivilege(Integer.parseInt(role_id));
        jsonTemplate.addData("privilege_list", privilegeList);
        jsonTemplate.addData("list_size", privilegeList.size());

        return jsonTemplate;
    }
}
