package com.example.coleta_logsup.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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

public class InsertDataIntoGoogleSheets extends AppCompatActivity {
    EditText etName;
    Button btnInsert;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_data_into_google_sheets);

        etName = findViewById(R.id.etName);
        btnInsert = findViewById(R.id.btnInsert);

        progressDialog = new ProgressDialog(InsertDataIntoGoogleSheets.this);
        progressDialog.setMessage("Aguarde...");

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addStudentData();
                progressDialog.show();
            }
        });
    }
    public void addStudentData(){
        String sName = etName.getText().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbxqqgIREUYu7ikN1wgx06gqVrX1lgdzN0fpb6XJv8vIZGGEH8cCgJh9gqrkTF6IcRMqcQ/exec", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent intent = new Intent(getApplicationContext(), SuccessActivity.class);
                startActivity(intent);
                progressDialog.hide();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("action", "addStudent");
                params.put("vName", sName);

                return params;
            }
        };

        int socketTimeOut = 50000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}