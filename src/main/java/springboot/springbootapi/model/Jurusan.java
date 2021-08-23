package springboot.springbootapi.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "jurusan")
@EntityListeners(AuditingEntityListener.class)

public class Jurusan {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private long id;

	@Column(name = "nama_jurusan")
	private String nama_jurusan;

	@Column(name = "id_fakultas")
	private boolean id_fakultas;
	
	public Jurusan() {
		
	}

	public Jurusan(String nama_jurusan, boolean id_fakultas) {
		this.nama_jurusan = nama_jurusan;
		this.id_fakultas = id_fakultas;
	}
	
	public long getId() {
		return id;
	}

	public String getNamaJurusan() {
		return nama_jurusan;
	}

	public void setNamaJurusan(String nama_jurusan) {
		this.nama_jurusan = nama_jurusan;
	}

	public boolean isFakultas() {
		return id_fakultas;
	}

	public void setFakultas(boolean isFakultas) {
		this.id_fakultas = isFakultas;
	}

	@Override
	public String toString() {
		return "Jurusan [id=" + id + ", nama_jurusan=" + nama_jurusan + ", id_fakultas=" + id_fakultas + "]";
	}

}
