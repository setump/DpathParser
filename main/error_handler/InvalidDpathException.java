package com.dpath.language_based_document_parser.error_handler;

import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

public class InvalidDpathException extends RuntimeException {
	public InvalidDpathException(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
        String msg, RecognitionException e) {
		if (recognizer instanceof Lexer) {
			System.out.println("InvalidDpathException");
			System.out
					.println(msg + " change the character at position " + charPositionInLine + " to a valid character");
			System.out.println(recognizer.getInputStream().toString());
			for (int i = 0; i < charPositionInLine; i++)
				System.out.print(" ");
			if (charPositionInLine >= 0) {
				System.err.println("^");
			}

		} else {
			List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
			//st rev here
			System.out.println("InvalidDpathException : ");
			System.err.println("rules involved till now : " + stack);
			System.err.println(msg + ":");
			System.err.println("Remove or Replace the Character At line " + line + ",Postion " + charPositionInLine);
			CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
			String input = tokens.getTokenSource().getInputStream().toString();
			System.out.println(input);
			for (int i = 0; i < charPositionInLine - 1; i++)
				System.err.print(" ");
			int start = ((Token) offendingSymbol).getStartIndex();
			int stop = ((Token) offendingSymbol).getStopIndex();
			if (start >= 0 && stop >= 0) {
				for (int i = start; i <= stop; i++)
					System.err.println("^");
			}
		}
	}

	public InvalidDpathException(String nodeValue, String miqValue, Integer i, boolean FirstNode) {
		System.out.println("InvalidDpathException : ");
		String[] nodeAttributes = { "AspectName", "BindingName", "EntityName", "BindingVersion", "EntityVersion" };
		String[] NodeType = { "LastNode's", "FirstNode's" };
		System.err.println(nodeAttributes[i] + " of " + NodeType[FirstNode ? 1 : 0] + " Miq and Node does not match");
		System.err.println(nodeAttributes[i] + " of Miq is:" + miqValue);
		System.err.println(nodeAttributes[i] + " of Node is:" + nodeValue + " " + FirstNode);

	}
}
//Collections.reverse(stack);
