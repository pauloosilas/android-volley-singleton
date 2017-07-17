package br.com.sumpaulo.volleyteste;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by paulo on 17/07/17.
 */

public class MySingletonRequest {

    private static MySingletonRequest mySingletonRequestInstance;
    private RequestQueue requestQueue;
    private static Context context;

    private MySingletonRequest(Context context){
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());

        return requestQueue;
    }

    public static synchronized MySingletonRequest getInstance(Context context){
        if(mySingletonRequestInstance == null){
            mySingletonRequestInstance = new MySingletonRequest(context);
        }
        return mySingletonRequestInstance;
    }

    public<T> void addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
}
