package ifrs.edu.model.dataPoaMatriculaEscola;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Field {
    private String type;
    private String id;

    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}