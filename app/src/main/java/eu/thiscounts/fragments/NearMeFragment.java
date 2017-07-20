package eu.thiscounts.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import eu.thiscounts.R;


public class NearMeFragment extends Fragment {

    private MapView mMapView;
    private GoogleMap mMap;
    private Bundle mBundle;
    private BottomSheetBehavior<View> behavior;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_near_me_mapview, container, false);

        initBottomSheet(inflatedView);

        try {
            MapsInitializer.initialize(getActivity());
        } catch (Exception e) {
            // TODO handle this situation
        }

        mMapView = (MapView) inflatedView.findViewById(R.id.map);
        mMapView.onCreate(mBundle);
        setUpMapIfNeeded(inflatedView);

        return inflatedView;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBundle = savedInstanceState;
    }

    private void setUpMapIfNeeded(View inflatedView) {
        if (mMap == null) {
            mMap = ((MapView) inflatedView.findViewById(R.id.map)).getMap();
            if (mMap != null) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    private void initBottomSheet(View inflatedView) {
        View bottomSheet = inflatedView.findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // React to state change
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });
    }
}
