package com.example.inventorymvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.inventorymvp.R;
import com.example.inventorymvp.pojo.Sector;
import com.example.inventorymvp.repository.SectorRepository;
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
    
    private OnItemClickListener listener;
    
    public interface OnItemClickListener{
        void onItemClick(Sector sector);
        
    }
    
    /**
     * Constructor que sólo se llamará cuando SectorActivity venga de un cambio de configuración
     * y se haya salvado el estado dinámico.
     * @param sectorsModified
     */
    public SectorAdapter(ArrayList<Sector> sectorsModified, OnItemClickListener listener){
        sectors = SectorRepository.getInstance().getSectors();
        this.sectorsModified = sectorsModified;
        this.listener = listener;
    }

    public SectorAdapter (){
        sectors = SectorRepository.getInstance().getSectors();
        sectorsModified = sectors;
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
        if(sectorsModified.contains(sectors.get(position)))
           sectorViewHolder.swEnabled.setChecked(sectorsModified.get(position).isEnabled());
        
        if (sectors.get(position).is_default())
            sectorViewHolder.txvSectorDefault.setText(R.string.txvSectorDefault);
        sectorViewHolder.bind(sectors.get(position), listener);
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
            swEnabled = view.findViewById(R.id.swEnabled);
            txvName = view.findViewById(R.id.txvName);
            txvSectorDefault= view.findViewById(R.id.txvSectorDefault);
        }
        
        public void bind(final Sector sector, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(sector);
                }
            }); // Elemento view que se crea en el recycler automáticamente
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
