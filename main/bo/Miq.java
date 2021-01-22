package com.dpath.language_based_document_parser.bo;

public class Miq {
	Float documentVersion;
	String miqId;

	public Miq(Float documentVersion, String miqId) {
		this.documentVersion = documentVersion;
		this.miqId = miqId;
	}

	@Override
	public String toString() {
		return String.valueOf(documentVersion) + " " + miqId;
	}
}
