package com.misael.task.management.entities.enums;

public enum Status {
	TODO("TODO"),
	DONE("DONE");
	
	private final String statusDescription;
	
	Status(String statusDescription){
		this.statusDescription = statusDescription;
	}

	public String getStatusDescription() {
		return statusDescription;
	}
		
}
