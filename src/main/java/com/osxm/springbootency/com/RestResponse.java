/**  
* @Title: RestResponse.java
* @Package com.osxm.springbootency.com
* @Description: TODO
* @author XM
* @date 2021年11月26日 下午9:42:48
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.springbootency.com;

public class RestResponse<T> {
	
	private String status;
	private T datas;
	private String msg;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public T getDatas() {
		return datas;
	}
	public void setDatas(T datas) {
		this.datas = datas;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
    public RestResponse(String status, T datas, String msg) {
        this.status = status;
        this.datas = datas;
        this.msg = msg;
    }

    public static <T> RestResponse<T> success(T datas) {
        return new RestResponse<>("success", datas, null);
    }

    public static <T> RestResponse<T> fail(String msg) {
    	return new RestResponse<>("fail", null, msg);
    }
}
