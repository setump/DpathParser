package com.dpath.language_based_document_parser.antlr_lexer_parser;

import java.util.ArrayList;

public class DpathList {
	public static ArrayList<String> getDpathList(int i) {
		ArrayList<String> dpathList = new ArrayList<String>();
		if (i == 1) {
			String original = "Utdi/amazon::1.0/ShippingRequest/ShippingRequest-ContainerRequest>ServiceOfferings>ServiceOfferings/amazon::1.0/ServiceGroup";
			String temp = original + '/';
			for (int j = 0; j < 1000; j++) {
				if (j < 0) {
					temp = original + String.valueOf(j) + '/';
				}
				dpathList.add(temp);
			}

		} else if (i == 2) {
			String original = "Utdi/amazon::1.0/ShippingRequest/ShippingRequest-ContainerRequest>ServiceOfferings>ServiceOfferings/amazon::1.0/ServiceGroup";
			String temp = original + '/';
			for (int j = 0; j < 10003; j++) {
				if (j < 10000) {
					temp = original + String.valueOf(j) + '/';
				}
				dpathList.add(temp);
			}

		} else if (i == 3) {
			String original = "Utdi/amazon::1.0/ShippingRequest/ShippingRequest-ContainerRequest>ServiceOfferings>ServiceOfferings/amazon::1.0/ServiceGroup";
			String temp = original + '/';
			for (int j = 0; j < 10003; j++) {
				if (j < 10003) {
					temp = original + String.valueOf(j) + '/';
				}
				dpathList.add(temp);
			}

		} else if (i == 4) {
			dpathList.add(
					"Utdi/amazon::1.0/ShippingRequest/ShippingRequest-ContainerRequest>ServiceOfferings>ServiceOfferings/amazon::1.0/ServiceGroup/");
			dpathList.add(
					"Utdi/amazon::1.0/ShippingRequest/ShippingRequest-ContainerRequest>ContainerRequest-Container");
			dpathList.add("Utdi/amazon::1.0/ShippingRequest");
		}
		return dpathList;
	}

}
