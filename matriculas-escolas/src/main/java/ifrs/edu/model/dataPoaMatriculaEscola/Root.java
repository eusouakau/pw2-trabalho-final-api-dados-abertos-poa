package ifrs.edu.model.dataPoaMatriculaEscola;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
    @JsonProperty("success")
    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    boolean success;

    @JsonProperty("result")
    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    Result result;
}