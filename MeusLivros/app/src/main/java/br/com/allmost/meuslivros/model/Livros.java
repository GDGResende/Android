package br.com.allmost.meuslivros.model;

import java.io.Serializable;

/**
 * Created by leonardobenedeti on 02/05/15.
 */
public class Livros implements Serializable{

    private Long id;
    private String titulo;
    private String autor;
    private int pagina;

    @Override
    public String toString() {
        return titulo.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }
}
