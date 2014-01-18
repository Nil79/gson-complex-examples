package com.nicolasodano.gson.example1;

import com.google.gson.*;

public class RunExample {

	/**
	 * 
	 * Deserialize the input json string into an array of contacts
	 * 
	 * @param json
	 * @return - an array of contacts
	 */
	public Contact[] deserialize(String json) {
		// Configure Gson
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Contact[].class,
				new ContactsDeserializer());
		gsonBuilder.registerTypeAdapter(Address.class,
				new AddressesDeserializer());

		Gson gson = gsonBuilder.create();

		// Retrieve data
		return gson.fromJson(json, Contact[].class);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * In this example we wish to deserialize this following string in json
		 * format: 
		 * { 
		 * 	'1': { 
		 * 			'id': '1', 
		 * 			'name': 'pippo', 
		 * 			'addresses': [{ 
		 * 				'city': 'Naples', 
		 * 				'street': 'Via Trento' 
		 * 			}, 
		 * 			{ 
		 * 				'city': 'Milan',
		 * 				'street': 'Via Adige' 
		 * 			}] 
		 * 		}, 
		 * 	'2': { 
		 * 			'id': '1', 
		 * 			'name': 'paperino', 
		 * 			'addresses': [{
		 * 				'city': 'Rome', 
		 * 				'street': 'Via Po' 
		 * 			}, 
		 * 			{ 
		 * 				'city': 'Tokyo', 
		 * 				'street': 'Via Chin' 
		 * 			}] 
		 * 		}
		 * }
		 * 
		 * For each index (1,2, etc...) we deserialize a Contact object that
		 * contains the following informations:
		 * 
		 * - id 
		 * - name 
		 * - addresses: a vector of Address objects
		 */

		// The input json string
		String myJson = "{'1':{'id': '1', 'name': 'pippo', "
				+ "'addresses': [{'city':'Naples', 'street': 'Via Trento'},"
				+ "{'city': 'Milan', 'street': 'Via Adige'}]},"
				+ " '2':{'id': '2', 'name': 'paperino', "
				+ "'addresses': [{'city':'Rome', 'street': 'Via Po'},"
				+ "{'city': 'Tokyo', 'street': 'Via Chin'}]}}".replace("'",
						"\"");

		Contact[] contacts = new RunExample().deserialize(myJson);
		
		// Print the contacts array
		for (Contact contact : contacts) {
			System.out.print("id: " + contact.getId());
			System.out.println(", name: " + contact.getName());
			Address[] addresses = contact.getAddresses();
			for (Address address : addresses) {
				System.out.println("------ Address (" + address.getCity()
						+ ", " + address.getStreet() + ")");
			}
		}

	}

}
