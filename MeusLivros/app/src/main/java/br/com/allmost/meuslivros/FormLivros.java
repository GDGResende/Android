package br.com.allmost.meuslivros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.allmost.meuslivros.dao.LivrosDao;
import br.com.allmost.meuslivros.model.Livros;


public class FormLivros extends ActionBarActivity {

    EditText titulo, autor, pagina;
    Button botao;
    Livros livroToEdit,livro;
    LivrosDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_livros);

        Intent intent = getIntent();
        livroToEdit = (Livros) intent.getSerializableExtra("livro-selecionado");

        livro = new Livros();
        dao = new LivrosDao(FormLivros.this);

        titulo = (EditText) findViewById(R.id.titulo);
        autor = (EditText) findViewById(R.id.autor);
        pagina = (EditText) findViewById(R.id.pagina);

        botao = (Button) findViewById(R.id.botao);

        if (livroToEdit != null){
            botao.setText("Alterar");

            titulo.setText(livroToEdit.getTitulo());
            autor.setText(livroToEdit.getAutor());
            pagina.setText(livroToEdit.getPagina()+"");

            livro.setId(livroToEdit.getId());


        }else{
            botao.setText("Salvar");
        }

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                livro.setTitulo(titulo.getText().toString());
                livro.setAutor(autor.getText().toString());
                livro.setPagina(Integer.parseInt(pagina.getText().toString()));

                if (botao.getText().toString().equals("Salvar")){
                    dao.salvaLivro(livro);
                    dao.close();
                }else{
                    dao.alteraLivro(livro);
                    dao.close();
                }

                finish();
            }
        });


    }

}
