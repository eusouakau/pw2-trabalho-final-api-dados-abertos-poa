package ifrs.edu.model.dataPoaMatriculaEscola;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Record {
    int _id;

    @JsonProperty("_id")
    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    Date data_extracao;

    @JsonProperty("data_extracao")
    public Date getData_extracao() {
        return this.data_extracao;
    }

    public void setData_extracao(Date data_extracao) {
        this.data_extracao = data_extracao;
    }

    int codigo;

    @JsonProperty("codigo")
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    String nome;

    @JsonProperty("nome")
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    int ei_creche_parcial;

    @JsonProperty("ei_creche_parcial")
    public int getEi_creche_parcial() {
        return this.ei_creche_parcial;
    }

    public void setEi_creche_parcial(int ei_creche_parcial) {
        this.ei_creche_parcial = ei_creche_parcial;
    }

    int ei_creche_integral;

    @JsonProperty("ei_creche_integral")
    public int getEi_creche_integral() {
        return this.ei_creche_integral;
    }

    public void setEi_creche_integral(int ei_creche_integral) {
        this.ei_creche_integral = ei_creche_integral;
    }

    int ei_creche;

    @JsonProperty("ei_creche")
    public int getEi_creche() {
        return this.ei_creche;
    }

    public void setEi_creche(int ei_creche) {
        this.ei_creche = ei_creche;
    }

    int ei_pre_parcial;

    @JsonProperty("ei_pre_parcial")
    public int getEi_pre_parcial() {
        return this.ei_pre_parcial;
    }

    public void setEi_pre_parcial(int ei_pre_parcial) {
        this.ei_pre_parcial = ei_pre_parcial;
    }

    int ei_pre_integral;

    @JsonProperty("ei_pre_integral")
    public int getEi_pre_integral() {
        return this.ei_pre_integral;
    }

    public void setEi_pre_integral(int ei_pre_integral) {
        this.ei_pre_integral = ei_pre_integral;
    }

    int ei_pre;

    @JsonProperty("ei_pre")
    public int getEi_pre() {
        return this.ei_pre;
    }

    public void setEi_pre(int ei_pre) {
        this.ei_pre = ei_pre;
    }

    int ef_ciclos_parcial;

    @JsonProperty("ef_ciclos_parcial")
    public int getEf_ciclos_parcial() {
        return this.ef_ciclos_parcial;
    }

    public void setEf_ciclos_parcial(int ef_ciclos_parcial) {
        this.ef_ciclos_parcial = ef_ciclos_parcial;
    }

    int ef_ciclos_integral;

    @JsonProperty("ef_ciclos_integral")
    public int getEf_ciclos_integral() {
        return this.ef_ciclos_integral;
    }

    public void setEf_ciclos_integral(int ef_ciclos_integral) {
        this.ef_ciclos_integral = ef_ciclos_integral;
    }

    int ef_ciclos;

    @JsonProperty("ef_ciclos")
    public int getEf_ciclos() {
        return this.ef_ciclos;
    }

    public void setEf_ciclos(int ef_ciclos) {
        this.ef_ciclos = ef_ciclos;
    }

    int ef_eja;

    @JsonProperty("ef_eja")
    public int getEf_eja() {
        return this.ef_eja;
    }

    public void setEf_eja(int ef_eja) {
        this.ef_eja = ef_eja;
    }

    int ensino_medio;

    @JsonProperty("ensino_medio")
    public int getEnsino_medio() {
        return this.ensino_medio;
    }

    public void setEnsino_medio(int ensino_medio) {
        this.ensino_medio = ensino_medio;
    }

    int normal_magisterio;

    @JsonProperty("normal_magisterio")
    public int getNormal_magisterio() {
        return this.normal_magisterio;
    }

    public void setNormal_magisterio(int normal_magisterio) {
        this.normal_magisterio = normal_magisterio;
    }

    int profissionalizante;

    @JsonProperty("profissionalizante")
    public int getProfissionalizante() {
        return this.profissionalizante;
    }

    public void setProfissionalizante(int profissionalizante) {
        this.profissionalizante = profissionalizante;
    }

    int total;

    @JsonProperty("total")
    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

// public class Record{
// public int _id;
// public Date data_extracao;
// public int codigo;
// public String nome;
// public int ei_creche_parcial;
// public int ei_creche_integral;
// public int ei_creche;
// public int ei_pre_parcial;
// public int ei_pre_integral;
// public int ei_pre;
// public int ef_ciclos_parcial;
// public int ef_ciclos_integral;
// public int ef_ciclos;
// public int ef_eja;
// public int ensino_medio;
// public int normal_magisterio;
// public int profissionalizante;
// public int total;
// }