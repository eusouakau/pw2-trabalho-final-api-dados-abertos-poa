package ifrs.edu;

public class MatriculaEscola {
    private Integer id;
    private String name;

    public MatriculaEscola(){

    }
    public MatriculaEscola(Integer id, String name){
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
