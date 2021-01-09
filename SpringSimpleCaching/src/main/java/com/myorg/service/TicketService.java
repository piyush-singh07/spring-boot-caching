package com.myorg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.myorg.dao.TicketDao;
import com.myorg.entities.Ticket;

@Service("ticketService")
public class TicketService {
	
	@Autowired
	private TicketDao ticketDao;
	
	public Ticket createTicket(Ticket ticket) {
				return ticketDao.save(ticket);
	}
	
	@Cacheable(value="ticketsCache",key="#ticketId")
	public Optional<Ticket> getTicketById(Integer ticketId) {
				return ticketDao.findById(ticketId);
	}

	//@Cacheable(value="ticketsallCache")
	public Iterable<Ticket> getAllBookedTickets() {
		
		return ticketDao.findAll();
	}

	@CacheEvict(value="ticketsCache",key="#ticketId")
	public void deleteBookedTicket(Integer ticketId) {
		
		ticketDao.deleteById(ticketId);
	}

	@CachePut(value="ticketsCache",key="#ticketId")
		public Ticket updateBookedTicket(Integer ticketId, String newEmail) {
		
		Ticket ticket=ticketDao.findById(ticketId).
				orElse(new Ticket());
		ticket.setEMail(newEmail);
		ticketDao.save(ticket);
		return ticket;
	}
}
