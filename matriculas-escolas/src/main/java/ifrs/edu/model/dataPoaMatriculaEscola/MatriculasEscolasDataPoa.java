package ifrs.edu.model.dataPoaMatriculaEscola;

import java.util.List;

public class MatriculasEscolasDataPoa {
    private List<Result> resultDataPoa;
    private String query;

    public List<Result> getResultDataPoa() {
        return resultDataPoa;
    }

    public void setResultDataPoa(List<Result> resultDataPoa) {
        this.resultDataPoa = resultDataPoa;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/*
 * ObjectMapper om = new ObjectMapper();
 * Root root = om.readValue(myJsonString, Root.class);
 */
// public class Field{
// @JsonProperty("type")
// public String getType() {
// return this.type; }
// public void setType(String type) {
// this.type = type; }
// String type;
// @JsonProperty("id")
// public String getId() {
// return this.id; }
// public void setId(String id) {
// this.id = id; }
// String id;
// }

// public class Links{
// @JsonProperty("start")
// public String getStart() {
// return this.start; }
// public void setStart(String start) {
// this.start = start; }
// String start;
// @JsonProperty("next")
// public String getNext() {
// return this.next; }
// public void setNext(String next) {
// this.next = next; }
// String next;
// }

// public class Record{
// @JsonProperty("_id")
// public int get_id() {
// return this._id; }
// public void set_id(int _id) {
// this._id = _id; }
// int _id;
// @JsonProperty("data_extracao")
// public Date getData_extracao() {
// return this.data_extracao; }
// public void setData_extracao(Date data_extracao) {
// this.data_extracao = data_extracao; }
// Date data_extracao;
// @JsonProperty("codigo")
// public int getCodigo() {
// return this.codigo; }
// public void setCodigo(int codigo) {
// this.codigo = codigo; }
// int codigo;
// @JsonProperty("nome")
// public String getNome() {
// return this.nome; }
// public void setNome(String nome) {
// this.nome = nome; }
// String nome;
// @JsonProperty("ei_creche_parcial")
// public int getEi_creche_parcial() {
// return this.ei_creche_parcial; }
// public void setEi_creche_parcial(int ei_creche_parcial) {
// this.ei_creche_parcial = ei_creche_parcial; }
// int ei_creche_parcial;
// @JsonProperty("ei_creche_integral")
// public int getEi_creche_integral() {
// return this.ei_creche_integral; }
// public void setEi_creche_integral(int ei_creche_integral) {
// this.ei_creche_integral = ei_creche_integral; }
// int ei_creche_integral;
// @JsonProperty("ei_creche")
// public int getEi_creche() {
// return this.ei_creche; }
// public void setEi_creche(int ei_creche) {
// this.ei_creche = ei_creche; }
// int ei_creche;
// @JsonProperty("ei_pre_parcial")
// public int getEi_pre_parcial() {
// return this.ei_pre_parcial; }
// public void setEi_pre_parcial(int ei_pre_parcial) {
// this.ei_pre_parcial = ei_pre_parcial; }
// int ei_pre_parcial;
// @JsonProperty("ei_pre_integral")
// public int getEi_pre_integral() {
// return this.ei_pre_integral; }
// public void setEi_pre_integral(int ei_pre_integral) {
// this.ei_pre_integral = ei_pre_integral; }
// int ei_pre_integral;
// @JsonProperty("ei_pre")
// public int getEi_pre() {
// return this.ei_pre; }
// public void setEi_pre(int ei_pre) {
// this.ei_pre = ei_pre; }
// int ei_pre;
// @JsonProperty("ef_ciclos_parcial")
// public int getEf_ciclos_parcial() {
// return this.ef_ciclos_parcial; }
// public void setEf_ciclos_parcial(int ef_ciclos_parcial) {
// this.ef_ciclos_parcial = ef_ciclos_parcial; }
// int ef_ciclos_parcial;
// @JsonProperty("ef_ciclos_integral")
// public int getEf_ciclos_integral() {
// return this.ef_ciclos_integral; }
// public void setEf_ciclos_integral(int ef_ciclos_integral) {
// this.ef_ciclos_integral = ef_ciclos_integral; }
// int ef_ciclos_integral;
// @JsonProperty("ef_ciclos")
// public int getEf_ciclos() {
// return this.ef_ciclos; }
// public void setEf_ciclos(int ef_ciclos) {
// this.ef_ciclos = ef_ciclos; }
// int ef_ciclos;
// @JsonProperty("ef_eja")
// public int getEf_eja() {
// return this.ef_eja; }
// public void setEf_eja(int ef_eja) {
// this.ef_eja = ef_eja; }
// int ef_eja;
// @JsonProperty("ensino_medio")
// public int getEnsino_medio() {
// return this.ensino_medio; }
// public void setEnsino_medio(int ensino_medio) {
// this.ensino_medio = ensino_medio; }
// int ensino_medio;
// @JsonProperty("normal_magisterio")
// public int getNormal_magisterio() {
// return this.normal_magisterio; }
// public void setNormal_magisterio(int normal_magisterio) {
// this.normal_magisterio = normal_magisterio; }
// int normal_magisterio;
// @JsonProperty("profissionalizante")
// public int getProfissionalizante() {
// return this.profissionalizante; }
// public void setProfissionalizante(int profissionalizante) {
// this.profissionalizante = profissionalizante; }
// int profissionalizante;
// @JsonProperty("total")
// public int getTotal() {
// return this.total; }
// public void setTotal(int total) {
// this.total = total; }
// int total;
// }

// public class Result{
// @JsonProperty("include_total")
// public boolean getInclude_total() {
// return this.include_total; }
// public void setInclude_total(boolean include_total) {
// this.include_total = include_total; }
// boolean include_total;
// @JsonProperty("resource_id")
// public String getResource_id() {
// return this.resource_id; }
// public void setResource_id(String resource_id) {
// this.resource_id = resource_id; }
// String resource_id;
// @JsonProperty("fields")
// public ArrayList<Field> getFields() {
// return this.fields; }
// public void setFields(ArrayList<Field> fields) {
// this.fields = fields; }
// ArrayList<Field> fields;
// @JsonProperty("records_format")
// public String getRecords_format() {
// return this.records_format; }
// public void setRecords_format(String records_format) {
// this.records_format = records_format; }
// String records_format;
// @JsonProperty("records")
// public ArrayList<Record> getRecords() {
// return this.records; }
// public void setRecords(ArrayList<Record> records) {
// this.records = records; }
// ArrayList<Record> records;
// @JsonProperty("_links")
// public Links get_links() {
// return this._links; }
// public void set_links(Links _links) {
// this._links = _links; }
// Links _links;
// @JsonProperty("total")
// public int getTotal() {
// return this.total; }
// public void setTotal(int total) {
// this.total = total; }
// int total;
// }

// public class Root{
// @JsonProperty("success")
// public boolean getSuccess() {
// return this.success; }
// public void setSuccess(boolean success) {
// this.success = success; }
// boolean success;
// @JsonProperty("result")
// public Result getResult() {
// return this.result; }
// public void setResult(Result result) {
// this.result = result; }
// Result result;
// }
