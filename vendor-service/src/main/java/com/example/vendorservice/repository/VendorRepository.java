package com.example.vendorservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendorservice.model.Vendor;

import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    List<Vendor> findByCategoryContainingIgnoreCase(String category);
    List<Vendor> findByNameContainingIgnoreCase(String name);
}
