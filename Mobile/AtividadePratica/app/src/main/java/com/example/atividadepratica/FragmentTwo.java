package com.example.atividadepratica;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {
    public FragmentTwo(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        SharedPreferences preferences = getActivity().getSharedPreferences("ARQUIVO_PREFERENCIA", Context.MODE_PRIVATE);
        String data = preferences.getString("Descricao", "");

        TextView textView = view.findViewById(R.id.tv_frag2);
        textView.setText(data);

        return view;
    };

}
