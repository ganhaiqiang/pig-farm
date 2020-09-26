package com.ghq.pig.farm.common;

public class ApiResponse implements Response {
	private Integer code;
	private String msg;
	private Object data;

	public static Response ok() {
		return new ApiResponse(200, "ok");
	}

	public static Response ok(Object data) {
		return new ApiResponse(200, "ok", data);
	}

	public static Response error(Integer code, String msg) {
		return new ApiResponse(code, msg);
	}

	public ApiResponse(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ApiResponse(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ApiResponse() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
