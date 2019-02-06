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

import sk.upjs.ics.evidencia_sprostredkovatela.entity.Product;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.ProductDao;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.DaoFactory;

@RestController
public class ProductDaoController {

	private ProductDao productDao = DaoFactory.INSTANCE.getProductDao();
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product add(@RequestBody Product product) {
		productDao.add(product);
		return product;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/validProducts")
	public List<Product> getAllValid() {
		return productDao.getAllValid();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/products")
	public List<Product> getAll() {
		return productDao.getAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public void save(@RequestBody Product product) {
		productDao.save(product);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public void decreaseQuantity(@RequestBody int quantity, @PathVariable Long productId) {
		productDao.decreaseQuantity(quantity, productId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		productDao.delete(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/products/setNotValid/{id}", method = RequestMethod.DELETE)
	public void setNotValid(@PathVariable long id) {
		productDao.setNotValid(id);
	}

}
