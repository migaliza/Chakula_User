package com.example.migaliza.chakula_user;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Salifu on 11/12/2015.
 */
public class Controller extends AsyncTask<String, Void, String> {

    public static String username;
    public static String password;
    public static int user_id;

    protected String doInBackground(String... params) {
        String cmd = params[0];
        String url = params[1];
        breakJsonLogin(sendRequest(url));
        return "done";
    }

    protected String sendRequest(String myUrl) {
        String response = "";
        HttpURLConnection urlConnection=null;

        try {
            URL url = new URL(myUrl);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader buffer = new BufferedReader(
                    new InputStreamReader(in));
            String s = "";
            while ((s = buffer.readLine()) != null) {
                //System.out.println(s);
                response += s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }

        return response;
    }

    @Override
    protected void onPostExecute(String result) {

    }

    /******** Get login details ********/
 public String[] breakJsonLogin(String jsonData){

            String OutputData = "";
            JSONObject jsonResponse;

            try {

                /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
                jsonResponse = new JSONObject(jsonData);

                /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
                /*******  Returns null otherwise.  *******/
                JSONArray jsonMainNode = jsonResponse.optJSONArray("user");

                if(jsonMainNode ==  null){
                    return null;
                }

                System.out.println(jsonMainNode);
                /*********** Process each JSON Node ************/

                int lengthJsonArr = jsonMainNode.length();

                for(int i=0; i < lengthJsonArr; i++)
                {
                    /****** Get Object for each JSON node.***********/
                    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                    /******* Fetch node values **********/
                    user_id = Integer.parseInt(jsonChildNode.optString("user_id"));
                    username   = jsonChildNode.optString("user_name");
                    password = jsonChildNode.optString("user_password");


                   OutputData += "Node : \n\n     "+ user_id +" | "
                            + username+" | "
                            + password +" \n\n ";

                    //Log.i("JSON parse", song_name);

                }

                /************ Show Output on screen/activity **********/

                //output.setText(OutputData);
                System.out.println(OutputData);

            } catch (JSONException e) {

                e.printStackTrace();
            }
            return null;
        }
}
