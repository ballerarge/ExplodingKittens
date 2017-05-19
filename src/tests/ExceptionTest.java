package tests;

import org.junit.Test;

import exceptions.IncorrectCardIconIDException;

public class ExceptionTest {

	@Test(expected = IncorrectCardIconIDException.class)
	public void testIncorrectCardIconIDException() throws IncorrectCardIconIDException {
		throw new IncorrectCardIconIDException();
	}

}
