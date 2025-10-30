package pe.com.arreglago.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.arreglago.entity.ContratacionEntity;
import pe.com.arreglago.service.ContratacionService;

@RestController
@RequestMapping("/contratacion")

public class ContratacionRestController {

	@Autowired
	private ContratacionService servicio;
	
	@GetMapping
	public List<ContratacionEntity> findAll()
	{
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<ContratacionEntity> findAllCustom()
	{
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public ContratacionEntity findById(@PathVariable Long id)
	{
		return servicio.findById(id);
	}
	
	@PostMapping
	public ContratacionEntity add(@RequestBody ContratacionEntity obj)
	{
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public ContratacionEntity update(@RequestBody ContratacionEntity obj, @PathVariable Long id)
	{
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public ContratacionEntity delete(@PathVariable Long id)
	{
		return servicio.delete(id);
	}
	
	@PutMapping("/enable/{id}")
	public ContratacionEntity enable(@PathVariable Long id)
	{
		return servicio.enable(id);
	}
}
