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

import pe.com.arreglago.entity.ValoracionEntity;
import pe.com.arreglago.service.ValoracionService;

@RestController
@RequestMapping("/valoracion")

public class ValoracionRestController {

	@Autowired
	private ValoracionService servicio;
	
	@GetMapping
	public List<ValoracionEntity> findAll()
	{
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<ValoracionEntity> findAllCustom()
	{
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public ValoracionEntity findById(@PathVariable Long id)
	{
		return servicio.findById(id);
	}
	
	@PostMapping
	public ValoracionEntity add(@RequestBody ValoracionEntity obj)
	{
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public ValoracionEntity update(@RequestBody ValoracionEntity obj, @PathVariable Long id)
	{
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public ValoracionEntity delete(@PathVariable Long id)
	{
		return servicio.delete(id);
	}
	
	@PutMapping("/enable/{id}")
	public ValoracionEntity enable(@PathVariable Long id)
	{
		return servicio.enable(id);
	}
}
