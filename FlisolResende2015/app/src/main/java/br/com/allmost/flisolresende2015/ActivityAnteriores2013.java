package br.com.allmost.flisolresende2015;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;


public class ActivityAnteriores2013 extends ActionBarActivity implements BaseSliderView.OnSliderClickListener, BaseSliderView.ImageLoadListener {

    private SliderLayout slImages;
    private TextView desc, link;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anteriores2013);

        desc = (TextView) findViewById(R.id.desc_treze);
        link = (TextView) findViewById(R.id.link_treze);

        desc.setText("O evento em 2013, a primeira edição de Resende, contou com a participação de vários temas como: O que é este tal de software livre?, Lista de Softwares livres, Empreendedorismo e Marketing Digital, Automação de Teste com Software Livre e Soluções de Software Livre para Empresas. As oficinas foram um sucesso com o tema Drupal 7.0 e Software Livre para gerenciamento de redes.\n");
        link.setText("Link: http://flisol.info/FLISOL2013/Brasil/Resende");
        link.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                link("http://flisol.info/FLISOL2013/Brasil/Resende");
            }
        });

        slImages = (SliderLayout) findViewById(R.id.slImages);

        TextSliderView aux1 = new TextSliderView(ActivityAnteriores2013.this);
        aux1.image(R.drawable.treze_um);
        aux1.setOnSliderClickListener(ActivityAnteriores2013.this);
        aux1.setOnImageLoadListener(ActivityAnteriores2013.this);
        slImages.addSlider(aux1);

        aux1 = new TextSliderView(ActivityAnteriores2013.this);
        aux1.image(R.drawable.treze_dois);
        aux1.setOnSliderClickListener(ActivityAnteriores2013.this);
        aux1.setOnImageLoadListener(ActivityAnteriores2013.this);
        slImages.addSlider(aux1);

        aux1 = new TextSliderView(ActivityAnteriores2013.this);
        aux1.image(R.drawable.treze_tres);
        aux1.setOnSliderClickListener(ActivityAnteriores2013.this);
        aux1.setOnImageLoadListener(ActivityAnteriores2013.this);
        slImages.addSlider(aux1);

        aux1 = new TextSliderView(ActivityAnteriores2013.this);
        aux1.image(R.drawable.treze_quatro);
        aux1.setOnSliderClickListener(ActivityAnteriores2013.this);
        aux1.setOnImageLoadListener(ActivityAnteriores2013.this);
        slImages.addSlider(aux1);

        aux1 = new TextSliderView(ActivityAnteriores2013.this);
        aux1.image(R.drawable.treze_cinco);
        aux1.setOnSliderClickListener(ActivityAnteriores2013.this);
        aux1.setOnImageLoadListener(ActivityAnteriores2013.this);
        slImages.addSlider(aux1);

        aux1 = new TextSliderView(ActivityAnteriores2013.this);
        aux1.image(R.drawable.treze_seis);
        aux1.setOnSliderClickListener(ActivityAnteriores2013.this);
        aux1.setOnImageLoadListener(ActivityAnteriores2013.this);
        slImages.addSlider(aux1);

        aux1 = new TextSliderView(ActivityAnteriores2013.this);
        aux1.image(R.drawable.treze_sete);
        aux1.setOnSliderClickListener(ActivityAnteriores2013.this);
        aux1.setOnImageLoadListener(ActivityAnteriores2013.this);
        slImages.addSlider(aux1);

        slImages.setPresetTransformer(SliderLayout.Transformer.RotateDown);
        slImages.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        slImages.setCustomIndicator((PagerIndicator)findViewById(R.id.custom_indicator));


        PagerIndicator p = (PagerIndicator)findViewById(R.id.custom_indicator);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LOG", "ID: " + v.getId());
            }
        });


    }

    private void link(String web) {
        Intent it;
        try{
            it = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            startActivity(it);
        }
        catch(Exception e){
            Toast.makeText(ActivityAnteriores2013.this, "Site não encontrado. =/", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {
        Log.i("LOG", "onSliderClick(" + baseSliderView.getDescription() + ")");
        slImages.startAutoCycle();
    }

    @Override
    public void onStart(BaseSliderView baseSliderView) {
        Log.i("LOG", "onStart(" + baseSliderView.getDescription() + ")");
    }

    @Override
    public void onEnd(boolean b, BaseSliderView baseSliderView) {
        Log.i("LOG", "onEnd(" + baseSliderView.getDescription() + ")");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_anteriores2013, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
