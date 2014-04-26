
package com.example.darkroom;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class DatabaseQueryer {

	/**
	 * Function to query the database and obtain a result set in the form of a
	 * JSON array.
	 * 
	 * @param phpFileName
	 *            -- Name of the php file in the EECS395 folder -- note: the
	 *            method accepts files using JUST THE NAME of the php file-- ie
	 *            to use myFile.php, use argument "myFile";
	 * @return JSONArray containing the results of the query.
	 * @throws JSONException -- if there is an error parsing data to JSONArray object
	 */
	public static String getData(String phpFileName) {
		String result = "";
		InputStream isr = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(
					"http://10.0.2.2/EECS395/"+phpFileName+ ".php");
			HttpResponse response = httpclient.execute(httppost);
			
			HttpEntity entity = response.getEntity();
			isr = entity.getContent();
		} catch (Exception e) {
			Log.e("log_tag", "Error in http connection " + e.toString());
		}
		// convert response to string
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					isr, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			isr.close();

			result = sb.toString();
		} catch (Exception e) {
			Log.e("log_tag", "Error  converting result " + e.toString());
		}
		/*
		 * // parse json data try { String s = ""; JSONArray jArray = new
		 * JSONArray(result);
		 * 
		 * for (int i = 0; i < jArray.length(); i++) { JSONObject json =
		 * jArray.getJSONObject(i); s = s + "Name : " +
		 * json.getString("username") + " " + json.getString("email"); }
		 * 
		 * 
		 * 
		 * } catch (Exception e) {
		 * 
		 * Log.e("log_tag", "Error Parsing Data " + e.toString()); }
		 */
		return result;

	}

	public void gay() throws IOException{
		URL url = new URL("http://localhost/CD/user/test");
	    String result = "";
	    String data = "fName=" + URLEncoder.encode("Atli", "UTF-8");
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	    try {

	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	        connection.setUseCaches(false);
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Content-Type",
	                "application/x-www-form-urlencoded");

	        // Send the POST data
	        DataOutputStream dataOut = new DataOutputStream(
	                connection.getOutputStream());
	        dataOut.writeBytes(data);
	        dataOut.flush();
	        dataOut.close();

	        BufferedReader in = null;
	        try {
	            String line;
	            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } finally {
	            if (in != null) {
	                in.close();
	            }
	        }
	        String g;
	        while ((g = in.readLine()) != null) {
	            result += g;
	        }
	        in.close();

	    } finally {
	        connection.disconnect();
	        System.out.println(result);
	    }
	}
}

