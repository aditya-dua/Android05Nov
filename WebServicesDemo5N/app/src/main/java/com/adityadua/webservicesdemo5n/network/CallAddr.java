package com.adityadua.webservicesdemo5n.network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.adityadua.webservicesdemo5n.utils.CommonUtilities;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import okio.Buffer;
import java.util.concurrent.TimeUnit;

/**
 * Created by AdityaDua on 27/01/18.
 */

public class CallAddr extends AsyncTask<String,Void,String> {


    Context context;
    String result = "";
    FormEncodingBuilder formBody;
    String url;
    OnWebServiceResult resultListener;
    CommonUtilities.SERVICE_TYPE serviceType;
    Request request;

    public CallAddr(Context context, FormEncodingBuilder formBody, String url, CommonUtilities.SERVICE_TYPE serviceType, OnWebServiceResult resultListener) {
        this.context = context;
        this.formBody = formBody;
        this.url = url;
        this.serviceType = serviceType;
        this.resultListener = resultListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        OkHttpClient client =new OkHttpClient();
        client.setConnectTimeout(120, TimeUnit.SECONDS); // connect timeout
        client.setReadTimeout(120, TimeUnit.SECONDS); // socket timeout
        //formBody.add("platform", "android");

        RequestBody body = formBody.build();
        Request request = new Request.Builder()
                .url(url)
                //.post(body)
                .build();
        Log.e("CallAddr ", "url= " + url + " params= " + bodyToString(request));
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                result = response.toString();
                if (result.equals("") || result.equals("null") || result.length() == 0) {
                    // CommonUtilities.showToast(context, "Something went wrong. Try later.");
                }
            } else {

            }
            result = response.body().string();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.e("Response is ::","Response ::"+s);
        resultListener.getWebResponse(s,serviceType);
    }


    private static String bodyToString(final Request request) {

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (Exception e) {
            return "did not work";
        }
    }
}










