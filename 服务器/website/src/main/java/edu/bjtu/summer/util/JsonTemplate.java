package edu.bjtu.summer.util;

import java.util.HashMap;
import java.util.Map;

public class JsonTemplate {

    private int code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public JsonTemplate(int code, String message){
        this.code = code;
        this.message = message;
    }

    public JsonTemplate(int code){
        message = (code == 1) ? "success" : "fail";
        this.code = code;
    }

    public void addData(String key, Object value){
        data.put(key, value);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
