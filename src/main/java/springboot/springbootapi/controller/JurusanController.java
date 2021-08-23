package springboot.springbootapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.springbootapi.model.Jurusan;
import springboot.springbootapi.repository.JurusanRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class JurusanController {
	@Autowired
	JurusanRepository JurusanRepository;

	@GetMapping("/jurusans")
	public ResponseEntity<List<Jurusan>> getAllJurusans(@RequestParam(required = false) String nama_matkul) {
		try {
			List<Jurusan> Jurusans = new ArrayList<Jurusan>();

			if(nama_jurusan == null)
				JurusanRepository.findAll().forEach(Jurusans::add);
			else
				JurusanRepository.findByJurusanContaining(nama_jurusan).forEach(Jurusans::add);
			if (Jurusans.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Jurusans, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/jurusans/{id}")
	public ResponseEntity<Jurusan> getJurusanById(@PathVariable("id") long id) {
		Optional<Jurusan> JurusanData = JurusanRepository.findById(id);

		if (JurusanData.isPresent()) {
			return new ResponseEntity<>(JurusanData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/jurusans")
	public ResponseEntity<Jurusan> createTutorial(@RequestBody Jurusan Jurusan) {
		try {
			Jurusan _Jurusan = JurusanRepository
					.save(new Jurusan(Jurusan.getNamaJurusan(), false));
			return new ResponseEntity<>(_Jurusan, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/jurusans/{id}")
	public ResponseEntity<Jurusan> updateJurusan(@PathVariable("id") long id, @RequestBody Jurusan Jurusan) {
		Optional<Jurusan> JurusanData = JurusanRepository.findById(id);

		if (JurusanData.isPresent()) {
			Jurusan _Jurusan = JurusanData.get();
			_Jurusan.setNamaJurusan(Jurusan.getNamaJurusan());
			_Jurusan.setFakultas(Jurusan.isFakultas());
			return new ResponseEntity<>(JurusanRepository.save(_Jurusan), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/jurusans/{id}")
	public ResponseEntity<HttpStatus> deleteJurusan(@PathVariable("id") long id) {
		try {
			JurusanRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/jurusans")
	public ResponseEntity<HttpStatus> deleteAllJurusans() {
		try {
			JurusanRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/jurusans/id_fakultas")
	public ResponseEntity<List<Jurusan>> findByFakultas() {
		try {
			List<Jurusan> Jurusans = JurusanRepository.findByFakultas(true);

			if (Jurusans.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Jurusans, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
