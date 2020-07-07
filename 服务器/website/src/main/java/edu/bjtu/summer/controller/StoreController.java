package edu.bjtu.summer.controller;

import edu.bjtu.summer.model.Store;
import edu.bjtu.summer.service.StoreService;
import edu.bjtu.summer.util.JsonTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin", method = RequestMethod.POST)
public class StoreController {

    private StoreService storeService = new StoreService();

    @RequestMapping("/getStoreListWithLimit")
    public JsonTemplate getStoreListWithLimit(@RequestParam(value = "left", required = false) String left,
                                              @RequestParam(value = "right", required = false) String right){
        if (left == null || left.equals("") || right == null || right.equals("")){
            return new JsonTemplate(0);
        }

        JsonTemplate jsonTemplate = new JsonTemplate(1);
        List<Store> storeList = storeService.getStoreListWithLimit(Integer.parseInt(left), Integer.parseInt(right));
        jsonTemplate.addData("list_size", storeList.size());
        jsonTemplate.addData("store_list", storeList);

        return jsonTemplate;
    }

    @RequestMapping("/addStore")
    public JsonTemplate addStore(@RequestBody Store store){
        int store_id  = storeService.addStore(store);

        if (store_id != -1){
            JsonTemplate jsonTemplate = new JsonTemplate(1);
            jsonTemplate.addData("store_id", store_id);
            return jsonTemplate;
        }else{
            return new JsonTemplate(0);
        }
    }

    @RequestMapping("/updateStoreInfo")
    public JsonTemplate updateStore(@RequestBody Store store){
        if (storeService.updateStore(store)){
            return new JsonTemplate(1);
        }else {
            return new JsonTemplate(0);
        }
    }

    @RequestMapping("/deleteStore")
    public JsonTemplate deleteStore(@RequestParam(value = "store_id", required = false) String store_id){
        if (store_id == null || store_id.equals("")){
            return new JsonTemplate(0);
        }

        if (storeService.deleteStore(Integer.parseInt(store_id))){
            return new JsonTemplate(1);
        }else{
            return new JsonTemplate(0);
        }
    }
}
