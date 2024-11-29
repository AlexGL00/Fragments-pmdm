package com.alexgl00.misaficiones.fr.sobremi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alexgl00.misaficiones.R;
import com.alexgl00.misaficiones.fr.aficiones.Comer;
import com.alexgl00.misaficiones.fr.aficiones.Dormir;

public class Favorito1 extends Fragment {

    private TextView textViewFavorito;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorito1, container, false);

        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("MisAficionesPreferidas", Context.MODE_PRIVATE);
        String favorito = sharedPreferences.getString("Favorito", "nada encontrado");
        FrameLayout fragmentContainer = view.findViewById(R.id.fragmentContainer1);
        Fragment fragment = null;
        if ("Comer".equals(favorito)) {
            fragment = new Comer();
        } else if ("Dormir".equals(favorito)) {
            fragment = new Dormir();
        } else {
            textViewFavorito.setText("No hay favoritos");
        }

        if (fragment != null) {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer1, fragment);
            transaction.commit();
        }
        return view;
    }
}
