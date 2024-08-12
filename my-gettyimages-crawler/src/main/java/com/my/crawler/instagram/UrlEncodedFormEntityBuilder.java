package com.my.crawler.instagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class UrlEncodedFormEntityBuilder {

	public static List<NameValuePair> getPairs() throws IOException {
		List<NameValuePair> pairs = new ArrayList<>();
		InputStream stream = Headers.class.getResourceAsStream("form.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line = reader.readLine();

		reader.close();

		String[] splitAnd = line.split("&");
		for (String str1 : splitAnd) {
//			System.out.println(str1);
			String[] splitStr1 = str1.split("=");
			NameValuePair pair = new BasicNameValuePair(splitStr1[0], splitStr1[1]);
			pairs.add(pair);
		}
		System.out.println(pairs);
		return pairs;
	}
}
