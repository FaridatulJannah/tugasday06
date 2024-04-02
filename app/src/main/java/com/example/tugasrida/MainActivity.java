package com.example.tugasrida;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MieAdapter.OnItemClickListener{

    private RecyclerView recyclerView;
    private MieAdapter mieAdapter;
    private ArrayList<MieModel> mieModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getData();

        recyclerView = findViewById(R.id.recycleview);
        mieAdapter = new MieAdapter(mieModel);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mieAdapter);

        mieAdapter.setOnItemClickListener(this);
    }

    private void getData() {
        mieModel = new ArrayList<>();
        mieModel.add(new MieModel("Mie Hype Abis","Mie goreng dengan rasa ayam geprek pedas lengkap dengan minyak dan bumbu","Rp. 3.600", R.drawable.miegor1));
        mieModel.add(new MieModel("Mie Goreng Rendang","Mie goreng dengan rasa bumbu rendang","Rp. 3.900", R.drawable.miegor2));
        mieModel.add(new MieModel("Mie Goreng original","Mie goreng biasa tanpa ada rasa tambahan","Rp. 3.000", R.drawable.miegor3));
        mieModel.add(new MieModel("Mie Goreng Aceh","Mie goreng Kuliner Indonesia bumbu khas Aceh","Rp. 3.600", R.drawable.miegor4));
        mieModel.add(new MieModel("Mie Goreng Hot Spicy","Mie goreng dengan pedas diatas rata-rata","Rp. 4.000", R.drawable.miegor5));
        mieModel.add(new MieModel("Mie Goreng Cakalang ","Mie goreng Kuliner Indonesia khas Sulawesi Utara","Rp. 5.000", R.drawable.miegor6));
        mieModel.add(new MieModel("Mie Goreng Sate","Mie goreng dengan rasa bumbu Sate","Rp. 3.000", R.drawable.miegor7));
        mieModel.add(new MieModel("Mie Goreng Ayam Pop","Mie goreng Kuliner Indonesia khas Sumatera Barat","Rp. 3.500", R.drawable.miegor8));
        mieModel.add(new MieModel("Mie Goreng Cabe Ijo","Mie goreng dengan bumbu Cabe hijau rawit","Rp. 3.600", R.drawable.miegor9));
        mieModel.add(new MieModel("Mie Goreng Salted Egg","Mie keriting goreng telur asin lengkap dengan bumbu pasta dan daun kari","Rp. 3.000", R.drawable.miegor10));
        mieModel.add(new MieModel("Mie Goreng Masak Habang","Mie goreng Kuliner Indonesia khas Kalimantan Selatan","Rp. 5.000", R.drawable.miegor11));
        mieModel.add(new MieModel("Mie Goreng Ayam Panggang","Mie keriting goreng dengan rasa lebih mantap lengkap dengan bumbu dan sayuran kering","Rp. 4.000", R.drawable.miegor12));
        mieModel.add(new MieModel("Mie Goreng Dendeng Balado","Mie goreng Kuliner Indonesia khas Padang dengan rasa dendeng baladonya","Rp. 3.600", R.drawable.miegor13));
        mieModel.add(new MieModel("Mie Goreng Sambal Rica-Rica","Mie goreng lengkap dengan bumbu cape rasa rica-rica yang khas","Rp. 3.500", R.drawable.miegor14));
        mieModel.add(new MieModel("Mie Goreng Iga Penyet","Mie goreng rasa iga yang kental lengkap dengan minyak dan kecap","Rp. 4.000", R.drawable.miegor15));
    }
    @Override
    public void onItemClick(int position) {
        MieModel clickedItem = mieModel.get(position);

        Intent intent= new Intent(MainActivity.this, DetailActivity.class);

        intent.putExtra("nama", clickedItem.getNamaMie());
        intent.putExtra("deskripsi", clickedItem.getDescMie());
        intent.putExtra("harga", clickedItem.getHargaMie());
        intent.putExtra("foto", clickedItem.getGambarMie());
        startActivity(intent);
    }

}