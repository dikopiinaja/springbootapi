package springboot.springbootapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.springbootapi.model.Jurusan;

public interface JurusanRepository extends JpaRepository<Jurusan, Long> {
	List<Jurusan> findByFakultas(boolean id_fakultas);
	List<Jurusan> findByJurusanContaining(String nama_jurusan);
}

