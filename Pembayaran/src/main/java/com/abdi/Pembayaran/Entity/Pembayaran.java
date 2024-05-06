/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.abdi.Pembayaran.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

///@author M.ABDI

@Entity
@Table(name=" t_pembayaran")
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private int modepembayaran;
    private String nomorreferensi;
    private String tanggal;
    private double total;
    
    
     public Pembayaran() {
    }

    public Pembayaran(Long id, Long orderId, int  modepembayaran, String nomorreferensi,String tanggal,double total) {
        this.id = id;
        this.orderId = orderId;
        this.modepembayaran = modepembayaran;
        this.nomorreferensi =nomorreferensi;
        this.tanggal = tanggal;
        this.total = total;
     
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getModepembayaran() {
        return modepembayaran;
    }

    public void setModepembayaran(int modepembayaran) {
        this.modepembayaran = modepembayaran;
    }

    public String getNomorreferensi() {
        return nomorreferensi;
    }

    public void setNomorreferensi(String nomorreferensi) {
        this.nomorreferensi = nomorreferensi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pembayaran{" + "id=" + id + ", orderId=" + orderId + ", modepembayaran=" + modepembayaran + ", nomorreferensi=" + nomorreferensi + ", tanggal=" + tanggal + ", total=" + total + '}';
    }

    
}
