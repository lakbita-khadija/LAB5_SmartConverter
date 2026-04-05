package com.example.smartconverter;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 pager = findViewById(R.id.pager);
        TabLayout tabs   = findViewById(R.id.tabs);

        pager.setAdapter(new FragmentAdapter(this));
        pager.setOffscreenPageLimit(2);

        new TabLayoutMediator(tabs, pager, (tab, pos) -> {
            if (pos == 0) tab.setText("Température");
            else          tab.setText("Distance");
        }).attach();

        // Remplacement de onBackPressed (API moderne)
        getOnBackPressedDispatcher().addCallback(this,
                new androidx.activity.OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Quitter")
                                .setMessage("Souhaitez-vous quitter l'application ?")
                                .setPositiveButton("Oui", (d, w) -> finish())
                                .setNegativeButton("Non", null)
                                .show();
                    }
                });
    }
}