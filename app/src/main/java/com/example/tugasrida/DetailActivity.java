package com.example.tugasrida;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nama = extras.getString("nama");
            String deskripsi = extras.getString("deskripsi");
            String harga = extras.getString("harga");
            int foto = extras.getInt("foto");

            TextView namaTextView = findViewById(R.id.nama);
            TextView deskripsiTextView = findViewById(R.id.desc);
            TextView hargaTextView = findViewById(R.id.harga);
            ImageView fotoImageView = findViewById(R.id.gambar);
            Button btnShare = findViewById(R.id.btnShare);

            namaTextView.setText(nama);
            deskripsiTextView.setText(deskripsi);
            hargaTextView.setText(harga);
            fotoImageView.setImageResource(foto);

            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent share = new Intent();
                    String text = "Nama Barang : " + nama + "\nDeskripsi : " + deskripsi + "\nHarga : " + harga;

                    Uri imageUri = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + getResources().getResourceEntryName(foto));

                    share.setAction(Intent.ACTION_SEND);
                    share.setType("image/*");
                    share.putExtra(Intent.EXTRA_TEXT, text);
                    share.putExtra(Intent.EXTRA_STREAM, imageUri);

                    startActivity(Intent.createChooser(share, "bagikan dengan"));
                }
            });
        }
    }
}