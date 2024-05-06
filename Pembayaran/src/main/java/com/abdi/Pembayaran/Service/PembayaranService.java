package com.abdi.Pembayaran.Service;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.abdi.Pembayaran.Entity.Pembayaran;
import com.abdi.Pembayaran.Repository.PembayaranRepository;
import com.abdi.Pembayaran.Service.vo.Order;
import com.abdi.Pembayaran.Service.vo.ResponseTemplate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Objects;


@Service
public class PembayaranService {

    @Autowired
    private PembayaranRepository pembayaranRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    private int modepembayaran;
    private Object Modepembayaran;
    
    public List<Pembayaran> getAll() {
        return pembayaranRepository.findAll();
    }

    public Pembayaran getOrderById(Long id) {
    return pembayaranRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("Pembayaran dengan ID " + id + " tidak ditemukan"));
    }

    public void insert(Pembayaran pembayaran) {
        pembayaranRepository.save(pembayaran);
    }

    
      @Transactional
    
    public void update (Long Id, String nomorreferensi, String tanggal) {
     Pembayaran pembayaran =  pembayaranRepository.findById(Id).orElseThrow(
     ()-> new IllegalStateException("Order Tidak Ada")); 

   if (Modepembayaran!= null){
         pembayaran.setModepembayaran(modepembayaran);
     }
      if(nomorreferensi !=null && nomorreferensi.length()>0
         && !Objects.equals(pembayaran.getNomorreferensi(),nomorreferensi)){
       pembayaran.setNomorreferensi(nomorreferensi);
    }
         if(tanggal !=null && tanggal.length()>0
         && !Objects.equals(pembayaran.getTanggal (),tanggal)){
       pembayaran.setTanggal(tanggal);
    }
    }

    public void delete(Long id) {
        pembayaranRepository.deleteById(id);
    }
 public ResponseTemplate getOrderWithOrderById(Long id) {
    ResponseTemplate responseTemplate = new ResponseTemplate();
    Pembayaran pembayaran = getOrderById(id);
     Order order =
                    restTemplate.getForObject ("http://localhost:9007/api/v1/order/"
                   +pembayaran.getOrderId(), Order.class);
           
           responseTemplate.setPembayaran(pembayaran);
           responseTemplate.setOrder(order);
           return responseTemplate;
 }
}

