package br.com.caseAPI.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.caseAPI.controller.JSONController;
import br.com.caseAPI.model.Event;
import br.com.caseAPI.model.Platform;
import br.com.caseAPI.model.ResponseCase;


@Repository
public class EventDao {

	ArrayList<Event> events = new ArrayList<>(); 

	@SuppressWarnings("unlikely-arg-type")
	public ArrayList<Event> response(String platform) {


		if (platform.equals(Platform.MobileWEB)){

			return JSONController.readJSON(events, Platform.MobileWEB);

		}
		/*else if (platform.equals(Platform.android)){
	    }
	      else if (platform.equals(Platform.iOS)){
	    }*/
		else {
			return events;
		}
	}



	public Long getEventSum(List<Event> events2) {
		Long counter = 0L;
		for(Event event: events2) {

			if( event.getType().equals("product")) {
				counter++;
			}
		}

		return counter;

	}

	public void writeJSON(ArrayList<ResponseCase> responses) {
		JSONController json = new JSONController();
		json.writeJSON(responses);
	}
}