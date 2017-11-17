package com.example.inventorymvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventorymvp.R;
import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by usuario on 26/10/17.
 * ES LA PRIMERA OPCION NO OPTIMIZADA
 */

public class DependencyAdapterA extends ArrayAdapter<Dependency>{

    public DependencyAdapterA(@NonNull Context context){
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    // Devuelve un objeto View
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortName;
        View view;

        // 1. Obtener el servicio del sistema Layout Inflater en el contexto
        // LayoutInflater inflater = LayoutInflater.from(getContext());
        // LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Inflar la vista. Crea en memoria el objeto View con todos los widget del xml: item_dependecy.xml
        view = inflater.inflate(R.layout.item_dependency, null);


        // 3. Inicializar las variables a los objetos ya creados de los widget del xml. ¡¡CUIDADO View.findViewID!!
        icon = (MaterialLetterIcon) view.findViewById(R.id.materialLetterIcon);
        txvName = (TextView) view.findViewById(R.id.txvName);
        txvShortName = (TextView) view.findViewById(R.id.txvShortName);

        // 4. Mostrar los datos del ArrayList mediante position
        icon.setLetter(getItem(position).getShortname().substring(0,1));
        txvName.setText(getItem(position).getName());
        txvShortName.setText(getItem(position).getShortname());
        return view;
    }
}
