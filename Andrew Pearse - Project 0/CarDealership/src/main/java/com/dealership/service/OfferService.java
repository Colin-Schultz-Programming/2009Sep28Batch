package com.dealership.service;

import java.util.List;

import com.dealership.models.Offer;
import com.dealership.repository.OfferDAO;

public class OfferService {

	OfferDAO od;
	
	public OfferService() {
		this(new OfferDAO());
	}
	
	public OfferService(OfferDAO od) {
		this.od = od;
	}
	
	public Offer findById(int offerID) {
		return od.findById(offerID);
	}
	
	public Offer makeOffer(Offer offer) {
		return od.create(offer);
	}
	
	public List<Offer> viewAllPaymentsOnCars(String username) {
		return od.viewAllPaymentsOnCars(username);
	}
	
	public List<Offer> viewAllOffersOnACar(int cid){
		return od.viewAllOffersOnACar(cid);
	}
	
	public Offer updateOffer(Offer offer) {
		return od.update(offer);
	}
	
	public List<Offer> getAllPayments() {
		return od.getAllPayments();
	}
}