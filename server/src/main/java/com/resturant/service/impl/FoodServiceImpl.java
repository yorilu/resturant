package com.resturant.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.resturant.entity.Resturant;
import com.resturant.mapper.ResturantMapper;
import com.resturant.service.IResturantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl extends ServiceImpl<ResturantMapper, Resturant> implements IFoodService {
    @Override
    public Result getAllRestuant(Long pageIndex, Long pageNum,) {
        Page<Resturant> page = query()
                .page(new Page<>(pageIndex, pageNum)));
        // 获取当前页数据
        List<Resturant> records = page.getRecords();
        return Result.ok(records);
    }

    @Override
    public Result getRestuantDetail(Long restuantId) {
        Page<Resturant> page = query()
                .page(new Page<>(restuantId));
        // 获取当前页数据
        List<Resturant> records = page.getRecords();
        return Result.ok(records[0]);
    }
}
