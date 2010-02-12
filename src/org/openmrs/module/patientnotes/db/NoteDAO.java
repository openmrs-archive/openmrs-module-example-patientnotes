package org.openmrs.module.patientnotes.db;

import java.util.List;

import org.openmrs.Patient;
import org.openmrs.module.patientnotes.Note;


public interface NoteDAO {

	Note getNote(Integer id);

	Note getNoteByUuid(String uuid);

	List<Note> getNotes(Patient patient);

	Note saveNote(Note note);

}
