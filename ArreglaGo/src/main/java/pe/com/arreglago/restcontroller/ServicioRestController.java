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

import pe.com.arreglago.entity.ServicioEntity;
import pe.com.arreglago.service.ServicioService;

@RestController
@RequestMapping("/servicio")

public class ServicioRestController {

	@Autowired
	private ServicioService servicio;
	
	@GetMapping
	public List<ServicioEntity> findAll()
	{
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<ServicioEntity> findAllCustom()
	{
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public ServicioEntity findById(@PathVariable Long id)
	{
		return servicio.findById(id);
	}
	
	@PostMapping
	public ServicioEntity add(@RequestBody ServicioEntity obj)
	{
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public ServicioEntity update(@RequestBody ServicioEntity obj, @PathVariable Long id)
	{
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public ServicioEntity delete(@PathVariable Long id)
	{
		return servicio.delete(id);
	}
	
	@PutMapping("/enable/{id}")
	public ServicioEntity enable(@PathVariable Long id)
	{
		return servicio.enable(id);
	}
}
