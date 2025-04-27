package com.example.guestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.guestservice.entity.Guest;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByEventId(Long eventId);
}