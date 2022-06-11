package ifrs.edu;

public class CadastroEscolas {
    private String name;
    private Integer _id;

    public CadastroEscolas(String name, Integer _id) {
        this.name = name;
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCodigo() {
        return _id;
    }

    public void setCodigo(Integer id) {
        this._id = id;
    }
}
