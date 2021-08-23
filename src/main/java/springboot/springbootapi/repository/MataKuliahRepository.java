package springboot.springbootapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.springbootapi.model.MataKuliahModel;

public interface MataKuliahRepository extends JpaRepository<MataKuliahModel, Long> {
	List<MataKuliahModel> findBySemester(boolean semester);
	List<MataKuliahModel> findByMataKuliahContaining(String nama_matkul);
}

