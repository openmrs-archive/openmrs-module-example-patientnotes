package org.openmrs.module.patientnotes;

import java.util.List;

import org.openmrs.Patient;
import org.openmrs.api.OpenmrsService;

public interface NoteService extends OpenmrsService {

	/**
	 * @param note
	 * @return
	 * 
	 * @should create a note
	 */
	public Note saveNote(Note note);
	
	public Note getNote(Integer id);
	
	public Note getNoteByUuid(String uuid);
	
	public List<Note> getNotesByPatient(Patient patient);
	
}
