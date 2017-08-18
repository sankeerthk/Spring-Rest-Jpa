package io.jpa.exception;

public class NotFoundException extends RuntimeException{
 
	private static final long serialVersionUID = 1L;

	public NotFoundException(String msg){
		super(msg);
	}
	
	public NotFoundException(String msg,Throwable cause){
		super(msg, cause);
	}
}
