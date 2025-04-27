package com.example.guestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.guestservice.dto.GuestDTO;
import com.example.guestservice.entity.Guest;
import com.example.guestservice.entity.RsvpStatus;
import com.example.guestservice.services.GuestService;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping
    public ResponseEntity<Guest> addGuest(@RequestBody GuestDTO guestDTO) {
        return ResponseEntity.ok(guestService.addGuest(guestDTO));
    }

    @PutMapping("/{id}/rsvp")
    public ResponseEntity<Guest> updateRsvp(@PathVariable Long id, @RequestParam RsvpStatus status) {
        return ResponseEntity.ok(guestService.updateRsvpStatus(id, status));
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Guest>> getGuestsByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(guestService.getGuestsByEvent(eventId));
    }
}
