package com.nicolasodano.gson.example1;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class StringDeserializer  implements JsonDeserializer<String[]> {

	
	  public String[] deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
	      throws JsonParseException {
		final JsonObject jsonObject = json.getAsJsonObject();
		
		final String v1 = jsonObject.get("1").getAsString();
		final String v2 = jsonObject.get("2").getAsString();
		


		return new String[] {v1, v2};
		
	}
}
