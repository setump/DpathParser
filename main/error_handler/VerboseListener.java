package com.dpath.language_based_document_parser.error_handler;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class VerboseListener extends BaseErrorListener {
	/**
	 * this method overrides the default implementation of syntaxError.By default
	 * syntaxError specifies how to recover from syntax errors and how to compute
	 * error messages. it's job is simply to emit a computed message,But overridden
	 * implementation is aimed at throwing exception.
	 */
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		System.out.println("\n");
		throw new InvalidDpathException(recognizer, offendingSymbol, line, charPositionInLine, msg, e);

	}

}
