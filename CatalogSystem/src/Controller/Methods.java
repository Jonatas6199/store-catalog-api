package Controller;

import com.google.gson.Gson;

public class Methods {
	public static String convertToJson(Object object) {
		Gson json = new Gson();
		return json.toJson(object);
	}
}
