package org.openmrs.module.patientnotes.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientnotes.Note;
import org.openmrs.module.patientnotes.NoteService;
import org.openmrs.web.controller.PortletController;


public class PatientNotesPortletController extends PortletController {

	@Override
	protected void populateModel(HttpServletRequest request, Map<String, Object> model) {
		Patient patient = (Patient) model.get("patient");
		List<Note> notes = Context.getService(NoteService.class).getNotesByPatient(patient);
		model.put("notes", notes);
	}
	
}
