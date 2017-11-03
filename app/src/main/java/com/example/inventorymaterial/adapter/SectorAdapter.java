package com.example.inventorymaterial.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.pojo.Sector;
import com.example.inventorymaterial.repository.SectorRepository;
import java.util.ArrayList;

/**
 * Created by usuario on 30/10/17.
 */

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder>{

    private ArrayList<Sector> sectors;

    // Array que almacenará los sectores que se han modificado en la interfaz y no se han guardado aún en la base de datos
    // En nuestro caso en el Repository
    private ArrayList<Sector> sectorsModified;
    private onSwitchCheckedChangeListener onSwitchCheckedChangeListener;
    /**
     * Constructor que sólo se llamará cuando SectorActivity venga de un cambio de configuración
     * y se haya salvado el estado dinámico.
     * @param sectorsModified
     */
    public SectorAdapter(ArrayList<Sector> sectorsModified){
        sectors = SectorRepository.getInstance().getSectors();
        this.sectorsModified = sectorsModified;
    }

    public SectorAdapter (){
        sectors = SectorRepository.getInstance().getSectors();
        sectorsModified = new ArrayList<>();
    }

    @Override
    public SectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Inflar la vista. Crea en memoria el objeto View con todos los widget del xml: item_sector.xml
        View view = inflater.inflate(R.layout.item_sector, null);
        // 3. Se crea el objeto sectorViewHolder a partir de la vista
        SectorViewHolder sectorViewHolder = new SectorViewHolder(view);
        return sectorViewHolder;
    }
    // 4. Asigno los datos del Array a los componentes o widget
    @Override
    public void onBindViewHolder(SectorViewHolder sectorViewHolder, int position) {
        sectorViewHolder.swEnabled.setChecked(sectors.get(position).isEnabled());
        sectorViewHolder.swEnabled.setOnCheckedChangeListener(onSwitchCheckedChangeListener);
        sectorViewHolder.txvName.setText(sectors.get(position).getName());
        if (sectors.get(position).is_default())
            sectorViewHolder.txvSectorDefault.setText(R.string.txvSectorDefault);
    }

    /**
     * Se crearán tantos elementos SectorViewHolder como elementos haya en el ArrayList definido dentro de la clase.
     * @return Número de sectores en el array
     */
    @Override
    public int getItemCount() {
        return sectors.size();
    }

    public static class SectorViewHolder extends RecyclerView.ViewHolder{

        private Switch swEnabled;
        private TextView txvName;
        private TextView txvSectorDefault;

        public SectorViewHolder(View view) {
            super(view);
            swEnabled = (Switch) view.findViewById(R.id.swEnabled);
            txvName = (TextView)view.findViewById(R.id.txvName);
            txvSectorDefault= (TextView)view.findViewById(R.id.txvSectorDefault);
        }
    }

    /**
     * Devuelve el array de sectores que el usuario ha modificado cuando la activity estaba visible y que no se ha guardado en la base de datos (persistente).
     * @return ArrayList de sectores modificados
     */
    public ArrayList<Sector> getSectorsModified() {
        return sectorsModified;
    }

    class onSwitchCheckedChangeListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked){
            if (true){

            }
        }
    }
}
