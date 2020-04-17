package com.personal.content_center.entity.content;

import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "oms_order_item")
public class OmsOrderItem {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 订单编号
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 商品图片
     */
    @Column(name = "product_pic")
    private String productPic;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品品牌
     */
    @Column(name = "product_brand")
    private String productBrand;

    /**
     * 商品条码
     */
    @Column(name = "product_sn")
    private String productSn;

    /**
     * 销售价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 购买数量
     */
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /**
     * 商品sku编号
     */
    @Column(name = "product_sku_id")
    private Long productSkuId;

    /**
     * 商品sku条码
     */
    @Column(name = "product_sku_code")
    private String productSkuCode;

    /**
     * 商品分类id
     */
    @Column(name = "product_category_id")
    private Long productCategoryId;

    /**
     * 商品的销售属性1
     */
    private String sp1;

    /**
     * 商品的销售属性2
     */
    private String sp2;

    /**
     * 商品的销售属性3
     */
    private String sp3;

    /**
     * 商品促销名称
     */
    @Column(name = "promotion_name")
    private String promotionName;

    /**
     * 商品促销分解金额
     */
    @Column(name = "promotion_amount")
    private BigDecimal promotionAmount;

    /**
     * 优惠券优惠分解金额
     */
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;

    /**
     * 积分优惠分解金额
     */
    @Column(name = "integration_amount")
    private BigDecimal integrationAmount;

    /**
     * 该商品经过优惠后的分解金额
     */
    @Column(name = "real_amount")
    private BigDecimal realAmount;

    /**
     * 商品赠送积分
     */
    @Column(name = "gift_integration")
    private Integer giftIntegration;

    /**
     * 商品赠送成长值
     */
    @Column(name = "gift_growth")
    private Integer giftGrowth;

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    @Column(name = "product_attr")
    private String productAttr;
}