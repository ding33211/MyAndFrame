package com.soubu.CRMProject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dingsigang on 16-8-2.
 */
public class RetrofitApiResp<T> {

    @SerializedName("result")
    @Expose
    private T result;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("sec")
    @Expose
    private String sec;

    /**
     *
     * @return
     *     The result
     */
    public T getResult() {
        return result;
    }

    /**
     *
     * @param result
     *     The result
     */
    public void setResult(T result) {
        this.result = result;
    }

    /**
     *
     * @return
     *     The status
     */
    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *     The status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     *
     * @return
     *     The msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @param msg
     *     The msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     *
     * @return
     *     The sec
     */
    public String getSec() {
        return sec;
    }

    /**
     *
     * @param sec
     *     The sec
     */
    public void setSec(String sec) {
        this.sec = sec;
    }
}
