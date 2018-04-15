package org.jboss.as.quickstarts.kitchensink.menu;

import java.util.List;
import java.io.Serializable;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.as.quickstarts.kitchensink.model.Vocabulary;
import org.jboss.as.quickstarts.kitchensink.model.VocabularyCase;
import org.jboss.as.quickstarts.kitchensink.model.VocabularyGenre;

@ManagedBean(name = "grammarRules")
@ViewScoped
public class GrammarRules implements Serializable {
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
	
	public String derdiedas(VocabularyCase theCase, VocabularyGenre theGenre, boolean plural) {
		if (plural) {
			String[] derdiedas = {"die", "die", "den", "der"};
			return derdiedas[theCase.ordinal()];
		}
		else {
			// NOM, ACC, DAT, GEN ... MAS, FEM, NEU
			String[][] derdiedas = {{"der", "den", "dem", "des"}, {"die", "die", "der", "der"}, {"das", "das", "dem", "des"}};
			return derdiedas[theGenre.ordinal()][theCase.ordinal()];
		}
	}
	
	/**
	 * ein, kein, mein, irgendein
	 * @param theCase
	 * @param theGenre
	 * @param plural
	 * @return
	 */
	public String ein(VocabularyCase theCase, VocabularyGenre theGenre, boolean plural) {
		// NOM, ACC, DAT, GEN ... MAS, FEM, NEU
		String[][] ein = {{"", "en", "em", "es"}, {"e", "e", "er", "er"}, {"", "", "em", "es"}};
		return ein[theGenre.ordinal()][theCase.ordinal()];
		
	}
	
	
	
	/**
	 * After der (den, dem, des), dieser, jener, jeder, mancher, welcher
	 * @param theCase
	 * @param theGenre
	 * @return
	 */
	public String adjectiveDeclinationAfterDefiniteArticle(VocabularyCase theCase, VocabularyGenre theGenre ) {
		// NOM, ACC, DAT, GEN ... MAS, FEM, NEU
		String[][] ending = {{"e", "en", "en", "en"}, {"e", "e", "en", "en"}, {"e", "e", "en", "en"}};
		return ending[theGenre.ordinal()][theCase.ordinal()];
	}
	
	
	/**
	 * After ein (einen, einem, eines), kein, mein, irgendein 
	 * @param theCase
	 * @param theGenre
	 * @return
	 */
	public String adjectiveDeclinationAfterIndefiniteArticle(VocabularyCase theCase, VocabularyGenre theGenre ) {
		// NOM, ACC, DAT, GEN ... MAS, FEM, NEU
		String[][] ending = {{"er", "en", "en", "en"}, {"es", "es", "en", "en"}, {"e", "e", "en", "en"}};
		String result = "";
		return ending[theGenre.ordinal()][theCase.ordinal()];
	}
	
	
	public VocabularyCase caseForPreposition(String preposition) {
		List dativ = Arrays.asList("in", "nach", "unter");
		List accusativ = Arrays.asList("durch");
		if (accusativ.contains(preposition)) return VocabularyCase.ACC;
		
		return null;
	}
	
}
