package com.example.demo.entity;

public class Goods {
    private Integer id; //商品Id
    private String productName; //商品名称
    private Double price; //商品价格
    private String productPic; //商品图片
    private Integer productNum; //商品数量
    private Integer classFirestId; //所属的一级分类
    private Integer classSecId; //所属的二级分类
    private String productContent ; //商品信息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Integer getClassFirestId() {
        return classFirestId;
    }

    public void setClassFirestId(Integer classFirestId) {
        this.classFirestId = classFirestId;
    }

    public Integer getClassSecId() {
        return classSecId;
    }

    public void setClassSecId(Integer classSecId) {
        this.classSecId = classSecId;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }
}
