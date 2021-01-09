package com.myorg.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.entities.Ticket;
import com.myorg.service.TicketService;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketBookingService;
	
	@PostMapping(value = "/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.createTicket(ticket);
	}

	@GetMapping(value = "/ticket/{ticketId}")
	public Optional<Ticket> getTicketById(@PathVariable("ticketId") Integer ticketId,
			@RequestParam("isCacheable") Boolean isCacheable) {

		return ticketBookingService.getTicketById(ticketId,isCacheable);

	}

	@GetMapping(value = "/ticket/allTickets")
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingService.getAllBookedTickets();
	}

	@DeleteMapping(value = "/ticket/{ticketId}")
	public void deleteBookedTicket(@PathVariable("ticketId") Integer ticketId) {

		ticketBookingService.deleteBookedTicket(ticketId);

	}

	@PutMapping(value = "/ticket/{ticketId}/{newEmail}")
	public Ticket updateBookedTicket(@PathVariable("ticketId") Integer ticketId,
			@PathVariable("newEmail") String newEmail) {

		return ticketBookingService.updateBookedTicket(ticketId, newEmail);

	}

}
