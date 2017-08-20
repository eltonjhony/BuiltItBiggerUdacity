package com.eljholiveira.builtitbiggerudacity;

/**
 * Created by eltonjhony on 19/08/17.
 */

public class JokeResponse {

    private String data;
    private boolean error;

    public JokeResponse(String data, boolean error) {
        this.data = data;
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }
}
