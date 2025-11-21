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

import pe.com.arreglago.entity.CategoriaEntity;
import pe.com.arreglago.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")

public class CategoriaRestController {

	@Autowired
	private CategoriaService servicio;
	
	@GetMapping
	public List<CategoriaEntity> findAll()
	{
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<CategoriaEntity> findAllCustom()
	{
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public CategoriaEntity findById(@PathVariable Long id)
	{
		return servicio.findById(id);
	}
	
	@PostMapping
	public CategoriaEntity add(@RequestBody CategoriaEntity obj)
	{
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public CategoriaEntity update(@RequestBody CategoriaEntity obj, @PathVariable Long id)
	{
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public CategoriaEntity delete(@PathVariable Long id)
	{
		return servicio.delete(id);
	}
	
	@PutMapping("/enable/{id}")
	public CategoriaEntity enable(@PathVariable Long id)
	{
		return servicio.enable(id);
	}
}
