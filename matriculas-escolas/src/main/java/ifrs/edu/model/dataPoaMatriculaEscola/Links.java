package ifrs.edu.model.dataPoaMatriculaEscola;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Links {
    private String start;
    private String next;

    @JsonProperty("start")
    public String getStart() {
        return this.start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @JsonProperty("next")
    public String getNext() {
        return this.next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}