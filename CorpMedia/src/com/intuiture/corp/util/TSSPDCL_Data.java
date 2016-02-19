package com.intuiture.corp.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TSSPDCL_Data {

	public static void main(String[] args) throws Exception {
		try {

			Connection.Response loginForm = Jsoup
					.connect(
							"https://tssouthernpower.com/CPDCL_Home.portal?_nfpb=true&_pageLabel=CPDCL_Home_portal_page_109")
					.method(Connection.Method.GET).execute();

			Document document = Jsoup
					.connect("https://tssouthernpower.com/CPDCL_Home.portal")
					.data("_nfpb", "true")
					.data("_windowLabel", "OnlineBillEnquiry_LeftPanel_3")
					.data("OnlineBillEnquiry_LeftPanel_3_actionOverride",
							"%2Fpages%2FBillingInfo%2FOnlineBillEnquiryDetailsBilling")
					.data("OnlineBillEnquiry_LeftPanel_3circle", "HYD")
					.data("OnlineBillEnquiry_LeftPanel_3eroHidden", "9")
					.data("OnlineBillEnquiry_LeftPanel_3scno", "")
					.data("OnlineBillEnquiry_LeftPanel_3uscno", "101430180")
					.data("ero", "9").cookies(loginForm.cookies()).post();
			Elements tdElements = document.getElementsByTag("td");
			List<String> keys = new ArrayList<String>();
			List<String> values = new ArrayList<String>();
			for (Element element : tdElements) {
				if (element.attr("bgcolor").equals("#E6F3FF")) {
					String key = element.html().replaceAll("<b>", "")
							.replaceAll("&nbsp;", "").replaceAll("</b>", "");
					keys.add(key);
				}
				if (element.attr("bgcolor").equals("#FFFFFF")) {
					String key = element.html().replaceAll("<b>", "")
							.replaceAll("&nbsp;", "").replaceAll("</b>", "")
							.replaceAll("<br", "").replaceAll("/>", "");
					values.add(key);
				}
			}
			System.out.println(keys + "\n" + values);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
