package com.sagnikdas.Springbootapp.error;

public class DepartmentNotFoundException extends Exception {

	private static final long serialVersionUID = -8553665104058626597L;

	public DepartmentNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DepartmentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DepartmentNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DepartmentNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
