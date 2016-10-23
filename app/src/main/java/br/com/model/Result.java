package br.com.model;

import com.google.gson.JsonElement;

/**
 * Created by Fernando on 22/10/2016.
 */
public class Result {

    public static final Long ERROR = 0L;
    public static final Long SUCCESS = 1L;

    private Long status = SUCCESS;
    private JsonElement answer;

    public static Long getERROR() {
        return ERROR;
    }

    public static Long getSUCCESS() {
        return SUCCESS;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public JsonElement getAnswer() {
        return answer;
    }

    public void setAnswer(JsonElement answer) {
        this.answer = answer;
    }

    public boolean hasError() {
        return ERROR.equals(this.status);
    }

}
