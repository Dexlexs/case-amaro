package br.com.caseAPI.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caseAPI.model.Order;
import br.com.caseAPI.model.RequestCase;

@Repository
public class OrderDao {

	@PersistenceContext
	private EntityManager manager;


	public List<Order> response(RequestCase requestCase) {
		if(requestCase.product.isEmpty()) {
			if(requestCase.platform.isEmpty()) {

				List<Order> queryPrEmptyPlEmpty = manager.createQuery("select orders.id, orders.device_type, orders.utm_source_medium, items.code_color, count(items.sku)\n" + 
						"from amaro.orders orders left join amaro.order_items items on orders.id = items.order_id\n" + 
						"group by orders.id, orders.device_type, orders.utm_source_medium, items.code_color;"
						, Order.class).getResultList();

				return queryPrEmptyPlEmpty;
			}
			//Platform não vazia
			else {
				List<Order> queryPrEmptyPlNotEmpty = manager.createQuery("select orders.id, orders.device_type, orders.utm_source_medium, items.code_color, count(items.sku)\n" + 
						"from amaro.orders orders left join amaro.order_items items on orders.id = items.order_id\n" + 
						"where orders.device_type = :device\n" + 
						"group by orders.id, orders.device_type, orders.utm_source_medium, items.code_color;"
						, Order.class).setParameter("devide", requestCase.getPlatform()).getResultList();

				return queryPrEmptyPlNotEmpty;
			}
		}
		//Produto não vazio
		else if(requestCase.platform.isEmpty()) {

			List<Order> queryPrNotEmptyPlEmpty = manager.createQuery("select orders.id, orders.device_type, orders.utm_source_medium, items.code_color, count(items.sku)\n" + 
					"from amaro.orders orders left join amaro.order_items items on orders.id = items.order_id\n" + 
					"where items.code_color = :product\n" + 
					"group by orders.id, orders.device_type, orders.utm_source_medium, items.code_color;"
					, Order.class).setParameter("product", requestCase.getProduct()).getResultList();

			return queryPrNotEmptyPlEmpty;
		}
		//Platform não vazia
		else {

			List<Order> queryPrNotEmptyPlEmpty = manager.createQuery("select orders.id, orders.device_type, orders.utm_source_medium, items.code_color, count(items.sku)\n" + 
					"from amaro.orders orders left join amaro.order_items items on orders.id = items.order_id\n" + 
					"where items.code_color = :product\n" +
					"and   orders.device_type = :device\n" + 
					"group by orders.id, orders.device_type, orders.utm_source_medium, items.code_color;"
					, Order.class).setParameter("devide", requestCase.getPlatform()).setParameter("devide", requestCase.getPlatform())
					.setParameter("product", requestCase.getProduct()).getResultList();

			return queryPrNotEmptyPlEmpty;

		}
	}
}