/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.abdi.Pembayaran.Repository;
import com.abdi.Pembayaran.Entity.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
/**
 *
 * @author M.ABDI
 */
 
@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, Long> {
    
}