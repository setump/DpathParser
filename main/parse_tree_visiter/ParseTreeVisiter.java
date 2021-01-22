
package com.dpath.language_based_document_parser.parse_tree_visiter;

import org.dpath_grammar.DpathGrammarBaseVisitor;
import org.dpath_grammar.DpathGrammarParser;

import com.dpath.language_based_document_parser.bo.DpathDecoder;
import com.dpath.language_based_document_parser.bo.Miq;
import com.dpath.language_based_document_parser.bo.Node;
import com.dpath.language_based_document_parser.bo.Relation;
import com.dpath.language_based_document_parser.error_handler.InvalidDpathException;

/**
 * This class contains methods corresponding to each rules and subrule(starting
 * with # in dpathgrammar file) in our grammar file
 */
public class ParseTreeVisiter extends DpathGrammarBaseVisitor<DpathDecoder> {
	/**
	 * This is to decide which node is to be set ,if StartNodeTaken is true
	 * FinalNode will be set else StartNode will be set
	 */
	private boolean startNodeTaken = false;
	/**
	 * This object will store the attributes of Dpath ie,StartNode,FinishNode and
	 * RelationshipChain
	 */
	private DpathDecoder dpathDecoder = new DpathDecoder();

	String aspectName = null, bindingName = null, entityName = null, miqId = null;
	Float bindingVersion = null, documentVersion = null;
	Float entityVersion = null;

	@Override
	/**
	 * This method will visit the subrule #StartNodeRel,hence subsequently visit all
	 * the methods corresponding to the variables(or non terminals) and terminals on
	 * the RHS of this subrule,
	 */
	public DpathDecoder visitStartNode(DpathGrammarParser.StartNodeContext ctx) {
		visitChildren(ctx);

		return dpathDecoder;
	}

	@Override
	/**
	 * This method will add a relationName to the relationshipChain list of
	 * dpathDeccoder object.
	 */
	public DpathDecoder visitRelationName(DpathGrammarParser.RelationNameContext ctx) {

		dpathDecoder.addRelation(new Relation(ctx.Word().getText()));
		visitChildren(ctx);
		return dpathDecoder;
	}

	/**
	 * This method will visit rule "relationName" ie,child node of subrule
	 * #relation1
	 */
	@Override
	public DpathDecoder visitRelation1(DpathGrammarParser.Relation1Context ctx) {

		visitChildren(ctx);
		return dpathDecoder;
	}

	@Override
	/**
	 * This method will set entityName of dpathDeccoder object.
	 */
	public DpathDecoder visitEntityName(DpathGrammarParser.EntityNameContext ctx) {

		entityName = ctx.Word().getText();

		visitChildren(ctx);
		return dpathDecoder;
	}

	@Override
	/**
	 * This method will visit all the methods corresponding to the variables(or non
	 * terminals) and terminals on the RHS of #nodeWithoutEV subrule,store the
	 * values of terminals in our defined
	 * variables(eg.aspectName,bindingVersion,etc.) and hence set the attributes of
	 * a node
	 */
	public DpathDecoder visitNodeWithoutEV(DpathGrammarParser.NodeWithoutEVContext ctx) {

		visitChildren(ctx);
		Miq miq = new Miq(documentVersion, miqId);
		/** This rule doesn't has any entityVersion */
		if (startNodeTaken) {
			dpathDecoder
					.setFinalNode(new Node(aspectName, bindingName, entityName, bindingVersion, entityVersion, miq));
		} else {
			dpathDecoder
					.setStartNode(new Node(aspectName, bindingName, entityName, bindingVersion, entityVersion, miq));
			startNodeTaken = true;
		}
		entityVersion = null;
		bindingVersion = null;
		return dpathDecoder;
	}

	@Override
	/**
	 * This method will visit rule "relationName" and "relation" ie,child node of
	 * subrule #relation2
	 */
	public DpathDecoder visitRelation2(DpathGrammarParser.Relation2Context ctx) {

		visitChildren(ctx);
		return dpathDecoder;
	}

	@Override
	/**
	 * This method will visit the subrule #StartNodeRel,hence subsequently visit all
	 * the methods corresponding to the variables(or non terminals) and terminals on
	 * the RHS of this subrule,
	 */
	public DpathDecoder visitStartTwoNodes(DpathGrammarParser.StartTwoNodesContext ctx) {

		visitChildren(ctx);

		return dpathDecoder;
	}

