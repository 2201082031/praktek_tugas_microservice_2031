/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abdi.Pembayaran.Controller;

import com.abdi.Pembayaran.Entity.Pembayaran;
import com.abdi.Pembayaran.Service.PembayaranService;
import com.abdi.Pembayaran.Service.vo.ResponseTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author M.ABDI
 */

@RestController
@RequestMapping("api/v1/pembayaran")
public class PembayaranController {

    @Autowired
    private PembayaranService pembayaranService;

    @GetMapping
    public List<Pembayaran> getAll() {
        return pembayaranService.getAll();
    }

    @PostMapping
    public void insert(@RequestBody Pembayaran pembayaran) {
        pembayaranService.insert(pembayaran);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        pembayaranService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") Long id,
                       @RequestParam(required = false) String nomorreferensi,
                       @RequestParam(required = false) String tanggal) {
        pembayaranService.update(id, nomorreferensi, tanggal);
    }

    @GetMapping(path = "/order/{id}")
    public ResponseTemplate getOrderWithOrderById(@PathVariable("id") Long id) {
        return pembayaranService.getOrderWithOrderById(id);
    }
}
