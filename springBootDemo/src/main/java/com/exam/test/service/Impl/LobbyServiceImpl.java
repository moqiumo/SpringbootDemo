package com.exam.test.service.Impl;

import com.exam.test.mapper.LobbyMapper;
import com.exam.test.service.LobbyService;
import com.exam.test.vo.Account;
import com.exam.test.vo.Menu;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LobbyServiceImpl implements LobbyService {
    @Autowired
    private LobbyMapper lobbyMapper;
    @Override
    public List<Menu> findAllMenu() {
        return lobbyMapper.findAllMenu();
    }

    @Override
    public List<Account> findAccount(String projectType) {
        return lobbyMapper.findAccount(projectType);
    }

//    @Override
//    public Object hpjyLottery() {
//        String url = "http://xxx.com/v1/query?projectCode=ALL&encrypt=NONE";
//        Map<String,String> headers = new HashMap<String,String>();
//        headers.put("accept","application/json;charset=UTF-8");
//        headers.put("Content-Type","application/json;charset=UTF-8");
//
//        Map<String,Object> bodyParams = new HashMap<String,Object>();
//        bodyParams.put("realName", "xxx");
//        bodyParams.put("idCard", "xxx");
//        bodyParams.put("phoneNumber", "xxx");
//
//        //效果如上
////        ObjectNode object = mapper.readValue("{\n" +
////                "\"idCard\": \"xxx\",\n" +
////                "\"phoneNumber\": \"xxx\",\n" +
////                "\"realName\": \"xxx\"\n" +
////                "}", ObjectNode.class);
//
//        //post 请求
//        HttpResponse<JsonNode> httpResponse = Unirest.post(url)
//                .headers(headers)
//                .body(mapper.writeValueAsString(bodyParams))
//                .asJson();
//        System.out.println(httpResponse.toString());
//    }
//        return null;


}
