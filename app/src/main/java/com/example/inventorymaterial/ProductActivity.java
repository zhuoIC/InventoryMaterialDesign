package com.example.inventorymaterial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Permite seleccionar todos los datos del producto
 * @author Nicolás Hernández Jiménez
 */

public class ProductActivity extends AppCompatActivity {
    Spinner spnCategory;
    Spinner spnSubcategory;
    Spinner spnType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        spnCategory = (Spinner) findViewById(R.id.spnCategory);
        spnSubcategory = (Spinner) findViewById(R.id.spnSubcategory);
        spnType = (Spinner) findViewById(R.id.spnType);

        ArrayAdapter<CharSequence> adpCategory = ArrayAdapter.createFromResource(this,
                R.array.spnCategory, android.R.layout.simple_spinner_item);
        adpCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategory.setAdapter(adpCategory);

        ArrayAdapter<CharSequence> adpSubcategory = ArrayAdapter.createFromResource(this,
                R.array.spnSubcategory, android.R.layout.simple_spinner_item);
        adpSubcategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSubcategory.setAdapter(adpSubcategory);


        ArrayAdapter<CharSequence> adpType = ArrayAdapter.createFromResource(this,
                R.array.spnType, android.R.layout.simple_spinner_item);
        adpCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(adpType);
    }
}
