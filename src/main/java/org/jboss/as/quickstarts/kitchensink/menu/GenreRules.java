package org.jboss.as.quickstarts.kitchensink.menu;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.as.quickstarts.kitchensink.model.Vocabulary;

@ManagedBean(name = "genreRules")
@ViewScoped
public class GenreRules implements Serializable {
	public String derdiedas(Vocabulary vocabulary) {
		String result = null;
		if (vocabulary.isMasculine())
			result = "der";
		if (vocabulary.isFeminine())
			result = "die";
		if (vocabulary.isNeutrum())
			result = "das";
		return result;
	}

}
