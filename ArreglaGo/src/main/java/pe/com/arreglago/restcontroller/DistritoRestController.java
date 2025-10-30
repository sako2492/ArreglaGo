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

import pe.com.arreglago.entity.DistritoEntity;
import pe.com.arreglago.service.DistritoService;

@RestController
@RequestMapping("/distrito")
public class DistritoRestController {

	@Autowired
	private DistritoService servicio;
	
	@GetMapping
	public List<DistritoEntity> findAll()
	{
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<DistritoEntity> findAllCustom()
	{
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public DistritoEntity findById(@PathVariable Long id)
	{
		return servicio.findById(id);
	}
	
	@PostMapping
	public DistritoEntity add(@RequestBody DistritoEntity obj)
	{
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public DistritoEntity update(@RequestBody DistritoEntity obj, @PathVariable Long id)
	{
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public DistritoEntity delete(@PathVariable Long id)
	{
		return servicio.delete(id);
	}
	
	@PutMapping("/enable/{id}")
	public DistritoEntity enable(@PathVariable Long id)
	{
		return servicio.enable(id);
	}
}
