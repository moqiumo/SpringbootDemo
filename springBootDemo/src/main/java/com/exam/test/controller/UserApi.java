//package com.exam.test.controller;
//
//import com.exam.test.common.TokenService;
//import com.exam.test.common.TokenUtil;
//import com.exam.test.common.UserLoginToken;
//import com.exam.test.service.UserService;
//import com.exam.test.vo.User;
//import net.minidev.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Create By  on
// */
//@RestController
//public class UserApi {
//    @Autowired
//    UserService userService;
//    @Autowired
//    TokenService tokenService;
//
//    // 登录
//    @GetMapping("/login")
//    public Object login(User user, HttpServletResponse response) {
//        JSONObject jsonObject = new JSONObject();
//        User userForBase = new User();
//        userForBase.setId("1");
//        userForBase.setPassword("123");
//        userForBase.setUsername("mrc");
//
//        if (!userForBase.getPassword().equals(user.getPassword())) {
//            jsonObject.put("message", "登录失败,密码错误");
//            return jsonObject;
//        } else {
//            String token = tokenService.getToken(userForBase);
//            jsonObject.put("token", token);
//
//            Cookie cookie = new Cookie("token", token);
//            cookie.setPath("/");
//            response.addCookie(cookie);
//
//            return jsonObject;
//
//        }
//    }
//
//    /***
//     * 这个请求需要验证token才能访问
//     *
//     * @author: MRC
//     * @date 2019年5月27日 下午5:45:19
//     * @return String 返回类型
//     */
//    @UserLoginToken
//    @GetMapping("/getMessage")
//    public String getMessage() {
//
//        // 取出token中带的用户id 进行操作
//        System.out.println(TokenUtil.getTokenUserId());
//
//        return "你已通过验证";
//    }
//}
//}
