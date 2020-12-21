package com.example.thecoffeehouse.bottomNavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.thecoffeehouse.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Cuahang extends Fragment implements OnMapReadyCallback {


    private static final String LOG_TAG = "PopupMenuExample";
    Button btnchonkhuvuc;
    MapView mapView;

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = view.findViewById(R.id.maps);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng danang = new LatLng(16.068000, 108.212000);
        googleMap.addMarker(new MarkerOptions().position(danang).title("Marker in DaNang"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(danang));
    }

//    private OnMapReadyCallback callback = new OnMapReadyCallback() {
//
//        /**
//         * Manipulates the map once available.
//         * This callback is triggered when the map is ready to be used.
//         * This is where we can add markers or lines, add listeners or move the camera.
//         * In this case, we just add a marker near Sydney, Australia.
//         * If Google Play services is not installed on the device, the user will be prompted to
//         * install it inside the SupportMapFragment. This method will only be triggered once the
//         * user has installed Google Play services and returned to the app.
//         */
//        @Override
//        public void onMapReady(GoogleMap googleMap) {
//            LatLng danang = new LatLng(16.068000, 108.212000);
//            googleMap.addMarker(new MarkerOptions().position(danang).title("Marker in DaNang"));
//            googleMap.moveCamera(CameraUpdateFactory.newLatLng(danang));
//        }
//    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_navigation_cuahang, container, false);
        btnchonkhuvuc = root.findViewById(R.id.btnchonkhuvuc);
        btnchonkhuvuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1Clicked();
            }
        });
        return root;
    }

    public void button1Clicked() {
        //1. Khi kích vào button sẽ tạo 1 menu
        PopupMenu popup = new PopupMenu(Cuahang.this.getActivity(), this.btnchonkhuvuc);
        popup.inflate(R.menu.menu_chonkhuvuc);


        Menu menu = popup.getMenu();

        // com.android.internal.view.menu.MenuBuilder
        Log.i(LOG_TAG, "Menu class: " + menu.getClass().getName());

        // Đăng kí gọi chữ
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return menuItemClicked(item);
            }
        });
        // Hiển thị Popupmenu
        popup.show();
    }

    private boolean menuItemClicked(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cantho:
                Toast.makeText(Cuahang.this.getActivity(), "Cần Thơ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.thanhhoa:
                Toast.makeText(Cuahang.this.getActivity(), "Thanh Hóa", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(Cuahang.this.getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        SupportMapFragment mapFragment =
//                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.maps);
//        if (mapFragment != null) {
//            mapFragment.getMapAsync(callback);
//        }
//    }
}