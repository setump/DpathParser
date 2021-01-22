package com.dpath.language_based_document_parser.antlr_lexer_parser;

import java.util.ArrayList;

import org.junit.Test;

public class TestingJunit {

	@Test
	public void testEntityVersionForTwoNodes() {
		ArrayList<String> dpathList = DpathList.getDpathList(1);
		int t = 1000000;
		// while (t > 0) {
		for (int i = 0; i < dpathList.size(); i++) {
			long startTime = System.nanoTime();
			AntlrParser antlrParser = new AntlrParser();
			antlrParser.getDpathInfo(dpathList.get(i));
			long endTime = System.nanoTime();
			// if (t == 0)
			System.out.println("\n" + dpathList.get(i) + "\nTime Taken:" + (endTime - startTime) + "ns");
			t--;
		}
		// }
	}

	/*
	 * @Test public void testStartNodeForSingleNodeWithRelation() {
	 * ArrayList<String> dpaths = new ArrayList<String>(); //
	 * "Utdi/amazon::1.0/ShippingRequest::3.0/[miq://document:1.0/Utdi/amazon:1.0/
	 * ShippingRequest:3.0/171f7d88-3030-4b52-9dde-5586f2b0a579]/ //
	 * ShippingRequest-ContainerRequest>ExpectedStartTime>Core/amazon::1.0/
	 * DateTimeWindow/[miq://document:1.0/Core/amazon:1.0/DateTimeWindow/34cf7dsdf88
	 * -3030-4b52-9dde-5586f2b0a579]/";
	 * dpaths.add("Utdi/amazon::1.0/ShippingRequest");
	 * dpaths.add("Utdi/amazon::1.0/ShippingRequest");
	 * dpaths.add("Utdi/amazon::1.0/ShippingRequest");
	 * dpaths.add("Utdi/amazon::1.0/ShippingRequest");
	 * dpaths.add("Utdi/amazon::1.0/ShippingRequest");
	 * dpaths.add("Utdi/amazon::1.0/ShippingRequest"); for (int i = 0; i <
	 * dpaths.size(); i++) { long startTime = System.nanoTime(); AntlrParser
	 * antlrLexerParser = new AntlrParser(); // System.out.println(new
	 * GsonBuilder().setPrettyPrinting().create() //
	 * .toJson(antlrLexerParser.getDpathInfo(dpaths.get(i))));
	 * antlrLexerParser.getDpathInfo(dpaths.get(i)); long endTime =
	 * System.nanoTime(); System.out.println("\nTime Taken:" + (endTime - startTime)
	 * + "ns"); }
	 * 
	 * }
	 * 
	 * @Test public void testBindingNameForSingleNode() { ArrayList<String>
	 * dpathsType2 = new ArrayList<String>();
	 * 
	 * for (int i = 0; i < dpathsType2.size(); i++) { long startTime =
	 * System.nanoTime(); AntlrParser antlrLexerParser = new AntlrParser();
	 * antlrLexerParser.getDpathInfo(dpathsType2.get(i)); long endTime =
	 * System.nanoTime(); System.out.println("\nTime Taken:" + (endTime - startTime)
	 * + "ns"); }
	 * 
	 * }
	 * 
	 * @Test public void testEntityNameForSingleNode() { ArrayList<String> dpaths =
	 * new ArrayList<String>();
	 * 
	 * for (int i = 0; i < dpaths.size(); i++) { long startTime = System.nanoTime();
	 * AntlrParser antlrLexerParser = new AntlrParser();
	 * antlrLexerParser.getDpathInfo(dpaths.get(i)); long endTime =
	 * System.nanoTime(); System.out.println("\nTime Taken:" + (endTime - startTime)
	 * + "ns"); }
	 * 
	 * } /*
	 * 
	 * @Test public void testAspectNameForSingleNode() { String dpath =
	 * "Utdi/amazon::1.0/ShippingRequest"; AntlrLexerParser antlrLexerParser = new
	 * AntlrLexerParser(); assertEquals("Utdi",
	 * antlrLexerParser.getDpathInfo(dpath).getStartNode().getAspectName());
	 * 
	 * }
	 * 
	 * @Test public void test7() { String dpath =
	 * "Utdi/amazon::1.0/ShippingRequest"; AntlrLexerParser antlrLexerParser = new
	 * AntlrLexerParser(); assertEquals(null,
	 * antlrLexerParser.getDpathInfo(dpath).getFinalNode());
	 * 
	 * }
	 * 
	 * @Test public void test8() { String dpath =
	 * "Utdi/amazon::1.0/ShippingRequest::4.0/ShippingRequest-ContainerRequest>ExpectedStartTime>Core/amazon::1.0/DateTimeWindow/";
	 * AntlrLexerParser antlrLexerParser = new AntlrLexerParser();
	 * assertEquals("ExpectedStartTime",
	 * antlrLexerParser.getDpathInfo(dpath).getRelationshipChain().get(1).toString()
	 * );
	 * 
	 * }
	 * 
	 * @Test public void test9() { String dpath =
	 * "Utdi/amazon::1.0/ShippingRequest/ShippingRequest-ContainerRequest>ExpectedStartTime>Core/amazon::1.0/DateTimeWindow::2.0/";
	 * AntlrLexerParser antlrLexerParser = new AntlrLexerParser();
	 * assertEquals(Float.valueOf("1.0"),
	 * antlrLexerParser.getDpathInfo(dpath).getFinalNode().getBindingVersion());
	 * 
	 * }
	 */

}
