/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abdi1.order.vo;

import com.abdi1.order.Entity.Order;

/**
 *
 * @author M.ABDI
 */
public class ResponseTemplate {
    Order Order;
    Produk produk;

    public ResponseTemplate() {
    }

    public ResponseTemplate(Order Order, Produk produk) {
        this.Order = Order;
        this.produk = produk;
    }

    public Order getOrder() {
        return Order;
    }

    public void setOrder(Order Order) {
        this.Order = Order;
    }

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    
   
    
    
    

}
