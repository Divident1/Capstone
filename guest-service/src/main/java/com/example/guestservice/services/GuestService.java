package com.example.guestservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.guestservice.dto.GuestDTO;
import com.example.guestservice.entity.Guest;
import com.example.guestservice.entity.RsvpStatus;
import com.example.guestservice.repository.GuestRepository;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired(required = false) // optional dependency for notification
    private NotificationService notificationService;

    public Guest addGuest(GuestDTO guestDTO) {
        Guest guest = new Guest();
        guest.setName(guestDTO.name);
        guest.setEmail(guestDTO.email);
        guest.setPhone(guestDTO.phone);
        guest.setEventId(guestDTO.eventId);
        guest.setRsvpStatus(RsvpStatus.PENDING);

        Guest saved = guestRepository.save(guest);

        if (notificationService != null) {
            notificationService.sendSms(saved.getPhone(), "Hi " + saved.getName() + ", you're invited to an event. RSVP now!");
        }

        return saved;
    }

    public Guest updateRsvpStatus(Long id, RsvpStatus status) {
        Guest guest = guestRepository.findById(id).orElseThrow();
        guest.setRsvpStatus(status);
        return guestRepository.save(guest);
    }

    public List<Guest> getGuestsByEvent(Long eventId) {
        return guestRepository.findByEventId(eventId);
    }
}
