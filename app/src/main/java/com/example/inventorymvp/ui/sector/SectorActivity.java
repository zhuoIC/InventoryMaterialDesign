package com.example.inventorymvp.ui.sector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.inventorymvp.R;
import com.example.inventorymvp.adapter.SectorAdapter;
import com.example.inventorymvp.pojo.Sector;


public class SectorActivity extends AppCompatActivity {
    private RecyclerView recyclerSector;
    private SectorAdapter sectorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);
        recyclerSector = (RecyclerView) findViewById(R.id.recyclerSector);
        recyclerSector.setHasFixedSize(true);
        recyclerSector.setLayoutManager(new LinearLayoutManager(this));
        // recyclerSector.setLayoutManager(new GridLayoutManager(this, 2));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState != null){
            sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));
        }
        else{
            sectorAdapter = new SectorAdapter();
        }
        recyclerSector.setAdapter(sectorAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_sector, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Almaceno los sectores que se han modificado en la vista y no han sido guardados
     * para visualizar el estado correcto en onCreate()
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sector", sectorAdapter.getSectorsModified());
    }
}
