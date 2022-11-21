package com.my.crawler.common;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class HttpGets {
	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {
		String urlStr = "https://thumb-p9.xhcdn.com/a/l4HIS1HIaK4Qr9U2ZXADoQ/000/410/099/769_1000.jpg";
		URL url = new URL(urlStr);
		IPath path = new Path(url.getPath());
		path = path.removeFirstSegments(2);
		System.out.println(path);
	}
}
