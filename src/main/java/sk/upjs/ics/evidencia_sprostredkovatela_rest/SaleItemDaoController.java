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

import sk.upjs.ics.evidencia_sprostredkovatela.entity.SaleItem;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.SaleItemDao;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.DaoFactory;

@RestController
public class SaleItemDaoController {

	private SaleItemDao saleItemDao = DaoFactory.INSTANCE.getSaleItemDao();
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/saleItems", method = RequestMethod.POST)
	public SaleItem add(@RequestBody SaleItem saleItem) {
		saleItemDao.add(saleItem);
		return saleItem;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/saleItems")
	public List<SaleItem> getAll() {
		return saleItemDao.getAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/saleItems", method = RequestMethod.PUT)
	public void save(@RequestBody SaleItem saleItem) {
		saleItemDao.save(saleItem);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/saleItems/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		saleItemDao.delete(id);
	}

}
