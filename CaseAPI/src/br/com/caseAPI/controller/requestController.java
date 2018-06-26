package br.com.caseAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.caseAPI.dao.EventDao;
import br.com.caseAPI.dao.OrderDao;
import br.com.caseAPI.model.Event;
import br.com.caseAPI.model.Order;
import br.com.caseAPI.model.RequestCase;
import br.com.caseAPI.model.ResponseCase;

@RestController
@RequestMapping("/request")
@Controller
public class requestController {

	@Autowired
	public RequestCase requestCase;
	
	@Autowired
	public ResponseCase responseCase;

	@Autowired
	public OrderDao orderDao;

	@Autowired
	public EventDao eventDao;

	@RequestMapping(method = RequestMethod.POST)
	public void request(RequestCase requestCase) {
		
		ArrayList<ResponseCase> responses = new ArrayList<ResponseCase>();
		
		//Pesquisa na Base MySQL(exemplo) para obtenção dos valores
		List<Order> orders = orderDao.response(requestCase);
		
		//Leitura dos eventos em JSON
		List<Event> events = eventDao.response(requestCase.platform);
		
		
		//Inserção dos valores para a resposta
		for(Order order: orders) {
			responseCase.setTimestamp(System.currentTimeMillis() / 1000L);
			responseCase.setPlatform(order.getDevice());
			responseCase.setProduct(order.getCode_color());
			responseCase.setCtr( order.getItem_quantity() /eventDao.getEventSum(events));
			
			responses.add(responseCase);
		}
		
		eventDao.writeJSON(responses);
		
		
		
	}

	
}
