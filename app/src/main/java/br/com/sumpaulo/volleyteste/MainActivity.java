package br.com.sumpaulo.volleyteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {


    String url = "" ;//url server get;
    TextView textView ;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.txtView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST,
                            url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    textView.setText(response);

                                }

                            },
                            new Response.ErrorListener(){

                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    textView.setText("Error................");
                                }
                            }

                    );
                MySingletonRequest.getInstance(getApplicationContext())
                        .addToRequestQueue(stringRequest);
            }
        });

    }
}
