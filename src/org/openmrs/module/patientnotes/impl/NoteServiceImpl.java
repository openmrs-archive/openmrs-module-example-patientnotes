package org.openmrs.module.patientnotes.impl;

import java.util.List;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.patientnotes.Note;
import org.openmrs.module.patientnotes.NoteService;
import org.openmrs.module.patientnotes.db.NoteDAO;
import org.springframework.transaction.annotation.Transactional;


public class NoteServiceImpl extends BaseOpenmrsService implements NoteService {
	
	private NoteDAO dao;
	
    public void setDao(NoteDAO dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly=true)
	public Note getNote(Integer id) {
		return dao.getNote(id);
	}
	
	@Transactional(readOnly=true)
	public Note getNoteByUuid(String uuid) {
		return dao.getNoteByUuid(uuid);
	}
	
	@Transactional(readOnly=true)
	public List<Note> getNotesByPatient(Patient patient) {
		return dao.getNotes(patient);
	}
	
	@Transactional
	public Note saveNote(Note note) {
		return dao.saveNote(note);
	}
	
}
