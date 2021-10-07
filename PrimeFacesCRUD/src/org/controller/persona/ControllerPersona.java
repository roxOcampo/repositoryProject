package org.controller.persona;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.dao.persona.DaoPersona;
import org.modelo.persona.Persona;

@ManagedBean
@ViewScoped
public class ControllerPersona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Persona> listaPersonas;
	private Persona persona;
		
	//CONSTRUCTOR METHOD SUPERCLASS
	public ControllerPersona() {
		persona = new Persona();
	}

	//GET AND SET OF LISTAPERSONAS
	public List<Persona> getListaPersonas() {
		DaoPersona dao = new DaoPersona();
		listaPersonas = dao.listPersona();
		return listaPersonas;
	}
	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	//GET AND SET OF PERSONA
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	//METHODS DAO PERSONA
	public void limpiarPersona() {
		persona = new Persona();
	}
	public String agregarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.addPersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}
	public String modificarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.updatePersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}
	public String eliminarPersona() {
		DaoPersona dao = new DaoPersona();
		dao.deletePersona(persona);
		return "/index.xhtml?faces-redirect=true";
	}	
		
	
}
