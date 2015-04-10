package br.com.allmost.flisolresende2015.fragments;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.allmost.flisolresende2015.ActivityAnteriores2013;
import br.com.allmost.flisolresende2015.ActivityAnteriores2014;
import br.com.allmost.flisolresende2015.R;

/**
 * Created by leonardobenedeti on 04/04/15.
 */
public class FmtAnteriores extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_anteriores, container, false);

        TextView desc_catorze = (TextView) rootView.findViewById(R.id.desc_catorze);
        TextView link_catorze = (TextView) rootView.findViewById(R.id.link_catorze);
        TextView desc_treze = (TextView) rootView.findViewById(R.id.desc_treze);
        TextView link_treze = (TextView) rootView.findViewById(R.id.link_treze);
        Button treze = (Button) rootView.findViewById(R.id.treze);
        Button catorze = (Button) rootView.findViewById(R.id.catorze);
//        middleware aberto para a televisão digital no Brasil; GLPI e OCS Inventory - Gestão de Service Desk e T.I levada a sério; Otimizando o relacionamento com seus clientes utilizando o Vtiger CRM; Produção da web série Podre Vida e ainda  Automação Residencial Livre com Arduíno. As oficinas: PHP, Drupal, Zabbix, GIMP e BrazilFW contaram com a participação de profissionais e ex alunos.
        desc_catorze.setText("Em 2014 na segunda edição da cidade de Resende contamos com: A Era da colaboração; Mesa redonda; Ginga: a aventura de um ...");
        link_catorze.setText("Link: http://flisol.info/FLISOL2014/Brasil/Resende");
        link_catorze.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        catorze.setText("Mais detalhes");
//        , Lista de Softwares livres, Empreendedorismo e Marketing Digital, Automação de Teste com Software Livre e Soluções de Software Livre para Empresas. As oficinas foram um sucesso com o tema Drupal 7.0 e Software Livre para gerenciamento de redes.
        desc_treze.setText("O evento em 2013, a primeira edição de Resende, contou com a participação de vários temas como: O que é este tal de software livre?...");
        link_treze.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        link_treze.setText("Link: http://flisol.info/FLISOL2013/Brasil/Resende");
        treze.setText("Mais detalhes");

        catorze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ActivityAnteriores2014.class);
                startActivity(i);
            }
        });

        treze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ActivityAnteriores2013.class);
                startActivity(i);
            }
        });

        link_catorze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://flisol.info/FLISOL2014/Brasil/Resende");
            }
        });

        link_treze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://flisol.info/FLISOL2013/Brasil/Resende");
            }
        });

        return rootView;
    }

    private void link(String web) {
        Intent it;
        try{
            it = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            getActivity().startActivity(it);
        }
        catch(Exception e){
            Toast.makeText(getActivity(), "Site não encontrado. =/", Toast.LENGTH_SHORT).show();
        }

    }
}