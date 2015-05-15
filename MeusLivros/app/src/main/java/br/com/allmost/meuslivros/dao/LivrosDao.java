package br.com.allmost.meuslivros.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import br.com.allmost.meuslivros.model.Livros;

/**
 * Created by leonardobenedeti on 02/05/15.
 */
public class LivrosDao extends SQLiteOpenHelper {

    private static final String DATABASE = "dblivros";
    private static final int VERSION = 2;

    public LivrosDao(Context context){
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String livro = "CREATE TABLE livros " +
                       " ( " +
                         " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                         " titulo TEXT NOT NULL," +
                         " autor TEXT NOT NULL," +
                         " pagina INTEGER" +
                       " );";
        db.execSQL(livro);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String livro = "DROP TABLE IF EXISTS livros";
        db.execSQL(livro);
    }

    public void salvaLivro(Livros livro){
        ContentValues values = new ContentValues();

        values.put("titulo", livro.getTitulo());
        values.put("autor", livro.getAutor());
        values.put("pagina", livro.getPagina());

        getWritableDatabase().insert("livros", null, values);

    }

    public void alteraLivro(Livros livro){
        ContentValues values = new ContentValues();

        values.put("titulo", livro.getTitulo());
        values.put("autor", livro.getAutor());
        values.put("pagina", livro.getPagina());


        String[] args = {livro.getId().toString()};
        getWritableDatabase().update("livros", values, "id=?", args);
    }

    public void deletaLivro(Livros livro){

        String[] args = {livro.getId().toString()};
        getWritableDatabase().delete("livros", "id=?", args);

    }

    public ArrayList<Livros> getLista(){

        String[] columns = {"id", "titulo", "autor", "pagina"};
        Cursor cursor = getWritableDatabase().query("livros", columns, null, null, null, null, null, null);

        ArrayList<Livros> livros = new ArrayList<Livros>();

        while (cursor.moveToNext()){

            Livros livro = new Livros();

            livro.setId(cursor.getLong(0));
            livro.setTitulo(cursor.getString(1));
            livro.setAutor(cursor.getString(2));
            livro.setPagina(cursor.getInt(3));

            livros.add(livro);

        }

        return livros;
    }






}
