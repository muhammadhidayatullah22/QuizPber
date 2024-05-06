package com.example.tugasday10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private RadioGroup menuRadioGroup,minumanRadioGroup;
    private TextInputEditText jumlahPorsiEditText;
    private Button pesanButton;

    private int hargaMakanan = 0;
    private int hargaMinuman = 0;
    private int jumlahPorsi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuRadioGroup = findViewById(R.id.rg1);
        minumanRadioGroup = findViewById(R.id.rg2);
        jumlahPorsiEditText = findViewById(R.id.et1);
        pesanButton = findViewById(R.id.btn);

        pesanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedMenuId = menuRadioGroup.getCheckedRadioButtonId();
                int selectedMinumanId = minumanRadioGroup.getCheckedRadioButtonId();

                switch (selectedMenuId) {
                    case R.id.rb1:
                        hargaMakanan = 10000;
                        break;
                    case R.id.rb2:
                        hargaMakanan = 8000;
                        break;
                    case R.id.rb3:
                        hargaMakanan = 8000;
                        break;
                    case R.id.rb4:
                        hargaMakanan = 15000;
                        break;
                }

                switch (selectedMinumanId) {
                    case R.id.rb5:
                        hargaMinuman = 5000;
                        break;
                    case R.id.rb6:
                        hargaMinuman = 7000;
                        break;
                }

                jumlahPorsi = Integer.parseInt(jumlahPorsiEditText.getText().toString());

                int totalHarga = (hargaMakanan + hargaMinuman) * jumlahPorsi;

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("menu_makanan", getSelectedMenuMakanan());
                intent.putExtra("menu_minuman", getSelectedMenuMinuman());
                intent.putExtra("jumlah_porsi", jumlahPorsi);
                intent.putExtra("total_harga", totalHarga);
                startActivity(intent);
            }
        });
    }

    private String getSelectedMenuMakanan() {
        int selectedMenuId = menuRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedMenuRadioButton = findViewById(selectedMenuId);
        return selectedMenuRadioButton.getText().toString();
    }

    private String getSelectedMenuMinuman() {
        int selectedMinumanId = minumanRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedMinumanRadioButton = findViewById(selectedMinumanId);
        return selectedMinumanRadioButton.getText().toString();
    }
}