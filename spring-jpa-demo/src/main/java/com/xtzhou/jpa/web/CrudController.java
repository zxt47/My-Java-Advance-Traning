package com.xtzhou.jpa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;

@RestController
public class CrudController {
    /**
     * 插入SQL
     */
    @PostMapping("/add")
    public void insertSQL() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取信息
     *
     * @param id ID
     * @return 用户结果
     */
    @GetMapping("get")
    public ApiResult userinfo(@RequestBody String id) {
        return new ApiResult();
    }
}
