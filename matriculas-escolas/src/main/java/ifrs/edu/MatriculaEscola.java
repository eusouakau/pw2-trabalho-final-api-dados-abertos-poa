package ifrs.edu;

public class MatriculaEscola {
    private Integer _id;
    private String name;
    private Integer codigo;

    public MatriculaEscola() {

    }

    public MatriculaEscola(Integer _id, String name, Integer codigo) {
        this._id = _id;
        this.name = name;
        this.codigo = codigo;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.format("Id de Matriculas Escolas [%i] - Nome das Escoals [%s] - Código das Escolas [%i]", _id,
                name, codigo);
    }
}
