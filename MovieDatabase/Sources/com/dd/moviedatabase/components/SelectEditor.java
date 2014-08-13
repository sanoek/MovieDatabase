package com.dd.moviedatabase.components;

import java.util.Date;

import com.dd.moviedatabase.data.Director;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.components.ERXComponent;

public class SelectEditor extends ERXComponent {

	private Director selectedDirector;

	public SelectEditor(WOContext context) {
        super(context);
    }


	public WOActionResults changeSelectedDirectorData() {
		
		selectedDirector.setName("Test");
		selectedDirector.setBirthday(new NSTimestamp());
		selectedDirector.setNationality("aus Russland");
		
		session().defaultEditingContext().saveChanges();
		
		return null;
	}

	/**
	 * @return the selectedDirector
	 */
	public Director selectedDirector() {
		return selectedDirector;
	}

	/**
	 * @param selectedDirector the selectedDirector to set
	 */
	public void setSelectedDirector(Director selectedDirector) {
		this.selectedDirector = selectedDirector;
	}
}