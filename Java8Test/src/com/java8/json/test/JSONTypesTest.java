package com.java8.json.test;

import com.java8.features.model.Person;
import com.java8.test.PaymentAPI;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONTypesTest {

    public static void main(String[] args) {

        PaymentAPI paymentAPI = new PaymentAPI();

        String str = new String();
        //str.subSequence()

        //JSONObject
        Map<String, String> map = new HashMap<>();
        map.put("name", "jon doe");
        map.put("age", "22");
        map.put("city", "chicago");
        JSONObject jo = new JSONObject(map);
        jo.put("country", "usa");

        JSONObject jo2 = new JSONObject("{\"city\":\"chicago\",\"name\":\"jon doe\",\"age\":\"22\"}");

        Person person = new Person("Jhon", 40, true);
        JSONObject jo3 = new JSONObject(person);

        System.out.println(jo + "\n" + jo2 + "\n" + jo3);

        // JSONArray
        List<String> list = new ArrayList<>();
        list.add("California");
        list.add("Texas");
        list.add("Hawaii");
        list.add("Alaska");

        JSONArray ja = new JSONArray(list);
        System.out.println(ja);

        ja.put(Boolean.TRUE);
        ja.put("lorem ipsum");

        ja.put(jo);
        System.out.println(ja);

        // JSONTokener

        JSONTokener jt = new JSONTokener("lorem");

        while (jt.more()) {
            System.out.println(jt.next());
        }

        // CDL: Comma Delimited Text
        JSONArray ja4 = CDL.rowToJSONArray(new JSONTokener("England, USA, Canada"));
        System.out.println(ja4);

        // The first line is interpreted as a list of headers and all the subsequent lines are treated as data:
        String string = "name, city, age \n" +
                "john, chicago, 22 \n" +
                "gary, florida, 35 \n" +
                "sal, vegas, 18";

        JSONArray result = CDL.toJSONArray(string);

        System.out.println(result);
    }

}

// JSONObject  similar to Java's native Map like object which stores unordered key-value pairs
// JSONArray  an ordered sequence of values similar to Java's native Vector implementation
// JSONTokener  a tool that breaks a piece of text into a series of tokens which can be used by JSONObject or JSONArray to parse JSON strings
// CDL  a tool that provides methods to convert comma-delimited text into a JSONArray and vice versa
// Cookie  converts from JSON String to cookies and vice versa
// HTTP  used to convert from JSON String to HTTP headers and vice versa
// JSONException  this is a standard exception thrown by this lib
