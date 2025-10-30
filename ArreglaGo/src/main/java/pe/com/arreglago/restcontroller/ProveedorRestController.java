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

import pe.com.arreglago.entity.ProveedorEntity;
import pe.com.arreglago.service.ProveedorService;

@RestController
@RequestMapping("/proveedor")

public class ProveedorRestController {

	@Autowired
	private ProveedorService servicio;
	
	@GetMapping
	public List<ProveedorEntity> findAll()
	{
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<ProveedorEntity> findAllCustom()
	{
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public ProveedorEntity findById(@PathVariable Long id)
	{
		return servicio.findById(id);
	}
	
	@PostMapping
	public ProveedorEntity add(@RequestBody ProveedorEntity obj)
	{
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public ProveedorEntity update(@RequestBody ProveedorEntity obj, @PathVariable Long id)
	{
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public ProveedorEntity delete(@PathVariable Long id)
	{
		return servicio.delete(id);
	}
	
	@PutMapping("/enable/{id}")
	public ProveedorEntity enable(@PathVariable Long id)
	{
		return servicio.enable(id);
	}
}
