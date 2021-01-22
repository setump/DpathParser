package com.dpath.language_based_document_parser.bo;

import java.util.ArrayList;
import java.util.List;

public class DpathDecoder {

	private Node startNode, finalNode;
	private List<Relation> relationshipChain;

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public void setFinalNode(Node finalNode) {
		this.finalNode = finalNode;
	}

	public void addRelation(Relation RelationName) {

		if (relationshipChain == null) {
			relationshipChain = new ArrayList<Relation>();
		}
		relationshipChain.add(RelationName);
	}

	public List<Relation> getRelationshipChain() {
		return relationshipChain;
	}

	public Node getStartNode() {
		return startNode;
	}

	public Node getFinalNode() {
		return finalNode;
	}
}