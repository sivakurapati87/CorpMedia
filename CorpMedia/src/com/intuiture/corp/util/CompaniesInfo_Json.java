package com.intuiture.corp.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CompaniesInfo_Json {
	public static void main(String[] args) throws Exception {
		Document htmlFile = null;
		Elements requiredInputTags = new Elements();
		List<String> companiesList = new ArrayList<String>();
		List<String> companiesUUIDList = new ArrayList<String>();
		Map<String, Map<String, String>> compWithInfoMap = new HashMap<String, Map<String, String>>();
		Map<String, Map<String, Map<String, String>>> compWithSignatoriesMap = new HashMap<String, Map<String, Map<String, String>>>();
		CompaniesInfo_Json ex = new CompaniesInfo_Json();
		try {

			for (int input = 0; input < 2; input++) {
				htmlFile = Jsoup.parseBodyFragment(ex.sendPost(input));// Jsoup.parse(new
																		// File("d://companies.html"),
																		// "ISO-8859-1");

				Element body = htmlFile.body();
				Elements inputTags = body.getElementsByTag("input"); // getting
																		// class
																		// form
																		// HTML
																		// element

				int i = 0;
				for (Element inputTag : inputTags) {
					if (inputTag.getElementById("strCompanyName" + i) != null) {
						requiredInputTags.add(inputTag);
						companiesList.add(inputTag.getElementsByAttribute("value").val());
					}
					if (inputTag.getElementById("strCin" + i) != null) {
						requiredInputTags.add(inputTag);
						companiesUUIDList.add(inputTag.getElementsByAttribute("value").val());
						i++;
					}
				}
				System.out.println("Jsoup can also parse HTML file directly");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // right
		System.out.println("\nclass of div tag : " + companiesList);
		Boolean isNeedToDisplay = false;
		for (int j = 0; j < companiesList.size(); j++) {
			htmlFile = Jsoup.parseBodyFragment(ex.sendPost(companiesList.get(j), companiesUUIDList.get(j)));
			Map<String, String> compInfoMap = new HashMap<String, String>();
			Element body = htmlFile.body();
			// System.out.println(body);
			Elements trs = body.getElementsByTag("tr");
			// List<String> compInfoList = new ArrayList<String>();
			String keyOrValue = null;
			for (Element tr : trs) {
				Elements tds = tr.getElementsByTag("td");
				String key = null, value = null;
				for (Element td : tds) {
					if (td.html().equals(("<h4>Company Master Details</h4>"))) {
						isNeedToDisplay = true;
					}
					if (isNeedToDisplay && !td.html().contains("Prosecution Details") && !td.html().contains("<h4>Company Master Details</h4>")) {
						System.out.println(td.html().replaceAll("&nbsp;", ""));
						if (td.html().startsWith("<br>")) {
							isNeedToDisplay = false;
						} else {

							if (td.html().replaceAll("&nbsp;", "").contains("select")) {
								Elements optionsElements = td.getElementsByTag("option");
								for (Element option : optionsElements) {
									if (option.hasAttr("selected")) {
										keyOrValue = option.html().replaceAll("&nbsp;", "").trim();
									}
								}
							} else if (td.html().replaceAll("&nbsp;", "").contains("input")) {
								Elements inputElements = td.getElementsByTag("input");
								for (Element input : inputElements) {
									if (input.attr("type").equals("text")) {
										if (input.getElementsByAttribute("value").val().trim().length() == 0) {
											keyOrValue = null;
										} else {
											keyOrValue = input.getElementsByAttribute("value").val().trim();
										}
									}
									if (input.attr("type").equals("radio")) {
										if (input.hasAttr("checked")) {
											switch (input.getElementsByAttribute("value").val().trim()) {
											case "L":
												keyOrValue = "Listed";
												break;
											case "U":
												keyOrValue = "Unlisted";
												break;
											case "PUBC":
												keyOrValue = "Public";
												break;
											default:
												keyOrValue = "Private";
											}
										}
									}
								}
							} else {
								keyOrValue = td.html().replaceAll("&nbsp;", "").replaceAll(":", "").trim();
							}
							if (td.html().contains(":")) {
								value = keyOrValue != null ? keyOrValue.replaceAll("&amp;", "&") : keyOrValue;
							} else {
								key = keyOrValue != null ? keyOrValue.replaceAll("&amp;", "&") : keyOrValue;
							}
							compInfoMap.put(key, value);
						}
					}
				}
			}

			compWithInfoMap.put(companiesList.get(j), compInfoMap);
			// for Signatories
			htmlFile = Jsoup.parseBodyFragment(ex.sendGet(companiesUUIDList.get(j)));
			Map<String, Map<String, String>> signatorWithInfoMap = new HashMap<String, Map<String, String>>();
			body = htmlFile.body();
			trs = body.getElementsByTag("tr");
			keyOrValue = null;
			List<String> keysOfSignators = new ArrayList<String>();
			for (Element tr : trs) {
				if (!tr.attr("class").equals("mca-header")) {
					if (tr.attr("class").equals("mca-row")) {
						Elements tds = tr.getElementsByTag("td");
						for (Element td : tds) {
							keysOfSignators.add(td.html().replaceAll("&nbsp;<b>", "").replaceAll("&nbsp;", "").replaceAll("</b>", "").trim());
						}
					} else {
						Elements tds = tr.getElementsByTag("td");
						Map<String, String> signatorsInfoMap = new HashMap<String, String>();
						for (int k = 1; k < tds.size(); k++) {
							signatorsInfoMap.put(keysOfSignators.get(k), tds.get(k).html().trim());
						}
						signatorWithInfoMap.put(tds.get(1).html().trim(), signatorsInfoMap);
						compWithSignatoriesMap.put(companiesList.get(j), signatorWithInfoMap);
					}
				}
			}
		}
		// Getting comapanies info
		System.out.println("[");
		ArrayList<String> compList = new ArrayList<String>();
		compList.addAll(compWithInfoMap.keySet());
		for (int k = 0; k < compList.size(); k++) {
			System.out.println("{\"company name\":\"" + compList.get(k) + "\",");
			ArrayList<String> compInfoList = new ArrayList<String>();
			compInfoList.addAll(compWithInfoMap.get(compList.get(k)).keySet());
			for (int c = 0; c < compInfoList.size(); c++) {
				System.out.print("\"" + compInfoList.get(c) + "\" : " + "\"" + compWithInfoMap.get(compList.get(k)).get(compInfoList.get(c)) + "\"");
				if (c != compInfoList.size() - 1) {
					System.out.println(",");
				}
			}
			System.out.println("}");
			if (k != compList.size() - 1) {
				System.out.println(",");
			}
		}
		System.out.println("]");

		ArrayList<String> cList = new ArrayList<String>();
		cList.addAll(compWithSignatoriesMap.keySet());
		// Getting signators info
		System.out.println("[");
		for (int c = 0; c < cList.size(); c++) {
			System.out.println("{\"company name\":\"" + cList.get(c) + "\",");
			ArrayList<String> signatorsList = new ArrayList<String>();
			signatorsList.addAll(compWithSignatoriesMap.get(cList.get(c)).keySet());
			System.out.println("\"signators\":[");
			for (int s = 0; s < signatorsList.size(); s++) {
				System.out.println("{\"signator name\":\"" + signatorsList.get(s) + "\",");
				ArrayList<String> signatorInfoList = new ArrayList<String>();
				signatorInfoList.addAll(compWithSignatoriesMap.get(cList.get(c)).get(signatorsList.get(s)).keySet());
				for (int si = 0; si < signatorInfoList.size(); si++) {
					System.out.print("\"" + signatorInfoList.get(si) + "\" : " + "\"" + compWithSignatoriesMap.get(cList.get(c)).get(signatorsList.get(s)).get(signatorInfoList.get(si)) + "\"");
					if (si != signatorInfoList.size() - 1) {
						System.out.println(",");
					}
				}
				System.out.println("}");
				if (s != signatorsList.size() - 1) {
					System.out.println(",");
				}
			}
			System.out.println("]");
			System.out.println("}");
			if (c != cList.size() - 1) {
				System.out.println(",");
			}
		}
		System.out.println("]");

	}

	private final String USER_AGENT = "Mozilla/5.0";

	public static void sd(String[] args) throws Exception {

		CompaniesInfo_Json http = new CompaniesInfo_Json();

		// System.out.println("Testing 1 - Send Http GET request");
		// http.sendGet();

		System.out.println("\nTesting 2 - Send Http POST request");
		// http.sendPost();

	}

	// HTTP GET request
	private String sendGet(String cin) throws Exception {

		String url = "http://mca.gov.in/DCAPortalWeb/dca/SignatoryDetailsAction.do?method=viewSignatoryComp&cin=" + cin;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Cookie", "JSESSIONID=0000Acs1cQgsRkLas9IpsEpORV8:17ufb6htp");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		// System.out.println(response.toString());
		return response.toString();

	}

	// HTTP POST request
	private String sendPost(int i) throws Exception {
		StringBuffer response = new StringBuffer();
		String url = "http://mca.gov.in/DCAPortalWeb/dca/displayCIN.do";
		URL obj = new URL(url);

		String urlParameters = null;

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Cookie", "JSESSIONID=0000Acs1cQgsRkLas9IpsEpORV8:17ufb6htp");

		con.setRequestProperty("Connection", "keep-alive");
		if (i == 0)
			urlParameters = "companyName=IN&method=fetchCIN&property=&stFieldName0=1%3AcompanyName&stFieldName1=2%3Acin&stFieldName2=&stFieldName3=&stFieldName4=&stNextEnabled=&stPreviousEnabled=&styleId=&taskID=1501&textproperty=&textstyleId=";
		else {
			urlParameters = "companyName=INT&method=next&property=&queryValues=&radSelect=0&rowModified_listlov=&stFieldName0=1%3AcompanyName&stFieldName1=2%3Acin&stFieldName2=&stFieldName3=&stFieldName4=&stNextEnabled=true&stPreviousEnabled=true&strCin=U93020AP2005PTC048475&strCin=U92113PB2012PTC036009&strCin=U74999TN2012PTC088656&strCin=U74300DL2003PTC120504&strCin=U74210DL2010FTC201569&strCin=U92120MH2006PTC165101&strCin=U72900DL2000PLC104575&strCin=U74210DL2011PTC212284&strCin=U22121MH2000PLC129433&strCin=U74899DL1989PTC034535&strCompanyName=IN%20BEAUTY%20HAIR%20PRODUCTS%20PRIVATE%20LIMITED&strCompanyName=IN%20CABLE%20TRANSMISSIONS%20PRIVATE%20LIMITED&strCompanyName=IN%20CINEMAS%20ENTERTAINMENT%20PRIVATE%20LIMITED&strCompanyName=IN%20COMMUNICATIONS%20ADVERTISING%20PRIVATE%20LIMITED&strCompanyName=In%20Crane%20Equipment%20Private%20Limited&strCompanyName=IN%20DEPTH%20ENTERTAINING%20ARTS%20PRIVATE%20LIMITED&strCompanyName=IN%20E-COMMERCE%20SOFTECH%20LIMITED&strCompanyName=IN%20ENGINEERING%20PRIVATE%20LIMITED&strCompanyName=IN%20ENTERTAINMENT%20(INDIA)%20LIMITED&strCompanyName=IN%20EXPORTS%20PRIVATE%20LIMITED&styleId=&taskID=1501&textproperty=&textstyleId=";
		}// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print result
		System.out.println(response.toString());
		return response.toString();
	}

	// HTTP POST request
	private String sendPost(String cmpName, String cmpId) throws Exception {
		StringBuffer response = new StringBuffer();
		String url = "http://mca.gov.in/DCAPortalWeb/dca/CompanyMaster.do";
		URL obj = new URL(url);

		String urlParameters = null;

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Cookie", "JSESSIONID=0000Acs1cQgsRkLas9IpsEpORV8:17ufb6htp");

		con.setRequestProperty("Connection", "keep-alive");
		// if (i == 0)
		// urlParameters =
		// "companyName=IN&method=fetchCIN&property=&stFieldName0=1%3AcompanyName&stFieldName1=2%3Acin&stFieldName2=&stFieldName3=&stFieldName4=&stNextEnabled=&stPreviousEnabled=&styleId=&taskID=1501&textproperty=&textstyleId=";
		urlParameters = "cmpnyID=" + cmpId + "&cmpnyname=" + cmpName + "&method=find&taskID=9412";
		// else {
		// urlParameters =
		// "companyName=INT&method=next&property=&queryValues=&radSelect=0&rowModified_listlov=&stFieldName0=1%3AcompanyName&stFieldName1=2%3Acin&stFieldName2=&stFieldName3=&stFieldName4=&stNextEnabled=true&stPreviousEnabled=true&strCin=U93020AP2005PTC048475&strCin=U92113PB2012PTC036009&strCin=U74999TN2012PTC088656&strCin=U74300DL2003PTC120504&strCin=U74210DL2010FTC201569&strCin=U92120MH2006PTC165101&strCin=U72900DL2000PLC104575&strCin=U74210DL2011PTC212284&strCin=U22121MH2000PLC129433&strCin=U74899DL1989PTC034535&strCompanyName=IN%20BEAUTY%20HAIR%20PRODUCTS%20PRIVATE%20LIMITED&strCompanyName=IN%20CABLE%20TRANSMISSIONS%20PRIVATE%20LIMITED&strCompanyName=IN%20CINEMAS%20ENTERTAINMENT%20PRIVATE%20LIMITED&strCompanyName=IN%20COMMUNICATIONS%20ADVERTISING%20PRIVATE%20LIMITED&strCompanyName=In%20Crane%20Equipment%20Private%20Limited&strCompanyName=IN%20DEPTH%20ENTERTAINING%20ARTS%20PRIVATE%20LIMITED&strCompanyName=IN%20E-COMMERCE%20SOFTECH%20LIMITED&strCompanyName=IN%20ENGINEERING%20PRIVATE%20LIMITED&strCompanyName=IN%20ENTERTAINMENT%20(INDIA)%20LIMITED&strCompanyName=IN%20EXPORTS%20PRIVATE%20LIMITED&styleId=&taskID=1501&textproperty=&textstyleId=";
		// }// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print result
		// System.out.println(response.toString());
		return response.toString();
	}
}
