package pe.gob.servir.systems.util.retorno;

import java.io.Serializable;

public class ReturnObject implements  Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean		sw;
	private String		msg;
	private Long		id;
	
	public ReturnObject() {
		super();
	}

	public Boolean getSw() {
		return sw;
	}

	public void setSw(Boolean sw) {
		this.sw = sw;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
