package com.example.coleta_logsup.activities;

import android.content.Intent;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;
import com.example.coleta_logsup.activities.users.UserNewActivity;
import com.example.coleta_logsup.activities.users.UsersActivity;
import com.example.coleta_logsup.models.Baggage;
import com.example.coleta_logsup.models.User;

public class UploadPhoto extends AppCompatActivity {
    private ImageView imageView;
    private Button button, button_save_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_photo_activity01);
        imageView = findViewById(R.id.capturedImage);
        button = findViewById(R.id.openCamera);

        Button buttonsavephoto = (Button) findViewById(R.id.button_save_photo);
        ImageView capturedImage = (ImageView) findViewById(R.id.capturedImage);

        if (capturedImage.getDrawable() == null) {
            //Toast.makeText(this, "ImageView vazio", Toast.LENGTH_SHORT).show();
        }else{
            buttonsavephoto.findViewById(R.id.button_save_photo);
            buttonsavephoto.setEnabled(true);
        }

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera, 100);
            }
        });

        getSupportActionBar().hide(); //esconder actionbar
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap photo = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(photo);
        imageView = findViewById(R.id.capturedImage);
        Button buttonsavephoto = (Button) findViewById(R.id.button_save_photo);
        ImageView capturedImage = (ImageView) findViewById(R.id.capturedImage);
        if (capturedImage.getDrawable() != null) {
            buttonsavephoto.findViewById(R.id.button_save_photo);
            buttonsavephoto.setEnabled(true);
        }
    }

    public void salvarFoto(View view) {
        Toast.makeText(this, "Imagem salva com sucesso.", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, ScanActivity.class));
    }

    /////////////////////////////////
    /*public void save(View view) {
        try {
            baggageDAO.insert(new Baggage(
                    user.getText().toString(),
                    quantity.getText().toString())
            );
            Toast.makeText(this, "Foto salva no BD com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (SQLException e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, UserNewActivity.class));
        }
    }*/
    /////////////////////////////////////
}