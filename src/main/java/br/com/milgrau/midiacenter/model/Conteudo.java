package br.com.milgrau.midiacenter.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="conteudo")
public class Conteudo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="descricao")
    private String descricao;

    @Column(name="tipoArquivo")
    private String tipoArquivo;

    @Column(name="diretorioInserir")
    private String diretorioInserir;

    @Column(name="diretorioBuscar")
    private String diretorioBuscar;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(String tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public String getDiretorioInserir() {
        return diretorioInserir;
    }

    public void setDiretorioInserir(String diretorioInserir) {
        this.diretorioInserir = diretorioInserir;
    }

    public String getDiretorioBuscar() {
        return diretorioBuscar;
    }

    public void setDiretorioBuscar(String diretorioBuscar) {
        this.diretorioBuscar = diretorioBuscar;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
