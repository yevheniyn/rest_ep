package sk.upjs.ics.evidencia_sprostredkovatela_rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.ics.evidencia_sprostredkovatela.entity.Order;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.OrderDao;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.DaoFactory;

@RestController
public class OrderDaoController {

	private OrderDao orderDao = DaoFactory.INSTANCE.getOrderDao();
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public Order add(@RequestBody Order order) {
		orderDao.add(order);
		return order;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/orders")
	public List<Order> getAll() {
		return orderDao.getAll();
	}
//	not sure if it's working
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/orders", method = RequestMethod.PUT)
	public void save(@RequestBody Order order) {
		orderDao.save(order);
	}
// crash upon deleting -> FK error
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		orderDao.delete(id);
	}

}
