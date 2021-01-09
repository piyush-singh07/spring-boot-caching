package com.myorg.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ticket")
@Getter
@Setter
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	
	@Column(name="passenger_name",nullable=false)
	private String passengerName;
	
	@Column(name="booking_date")
	private Date bookingDate;

	
	@Column(name="source_station")
	private String sourceStation;
	
	@Column(name="dest_station")
	private String destinationStation;
	
	@Column(name="email")
	private String eMail;

}
