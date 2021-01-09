package com.myorg.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myorg.entities.Ticket;

@Repository("ticketDao")
public interface TicketDao extends CrudRepository<Ticket, Integer> {

}
