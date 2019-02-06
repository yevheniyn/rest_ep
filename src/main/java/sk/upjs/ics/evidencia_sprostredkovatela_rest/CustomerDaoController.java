package sk.upjs.ics.evidencia_sprostredkovatela_rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import sk.upjs.ics.evidencia_sprostredkovatela.entity.Customer;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.CustomerDao;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.DaoFactory;

@RestController
public class CustomerDaoController {

	private CustomerDao customerDao = DaoFactory.INSTANCE.getCustomerDao();

	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public Customer add(@RequestBody Customer customer) {
		customerDao.add(customer);
		return customer;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/customers")
	public List<Customer> getAllEnabled() {
		return customerDao.getAllEnabled();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/customers/all")
	public List<Customer> getAll() {
		return customerDao.getAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/customers", method = RequestMethod.PUT)
	public void save(@RequestBody Customer customer) {
		customerDao.save(customer);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		customerDao.delete(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/customers/disable/{id}", method = RequestMethod.DELETE)
	void disable(@PathVariable long id) {
		customerDao.disable(id);
	}

}
