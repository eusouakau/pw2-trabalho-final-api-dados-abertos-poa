package ifrs.edu.model.dataPoaMatriculaEscola;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("include_total")
    public boolean getInclude_total() {
        return this.include_total;
    }

    public void setInclude_total(boolean include_total) {
        this.include_total = include_total;
    }

    boolean include_total;

    @JsonProperty("resource_id")
    public String getResource_id() {
        return this.resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    String resource_id;

    @JsonProperty("fields")
    public ArrayList<Field> getFields() {
        return this.fields;
    }

    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }

    ArrayList<Field> fields;

    @JsonProperty("records_format")
    public String getRecords_format() {
        return this.records_format;
    }

    public void setRecords_format(String records_format) {
        this.records_format = records_format;
    }

    String records_format;

    @JsonProperty("records")
    public ArrayList<Record> getRecords() {
        return this.records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    ArrayList<Record> records;

    @JsonProperty("_links")
    public Links get_links() {
        return this._links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    Links _links;

    @JsonProperty("total")
    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    int total;
}