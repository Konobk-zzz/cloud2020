package com.zja.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author zhujiaao
 * @Date 2020/9/9 22:01
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    private Integer status;

}
