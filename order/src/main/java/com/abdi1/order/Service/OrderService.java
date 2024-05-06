/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abdi1.order.Service;
import com.abdi1.order.Entity.Order;
import com.abdi1.order.Repository.OrderRepository;
import com.abdi1.order.vo.Produk;
import com.abdi1.order.vo.ResponseTemplate;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author M.ABDI
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository OrderRepository;
    
    
     @Autowired
    private RestTemplate restTemplate;
    
    
    private int jumlah;
    private Object Jumlah;
    
    public List<Order> getAll(){
        return  OrderRepository.findAll();
    }
    public Order getOrderById(Long id){
        return OrderRepository.findById(id).get();
    }
    
    public void insert(Order Order){
        OrderRepository.save(Order);
    }
    
   
      @Transactional
    
    public void update (Long Id, String tanggal, String status, String satuan) {
     Order order = OrderRepository.findById(Id).orElseThrow(
     ()-> new IllegalStateException("Produk Tidak Ada")); 
     if (Jumlah != null){
         order.setJumlah(jumlah);
     }
      if(tanggal !=null && tanggal.length()>0
         && !Objects.equals(order.getTanggal(),tanggal)){
        order.setTanggal(tanggal);
    }
         if(status !=null && tanggal.length()>0
         && !Objects.equals(order.getStatus(),status)){
        order.setStatus(status);
    }
    }
        
      public void delete(Long Id){
        OrderRepository.deleteById(Id);
      
    }
      
      public ResponseTemplate getOrderWithProdukById(Long id){
           ResponseTemplate responseTemplate = new ResponseTemplate();
           Order order =getOrderById(id);
           Produk produk = 
                   restTemplate.getForObject ("http://localhost:9006/api/v1/produk/"
                   +order.getProdukId(),Produk.class);
           
           responseTemplate.setOrder(order);
           responseTemplate.setProduk(produk);
           return responseTemplate;
      }
      

    
    
}

   

