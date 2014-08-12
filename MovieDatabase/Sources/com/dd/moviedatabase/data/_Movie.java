// DO NOT EDIT.  Make changes to Movie.java instead.
package com.dd.moviedatabase.data;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _Movie extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Movie";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> RELEASE_DATE = new ERXKey<NSTimestamp>("releaseDate");
  public static final ERXKey<String> TITLE = new ERXKey<String>("title");
  // Relationship Keys
  public static final ERXKey<com.dd.moviedatabase.data.Director> DIRECTOR = new ERXKey<com.dd.moviedatabase.data.Director>("director");

  // Attributes
  public static final String RELEASE_DATE_KEY = RELEASE_DATE.key();
  public static final String TITLE_KEY = TITLE.key();
  // Relationships
  public static final String DIRECTOR_KEY = DIRECTOR.key();

  private static Logger LOG = Logger.getLogger(_Movie.class);

  public Movie localInstanceIn(EOEditingContext editingContext) {
    Movie localInstance = (Movie)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp releaseDate() {
    return (NSTimestamp) storedValueForKey(_Movie.RELEASE_DATE_KEY);
  }

  public void setReleaseDate(NSTimestamp value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating releaseDate from " + releaseDate() + " to " + value);
    }
    takeStoredValueForKey(value, _Movie.RELEASE_DATE_KEY);
  }

  public String title() {
    return (String) storedValueForKey(_Movie.TITLE_KEY);
  }

  public void setTitle(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating title from " + title() + " to " + value);
    }
    takeStoredValueForKey(value, _Movie.TITLE_KEY);
  }

  public com.dd.moviedatabase.data.Director director() {
    return (com.dd.moviedatabase.data.Director)storedValueForKey(_Movie.DIRECTOR_KEY);
  }
  
  public void setDirector(com.dd.moviedatabase.data.Director value) {
    takeStoredValueForKey(value, _Movie.DIRECTOR_KEY);
  }

  public void setDirectorRelationship(com.dd.moviedatabase.data.Director value) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("updating director from " + director() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setDirector(value);
    }
    else if (value == null) {
    	com.dd.moviedatabase.data.Director oldValue = director();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Movie.DIRECTOR_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _Movie.DIRECTOR_KEY);
    }
  }
  

  public static Movie createMovie(EOEditingContext editingContext, String title
) {
    Movie eo = (Movie) EOUtilities.createAndInsertInstance(editingContext, _Movie.ENTITY_NAME);    
		eo.setTitle(title);
    return eo;
  }

  public static ERXFetchSpecification<Movie> fetchSpec() {
    return new ERXFetchSpecification<Movie>(_Movie.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Movie> fetchAllMovies(EOEditingContext editingContext) {
    return _Movie.fetchAllMovies(editingContext, null);
  }

  public static NSArray<Movie> fetchAllMovies(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Movie.fetchMovies(editingContext, null, sortOrderings);
  }

  public static NSArray<Movie> fetchMovies(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Movie> fetchSpec = new ERXFetchSpecification<Movie>(_Movie.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Movie> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Movie fetchMovie(EOEditingContext editingContext, String keyName, Object value) {
    return _Movie.fetchMovie(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Movie fetchMovie(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Movie> eoObjects = _Movie.fetchMovies(editingContext, qualifier, null);
    Movie eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Movie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Movie fetchRequiredMovie(EOEditingContext editingContext, String keyName, Object value) {
    return _Movie.fetchRequiredMovie(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Movie fetchRequiredMovie(EOEditingContext editingContext, EOQualifier qualifier) {
    Movie eoObject = _Movie.fetchMovie(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Movie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Movie localInstanceIn(EOEditingContext editingContext, Movie eo) {
    Movie localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
