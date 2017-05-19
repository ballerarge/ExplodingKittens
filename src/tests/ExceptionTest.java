package tests;

import org.junit.Test;

import exceptions.IncorrectCardIconIDException;

public class ExceptionTest {

	@Test(expected = IncorrectCardIconIDException.class)
	public void testIncorrectCardIconIDException() throws IncorrectCardIconIDException {
		throw new IncorrectCardIconIDException();
	}
	
	@Test(expected = IncorrectCardIconIDException.class)
	public void testIncorrectCardIconIDExceptionMessage() throws IncorrectCardIconIDException {
		throw new IncorrectCardIconIDException("Error");
	}

}
