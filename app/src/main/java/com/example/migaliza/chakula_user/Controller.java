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
import java.util.ArrayList;


/**
 * Created by Salifu on 11/23/2015.
 */
public class Controller extends AsyncTask<String, Void, String> {

    public static String username;
    public static String password;
    public static int user_id;
    //public static OrderHistory.Order[] history;
    public ArrayList<Meal> meals = new ArrayList<>();
    public ArrayList<OrderHistory> historylist = new ArrayList<>();
    public ArrayList<CurrentOrder> currentOrders = new ArrayList<>();

    protected String doInBackground(String... params) {
        String cmd = params[0];
        String url = params[1];
        if(cmd.equals("login")){
            breakJsonLogin(sendRequest(url));
        }else if(cmd.equals("history")){
            breakJsonHistory(sendRequest(url));
        }else if(cmd.equals("meals")){
            breakJsonMeals(sendRequest(url));
        }else if(cmd.equals("current")){
            breakJsonCurrent(sendRequest(url));
        }
        return "done";
    }

    /*public static OrderHistory.Order[] getHistory(){
        return history;
    }
    */

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
            //System.out.println(OutputData);

        } catch (JSONException e) {

            e.printStackTrace();
        }
        return null;
    }


    public String breakJsonHistory(String jsonData){

        JSONObject jsonResponse;

        try {

            /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
            jsonResponse = new JSONObject(jsonData);

            /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
    /*******  Returns null otherwise.  *******/
           JSONArray jsonMainNode = jsonResponse.optJSONArray("orders");

            if(jsonMainNode ==  null){
                return null;
            }

            System.out.println(jsonMainNode);
            /*********** Process each JSON Node ************/

            int lengthJsonArr = jsonMainNode.length();
            //historylist = new OrderHistory.Order[lengthJsonArr];
            for(int i=0; i < lengthJsonArr; i++)
            {
                /****** Get Object for each JSON node.***********/
               JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                /******* Fetch node values **********/
                String meal_name = jsonChildNode.optString("meal_name");
                String meal_price   = jsonChildNode.optString("meal_price");
                String timestamp = jsonChildNode.optString("timestamp");


                OrderHistory myorde = new OrderHistory(meal_name, meal_price, timestamp);
                historylist.add(myorde);

            }

            /************ Show Output on screen/activity **********/

        //output.setText(OutputData);
           //System.out.println(historylist.get(0).order_details);

        } catch (JSONException e) {

            e.printStackTrace();
        }
        return "Yes";
    }

    public String breakJsonMeals(String jsonData){

        JSONObject jsonResponse;

        try {

            /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
            jsonResponse = new JSONObject(jsonData);

            /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
            /*******  Returns null otherwise.  *******/
            JSONArray jsonMainNode = jsonResponse.optJSONArray("meals");

            if(jsonMainNode ==  null){
                return null;
            }

            System.out.println(jsonMainNode);
            /*********** Process each JSON Node ************/

            int lengthJsonArr = jsonMainNode.length();
            //meals = new Meal[lengthJsonArr];
            for(int i=0; i < lengthJsonArr; i++)
            {
                /****** Get Object for each JSON node.***********/
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                /******* Fetch node values **********/
                String meal_name = jsonChildNode.optString("meal_name");
                String meal_price   = jsonChildNode.optString("meal_price");
                String meal_id = jsonChildNode.optString("meal_id");
                String cafeteria = jsonChildNode.optString("cafeteria_name");
                String availability = jsonChildNode.optString("meal_availability");

                meals.add(new Meal(meal_id, meal_name, meal_price, cafeteria, availability));
            }

            /************ Show Output on screen/activity **********/

            //output.setText(OutputData);
            System.out.println(meals.get(0));

        } catch (JSONException e) {

            e.printStackTrace();
        }
        return "Yes";
    }

    public String breakJsonCurrent(String jsonData){

        JSONObject jsonResponse;

        try {

            /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
            jsonResponse = new JSONObject(jsonData);

            /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
            /*******  Returns null otherwise.  *******/
            JSONArray jsonMainNode = jsonResponse.optJSONArray("current_orders");

            if(jsonMainNode ==  null){
                return null;
            }

            System.out.println(jsonMainNode);
            /*********** Process each JSON Node ************/

            int lengthJsonArr = jsonMainNode.length();
            //historylist = new OrderHistory.Order[lengthJsonArr];
            for(int i=0; i < lengthJsonArr; i++)
            {
                /****** Get Object for each JSON node.***********/
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                /******* Fetch node values **********/
                String order_detail = jsonChildNode.optString("meal_name");
                String meal_price   = jsonChildNode.optString("meal_price");
                String timestamp = jsonChildNode.optString("timestamp");
                String status = jsonChildNode.optString("status");

                CurrentOrder myorde = new CurrentOrder(order_detail, meal_price, timestamp, status);
                currentOrders.add(myorde);

            }

            /************ Show Output on screen/activity **********/

            //output.setText(OutputData);
           // System.out.println(currentOrders.get(0).order_details);

        } catch (JSONException e) {

            e.printStackTrace();
        }
        return "Yes";
    }
}

