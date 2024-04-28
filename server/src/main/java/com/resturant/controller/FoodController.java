package com.resturant.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.resturant.dto.Result;
import com.resturant.dto.UserDTO;
import com.resturant.entity.Blog;
import com.resturant.entity.User;
import com.resturant.service.IFoodService;
import com.resturant.utils.SystemConstants;
import com.resturant.utils.UserHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Resource
    private IFoodService foodService;

    @GetMapping("/getAllRestuant")
    public Result getAllRestuant(@PathVariable("PageIndex") Long pageIndex = 1, @PathVariable("PageNum") Long pageNum = 10) {
        return foodService.querAllRestuant(pageIndex, pageNum);
    }

    @GetMapping("/getRestuantDetail")
    public Result getRestuantDetail(@PathVariable("restuantId") String restuantId = "" {
        return foodService.getRestuantDetail(restuantId);
    }
}
