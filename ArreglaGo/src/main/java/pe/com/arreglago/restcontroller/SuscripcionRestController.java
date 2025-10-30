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

import pe.com.arreglago.entity.SuscripcionEntity;
import pe.com.arreglago.service.SuscripcionService;

@RestController
@RequestMapping("/suscripcion")
public class SuscripcionRestController {

	@Autowired
	private SuscripcionService servicio;
	
	@GetMapping
	public List<SuscripcionEntity> findAll()
	{
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<SuscripcionEntity> findAllCustom()
	{
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public SuscripcionEntity findById(@PathVariable Long id)
	{
		return servicio.findById(id);
	}
	
	@PostMapping
	public SuscripcionEntity add(@RequestBody SuscripcionEntity obj)
	{
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public SuscripcionEntity update(@RequestBody SuscripcionEntity obj, @PathVariable Long id)
	{
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public SuscripcionEntity delete(@PathVariable Long id)
	{
		return servicio.delete(id);
	}
	
	@PutMapping("/enable/{id}")
	public SuscripcionEntity enable(@PathVariable Long id)
	{
		return servicio.enable(id);
	}
}