	@Override
	/**
	 * This method will visit all the methods corresponding to the variables(or non
	 * terminals) and terminals on the RHS of #nodeWithEV subrule,store the values
	 * of terminals in our defined variables(eg.aspectName,entityVersion,etc.) and
	 * hence set the attributes of a node
	 */
	public DpathDecoder visitNodeWithEV(DpathGrammarParser.NodeWithEVContext ctx) {
		visitChildren(ctx);
		Miq miq = new Miq(documentVersion, miqId);
		if (startNodeTaken) {
			dpathDecoder
					.setFinalNode(new Node(aspectName, bindingName, entityName, bindingVersion, entityVersion, miq));

		} else {
			dpathDecoder
					.setStartNode(new Node(aspectName, bindingName, entityName, bindingVersion, entityVersion, miq));
			startNodeTaken = true;
		}
		entityVersion = null;
		bindingVersion = null;
		return dpathDecoder;
	}

	@Override
	/**
	 * This method will set aspectName of dpathDeccoder object.
	 */
	public DpathDecoder visitAspectName(DpathGrammarParser.AspectNameContext ctx) {
		if (ctx.isEmpty())
			return dpathDecoder;
		aspectName = ctx.Word().getText();
		visitChildren(ctx);
		return dpathDecoder;
	}

	@Override
	/**
	 * This method will set bindingVersion of dpathDeccoder object.
	 */
	public DpathDecoder visitBindingVersion(DpathGrammarParser.BindingVersionContext ctx) {
		bindingVersion = Float.valueOf(ctx.FloatValue().getText());

		visitChildren(ctx);
		return dpathDecoder;
	}

	@Override
	/**
	 * This method will set entityVersion of dpathDeccoder object.
	 */
	public DpathDecoder visitEntityVersion(DpathGrammarParser.EntityVersionContext ctx) {
		entityVersion = Float.valueOf(ctx.FloatValue().getText());

		visitChildren(ctx);
		return dpathDecoder;
	}

	/**
	 * This method will visit the subrule #StartNodeRel,hence subsequently visit all
	 * the methods corresponding to the variables(or non terminals) and terminals on
	 * the RHS of this subrule,
	 */
	@Override
	public DpathDecoder visitStartNodeRel(DpathGrammarParser.StartNodeRelContext ctx) {

		visitChildren(ctx);
		return dpathDecoder;
	}

	@Override
	/**
	 * This method will set bindingName of dpathDeccoder object.
	 */
	public DpathDecoder visitBindingName(DpathGrammarParser.BindingNameContext ctx) {

		bindingName = ctx.Word().getText();

		visitChildren(ctx);
		return dpathDecoder;
	}

	@Override
	public DpathDecoder visitMiqWithEv(DpathGrammarParser.MiqWithEvContext ctx) {

		if (!ctx.aspectName().getText().toString().equals(aspectName.toString())) {

			throw new InvalidDpathException(ctx.aspectName().getText(), aspectName, 0, startNodeTaken);
		} else if (!ctx.bindingName().getText().equals(bindingName)) {
			throw new InvalidDpathException(ctx.bindingName().getText(), bindingName, 1, startNodeTaken);
		} else if (!ctx.entityName().getText().equals(entityName)) {
			throw new InvalidDpathException(ctx.entityName().getText(), entityName, 2, startNodeTaken);
		} else if (!Float.valueOf(ctx.bindingVersion().getText()).equals(bindingVersion)) {
			throw new InvalidDpathException(ctx.bindingVersion().getText(), String.valueOf(bindingVersion), 3,
					startNodeTaken);
		} else if (!Float.valueOf(ctx.entityVersion().getText()).equals(entityVersion)) {
			throw new InvalidDpathException(ctx.entityVersion().getText(), String.valueOf(entityVersion), 4,
					startNodeTaken);
		}
		visitChildren(ctx);
		return dpathDecoder;
	}

	@Override
	public DpathDecoder visitMiqWithoutEv(DpathGrammarParser.MiqWithoutEvContext ctx) {

		if (!ctx.aspectName().getText().equals(aspectName)) {
			throw new InvalidDpathException(ctx.aspectName().getText(), aspectName, 0, startNodeTaken);
		} else if (!ctx.bindingName().getText().equals(bindingName)) {
			throw new InvalidDpathException(ctx.bindingName().getText(), bindingName, 1, startNodeTaken);
		} else if (!ctx.entityName().getText().equals(entityName)) {
			throw new InvalidDpathException(ctx.entityName().getText(), entityName, 2, startNodeTaken);
		} else if (!Float.valueOf(ctx.bindingVersion().getText()).equals(bindingVersion)) {
			throw new InvalidDpathException(ctx.bindingVersion().getText(), String.valueOf(bindingVersion), 3,
					startNodeTaken);
		}

		visitChildren(ctx);
		return dpathDecoder;
	}

	@Override
	public DpathDecoder visitDocumentVersion(DpathGrammarParser.DocumentVersionContext ctx) {
		documentVersion = Float.valueOf(ctx.FloatValue().getText());
		visitChildren(ctx);
		return dpathDecoder;
	}

	@Override
	public DpathDecoder visitId(DpathGrammarParser.IdContext ctx) {
		miqId = ctx.Word().getText();
		visitChildren(ctx);
		return dpathDecoder;
	}
}
