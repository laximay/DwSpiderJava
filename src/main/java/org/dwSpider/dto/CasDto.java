package org.dwSpider.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenjing on 2017/3/16.
 */
public class CasDto <T> implements Serializable {

    public final static int SUCCESS = 1;
    public final static int FAIL = 0;

    private static final long serialVersionUID = 1596948553456839650L;
    //返回状态，1成功，0失败
    private int status;
    //返回消息
    private String msg;
    //返回对象
    private T content;

    //成功时候调用的构造函数
    public CasDto(int status, String msg, T content) {
        this.status = status;
        this.msg = msg;
        this.content = content;
    }
    //失败时候的调用的构造函数
    public CasDto(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }


    public Map<String, Object> toAppendMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", msg);
        map.put("resultCode", status);
        map.put("content", content);
        return map;
    }
    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("status",this.getStatus());
        map.put("msg",this.getMsg());
        map.put("content",this.getContent());
        return map;
    }

    @Override
    public String toString() {
        return "CasDto{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }
}
