package com.spring.boot.backend.apirest.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.boot.backend.apirest.curso.models.entity.Estudiante;
import com.spring.boot.backend.apirest.curso.models.services.IEstudianteService;
import com.spring.boot.backend.apirest.curso.models.services.IUploadFileService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/curso")
public class EstudianteRestController {

	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IUploadFileService uploadService;
	
	// private final Logger log = LoggerFactory.getLogger(ClienteRestController.class);

	@GetMapping("/estudiantes")
	public List<Estudiante> index() {
		return estudianteService.findAll();
	}
	
	@GetMapping("/estudiantes/page/{page}")
	public Page<Estudiante> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		return estudianteService.findAll(pageable);
	}
	
}
