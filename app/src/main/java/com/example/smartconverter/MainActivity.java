package com.example.smartconverter;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.OnBackPressedCallback;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager2 pager = findViewById(R.id.pager);
        TabLayout tabs   = findViewById(R.id.tabs);

        pager.setAdapter(new FragmentAdapter(this));
        pager.setOffscreenPageLimit(2);

        new TabLayoutMediator(tabs, pager, (tab, pos) -> {
            if (pos == 0) tab.setText("Température");
            else          tab.setText("Distance");
        }).attach();

        getOnBackPressedDispatcher().addCallback(this,
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        afficherDialogueQuitter();
                    }
                });
    }

    private void afficherDialogueQuitter() {
        new AlertDialog.Builder(this)
                .setTitle("Quitter")
                .setMessage("Souhaitez-vous quitter l'application ?")
                .setPositiveButton("Oui", (d, w) -> finish())
                .setNegativeButton("Non", null)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_quitter) {
            afficherDialogueQuitter();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}