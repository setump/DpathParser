package com.dpath.language_based_document_parser.antlr_lexer_parser;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.dpath_grammar.DpathGrammarLexer;
import org.dpath_grammar.DpathGrammarParser;

import com.dpath.language_based_document_parser.bo.DpathDecoder;

public interface IParser {
	/**
	 * this method will return DpathDecoder object which contains all 3 attributes
	 * of a dpath(StartNode,FinalNode,RelationshipChain)
	 * 
	 *
	 */
	DpathDecoder getDpathInfo(String dpath);

	/**
	 * this method will return root node of the parse tree and parse tree contains
	 * all rules and subrules(starting with '#' in grammar file ,eg.relation1) as
	 * nodes
	 * 
	 * 
	 */
	ParseTree getParseTree(String dpath);

	/**
	 * this method will return lexer object which converts given input String into
	 * tokens
	 * 
	 *
	 */
	DpathGrammarParser getParser(String dpath);

	/**
	 * this method will return CommonTokenStream object (or simply stream of tokens)
	 */
	CommonTokenStream getTokens(String dpath);

	/**
	 * this method will return lexer object which converts given input String into
	 * tokens
	 */
	DpathGrammarLexer getLexer(String dpath);
}
