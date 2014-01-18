package com.nicolasodano.gson.example1;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class AddressesDeserializer implements JsonDeserializer<Address> {
	
	  public Address deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) {
		  final JsonObject jsonObject = json.getAsJsonObject();
		  
		  final Address address = new Address();
		  
		  // Fill the current address object data reading the content of the current jsonObject
		  address.setCity(jsonObject.get("city").getAsString());
		  address.setStreet(jsonObject.get("street").getAsString());
		  
		  return address;
	  }

}
