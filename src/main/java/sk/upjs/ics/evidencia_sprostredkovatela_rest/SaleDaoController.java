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

import sk.upjs.ics.evidencia_sprostredkovatela.entity.Sale;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.SaleDao;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.DaoFactory;

@RestController
public class SaleDaoController {

	private SaleDao saleDao = DaoFactory.INSTANCE.getSaleDao();
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/sales", method = RequestMethod.POST)
	public Sale add(@RequestBody Sale sale) {
		saleDao.add(sale);
		return sale;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/sales")
	public List<Sale> getAll() {
		return saleDao.getAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/sales", method = RequestMethod.PUT)
	public void save(@RequestBody Sale sale) {
		saleDao.save(sale);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/sales/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		saleDao.delete(id);
	}
}
