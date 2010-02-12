package org.openmrs.module.patientnotes.db.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.module.patientnotes.Note;
import org.openmrs.module.patientnotes.db.NoteDAO;


public class HibernateNoteDAO implements NoteDAO {
	
	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Note getNote(Integer id) {
		return (Note) sessionFactory.getCurrentSession().get(Note.class, id);
	}
	
	public Note getNoteByUuid(String uuid) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Note.class);
		crit.add( Restrictions.eq("uuid", uuid) );
		return (Note) crit.uniqueResult();
	}
	
	public List<Note> getNotes(Patient patient) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Note.class);
		crit.add( Restrictions.eq("patient", patient) );
		return crit.list();
	}
	
	public Note saveNote(Note note) {
		sessionFactory.getCurrentSession().saveOrUpdate(note);
		return note;
	}
	
}
