package com.example.vendorservice.service;


import org.springframework.stereotype.Service;

import com.example.vendorservice.model.Vendor;
import com.example.vendorservice.repository.VendorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }

    public List<Vendor> searchByCategory(String category) {
        return vendorRepository.findByCategoryContainingIgnoreCase(category);
    }

    public List<Vendor> searchByName(String name) {
        return vendorRepository.findByNameContainingIgnoreCase(name);
    }
}
