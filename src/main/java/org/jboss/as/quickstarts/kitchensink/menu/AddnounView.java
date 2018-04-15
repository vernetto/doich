package org.jboss.as.quickstarts.kitchensink.menu;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.as.quickstarts.kitchensink.model.VocabularyGenre;
import org.jboss.as.quickstarts.kitchensink.model.VocabularyType;

@ManagedBean(name = "addnounView")
@ViewScoped
public class AddnounView {

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genresAsList) {
		this.genres = genresAsList;
	}

	private List<String> genres = VocabularyGenre.genresAsList;
	
	private List<String> types = VocabularyType.typesAsList;

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

}
