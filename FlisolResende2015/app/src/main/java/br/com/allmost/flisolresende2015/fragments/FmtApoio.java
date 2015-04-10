package br.com.allmost.flisolresende2015.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.allmost.flisolresende2015.R;

/**
 * Created by leonardobenedeti on 04/04/15.
 */
public class FmtApoio extends Fragment {

    ImageView faceSantiago, linkSantiago, emailSantiago;
    ImageView facePri, linkPri, emailPri;
    ImageView allmost, allmost2, sejalinux, emporio, sinetwork, novatec, sergio, aedb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_apoio, container, false);

        faceSantiago = (ImageView) rootView.findViewById(R.id.facesantiago);
        linkSantiago = (ImageView) rootView.findViewById(R.id.linksantiago);
        emailSantiago = (ImageView) rootView.findViewById(R.id.emailsantiago);

        facePri = (ImageView) rootView.findViewById(R.id.facepri);
        linkPri = (ImageView) rootView.findViewById(R.id.linkpri);
        emailPri = (ImageView) rootView.findViewById(R.id.emailpri);

//        link empresas
        aedb = (ImageView) rootView.findViewById(R.id.aedb);
        allmost = (ImageView) rootView.findViewById(R.id.allmost);
        allmost2 = (ImageView) rootView.findViewById(R.id.allmost2);
        sejalinux = (ImageView) rootView.findViewById(R.id.sejalinux);
        emporio = (ImageView) rootView.findViewById(R.id.emporio);
        sinetwork = (ImageView) rootView.findViewById(R.id.sinetwork);
        novatec = (ImageView) rootView.findViewById(R.id.novatec);
        sergio = (ImageView) rootView.findViewById(R.id.sergio);

        faceSantiago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkFace("fb://page/798581333560497", "https://www.facebook.com/Professor.Santiago.Lopes");
            }
        });

        linkSantiago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkIn("linkedin://profile/13040274", "https://br.linkedin.com/in/santiagolopes/pt");
            }
        });

        emailSantiago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = "santiago@inf.aedb.br";

                //Está sem verificação se vazio pois é gerado um erro caso o campo esteja vazio na acao do envio.
                String subject = "Contato via app flisol: ";
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "E-mail"));
            }
        });

        facePri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkFace("fb://profile/1200460482", "https://www.facebook.com/priscylla.dealmeidafigueiredo");
            }
        });

        linkPri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkIn("linkedin://profile/124813383", "https://br.linkedin.com/in/priscyllafigueiredo");
            }
        });

        emailPri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = "priscyllaaf@yahoo.com.br";

                //Está sem verificação se vazio pois é gerado um erro caso o campo esteja vazio na acao do envio.
                String subject = "Contato via app flisol: ";
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "E-mail"));
            }
        });

        aedb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://www.aedb.br/");
            }
        });

        allmost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://www.allmost.com.br");
            }
        });

        allmost2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://www.allmost.com.br");
            }
        });

        sejalinux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://www.sejalinux.com.br/");
            }
        });

        emporio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://www.emporiohightech.com.br/");
            }
        });

        sinetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://www.sinetwork.com.br/");
            }
        });

        novatec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://novatec.com.br/");
            }
        });

        sergio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://tecnicolinux.blogspot.com");
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