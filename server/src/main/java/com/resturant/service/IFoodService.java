package com.resturant.service;

import com.resturant.dto.Result;
import com.resturant.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IFoodService extends IService<Blog> {

    Result getAllRestuant(Integer pageIndex, Integer pageNum);

    Result getRestuantDetail(Long restuantId);
}
