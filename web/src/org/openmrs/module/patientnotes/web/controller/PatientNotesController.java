package org.openmrs.module.patientnotes.web.controller;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.patientnotes.Note;
import org.openmrs.module.patientnotes.NoteService;
import org.openmrs.propertyeditor.PatientEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientNotesController {

	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		wdb.registerCustomEditor(Patient.class, new PatientEditor());
	}
	
	@RequestMapping("/module/patientnotes/notes")
	public void showNotes(ModelMap model,
	                      @RequestParam("patient_id") Patient patient) {
		NoteService service = Context.getService(NoteService.class);
		model.addAttribute("patient", patient);
		model.addAttribute("notes", service.getNotesByPatient(patient));
	}
	
	@RequestMapping(value="/module/patientnotes/addNote", method=RequestMethod.POST)
	public String addNote(@RequestParam("patient_id") Patient patient,
	                    @RequestParam("title") String title,
	                    @RequestParam("text") String text,
	                    @RequestParam(value="returnUrl", required=false) String returnUrl) {
		Note note = new Note();
		note.setPatient(patient);
		note.setTitle(title);
		note.setText(text);
		Context.getService(NoteService.class).saveNote(note);
		if (returnUrl == null)
			returnUrl = "notes.form?patient_id=" + patient.getPatientId();
		return "redirect:" + returnUrl;
	}
	
}
