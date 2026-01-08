package utils;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlaceRequest;
import pojo.Location;

public class TestDataBuilder {

	public static AddPlaceRequest addPlacePayload(String name, String language, String address)
	{
		AddPlaceRequest addPlaceRequest = new AddPlaceRequest();
		addPlaceRequest.setAccuracy("50");
		addPlaceRequest.setName(name);
		addPlaceRequest.setPhone_number("(+91) 983 893 3937");
		addPlaceRequest.setAddress(address);
		addPlaceRequest.setWebsite("http://google.com");
		addPlaceRequest.setLanguage(language);
		
		Location location = new Location();
		location.setLat("-38.383494");
		location.setLng("33.427362");
		
		List<String> typeList = new ArrayList<>();
		typeList.add("shoe park");
		typeList.add("shop");
		
		addPlaceRequest.setLocation(location);
		addPlaceRequest.setTypes(typeList);
		
		return addPlaceRequest;
	}
}
