package br.com.faculdadedelta.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.faculdadedelta.dao.VeiculoDaoWanderson;
import br.edu.faculdadedelta.modelo.VeiculoWanderson;


@ManagedBean
@SessionScoped

public class VeiculoControllerWanderson {

	private VeiculoWanderson servico = new VeiculoWanderson();
	private VeiculoDaoWanderson veiculoDAO = new VeiculoDaoWanderson();

	public VeiculoWanderson getVeiculoWanderson() {
		return servico;
	}

	public void setVeiculoWanderson(VeiculoWanderson veiculoWanderson) {
		this.servico = veiculoWanderson;
	}

	public void limparcampo(){
		servico = new VeiculoWanderson();		
	}

	public String salvar(){
		
		try {
			if (servico.getId() == null) {
				veiculoDAO.incluir(servico);
				FacesMessage mensagem = new FacesMessage("Inclusão realizada com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				limparcampo();
			} else {
				// alterar
				veiculoDAO.alterar(servico);
				FacesMessage mensagem = new FacesMessage("Alteração realizada com sucesso!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				limparcampo();
			}
	}catch(ClassNotFoundException|
	SQLException e){
		FacesMessage mensagem = new FacesMessage(
				"Erro ao realizar a operação. " + "Tente novamente mais tarde. " + e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		e.printStackTrace();
	}return"cadastroServicos.xhtml";
	}
	
	public List<VeiculoWanderson> getLista() {
		List<VeiculoWanderson> listaRetorno = new ArrayList<VeiculoWanderson>();
		try {
			listaRetorno = veiculoDAO.listar();
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return listaRetorno;
	}
	
	public String editar() {
		return "cadastroServicos.xhtml";
	}
	
	public String excluir() {
		try {
			veiculoDAO.excluir(servico);
			FacesMessage mensagem = new FacesMessage("Exclusão realizada com sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			limparcampo();
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage mensagem = new FacesMessage("Erro ao realizar a operação. "
					+ "Tente novamente mais tarde. " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			e.printStackTrace();
		}
		return "listaServicos.xhtml";
	}

}
