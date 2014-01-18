package com.nicolasodano.gson.example1;

import junit.framework.TestCase;

public class RunExampleTest extends TestCase {

	public void testDeserialize() {	
		String myJson = "{'1':{'id': '1', 'name': 'pippo', "
				+ "'addresses': [{'city':'Naples', 'street': 'Via Trento'},"
				+ "{'city': 'Milan', 'street': 'Via Adige'}]},"
				+ " '2':{'id': '2', 'name': 'paperino', "
				+ "'addresses': [{'city':'Rome', 'street': 'Via Po'},"
				+ "{'city': 'Tokyo', 'street': 'Via Chin'}]}}".replace("'",
						"\"");

		Contact[] contacts = new RunExample().deserialize(myJson);
		
		assertEquals("pippo", contacts[0].getName());
		assertEquals("Naples", contacts[0].getAddresses()[0].getCity());
	}
}
