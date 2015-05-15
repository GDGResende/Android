package br.com.allmost.meuslivros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.allmost.meuslivros.dao.LivrosDao;
import br.com.allmost.meuslivros.model.Livros;


public class MainActivity extends ActionBarActivity {

    ListView lista;
    LivrosDao dao;
    ArrayList<Livros> listLivros;
    Livros livro;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listaDeLivros);

        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                Livros livroSelecionado = (Livros) adapter.getItemAtPosition(position);

                Intent i = new Intent(MainActivity.this, FormLivros.class);
                i.putExtra("livro-selecionado", livroSelecionado);
                startActivity(i);

            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                livro = (Livros) adapter.getItemAtPosition(position);
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem mDelete = menu.add("Deletar Livro");
        mDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                dao = new LivrosDao(MainActivity.this);
                dao.deletaLivro(livro);
                dao.close();

                carregaLivro();

                return true;
            }
        });


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    protected void onResume() {
        super.onResume();

        carregaLivro();

    }

    public void carregaLivro(){
        dao = new LivrosDao(MainActivity.this);

        listLivros = dao.getLista();
        dao.close();

        if (listLivros != null){
            adapter = new ArrayAdapter<Livros>(MainActivity.this,
                                               android.R.layout.simple_list_item_1,
                                               listLivros);
            lista.setAdapter(adapter);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Intent i = new Intent(MainActivity.this, FormLivros.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
