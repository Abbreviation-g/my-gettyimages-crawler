package com.my.crawler.instagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class Headers {
	static List<Header> readHeader() throws IOException {
		List<Header> headers = new ArrayList<>();
		InputStream stream = Headers.class.getResourceAsStream("headers.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line = reader.readLine();

		String name = null;
		String value = null;
		while ((line = reader.readLine()) != null) {

			int index = line.indexOf(":");
			name = line.substring(0, index);
			value = line.substring(index + 2);
			if (name.equals("Content-Length")) {
				continue;
			}

			Header header = new BasicHeader(name, value);
			headers.add(header);
//			System.out.println(line);
		}
		reader.close();
		return headers;
	}
}
