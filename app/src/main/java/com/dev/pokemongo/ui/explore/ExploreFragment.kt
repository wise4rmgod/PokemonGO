package com.dev.pokemongo.ui.explore


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.dev.pokemongo.R
import com.dev.pokemongo.databinding.FragmentExploreBinding
import com.dev.pokemongo.sharedpreference.AccountManager
import com.example.urlshortenapp.utils.Status
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*


class ExploreFragment : Fragment(), OnMapReadyCallback {
    lateinit var binding: FragmentExploreBinding
    val viewModel: ExploreViewModel by viewModels()
    val myMap = mapOf<Double, Double>(
        4.8156 to 7.0498,
        6.5244 to 3.3792,
        9.0765 to 7.3986,
        5.4527 to 7.5248,
        12.0022 to 8.5920,
        5.7040 to 5.9339
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root = binding.root
        //Init map view
        binding.lockMapview.getMapAsync(this)
        binding.lockMapview.onCreate(savedInstanceState?.getBundle("mapViewSaveState"))

        getToken()
        return root
    }

    fun getToken() {
        viewModel.getToken().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data.let {
                            it?.let { it1 -> AccountManager.setToken(it1.token) }

                        }
                    }
                    Status.ERROR -> {
                        resource.message?.let { it1 -> Log.d("geterror", it1) }
                    }
                    Status.LOADING -> {
                        resource.message?.let { it1 -> Log.d("getmessage", it1) }

                    }
                }
            }
        })
    }

    override fun onMapReady(p0: GoogleMap) {
        val icon = BitmapDescriptorFactory.fromResource(R.drawable.pokeballmap)
        for (u in myMap) {
            p0.addMarker(
                MarkerOptions().position(LatLng(u.key, u.value))
                    .icon(icon)
                    .title("Marker")
            )
        }
        p0.uiSettings.isZoomControlsEnabled = true
        p0.uiSettings.isZoomGesturesEnabled = true
        p0.uiSettings.isMyLocationButtonEnabled = true
        p0.setOnMarkerClickListener {
            Toast.makeText(activity, "clicked on marker", Toast.LENGTH_SHORT).show()
            false
        }

        try {
            p0.isMyLocationEnabled = true
            //mGoogleMap.getUiSettings().setMyLocationButtonEnabled(false);
        } catch (e: SecurityException) {
            // should not happen
        }
    }

    override fun onResume() {
        super.onResume()
        binding.lockMapview.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.lockMapview.onPause()

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.lockMapview.onDestroy()

    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.lockMapview.onLowMemory()
    }


}