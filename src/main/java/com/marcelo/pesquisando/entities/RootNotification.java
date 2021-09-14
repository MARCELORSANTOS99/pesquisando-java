package com.marcelo.pesquisando.entities;

import java.util.List;

public class RootNotification{
    public Notification notification;
    public List<String> registration_ids;
    
    
	public RootNotification(Notification notification, List<String> registration_ids) {
		super();
		this.notification = notification;
		this.registration_ids = registration_ids;
	}


	@Override
	public String toString() {
		return "RootNotification [sendNotification=" + notification + ", registration_ids=" + registration_ids + "]";
	}
    
	
	
    
}