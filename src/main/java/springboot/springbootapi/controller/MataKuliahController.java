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

import springboot.springbootapi.model.MataKuliahModel;
import springboot.springbootapi.repository.MataKuliahRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MataKuliahController {
	@Autowired
	MataKuliahRepository matakuliahRepository;

	@GetMapping("/matakuliahs")
	public ResponseEntity<List<MataKuliahModel>> getAllMataKuliahs(@RequestParam(required = false) String nama_matkul) {
		try {
			List<MataKuliahModel> matakuliahs = new ArrayList<MataKuliahModel>();

			if (nama_matkul == null)
				matakuliahRepository.findAll().forEach(matakuliahs::add);
			else
				matakuliahRepository.findByMataKuliahContaining(nama_matkul).forEach(matakuliahs::add);

			if (matakuliahs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(matakuliahs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/matakuliahs/{id}")
	public ResponseEntity<MataKuliahModel> getMataKuliahById(@PathVariable("id") long id) {
		Optional<MataKuliahModel> matakuliahData = matakuliahRepository.findById(id);

		if (matakuliahData.isPresent()) {
			return new ResponseEntity<>(matakuliahData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/matakuliahs")
	public ResponseEntity<MataKuliahModel> createTutorial(@RequestBody MataKuliahModel matakuliah) {
		try {
			MataKuliahModel _matakuliah = matakuliahRepository
					.save(new MataKuliahModel(matakuliah.getNamaMataKuliah(), false));
			return new ResponseEntity<>(_matakuliah, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/matakuliahs/{id}")
	public ResponseEntity<MataKuliahModel> updateMataKuliah(@PathVariable("id") long id, @RequestBody MataKuliahModel matakuliah) {
		Optional<MataKuliahModel> matakuliahData = matakuliahRepository.findById(id);

		if (matakuliahData.isPresent()) {
			MataKuliahModel _matakuliah = matakuliahData.get();
			_matakuliah.setNamaMataKuliah(matakuliah.getNamaMataKuliah());
			_matakuliah.setSemester(matakuliah.isSemester());
			return new ResponseEntity<>(matakuliahRepository.save(_matakuliah), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/matakuliahs/{id}")
	public ResponseEntity<HttpStatus> deleteMataKuliah(@PathVariable("id") long id) {
		try {
			matakuliahRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/matakuliahs")
	public ResponseEntity<HttpStatus> deleteAllMataKuliahs() {
		try {
			matakuliahRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/matakuliahs/semester")
	public ResponseEntity<List<MataKuliahModel>> findBySemester() {
		try {
			List<MataKuliahModel> matakuliahs = matakuliahRepository.findBySemester(true);

			if (matakuliahs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(matakuliahs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
