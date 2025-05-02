package org.example.gamedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Boolean isSuccess;
    private String errMsg;
    private Object data;
    private Long total;

    static public Result ok(){
        return new Result(true,null,null,null);
    }

    static public Result ok(Object data){
        return new Result(true, null, data, null);
    }

    static public Result ok(List<?> data,Long total){
        return new Result(true, null, data, total);
    }

    static public Result fail(String msg){
        return new Result(false, msg, null, null);
    }

}
