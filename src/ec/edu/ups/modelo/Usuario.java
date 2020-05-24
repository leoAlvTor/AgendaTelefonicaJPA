package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String contrasena;
	@Column(unique = true )
	private String correo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private Set<Telefono> telefonos;
	
	public Usuario() {telefonos = new HashSet<Telefono>();}

	public Usuario(String cedula, String nombre, String apellido, String contrasena, String correo,
			Set<Telefono> telefonos) {
		super();
		telefonos = new HashSet<>();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrasena;
		this.correo = correo;
		this.telefonos = telefonos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getcontrasena() {
		return contrasena;
	}

	public void setcontrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Set<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	public boolean addTelefono(Telefono telefono) {
		return this.telefonos.add(telefono);
	}
	
	public boolean removeTelefono(Telefono telefono) {
		return this.telefonos.remove(telefono);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", contrasena=" + contrasena
				+ ", correo=" + correo + "]";
	}
	
	
	
}
