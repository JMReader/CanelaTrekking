package kora.jtrekking.model;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="circuitos")
@Component
public class Circuito {
//atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Lob
	@Column
	private String descripcion;
	@Column
	private String nombre;
	@Column 
	private String vistaprev;
	@Column
	private String dificultad;
	@Column
	private int desnivel;
	@Column
	private int duracion;
	@Column
	private String operable;
	@Column
	private float distancia;
	@Column
	private String region;
	@Lob
	@Column(name = "prod_imagen", columnDefinition = "LONGBLOB")
	private String imagen;
	@Lob
	@Column(name = "prod_imagen1", columnDefinition = "LONGBLOB")
	private String imagen1;
	@Lob
	@Column(name = "prod_imagen2", columnDefinition = "LONGBLOB")
	private String imagen2;
	
	
	
	//constructores
	public Circuito() {
		// TODO Auto-generated constructor stub
	}

	public Circuito(Integer id, String descripcion, String nombre, String vistaprev, String dificultad, int desnivel,
			int duracion, String operable, float distancia, String region, String imagen, String imagen1,
			String imagen2) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.vistaprev = vistaprev;
		this.dificultad = dificultad;
		this.desnivel = desnivel;
		this.duracion = duracion;
		this.operable = operable;
		this.distancia = distancia;
		this.region = region;
		this.imagen = imagen;
		this.imagen1 = imagen1;
		this.imagen2 = imagen2;
	}







	// gets y sets
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDificultad() {
		return dificultad;
	}


	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}


	public int getNivelAlt() {
		return desnivel;
	}


	public void setNivelAlt(int nivelAlt) {
		this.desnivel = nivelAlt;
	}




	public String getOperable() {
		return operable;
	}


	public void setOperable(String operable) {
		this.operable = operable;
	}





	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getImagen1() {
		return imagen1;
	}


	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}


	public String getImagen2() {
		return imagen2;
	}


	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}
	
	
	public int getDesnivel() {
		return desnivel;
	}


	public void setDesnivel(int desnivel) {
		this.desnivel = desnivel;
	}

	public String getVistaprev() {
		return vistaprev;
	}


	public void setVistaprev(String vistaprev) {
		this.vistaprev = vistaprev;
	}



	public int getDuracion() {
		return duracion;
	}



	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public float getDistancia() {
		return distancia;
	}


	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	//hashcod y equlas 
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + desnivel;
		result = prime * result + ((dificultad == null) ? 0 : dificultad.hashCode());
		result = prime * result + Float.floatToIntBits(distancia);
		result = prime * result + duracion;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((imagen1 == null) ? 0 : imagen1.hashCode());
		result = prime * result + ((imagen2 == null) ? 0 : imagen2.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((operable == null) ? 0 : operable.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((vistaprev == null) ? 0 : vistaprev.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circuito other = (Circuito) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (desnivel != other.desnivel)
			return false;
		if (dificultad == null) {
			if (other.dificultad != null)
				return false;
		} else if (!dificultad.equals(other.dificultad))
			return false;
		if (Float.floatToIntBits(distancia) != Float.floatToIntBits(other.distancia))
			return false;
		if (duracion != other.duracion)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (imagen1 == null) {
			if (other.imagen1 != null)
				return false;
		} else if (!imagen1.equals(other.imagen1))
			return false;
		if (imagen2 == null) {
			if (other.imagen2 != null)
				return false;
		} else if (!imagen2.equals(other.imagen2))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (operable == null) {
			if (other.operable != null)
				return false;
		} else if (!operable.equals(other.operable))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (vistaprev == null) {
			if (other.vistaprev != null)
				return false;
		} else if (!vistaprev.equals(other.vistaprev))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Circuito [id=" + id + ", descripcion=" + descripcion + ", nombre=" + nombre + ", vistaprev=" + vistaprev
				+ ", dificultad=" + dificultad + ", desnivel=" + desnivel + ", duracion=" + duracion + ", operable="
				+ operable + ", distancia=" + distancia + ", region=" + region + ", imagen=" + imagen + ", imagen1="
				+ imagen1 + ", imagen2=" + imagen2 + "]";
	}

	
	


	
	
	

	

}
