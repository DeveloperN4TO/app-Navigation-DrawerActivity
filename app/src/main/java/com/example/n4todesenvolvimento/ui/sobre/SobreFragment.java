package com.example.n4todesenvolvimento.ui.sobre;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.n4todesenvolvimento.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class SobreFragment extends Fragment {


    public SobreFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = " Bem-vindo à N4TO desenvolvimento de aplicações nativas para Android! " +
                " Como desenvolvedor júnior, tenho a missão de criar aplicativos de alta qualidade " +
                " fornecer manutenção eficiente e implementar novas funcionalidades para garantir a satisfação do cliente" +


        "Acreditamos que a tecnologia móvel é a chave para o sucesso e a eficiência no mundo de hoje" +
                "e estamos comprometidos em oferecer soluções inovadoras e personalizadas para atender às necessidades únicas de cada cliente." +
                "Nós trabalhamos duro para garantir que nossos aplicativos sejam fáceis de usar," +
                "esteticamente agradáveis e altamente funcionais." ;

        Element versao = new Element();
        versao.setTitle("Versao 1.0.0");


        return new AboutPage(getActivity())
                .setImage( R.drawable.logoprincipal )
                .setDescription( descricao )


                .addGroup( "Redes Sociais" )
                .addGitHub("sergiorodrigues", "GitHub")
                .addFacebook("sergiorodrigues", "Facebook")
                .addInstagram("sergiorodrigues", "Instagram")
                .addTwitter("sergiorodrigues", "Twitter")
                .addPlayStore("com.facebook.katana", "Download app")

                .addGroup(" Entre em Contato")
                .addEmail(" sergio.n4todev@gmail.com", "Envie um e-mail")
                .addWebsite("https://google.com/","Acesse nosso site")


                .addItem( versao )

                .create();



        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}