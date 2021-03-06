package br.com.allmost.flisolresende2015.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.com.allmost.flisolresende2015.R;

/**
 * Created by leonardobenedeti on 04/04/15.
 */
public class FmtOficinas extends Fragment {

    ImageView faceLeo, linkLeo, emailLeo;
    ImageView faceAgenor, linkAgenor, emailAgenor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_oficinas, container, false);

        faceLeo = (ImageView) rootView.findViewById(R.id.faceleo);
        linkLeo = (ImageView) rootView.findViewById(R.id.linkleo);
        emailLeo = (ImageView) rootView.findViewById(R.id.emailleo);

        faceAgenor = (ImageView) rootView.findViewById(R.id.faceagenor);
        linkAgenor = (ImageView) rootView.findViewById(R.id.linkagenor);
        emailAgenor = (ImageView) rootView.findViewById(R.id.emailagenor);

        faceLeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkFace("fb://profile/100001223036519", "https://www.facebook.com/leobenedeti");
            }
        });

        linkLeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkIn("linkedin://profile/148759799", "http://www.linkedin.com/in/leonardobenedeti/");
            }
        });

        emailLeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = "leonardobenedeti@gmail.com";

                //Está sem verificação se vazio pois é gerado um erro caso o campo esteja vazio na acao do envio.
                String subject = "Contato via app flisol: ";
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "E-mail"));
            }
        });

        faceAgenor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkFace("fb://profile/100000066059222", "https://www.facebook.com/asilvaneto");
            }
        });

        linkAgenor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkIn("linkedin://profile/55748143", "https://br.linkedin.com/in/asilvaneto/pt");
            }
        });

        emailAgenor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = "asilvaneto@gmail.com";

                //Está sem verificação se vazio pois é gerado um erro caso o campo esteja vazio na acao do envio.
                String subject = "Contato via app flisol: ";
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "E-mail"));
            }
        });

        return rootView;
    }

    private void linkFace(String app, String web) {
        Intent it;
        try{
            getActivity().getPackageManager().getPackageInfo("com.facebook.katana", 0);
            it = new Intent(Intent.ACTION_VIEW, Uri.parse(app));
            getActivity().startActivity(it);
        }
        catch(Exception e){
            it = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            getActivity().startActivity(it);
        }
    }

    private void linkIn(String app, String web) {
        Intent it;
        try{
            it = new Intent(Intent.ACTION_VIEW, Uri.parse(app));
            getActivity().startActivity(it);
        }
        catch(Exception e){
            it = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            getActivity().startActivity(it);
        }

    }
}