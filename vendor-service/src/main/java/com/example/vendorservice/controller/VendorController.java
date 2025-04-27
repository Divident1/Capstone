package com.example.vendorservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vendorservice.model.Vendor;
import com.example.vendorservice.service.VendorService;


import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "*") // allow frontend access
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.saveVendor(vendor));
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAll() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getById(@PathVariable Long id) {
        return vendorService.getVendorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/category")
    public ResponseEntity<List<Vendor>> searchByCategory(@RequestParam String category) {
        return ResponseEntity.ok(vendorService.searchByCategory(category));
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<Vendor>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(vendorService.searchByName(name));
    }
}

