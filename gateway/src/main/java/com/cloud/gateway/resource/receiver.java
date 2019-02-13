package com.cloud.gateway.resource;

import com.cloud.gateway.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/gateway")
public class receiver {

    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";

    private static final String ERROR_STATUS = "error";

    private static final int CODE_SUCCESS = 100;

    private static final int AUTH_FAILURE = 102;

    @RequestMapping("/sendHello")
    public String sendHello(){

        return ("Hello");
    }


    @RequestMapping(value = "/directions", method = RequestMethod.POST)
    public String directions(@RequestParam(value = "key") String key, @RequestBody Map<String, Object> payLoad){
        BaseResponse response = new BaseResponse();
        if (sharedKey.equalsIgnoreCase(key)) {

            response.setStatus(SUCCESS_STATUS);

            response.setCode(CODE_SUCCESS);

        } else {

            response.setStatus(ERROR_STATUS);

            response.setCode(AUTH_FAILURE);

        }
        
        //payLoad.put("Status","Ack");
        return "Ack";

    }


}








