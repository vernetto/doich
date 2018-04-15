package org.jboss.as.quickstarts.kitchensink.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum VocabularyCase {
	NOM,ACC,DAT,GEN;
	
	public static final List<String> casesAsList = Stream.of(VocabularyCase.values()).map(Enum::name).collect(Collectors.toList());

}
