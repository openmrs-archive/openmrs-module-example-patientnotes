package org.openmrs.module.patientnotes.extension.html;

import org.openmrs.module.web.extension.PatientDashboardTabExt;


public class PatientNotesDashboardTabExt extends PatientDashboardTabExt {

	@Override
    public String getPortletUrl() {
		return "patientNotes";
    }

	@Override
    public String getRequiredPrivilege() {
	    return null;
    }

	@Override
    public String getTabId() {
	    return "patientnotes";
    }

	@Override
    public String getTabName() {
	    return "Notes";
    }

}
