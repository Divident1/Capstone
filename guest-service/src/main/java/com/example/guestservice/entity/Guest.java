package com.example.guestservice.entity;

import jakarta.persistence.*;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Long eventId;

    @Enumerated(EnumType.STRING)
    private RsvpStatus rsvpStatus = RsvpStatus.PENDING;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public RsvpStatus getRsvpStatus() {
		return rsvpStatus;
	}

	public void setRsvpStatus(RsvpStatus rsvpStatus) {
		this.rsvpStatus = rsvpStatus;
	}

	public Guest(Long id, String name, String email, String phone, Long eventId, RsvpStatus rsvpStatus) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.eventId = eventId;
		this.rsvpStatus = rsvpStatus;
	}

    // Getters and Setters
    public Guest() {}
}
