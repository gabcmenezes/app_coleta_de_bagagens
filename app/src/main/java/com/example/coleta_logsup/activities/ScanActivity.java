package com.example.coleta_logsup.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coleta_logsup.R;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScanActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            } else {
                // permissão concedida, pode acessar a pasta de download do dispositivo
            }
        } else {
            // versão anterior ao Android 10, permissão concedida automaticamente
        }






        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_form_layout);

        editText = findViewById(R.id.editText_codigoBarras);
        button = findViewById(R.id.button_salvar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor = editText.getText().toString();
                DadosPlanilha dados = new DadosPlanilha(valor);
                //File file = new File(Environment.getExternalStorageDirectory(), "meu_arquivo.xlsx");
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "teste.xlsx");
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Planilha1");
                Row row = sheet.createRow(0);
                Cell cell = row.createCell(0);
                cell.setCellValue(dados.getValor());

                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    workbook.write(fos);
                    fos.flush();
                    fos.close();
                    Toast.makeText(ScanActivity.this, "Dados salvos com sucesso!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    //Toast.makeText(TestSaveBarCodeIntoExcel.this, "Erro ao salvar os dados!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(ScanActivity.this, "Erro ao salvar os dados: " + e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public class DadosPlanilha {
        private String valor;

        public DadosPlanilha(String valor) {
            this.valor = valor;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }
    }
}
