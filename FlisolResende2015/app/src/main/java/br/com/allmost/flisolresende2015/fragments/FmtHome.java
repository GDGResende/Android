package br.com.allmost.flisolresende2015.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.allmost.flisolresende2015.R;

/**
 * Created by leonardobenedeti on 04/04/15.
 */
public class FmtHome extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        TextView perfil = (TextView) rootView.findViewById(R.id.txtHome);

        perfil.setText("O Festival Latino-americano de Instalação de Software Livre é o maior evento da América Latina de divulgação de Software Livre. Ele é realizado desde o ano de 2005, e desde 2008 sua realização acontece no 4o. sábado de abril de cada ano. \n" +
                "\n" +
                "Seu principal objetivo é promover o uso de Software Livre, mostrando ao público em geral sua filosofia, abrangência, avanços e desenvolvimento.");


        return rootView;
    }
}