package com.dpath.language_based_document_parser.antlr_lexer_parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.dpath_grammar.DpathGrammarLexer;
import org.dpath_grammar.DpathGrammarParser;

import com.dpath.language_based_document_parser.bo.DpathDecoder;
import com.dpath.language_based_document_parser.error_handler.VerboseListener;
import com.dpath.language_based_document_parser.parse_tree_visiter.ParseTreeVisiter;

public class AntlrParser implements IParser {

	@Override
	public DpathDecoder getDpathInfo(String dpath) {
		ParseTree tree = getParseTree(dpath);
		ParseTreeVisiter parseTreeVisiter = new ParseTreeVisiter();

		/**
		 * pathTreeVisiter object will visit the parse tree formed
		 */
		DpathDecoder dpathDecoder = parseTreeVisiter.visit(tree);
		return dpathDecoder;

	}

	@Override
	public ParseTree getParseTree(String dpath) {
		ParseTree tree;
		DpathGrammarParser parser = getParser(dpath);
		parser.removeErrorListeners();
		parser.addErrorListener(new VerboseListener());
		tree = parser.dpath();/**
								 * dpath is the start rule in DpathGrammar.g4......tree contains the root node
								 * of parse tree formed.
								 */

		return tree;
	}

	@Override
	public DpathGrammarParser getParser(String dpath) {
		CommonTokenStream tokens = getTokens(dpath);
		DpathGrammarParser parser = new DpathGrammarParser(tokens);

		return parser;

	}

	@Override
	public CommonTokenStream getTokens(String dpath) {
		DpathGrammarLexer lexer = getLexer(dpath);
		CommonTokenStream tokens = new CommonTokenStream(lexer);/**
																 * object tokens contain tokenstream which will be given
																 * to parser to parse the dpath
																 */
		return tokens;
	}

	@Override
	public DpathGrammarLexer getLexer(String dpath) {
		CharStream input = CharStreams.fromString(dpath);
		DpathGrammarLexer lexer = new DpathGrammarLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(new VerboseListener());
		return lexer;
	}
}
