package com.example.thecoffeehouse.tablayout;

import android.animation.PropertyValuesHolder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.thecoffeehouse.R;
import com.example.thecoffeehouse.bottomNavigation.Dathang;
import com.example.thecoffeehouse.database.database;
import com.example.thecoffeehouse.model_adapter.DoUong;
import com.example.thecoffeehouse.model_adapter.SanPhamAdapter;

import java.util.ArrayList;
import java.util.List;

public class PhoBienFragment extends Fragment {

    private GridView gvmon;
    private SanPhamAdapter spadt;

    Context context;
    private List<DoUong> phobienData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        // Inflate the layout for this fragment
        View r = inflater.inflate(R.layout.fragment_pho_bien, container, false);
        gvmon = r.findViewById(R.id.gv_mon);
        database db = new database(getActivity());
        db.createDefaultsanphamIfNeed();
        phobienData = new ArrayList<DoUong>();
        phobienData = db.getAlldouong();
        spadt = new SanPhamAdapter(getActivity(), R.layout.item, phobienData);
        gvmon.setAdapter(spadt);
        registerForContextMenu(gvmon);
        addEvents();
        return r;
    }

    private void fakeData() {

    }

    private void addEvents() {
        gvmon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Dialog dialog = new Dialog(PhoBienFragment.this.getActivity());
                dialog.setContentView(R.layout.dilg_dathang);
                dialog.show();
            }
        });
        gvmon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(PhoBienFragment.this.getActivity());
                dialog.setContentView(R.layout.dhang);
                dialog.show();

                return true;
            }
        });
    }
}