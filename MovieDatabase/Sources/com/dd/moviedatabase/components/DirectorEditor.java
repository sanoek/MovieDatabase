package com.dd.moviedatabase.components;

import com.dd.moviedatabase.data.Director;
import com.dd.moviedatabase.data.Movie;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.components.ERXComponent;

public class DirectorEditor extends ERXComponent {
    private String newDirectorName;
	private Director currentDirector;
	private NSTimestamp newDirectorBirthday;
	private String newDirectorNationality;

	public DirectorEditor(WOContext context) {
        super(context);
    }

	/**
	 * @return the newDirectorName
	 */
	public String newDirectorName() {
		return newDirectorName;
	}

	/**
	 * @param newDirectorName the newDirectorName to set
	 */
	public void setNewDirectorName(String newDirectorName) {
		this.newDirectorName = newDirectorName;
	}

	public WOActionResults createNewDirector() {
		
		Director newDirector = Director.createDirector(session().defaultEditingContext());
		
		newDirector.setName(newDirectorName);
		newDirector.setBirthday(newDirectorBirthday);
		newDirector.setNationality(newDirectorNationality);
		
		session().defaultEditingContext().saveChanges();
		
		return null;
	}
	
	
	public NSArray<Director> allDirector() {
		return Director.fetchAllDirectors(session().defaultEditingContext());
	}

	/**
	 * @return the currentDirector
	 */
	public Director currentDirector() {
		return currentDirector;
	}

	/**
	 * @param currentDirector the currentDirector to set
	 */
	public void setCurrentDirector(Director currentDirector) {
		this.currentDirector = currentDirector;
	}

	/**
	 * @return the newDirectorBirthday
	 */
	public NSTimestamp newDirectorBirthday() {
		return newDirectorBirthday;
	}

	/**
	 * @param newDirectorBirthday the newDirectorBirthday to set
	 */
	public void setNewDirectorBirthday(NSTimestamp newDirectorBirthday) {
		this.newDirectorBirthday = newDirectorBirthday;
	}

	/**
	 * @return the newDirectorNationality
	 */
	public String newDirectorNationality() {
		return newDirectorNationality;
	}

	/**
	 * @param newDirectorNationality the newDirectorNationality to set
	 */
	public void setNewDirectorNationality(String newDirectorNationality) {
		this.newDirectorNationality = newDirectorNationality;
	}

	public WOActionResults deleteCurrentDirector() {
		
		currentDirector().delete();
		session().defaultEditingContext().saveChanges();
		
		return null;
	}

	public WOActionResults changeCurrentDirectorData() {
		
		SelectEditor nextPage = pageWithName(SelectEditor.class);
		
		nextPage.setSelectedDirector(currentDirector());
		
		return nextPage;
	}
	
	
}