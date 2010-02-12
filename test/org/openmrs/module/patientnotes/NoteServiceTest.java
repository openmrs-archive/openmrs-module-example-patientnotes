package org.openmrs.module.patientnotes;


import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.openmrs.test.Verifies;

public class NoteServiceTest extends BaseModuleContextSensitiveTest {
	
	/**
	 * @see {@link NoteService#saveNote(Note)}
	 * 
	 */
	@Test
	@Verifies(value = "should create a note", method = "saveNote(Note)")
	public void saveNote_shouldCreateANote() throws Exception {
		NoteService service = Context.getService(NoteService.class);
		Patient patient = new Patient(2);
		
		Note note = new Note();
		note.setPatient(patient);
		note.setTitle("War and Peace");
		note.setText("That's a long book");
		service.saveNote(note);
		
		List<Note> notes = service.getNotesByPatient(patient);
		Assert.assertEquals(1, notes.size());
		Assert.assertNotNull(notes.get(0).getCreator());
	}
}