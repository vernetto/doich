package org.jboss.as.quickstarts.kitchensink.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum VocabularyGenre {
	M, F, N;
	
	public static final List<String> genresAsList = Stream.of(VocabularyGenre.values()).map(Enum::name).collect(Collectors.toList());

}
