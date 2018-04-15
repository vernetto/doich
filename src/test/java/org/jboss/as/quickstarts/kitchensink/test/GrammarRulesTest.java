package org.jboss.as.quickstarts.kitchensink.test;

import static org.hamcrest.CoreMatchers.is;
import static org.jboss.as.quickstarts.kitchensink.model.VocabularyCase.*;
import static org.jboss.as.quickstarts.kitchensink.model.VocabularyGenre.*;
import static org.junit.Assert.assertThat;

import org.jboss.as.quickstarts.kitchensink.menu.GrammarRules;
import org.junit.Test;


public class GrammarRulesTest {

	@Test
	public void testEiner() {
		GrammarRules grammarRules = new GrammarRules();
		assertThat(grammarRules.adjectiveDeclinationAfterDefiniteArticle(NOM, M), is("e"));
		assertThat(grammarRules.adjectiveDeclinationAfterDefiniteArticle(ACC, M), is("en"));
		assertThat(grammarRules.adjectiveDeclinationAfterDefiniteArticle(ACC, N), is("e"));
	}
}
