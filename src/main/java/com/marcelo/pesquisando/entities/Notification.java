package com.marcelo.pesquisando.entities;

public class Notification{
    public String title;
    public String body;
    
    
	public Notification(String title, String body) {
		super();
		this.title = title;
		this.body = body;
	}


	@Override
	public String toString() {
		return "Notification [title=" + title + ", body=" + body + "]";
	}
    
    
}



