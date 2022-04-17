package br.com.farmacia.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JFSUtil {
	


	public static void mensagemSucesso(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}

	public static void mensagemErro(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
}
