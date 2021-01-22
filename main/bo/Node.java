package com.dpath.language_based_document_parser.bo;

public class Node {
	/** this contains the node attributes. */
	private final String aspectName;
	private final String bindingName;
	private final String entityName;
	private final Float bindingVersion;
	private final Float entityVersion;
	private final Miq miq;

	public String getAspectName() {
		return aspectName;
	}

	public String getBindingName() {
		return bindingName;
	}

	public String getEntityName() {
		return entityName;
	}

	public Float getBindingVersion() {
		return bindingVersion;
	}

	public Float getEntityVersion() {
		return entityVersion;
	}

	public Miq getMiq() {
		return miq;
	}

	public Node(String aspectName, String bindingName, String entityName, Float bindingVersion, Float entityVersion,
			Miq miq) {
		this.miq = miq;
		this.aspectName = aspectName;
		this.bindingName = bindingName;
		this.entityName = entityName;
		this.bindingVersion = bindingVersion;
		this.entityVersion = entityVersion;

	}

	@Override
	public String toString() {
		return aspectName + " " + bindingName + " " + bindingVersion + " " + entityName + " " + entityVersion + " "
				+ miq.toString();
	}
}
