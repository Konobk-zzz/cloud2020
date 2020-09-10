package com.zja.springcloud.dao;

import com.zja.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhujiaao
 * @Date 2020/9/9 22:07
 * @Version 1.0
 */
@Mapper
public interface OrderMapper {

    void create(Order order);

    void update(@Param("userId")Long userId,@Param("status") Integer status);
}
