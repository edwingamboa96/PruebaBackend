/**
 * 
 */
package com.daviplata.app.exceptions;

/**
 * @author Edwin Gamboa Sanchez
 * @version 17/06/2020
 * @since 17/06/2020
 */
public class ServiceException extends Exception {


	private static final long serialVersionUID = 1L;

	public ServiceException(String mensaje)
    {
        super(mensaje);
    }
    
       public ServiceException(String mensaje,Throwable cause)
    {
        super(mensaje,cause);
    }
	

}
