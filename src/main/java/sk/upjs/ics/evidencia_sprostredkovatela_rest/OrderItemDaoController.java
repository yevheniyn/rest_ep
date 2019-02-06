package sk.upjs.ics.evidencia_sprostredkovatela_rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.ics.evidencia_sprostredkovatela.entity.OrderItem;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.OrderItemDao;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.DaoFactory;

@RestController
public class OrderItemDaoController {

	private OrderItemDao orderItemDao = DaoFactory.INSTANCE.getOrderItemDao();
//FIXME: fix FK constraints
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/orderItems", method = RequestMethod.POST)
	public OrderItem add(@RequestBody OrderItem orderItem) {
		orderItemDao.add(orderItem);
		return orderItem;
	}

	@RequestMapping("/orderItems")
	public List<OrderItem> getAll() {
		return orderItemDao.getAll();
	}

	@RequestMapping(value = "/orderItems", method = RequestMethod.PUT)
	public void save(@RequestBody OrderItem orderItem) {
		orderItemDao.save(orderItem);
	}

	@RequestMapping(value = "/orderItems/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		orderItemDao.delete(id);
	}

}
