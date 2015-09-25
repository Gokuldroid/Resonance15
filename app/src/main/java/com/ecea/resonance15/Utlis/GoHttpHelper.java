package com.ecea.resonance15.Utlis;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by goku on 27-08-2015.
 */
public abstract class GoHttpHelper {

    public void execute(Request request)
    {
        HttpTask httpTask=new HttpTask();
        httpTask.execute(request);
    }
    public class HttpTask extends AsyncTask<Request,Integer,JSONObject>{
        @Override
        protected JSONObject doInBackground(Request... params) {
            OkHttpClient client=new OkHttpClient();
            Response response = null;
            JSONObject resultObj=new JSONObject();
            try {
                response = client.newCall(params[0]).execute();
                if (response.isSuccessful()) {
                    resultObj.put("result",true);
                    resultObj.put("resultbody",response.body().string());
                    return resultObj;
                } else {
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
            if(jsonObject!=null)
            {
                try {
                    Response(true,jsonObject.getString("resultbody"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            else {
                Response(true,null);
            }
        }
    }
    abstract public void Response(boolean result,String response);
}