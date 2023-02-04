package com.example.n4todesenvolvimento;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.n4todesenvolvimento.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.n4todesenvolvimento.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.fab.setOnClickListener
                (view -> enviarEmail());

        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.email.setOnClickListener(
                view -> enviarLigacao()
        );

        DrawerLayout drawer             = binding.drawerLayout;
        NavigationView navigationView   = binding.navView;


        mAppBarConfiguration = new AppBarConfiguration.Builder(

                R.id.nav_principal,
                R.id.nav_servicos,
                R.id.nav_clientes,
                R.id.nav_contato,
                R.id.nav_sobre
        )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController
                (this, R.id.nav_host_fragment_content_main);

        NavigationUI.setupActionBarWithNavController
                (this, navController, mAppBarConfiguration);

        NavigationUI.setupWithNavController
                (navigationView, navController);
    }

    public void enviarEmail(){

        Intent intent = new Intent ( Intent.ACTION_SEND);

        intent.putExtra( Intent.EXTRA_EMAIL, new String[]{"sergio.n4todev@gmail.com"} );
        intent.putExtra( Intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra( Intent.EXTRA_TEXT, "");

        intent.setType("message/rfc822");

        startActivity( Intent.createChooser( intent, "Escolha um meio de contato" ));


    }

    public void enviarLigacao(){

        Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse("tel: +5528999039373") );
        startActivity( intent );

    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController =
                Navigation.findNavController
                        (this, R.id.nav_host_fragment_content_main);

        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}