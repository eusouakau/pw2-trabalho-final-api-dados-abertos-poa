package ifrs.edu;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastroEscolas {
  // private String name;
  // private Integer _id;

  // public CadastroEscolas(String name, Integer _id) {
  // this.name = name;
  // this._id = _id;
  // }

  // public String getName() {
  // return name;
  // }

  // public void setName(String name) {
  // this.name = name;
  // }

  // public Integer getCodigo() {
  // return _id;
  // }

  // public void setCodigo(Integer id) {
  // this._id = id;
  // }

  @JsonProperty("_id")
  public int get_id() {
    return this._id;
  }

  public void set_id(int _id) {
    this._id = _id;
  }

  int _id;

  @JsonProperty("data_extracao")
  public Date getData_extracao() {
    return this.data_extracao;
  }

  public void setData_extracao(Date data_extracao) {
    this.data_extracao = data_extracao;
  }

  Date data_extracao;

  @JsonProperty("dep_administrativa")
  public String getDep_administrativa() {
    return this.dep_administrativa;
  }

  public void setDep_administrativa(String dep_administrativa) {
    this.dep_administrativa = dep_administrativa;
  }

  String dep_administrativa;

  @JsonProperty("tipo")
  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  String tipo;

  @JsonProperty("codigo")
  public int getCodigo() {
    return this.codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  int codigo;

  @JsonProperty("inep")
  public int getInep() {
    return this.inep;
  }

  public void setInep(int inep) {
    this.inep = inep;
  }

  int inep;

  @JsonProperty("nome")
  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  String nome;

  @JsonProperty("abr_nome")
  public String getAbr_nome() {
    return this.abr_nome;
  }

  public void setAbr_nome(String abr_nome) {
    this.abr_nome = abr_nome;
  }

  String abr_nome;

  @JsonProperty("logradouro")
  public String getLogradouro() {
    return this.logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  String logradouro;

  @JsonProperty("numero")
  public int getNumero() {
    return this.numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  int numero;

  @JsonProperty("bairro")
  public String getBairro() {
    return this.bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  String bairro;

  @JsonProperty("cep")
  public String getCep() {
    return this.cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  String cep;

  @JsonProperty("latitude")
  public double getLatitude() {
    return this.latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  double latitude;

  @JsonProperty("longitude")
  public double getLongitude() {
    return this.longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  double longitude;

  @JsonProperty("telefone")
  public String getTelefone() {
    return this.telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  String telefone;

  @JsonProperty("email")
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  String email;

  @JsonProperty("url_website")
  public String getUrl_website() {
    return this.url_website;
  }

  public void setUrl_website(String url_website) {
    this.url_website = url_website;
  }

  String url_website;

  @JsonProperty("blog")
  public String getBlog() {
    return this.blog;
  }

  public void setBlog(String blog) {
    this.blog = blog;
  }

  String blog;

  @JsonProperty("twitter")
  public String getTwitter() {
    return this.twitter;
  }

  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }

  String twitter;

  @JsonProperty("facebook")
  public String getFacebook() {
    return this.facebook;
  }

  public void setFacebook(String facebook) {
    this.facebook = facebook;
  }

  String facebook;

  @JsonProperty("reg_conselho_tutelar")
  public int getReg_conselho_tutelar() {
    return this.reg_conselho_tutelar;
  }

  public void setReg_conselho_tutelar(int reg_conselho_tutelar) {
    this.reg_conselho_tutelar = reg_conselho_tutelar;
  }

  int reg_conselho_tutelar;

  @JsonProperty("desc_reg_conselho_tutelar")
  public String getDesc_reg_conselho_tutelar() {
    return this.desc_reg_conselho_tutelar;
  }

  public void setDesc_reg_conselho_tutelar(String desc_reg_conselho_tutelar) {
    this.desc_reg_conselho_tutelar = desc_reg_conselho_tutelar;
  }

  String desc_reg_conselho_tutelar;

  @JsonProperty("reg_orcamento_part")
  public int getReg_orcamento_part() {
    return this.reg_orcamento_part;
  }

  public void setReg_orcamento_part(int reg_orcamento_part) {
    this.reg_orcamento_part = reg_orcamento_part;
  }

  int reg_orcamento_part;

  @JsonProperty("desc_reg_orcamento_part")
  public String getDesc_reg_orcamento_part() {
    return this.desc_reg_orcamento_part;
  }

  public void setDesc_reg_orcamento_part(String desc_reg_orcamento_part) {
    this.desc_reg_orcamento_part = desc_reg_orcamento_part;
  }

  String desc_reg_orcamento_part;

  @JsonProperty("situacao_funcionamento")
  public String getSituacao_funcionamento() {
    return this.situacao_funcionamento;
  }

  public void setSituacao_funcionamento(String situacao_funcionamento) {
    this.situacao_funcionamento = situacao_funcionamento;
  }

  String situacao_funcionamento;

  @JsonProperty("convenio_municipal")
  public String getConvenio_municipal() {
    return this.convenio_municipal;
  }

  public void setConvenio_municipal(String convenio_municipal) {
    this.convenio_municipal = convenio_municipal;
  }

  String convenio_municipal;

  @JsonProperty("convenio_estadual")
  public String getConvenio_estadual() {
    return this.convenio_estadual;
  }

  public void setConvenio_estadual(String convenio_estadual) {
    this.convenio_estadual = convenio_estadual;
  }

  String convenio_estadual;

  @JsonProperty("convenio_federal")
  public String getConvenio_federal() {
    return this.convenio_federal;
  }

  public void setConvenio_federal(String convenio_federal) {
    this.convenio_federal = convenio_federal;
  }

  String convenio_federal;

  @JsonProperty("convenio_fasc")
  public String getConvenio_fasc() {
    return this.convenio_fasc;
  }

  public void setConvenio_fasc(String convenio_fasc) {
    this.convenio_fasc = convenio_fasc;
  }

  String convenio_fasc;

  @JsonProperty("escola_especial")
  public String getEscola_especial() {
    return this.escola_especial;
  }

  public void setEscola_especial(String escola_especial) {
    this.escola_especial = escola_especial;
  }

  String escola_especial;

  @JsonProperty("cat_part_privada")
  public String getCat_part_privada() {
    return this.cat_part_privada;
  }

  public void setCat_part_privada(String cat_part_privada) {
    this.cat_part_privada = cat_part_privada;
  }

  String cat_part_privada;

  @JsonProperty("cat_part_comunitaria")
  public String getCat_part_comunitaria() {
    return this.cat_part_comunitaria;
  }

  public void setCat_part_comunitaria(String cat_part_comunitaria) {
    this.cat_part_comunitaria = cat_part_comunitaria;
  }

  String cat_part_comunitaria;

  @JsonProperty("cat_part_confessional")
  public String getCat_part_confessional() {
    return this.cat_part_confessional;
  }

  public void setCat_part_confessional(String cat_part_confessional) {
    this.cat_part_confessional = cat_part_confessional;
  }

  String cat_part_confessional;

  @JsonProperty("cat_part_filantropica")
  public String getCat_part_filantropica() {
    return this.cat_part_filantropica;
  }

  public void setCat_part_filantropica(String cat_part_filantropica) {
    this.cat_part_filantropica = cat_part_filantropica;
  }

  String cat_part_filantropica;

  @JsonProperty("mant_empresa_privada")
  public String getMant_empresa_privada() {
    return this.mant_empresa_privada;
  }

  public void setMant_empresa_privada(String mant_empresa_privada) {
    this.mant_empresa_privada = mant_empresa_privada;
  }

  String mant_empresa_privada;

  @JsonProperty("mant_sindicato")
  public String getMant_sindicato() {
    return this.mant_sindicato;
  }

  public void setMant_sindicato(String mant_sindicato) {
    this.mant_sindicato = mant_sindicato;
  }

  String mant_sindicato;

  @JsonProperty("mant_sistema_s")
  public String getMant_sistema_s() {
    return this.mant_sistema_s;
  }

  public void setMant_sistema_s(String mant_sistema_s) {
    this.mant_sistema_s = mant_sistema_s;
  }

  String mant_sistema_s;

  @JsonProperty("mant_ong")
  public String getMant_ong() {
    return this.mant_ong;
  }

  public void setMant_ong(String mant_ong) {
    this.mant_ong = mant_ong;
  }

  String mant_ong;

  @JsonProperty("mant_apae")
  public String getMant_apae() {
    return this.mant_apae;
  }

  public void setMant_apae(String mant_apae) {
    this.mant_apae = mant_apae;
  }

  String mant_apae;
}
