package com.nicolasodano.gson.example1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class ContactsDeserializer implements JsonDeserializer<Contact[]> {

	
	  public Contact[] deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
	      throws JsonParseException {
		final JsonObject jsonObject = json.getAsJsonObject();
		
		
		//Contacts c1 = context.deserialize(jsonObject.get("1"), Contacts.class);
		//Contacts c2 = context.deserialize(jsonObject.get("2"), Contacts.class);

		//Addresses[] addresses = context.deserialize(jsonObject.get("addresses"), Addresses[].class);
		
		List<Contact> list = new ArrayList<Contact>();
		
		// For each jsonElement in the jsonObject we deserialize it into Contact object
		// and add into Contact list object.
		for (Map.Entry<String,JsonElement> entry : jsonObject.entrySet()) {
		    Contact c = context.deserialize(entry.getValue(), Contact.class);
		    list.add(c);
		}

		// We won't return an ordered list of Contact but an array of Contact
		return list.toArray(new Contact[list.size()]);
	
		
	}

}
