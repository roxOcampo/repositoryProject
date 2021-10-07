package org.dao.persona;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.modelo.persona.Persona;

@SuppressWarnings("serial")
public class DaoPersona implements Serializable{

	public void addPersona(Persona persona) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(persona);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}
	
	public void updatePersona(Persona persona) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(persona);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}
	
	public void deletePersona(Persona persona) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(persona);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}
	
	public Persona getPersonaById(int id) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Persona persona = null;
		try {
			session.beginTransaction();
			persona = (Persona) session.get(Persona.class,id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Exception:" + e.getMessage());
		}
		return persona;
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> listPersona(){
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Persona> list = null;
		try {
			session.beginTransaction();
			list = (List<Persona>) session.createQuery("from Persona").list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Exception:" + e.getMessage());
		}
		return list;
	}
}
