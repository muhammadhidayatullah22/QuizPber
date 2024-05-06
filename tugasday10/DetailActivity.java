package com.example.tugasday10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView menuMakananTextView;
    private TextView menuMinumanTextView;
    private TextView jumlahPorsiTextView;
    private TextView totalHargaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        menuMakananTextView = findViewById(R.id.tvmakanan);
        menuMinumanTextView = findViewById(R.id.tvminuman);
        jumlahPorsiTextView = findViewById(R.id.tvporsi);
        totalHargaTextView = findViewById(R.id.tvtotal);

        Intent intent = getIntent();
        String menuMakanan = intent.getStringExtra("menu_makanan");
        String menuMinuman = intent.getStringExtra("menu_minuman");
        int jumlahPorsi = intent.getIntExtra("jumlah_porsi", 0);
        int totalHarga = intent.getIntExtra("total_harga", 0);

        menuMakananTextView.setText("Menu: " + menuMakanan);
        menuMinumanTextView.setText("Minuman: " + menuMinuman);
        jumlahPorsiTextView.setText("Jumlah Porsi: " + jumlahPorsi);
        totalHargaTextView.setText("Total Harga: Rp " + totalHarga);
    }
}