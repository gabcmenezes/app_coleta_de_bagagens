package com.example.coleta_logsup.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.coleta_logsup.R;

import java.util.HashMap;
import java.util.Map;

public class AddItem extends AppCompatActivity implements View.OnClickListener {

    EditText tv;
    String st;
    TextView receiver_msg;
    EditText editTextItemName;
    EditText editTextBrand;
    Button buttonAddItem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_item);

        //Toast.makeText(AddItem.this, st, Toast.LENGTH_SHORT).show();

        editTextItemName = (EditText)findViewById(R.id.et_item_name);
        editTextBrand = (EditText)findViewById(R.id.et_brand);

        //tv=findViewById(R.id.et_item_name);
        //st=getIntent().getExtras().getString("Value");
        //tv.setText(st);

        buttonAddItem = (Button)findViewById(R.id.btn_add_item);
        buttonAddItem.setOnClickListener(this);

        //super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        receiver_msg = (TextView)findViewById(R.id.barcodetextview);

        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first
        // activity
        String str = intent.getStringExtra("message_key");

        // display the string into textView
//        receiver_msg.setText(str);
//        receiver_msg.setText(st);

        //Bundle extras = getIntent().getExtras();
        //int fetchedVariable = extras.getInt("a");
    }

    //This is the part where data is transafeered from Your Android phone to Sheet by using HTTP Rest API calls

    private void   addItemToSheet() {

        final ProgressDialog loading = ProgressDialog.show(this,"Adding Item","Please wait");
        final String name = editTextItemName.getText().toString().trim();
        final String brand = editTextBrand.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbzH_djucIPp18cyj8BVBm8WrIVgfahDhaiTkwfTYKuLiHfjNsiJ6f_ra8HCfkYOX5HUEQ/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Toast.makeText(AddItem.this,response,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),ActivityMain.class);
                        startActivity(intent);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<>();

                //here we pass params
                parmas.put("action","addItem");
                parmas.put("itemName",name);
                parmas.put("brand",brand);

                return parmas;
            }
        };

        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);


    }




    @Override
    public void onClick(View v) {

        if(v==buttonAddItem){
            addItemToSheet();

            //Define what to do when button is clicked
        }
    }
}
