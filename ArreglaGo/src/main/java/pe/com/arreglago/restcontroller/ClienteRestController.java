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

import pe.com.arreglago.entity.ClienteEntity;
import pe.com.arreglago.service.ClienteService;

@RestController 
@RequestMapping ("/api/cliente")

public class ClienteRestController {

	@Autowired
	private ClienteService servicio;
	
	@GetMapping
	public List<ClienteEntity> findAll()
	{
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<ClienteEntity> findAllCustom()
	{
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public ClienteEntity findById(@PathVariable Long id)
	{
		return servicio.findById(id);
	}
	
	@PostMapping
	public ClienteEntity add(@RequestBody ClienteEntity obj)
	{
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public ClienteEntity update(@RequestBody ClienteEntity obj, @PathVariable Long id)
	{
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public ClienteEntity delete(@PathVariable Long id)
	{
		return servicio.delete(id);
	}
	
	@PutMapping("/enable/{id}")
	public ClienteEntity enable(@PathVariable Long id)
	{
		return servicio.enable(id);
	}
}
