package br.com.caseAPI.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.caseAPI.model.Event;
import br.com.caseAPI.model.Platform;
import br.com.caseAPI.model.ResponseCase;

public class JSONController {


	static JSONObject jsonObject;
	static JSONParser parser = new JSONParser();


	public static ArrayList<Event> readJSON( ArrayList<Event> events, Platform platform){
		try {
			//Por questões do exemplo, não coloquei a tratativa 
			//por platform para leitura do caminho do JSON
			jsonObject = (JSONObject) parser.parse(
					new FileReader("src/resources/productEvent_20160201.json"));

			//Salva no objeto EVENTO o JSON
			events.add(new Event((String) jsonObject.get("event_type"),
					(String) jsonObject.get("event_name"),
					(String) jsonObject.get("codeColor"),
					(String) jsonObject.get("timestamp_unixtime_ms")));

		} 
		//Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return events;
	}

	@SuppressWarnings("unchecked")
	public void writeJSON(List<ResponseCase> responses) {

		JSONArray jsonArray = new JSONArray();
		
		jsonArray.addAll(responses);
		 try {  

	            // Writing to a file  
	            File file=new File("src/resourcer/Response.json");  
	            file.createNewFile();  
	            FileWriter fileWriter = new FileWriter(file);  

	            fileWriter.write(jsonObject.toJSONString());  
	            fileWriter.flush();  
	            fileWriter.close();  

	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  

	}
}
