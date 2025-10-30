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

import pe.com.arreglago.entity.TipoDocumentoEntity;
import pe.com.arreglago.service.TipoDocumentoService;

@RestController
@RequestMapping("/tipoDocumento")

public class TipoDocumentoRestController {

	@Autowired
	private TipoDocumentoService servicio;
	
	@GetMapping
	public List<TipoDocumentoEntity> findAll()
	{
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<TipoDocumentoEntity> findAllCustom()
	{
		return servicio.findAllCustom();
	}
	
	@GetMapping("/{id}")
	public TipoDocumentoEntity findById(@PathVariable Long id)
	{
		return servicio.findById(id);
	}
	
	@PostMapping
	public TipoDocumentoEntity add(@RequestBody TipoDocumentoEntity obj)
	{
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public TipoDocumentoEntity update(@RequestBody TipoDocumentoEntity obj, @PathVariable Long id)
	{
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public TipoDocumentoEntity delete(@PathVariable Long id)
	{
		return servicio.delete(id);
	}
	
	@PutMapping("/enable/{id}")
	public TipoDocumentoEntity enable(@PathVariable Long id)
	{
		return servicio.enable(id);
	}
}
