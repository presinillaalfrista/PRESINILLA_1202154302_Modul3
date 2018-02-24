package com.example.android.presinilla_1202154302_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.presinilla_1202154302_modul3.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Main> mMainData;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count); //membuat variabel int untuk set ukuran kolom saat landscape dan potrait
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView); //referensi recyclerview dari activity_main.xml
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));//set layout untuk menampilkan kolom gambar

        mMainData = new ArrayList<>(); //objek baru pada ArrayList

        mAdapter = new MainAdapter (this, mMainData); //membuat objek baru pada MainAdapter
        mRecyclerView.setAdapter(mAdapter); //set Adapter

        initializeData(); //memanggil method initializeData
    }
    private void initializeData (){
        String[] mainList = getResources().getStringArray(R.array.main_titles); //mendapat data dari array main_titles
        String[] mainInfo = getResources().getStringArray(R.array.main_info);// mendapat data dari array main_info
        TypedArray mainImageResource = getResources().obtainTypedArray(R.array.main_images); //mendapat gambar dari array main_images

        mMainData.clear(); //menghapus data yang duplikat

        for(int i=0; i<mainList.length; i++){ //membuat perulangan untuk menampilkan gambar
            mMainData.add(new Main(mainList[i], mainInfo[i],
                    mainImageResource.getResourceId(i,0)));
        }

        //Recycle the typed array
        mainImageResource.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }
}
