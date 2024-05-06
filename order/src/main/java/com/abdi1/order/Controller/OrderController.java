/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abdi1.order.Controller;

import com.abdi1.order.Entity.Order;
import com.abdi1.order.Service.OrderService;
import com.abdi1.order.vo.ResponseTemplate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author M.ABDI
 */
@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    
    @Autowired
    private OrderService OrderService;
    
    @GetMapping
    public List<Order> getAll(){
        return OrderService.getAll();
    }
    
    @PostMapping
    public void insert(@RequestBody Order order){
        OrderService.insert(order);
    }
     @DeleteMapping(path = "{Id}")
    public void delete(@PathVariable("Id") Long Id){
        OrderService.delete(Id);
    }
    
     @PutMapping(path = "{id}")
    public void update(@PathVariable("id")Long id,
            @RequestParam(required =false) String jumlah,
            @RequestParam(required =false) String tanggal,
            @RequestParam(required =false) String satuan)
           
    {
        OrderService.update(id, jumlah, tanggal, satuan);
    }

    @GetMapping (path = "/produk/{Id}")
    public ResponseTemplate  getOrderWithProdukById(
            @PathVariable("Id")Long Id){
      return OrderService.getOrderWithProdukById(Id);
}
}



