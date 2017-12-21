package com.example.inventorymvp.ui.dependency;

import android.app.Activity;
import android.app.Dialog;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.inventorymvp.R;
import com.example.inventorymvp.adapter.DependencyAdapter;
import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.ui.base.BaseView;
import com.example.inventorymvp.ui.dependency.contract.ListDependencyContract;
import com.example.inventorymvp.ui.dependency.presenter.ListPresenter;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependency extends ListFragment implements BaseView, ListDependencyContract.View{

    public static final String TAG = "listdependency";
    private ListDependencyContract.Presenter presenter;
    private ListDependencyListener callback;
    private DependencyAdapter adapter;
    private Dialog dialog;
    private Toolbar toolbar;



    interface ListDependencyListener{
        void addNewDependency();
        void editDependency(Bundle bundle);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new DependencyAdapter(getActivity());
        this.presenter = new ListPresenter(this);
        setRetainInstance(true);
    }

    public static ListFragment newInstance(Bundle arguments) {
        ListDependency listDependency = new ListDependency();
        if(arguments != null){
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListDependencyListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must be implements " +
                    "LisDependencyListener");
        }
    }


    /**
     * Es entes método se asigna el adapter (sin datos)
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(adapter);
        //AdapterView de la lista
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(Dependency.TAG, adapter.getItem(position));
            }
        });
        // Activar el modo MULTICHOICE en la lista
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        getListView().setMultiChoiceModeListener(new DependencyMultiChoiceModeListener(presenter));
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                getListView().setItemChecked(position, !presenter.isPositionChecked(position));
                return false;
            }
        });

        //Registrar el menu contextual
        Log.d(TAG, "ListDependency: onViewCreated");
    }

    /**
     * Menu contextual (pulsacion larga) sobre la lista
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_listdependency, container, false);
        // Como se encuentra en el fragment usamos rootView
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        // Si el floatingActionButton se encontrara en el xml de la activity
        //FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.checkedActionMode();
                callback.addNewDependency();
            }
        });
        toolbar = rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        presenter.loadDependency();
        Log.d(TAG, "ListDependency onCreateview()");
        return rootView;
    }

    /**
     * Asigna el presentador a la vista
     * @param presenter
     */
    /*@Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListPresenter) presenter;
    }*/

    /**
     * Este método es el que usa la vista para cargar los datos del repositorio a través de esquema mMVP
     * @param list
     */
    @Override
    public void showDependency(List<Dependency> list){
        adapter.clear();
        adapter.addAll(list);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Override
    public void showMessage(String message){

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        adapter = null;
    }

    @Override
    public void showDeleteMessage() {
        showMessage("Se ha eliminado correctamente");
    }

    @Override
    public void updateAdapter() {

    }

    @Override
    public Dependency getDependency(int position) {
        return adapter.getItem(position);
    }

    public void setPresenter (ListPresenter presenter){
        this.presenter = presenter;
    }
}
