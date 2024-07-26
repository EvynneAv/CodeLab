package com.example.atividadepratica;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {
public FragmentOne(){

}

public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    View view = inflater.inflate(R.layout.fragment_one, container, false);

    // Recuperar dados do SharedPreferences
    SharedPreferences preferences = getActivity().getSharedPreferences("ARQUIVO_PREFERENCIA", Context.MODE_PRIVATE);
    String data = preferences.getString("nome_carro",  "");

    // Exibir dados em um TextView
    TextView textView = view.findViewById(R.id.tv_frag1);
    textView.setText(data);

    return view;
};

}
