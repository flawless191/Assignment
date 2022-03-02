/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class Product {

    int pid;
    String productName;
    String productImg;
    int productPrice;
    String productNote;
    int productCategory;
    int cid;

    public Product() {
    }

    public Product(int pid, String productName, String productImg, int productPrice, String productNote, int productCategory, int cid) {
        this.pid = pid;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.productNote = productNote;
        this.productCategory = productCategory;
        this.cid = cid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductNote() {
        return productNote;
    }

    public void setProductNote(String productNote) {
        this.productNote = productNote;
    }

    public int getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }

}
