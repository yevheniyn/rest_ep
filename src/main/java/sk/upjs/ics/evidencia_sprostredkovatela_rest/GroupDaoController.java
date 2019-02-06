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

import sk.upjs.ics.evidencia_sprostredkovatela.entity.Group;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.GroupDao;
import sk.upjs.ics.evidencia_sprostredkovatela.persistent.DaoFactory;

@RestController
public class GroupDaoController {

	private GroupDao groupDao = DaoFactory.INSTANCE.getGroupDao();
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/groups", method = RequestMethod.POST)
	public Group add(@RequestBody Group group) {
		groupDao.add(group);
		return group;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/groups")
	public List<Group> getAll() {
		return groupDao.getAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/groups/valid")
	public List<Group> getAllValid() {
		return groupDao.getAllValid();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/groups", method = RequestMethod.PUT)
	public void save(@RequestBody Group group) {
		groupDao.save(group);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/groups/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		groupDao.delete(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/groups/disable/{id}", method = RequestMethod.DELETE)
	public void setNotValid(@PathVariable long id) {
		groupDao.setNotValid(id);
	}

}
