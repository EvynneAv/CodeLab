package com.example.atividadepratica;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewpager;
    MyViewPagerAdapter myAdapter;
    TabLayout tabLayout;



    String[] menu = {"Carro", "Dados do modelo", "Comprar miniatura"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        SharedPreferences preferences = getSharedPreferences("ARQUIVO_PREFERENCIA", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nome_carro", "Maclaren MP4/4");
        editor.putString("Descricao", "O MP4/4 foi o modelo da McLaren da temporada de 1988 de F1. Seus condutores foram o francês Alain Prost e o brasileiro Ayrton Senna.");
        editor.putString("ComoComprar", "https://lista.mercadolivre.com.br/mclaren-mp4-4");
        editor.apply();


        tabLayout = findViewById(R.id.tablayout);

        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        myAdapter.addFragment(new FragmentOne());
        myAdapter.addFragment(new FragmentTwo());
        myAdapter.addFragment(new FragmentThree());

        viewpager = findViewById(R.id.viewPager2);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewpager.setAdapter(myAdapter);

        new TabLayoutMediator(
                tabLayout,
                viewpager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(menu[position]);
                    }
                }
        ).attach();



    }
}