package org.openmrs.module.patientnotes;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Patient;


public class Note extends BaseOpenmrsData {
	
	private Integer id;
	private String uuid;
	private Patient patient;
	private String title;
	private String text;
	
	public Note() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;		
	}
	
    /**
     * @return the patient
     */
    public Patient getPatient() {
    	return patient;
    }
	
    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
    	this.patient = patient;
    }
	
    /**
     * @return the title
     */
    public String getTitle() {
    	return title;
    }
	
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
    	this.title = title;
    }

    /**
     * @return the text
     */
    public String getText() {
    	return text;
    }
	
    /**
     * @param text the text to set
     */
    public void setText(String text) {
    	this.text = text;
    }
	
    /**
     * @return the uuid
     */
    public String getUuid() {
    	return uuid;
    }
	
    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
    	this.uuid = uuid;
    }
	
}
