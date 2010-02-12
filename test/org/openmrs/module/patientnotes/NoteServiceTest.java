package org.openmrs.module.patientnotes;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.openmrs.test.Verifies;

/**
 * This is a unit test for our module service.<br/>
 * <br/>
 * 
 * Run this test by right clicking on it and choosing Run As-->Unit test
 * 
 * <br/>
 * <br/>
 * See http://openmrs.org/wiki/Module_Unit_Testing for how to set up testing in
 * a module.
 * 
 */
public class NoteServiceTest extends BaseModuleContextSensitiveTest {

	/**
	 * @see {@link NoteService#saveNote(Note)} and the "@should" annotation in
	 *      javadoc
	 * 
	 */
	@Test
	@Verifies(value = "should create a note", method = "saveNote(Note)")
	public void saveNote_shouldCreateANote() throws Exception {
		NoteService service = Context.getService(NoteService.class);
		Patient patient = new Patient(2); // we can do this instead of doing
		// Context.getPatientService().getPatient(2)
		// because hibernate only looks at
		// the primary key object when
		// referencing this in the DAO

		Note note = new Note(); // create our Note object to save
		note.setPatient(patient); // add our Patient "stub" (just id) to mark
									// this note for
		note.setTitle("War and Peace"); // the subject of the note
		note.setText("That's a long book"); // the content of the note
		service.saveNote(note); // persist the note in the database

		// now do the testing

		List<Note> notes = service.getNotesByPatient(patient); // get all notes
																// for the #2
																// patient
		Assert.assertEquals(1, notes.size()); // there should only be 1 note for
												// this patient
		Assert.assertNotNull(notes.get(0).getCreator()); // the "creator" should
															// be set by the
															// SaveHandler
															// because we called
															// a method that
															// started with
															// 'save' and the
															// first argument
															// was an
															// "Auditable"
															// object
	}
}