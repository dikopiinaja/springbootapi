package springboot.springbootapi.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "matakuliah")
@EntityListeners(AuditingEntityListener.class)

public class MataKuliahModel {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private long id;
	
//	@NotBlank
	@Column(name = "nama_matkul")
	private String nama_matkul;

//	@NotBlank
	@Column(name = "semester")
	private boolean semester;
	
	public MataKuliahModel() {
		
	}

	public MataKuliahModel(String nama_matkul, boolean semester) {
		this.nama_matkul = nama_matkul;
		this.semester = semester;
	}
	
	public long getId() {
		return id;
	}

	public String getNamaMataKuliah() {
		return nama_matkul;
	}

	public void setNamaMataKuliah(String nama_matkul) {
		this.nama_matkul = nama_matkul;
	}

	public boolean isSemester() {
		return semester;
	}

	public void setSemester(boolean isSemester) {
		this.semester = isSemester;
	}

	@Override
	public String toString() {
		return "MataKuliah [id=" + id + ", nama_matkul=" + nama_matkul + ", semester=" + semester + "]";
	}

}
