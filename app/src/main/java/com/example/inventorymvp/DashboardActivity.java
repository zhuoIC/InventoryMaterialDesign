package com.example.inventorymvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.inventorymvp.data.prefs.AppPreferencesHelper;
import com.example.inventorymvp.ui.dependency.DependencyActivity;
import com.example.inventorymvp.ui.inventory.InventoryActivity;
import com.example.inventorymvp.ui.inventory.InventoryApplication;
import com.example.inventorymvp.ui.prefs.AccountSettingActivity;
import com.example.inventorymvp.ui.prefs.GeneralSettingActivity;
import com.example.inventorymvp.ui.product.ProductActivity;
import com.example.inventorymvp.ui.sector.SectorActivity;

/**
 * Activity que muestra un panel de iconos
 * @author Nicolás Hernández Jiménez
 */

public class DashboardActivity extends AppCompatActivity {
    private GridLayout gridDashboard;
    private ClickListenerDashboard listenerDashboard = new ClickListenerDashboard();
    private static int INVENTORY;
    private static int PRODUCT;
    private static int DEPENDENCY;
    private static int SECTION;
    private static int SETTING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        gridDashboard = (GridLayout) findViewById(R.id.gridDashboard);

        // Definir un array de int, que contendrá el id de las imágenes
        /**int[] images = {R.drawable.chair, R.drawable.closet, R.drawable.cpu, inventory,
                R.drawable.keyboard, R.drawable.monitor, R.drawable.mouse, R.drawable.printer,
                R.drawable.proyector, R.drawable.table, R.drawable.whiteboard};
        **/
        // Definir un array de int, que contendrá el id de las imágenes Inventory, Product, Dependencias, Secciones y Preferencias
        int[] images = {R.drawable.product, R.drawable.inventory, R.drawable.dependencies, R.drawable.sections}; //,R.drawable.preferences};

        // No se define en Java/Android arrays de objetos. Se utiliza Vector o Colecciones.
        // ImageView[] imageViews = new ImageView[images.length];
        // No utilizamos la clase Vector porque no trabajamos con hilos y no se requiere sincronización.
        // Vector<ImageView> vectorImages = new Vector<ImageView>();
        // ArrayList debe ser parametrizado
/*        ArrayList arrayImageViews = new ArrayList();
        for (int   i = 0; i < images.length; i++) {
            arrayImageViews.add(new ImageView(this));
            if (arrayImageViews.get(i) instanceof ImageView){
                ((ImageView)arrayImageViews.get(i)).setImageResource(images[i]);
            }
        }*/
        // ArrayList<ImageView> arrayImageViews = new ArrayList<>();
        ImageView imageView;
        float width = getResources().getDimension(R.dimen.imgDashboradWidth);
        float height = getResources().getDimension(R.dimen.imgDashboradHeight);

        for (int image : images) {
            imageView = new ImageView(this);
            imageView.setImageResource(image);
            generateID(image, imageView);
            imageView.setOnClickListener(listenerDashboard);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            imageView.setLayoutParams(params);
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            gridDashboard.addView(imageView);
        }
    }

    private void generateID(int id, ImageView imageView){
        switch (id){
            case R.drawable.inventory:
                INVENTORY = View.generateViewId();
                imageView.setId(INVENTORY);
                break;
            case R.drawable.product:
                PRODUCT = View.generateViewId();
                imageView.setId(PRODUCT);
                break;
            case R.drawable.dependencies:
                DEPENDENCY = View.generateViewId();
                imageView.setId(DEPENDENCY);
                break;
            case R.drawable.sections:
                SECTION = View.generateViewId();
                imageView.setId(SECTION);
                break;
        }
    }

    class ClickListenerDashboard implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = null;
            if(view.getId() == INVENTORY)
                    intent = new Intent(DashboardActivity.this, InventoryActivity.class);
            else if(view.getId() == PRODUCT)
                    intent = new Intent(DashboardActivity.this, ProductActivity.class);
            else if(view.getId() == DEPENDENCY)
                    intent = new Intent(DashboardActivity.this, DependencyActivity.class);
            else if(view.getId() == SECTION)
                intent = new Intent(DashboardActivity.this, SectorActivity.class);
            if(intent != null)
                startActivity(intent);
        }
    }

    /**
     * Infla el mení en la Activity
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_dashboard, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_account_setting:
                startActivity(new Intent(DashboardActivity.this, AccountSettingActivity.class));
                break;
            case R.id.action_general_setting:
                startActivity(new Intent(DashboardActivity.this, GeneralSettingActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showAppPreferences();
    }

    private void showAppPreferences() {
        AppPreferencesHelper sharedPreferences = ((InventoryApplication)getApplicationContext()).getAppPreferencesHelper();
        String message = "Tu usuario de sesión es: " + sharedPreferences.getCurrentUserName();

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
