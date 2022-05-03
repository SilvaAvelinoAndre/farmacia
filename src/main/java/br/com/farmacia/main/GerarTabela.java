package br.com.farmacia.main;

import br.com.farmacia.util.HibernateUtil;

public class GerarTabela {

	public static void main(String[] args) {


		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();;
	}

}
