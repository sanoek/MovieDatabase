// DO NOT EDIT.  Make changes to Director.java instead.
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
public abstract class _Director extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Director";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> BIRTHDAY = new ERXKey<NSTimestamp>("birthday");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> NATIONALITY = new ERXKey<String>("nationality");
  // Relationship Keys
  public static final ERXKey<com.dd.moviedatabase.data.Movie> MOVIES = new ERXKey<com.dd.moviedatabase.data.Movie>("movies");

  // Attributes
  public static final String BIRTHDAY_KEY = BIRTHDAY.key();
  public static final String NAME_KEY = NAME.key();
  public static final String NATIONALITY_KEY = NATIONALITY.key();
  // Relationships
  public static final String MOVIES_KEY = MOVIES.key();

  private static Logger LOG = Logger.getLogger(_Director.class);

  public Director localInstanceIn(EOEditingContext editingContext) {
    Director localInstance = (Director)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp birthday() {
    return (NSTimestamp) storedValueForKey(_Director.BIRTHDAY_KEY);
  }

  public void setBirthday(NSTimestamp value) {
    if (_Director.LOG.isDebugEnabled()) {
    	_Director.LOG.debug( "updating birthday from " + birthday() + " to " + value);
    }
    takeStoredValueForKey(value, _Director.BIRTHDAY_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_Director.NAME_KEY);
  }

  public void setName(String value) {
    if (_Director.LOG.isDebugEnabled()) {
    	_Director.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _Director.NAME_KEY);
  }

  public String nationality() {
    return (String) storedValueForKey(_Director.NATIONALITY_KEY);
  }

  public void setNationality(String value) {
    if (_Director.LOG.isDebugEnabled()) {
    	_Director.LOG.debug( "updating nationality from " + nationality() + " to " + value);
    }
    takeStoredValueForKey(value, _Director.NATIONALITY_KEY);
  }

  public NSArray<com.dd.moviedatabase.data.Movie> movies() {
    return (NSArray<com.dd.moviedatabase.data.Movie>)storedValueForKey(_Director.MOVIES_KEY);
  }

  public NSArray<com.dd.moviedatabase.data.Movie> movies(EOQualifier qualifier) {
    return movies(qualifier, null, false);
  }

  public NSArray<com.dd.moviedatabase.data.Movie> movies(EOQualifier qualifier, boolean fetch) {
    return movies(qualifier, null, fetch);
  }

  public NSArray<com.dd.moviedatabase.data.Movie> movies(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<com.dd.moviedatabase.data.Movie> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(com.dd.moviedatabase.data.Movie.DIRECTOR_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = com.dd.moviedatabase.data.Movie.fetchMovies(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = movies();
      if (qualifier != null) {
        results = (NSArray<com.dd.moviedatabase.data.Movie>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<com.dd.moviedatabase.data.Movie>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToMovies(com.dd.moviedatabase.data.Movie object) {
    includeObjectIntoPropertyWithKey(object, _Director.MOVIES_KEY);
  }

  public void removeFromMovies(com.dd.moviedatabase.data.Movie object) {
    excludeObjectFromPropertyWithKey(object, _Director.MOVIES_KEY);
  }

  public void addToMoviesRelationship(com.dd.moviedatabase.data.Movie object) {
    if (_Director.LOG.isDebugEnabled()) {
      _Director.LOG.debug("adding " + object + " to movies relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToMovies(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Director.MOVIES_KEY);
    }
  }

  public void removeFromMoviesRelationship(com.dd.moviedatabase.data.Movie object) {
    if (_Director.LOG.isDebugEnabled()) {
      _Director.LOG.debug("removing " + object + " from movies relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromMovies(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Director.MOVIES_KEY);
    }
  }

  public com.dd.moviedatabase.data.Movie createMoviesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( com.dd.moviedatabase.data.Movie.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Director.MOVIES_KEY);
    return (com.dd.moviedatabase.data.Movie) eo;
  }

  public void deleteMoviesRelationship(com.dd.moviedatabase.data.Movie object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Director.MOVIES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllMoviesRelationships() {
    Enumeration<com.dd.moviedatabase.data.Movie> objects = movies().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMoviesRelationship(objects.nextElement());
    }
  }


  public static Director createDirector(EOEditingContext editingContext) {
    Director eo = (Director) EOUtilities.createAndInsertInstance(editingContext, _Director.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<Director> fetchSpec() {
    return new ERXFetchSpecification<Director>(_Director.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Director> fetchAllDirectors(EOEditingContext editingContext) {
    return _Director.fetchAllDirectors(editingContext, null);
  }

  public static NSArray<Director> fetchAllDirectors(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Director.fetchDirectors(editingContext, null, sortOrderings);
  }

  public static NSArray<Director> fetchDirectors(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Director> fetchSpec = new ERXFetchSpecification<Director>(_Director.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Director> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Director fetchDirector(EOEditingContext editingContext, String keyName, Object value) {
    return _Director.fetchDirector(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Director fetchDirector(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Director> eoObjects = _Director.fetchDirectors(editingContext, qualifier, null);
    Director eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Director that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Director fetchRequiredDirector(EOEditingContext editingContext, String keyName, Object value) {
    return _Director.fetchRequiredDirector(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Director fetchRequiredDirector(EOEditingContext editingContext, EOQualifier qualifier) {
    Director eoObject = _Director.fetchDirector(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Director that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Director localInstanceIn(EOEditingContext editingContext, Director eo) {
    Director localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
