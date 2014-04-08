package com.example.darkroom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
	public static JSONArray getData(String phpFileName) throws JSONException {
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
		return new JSONArray(result);

	}

}
