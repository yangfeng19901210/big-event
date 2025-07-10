package com.yy.pojo;

import lombok.Data;

/*********************************************************
 ** 优惠券数据
 ** <br><br>
 ** @ClassName: Coupon
 ** @author: yangfeng
 ** @date: 2025/7/8 11:24
 ** @version: 1.0.0
 *********************************************************/
@Data
public class Coupon {
    /**
     * 优惠券id
     */
    private Integer couponId;
    /**
     * 优惠券名称
     */
    private String name;
    /**
     * 优惠券类型
     */
    private Integer type;

    public Coupon() {
    }

    public Coupon(Integer couponId, String name) {
        this.couponId = couponId;
        this.name = name;
    }
}
