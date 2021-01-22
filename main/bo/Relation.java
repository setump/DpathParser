package com.dpath.language_based_document_parser.bo;

public class Relation {
	final private String relationshipName;

	public Relation(String relationshipName) {
		this.relationshipName = relationshipName;
	}

	@Override
	public String toString() {
		return relationshipName;
	}
}
