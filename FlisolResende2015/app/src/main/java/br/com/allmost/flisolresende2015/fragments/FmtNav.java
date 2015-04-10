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
 * Created by leonardobenedeti on 08/04/15.
 */
public class FmtNav extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_nav, container, false);

        navigate();

        ImageView nav = (ImageView) rootView.findViewById(R.id.nav);

        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate();
            }
        });

        return rootView;
    }

    public void navigate(){
        try {
            Uri gmmIntentUri = Uri.parse("google.navigation:q=Associação+Educacional+Dom+Bosco,+Resende+-+Rio+de+Janeiro");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }catch (Exception e){
            Toast.makeText(getActivity(), "Nenhum aplicativo de mapas encontrado", Toast.LENGTH_LONG).show();

        }
    }
}