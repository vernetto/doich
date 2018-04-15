package org.jboss.as.quickstarts.kitchensink.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum VocabularyType {
	NOUN, ADVE, VERB, ADJE;
	
	
	public static final List<String> typesAsList = Stream.of(VocabularyType.values()).map(Enum::name).collect(Collectors.toList());

	
}
