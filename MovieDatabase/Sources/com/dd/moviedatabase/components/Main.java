package com.dd.moviedatabase.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;
import com.webobjects.appserver.WOActionResults;
import com.dd.moviedatabase.data.Movie;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;
import com.dd.moviedatabase.data.Director;

public class Main extends ERXComponent {
	private String greetingName;
	private Movie currentMovie;
	private String newMovieTitle;
	private NSTimestamp newMovieReleaseDate;
	private Director currentDirector;
	private Director newMovieDirector;

	public Main(WOContext context) {
		super(context);
	}

	/**
	 * @return the greetingName
	 */
	public String greetingName() {
		return greetingName;
	}

	/**
	 * @param greetingName the greetingName to set
	 */
	public void setGreetingName(String greetingName) {
		this.greetingName = greetingName;
	}

	public WOActionResults processName() {
		System.out.println("setting name");
		return null;
	}

	/**
	 * @return the currentMovie
	 */
	public Movie currentMovie() {
		return currentMovie;
	}

	/**
	 * @param currentMovie the currentMovie to set
	 */
	public void setCurrentMovie(Movie currentMovie) {
		this.currentMovie = currentMovie;
	}

	public NSArray<Movie> allMovies() {
		return Movie.fetchAllMovies(session().defaultEditingContext(),Movie.TITLE.ascInsensitives());
	}

	/**
	 * @return the newMovieTitle
	 */
	public String newMovieTitle() {
		return newMovieTitle;
	}

	/**
	 * @param newMovieTitle the newMovieTitle to set
	 */
	public void setNewMovieTitle(String newMovieTitle) {
		this.newMovieTitle = newMovieTitle;
	}

	/**
	 * @return the newMovieReleaseDate
	 */
	public NSTimestamp newMovieReleaseDate() {
		return newMovieReleaseDate;
	}

	/**
	 * @param newMovieReleaseDate the newMovieReleaseDate to set
	 */
	public void setNewMovieReleaseDate(NSTimestamp newMovieReleaseDate) {
		this.newMovieReleaseDate = newMovieReleaseDate;
	}

	public WOActionResults createNewMovie() {
		Movie newMovie = Movie.createMovie(session().defaultEditingContext(), newMovieTitle());
		newMovie.setReleaseDate(newMovieReleaseDate());
		
		//newMovie.setDirector(newMovieDirector);
		
		newMovie.setDirectorRelationship(newMovieDirector);
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
	 * @return the newMovieDirector
	 */
	public Director newMovieDirector() {
		return newMovieDirector;
	}

	/**
	 * @param newMovieDirector the newMovieDirector to set
	 */
	public void setNewMovieDirector(Director newMovieDirector) {
		this.newMovieDirector = newMovieDirector;
	}
}
