/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Order {
    int orderid;
    int custid;
    int accountorderid;
    Date orderDate;

    public Order() {
    }

    public Order(int orderid, int custid, int accountorderid, Date orderDate) {
        this.orderid = orderid;
        this.custid = custid;
        this.accountorderid = accountorderid;
        this.orderDate = orderDate;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public int getAccountorderid() {
        return accountorderid;
    }

    public void setAccountorderid(int accountorderid) {
        this.accountorderid = accountorderid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    
}
