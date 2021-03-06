package com.threezj.fuli.Util;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Zj on 2015/12/28.
 */
public class HttpUtil {

    private static RequestQueue mQueue;

    public static void httpRequest(Context context, final String address, final HttpUtilCallBack httpUtilCallBack){
        if (mQueue==null) mQueue = Volley.newRequestQueue(context);

        Response.Listener<String> requestListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                httpUtilCallBack.onFinsh(response);
            }
        };
        Response.ErrorListener requestErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                httpUtilCallBack.onError(error);
            }
        };

        StringRequest stringRequest = new StringRequest(address, requestListener, requestErrorListener);

        mQueue.add(stringRequest);
    }




    public interface HttpUtilCallBack {
        void onFinsh(String response);
        void onError(Exception e);
    }
}
