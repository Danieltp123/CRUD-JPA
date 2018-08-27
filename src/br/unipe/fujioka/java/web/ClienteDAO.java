package br.unipe.fujioka.java.web;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import br.unipe.fujioka.java.web.entidades.Cliente;



public class ClienteDAO {
	private EntityManager getEntityManager() {
	    EntityManagerFactory factory = null;
	    EntityManager entityManager = null;
	    try {
	      //Obtém o factory a partir da unidade de persistência.
	      factory = Persistence.createEntityManagerFactory("cadastro");
	      //Cria um entity manager.
	      entityManager = factory.createEntityManager();
	      //Fecha o factory para liberar os recursos utilizado.
	    } finally {
	      factory.close();
	    }
	    return entityManager;
	  }
	  public void salvar(Cliente cliente) throws Exception {
	    EntityManager entityManager = getEntityManager();
	    try {
	      // Inicia uma transação com o banco de dados.
	      entityManager.getTransaction().begin();
	      System.out.println("Salvando a pessoa.");
	      // Verifica se a pessoa ainda não está salva no banco de dados.
	      if(pessoa.getId() == null) {
	        //Salva os dados da pessoa.
	        entityManager.persist(pessoa);
	      } else {
	        //Atualiza os dados da pessoa.
	        pessoa = entityManager.merge(pessoa);
	      }
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	    return pessoa;
	  }

	  /**
	   * Método que apaga a pessoa do banco de dados.
	   * @param id
	   */
	  public void excluir(Long id) {
	    EntityManager entityManager = getEntityManager();
	    try {
	      // Inicia uma transação com o banco de dados.
	      entityManager.getTransaction().begin();
	      // Consulta a pessoa na base de dados através do seu ID.
	      Pessoa pessoa = entityManager.find(Pessoa.class, id);
	      System.out.println("Excluindo os dados de: " + pessoa.getNome());
	      // Remove a pessoa da base de dados.
	      entityManager.remove(pessoa);
	      // Finaliza a transação.
	      entityManager.getTransaction().commit();
	    } finally {
	      entityManager.close();
	    }
	  }

	  /**
	   * Consulta o pessoa pelo ID.
	   * @param id
	   * @return o objeto Pessoa.
	   */
	  public Pessoa consultarPorId(Long id) {
	    EntityManager entityManager = getEntityManager();
	    Pessoa pessoa = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	      pessoa = entityManager.find(Pessoa.class, id);
	    } finally {
	      entityManager.close();
	    }
	    return pessoa;
	  }
	}
	
	public void criarCliente(Cliente cliente) {
		System.out.println(cliente);
		manager.getTransaction().begin();
		manager.persist(cliente);		
		manager.getTransaction().commit();
		manager.close();
	}
	public void deletarCliente(Long id) {
		cliente = manager.find(Cliente.class, id);
		manager.remove(cliente);
		System.out.println(cliente);
		
	}
	public void update(Cliente cliente,String name,String lastName,String matricula,boolean ativo) {
		cliente = manager.find(Cliente.class, cliente.getId());
		cliente.setName(name);
		cliente.setLastName(lastName);
		cliente.setMatricula(matricula);
		cliente.setAtivo(ativo);
		cliente.setDataFim(new Date());
		cliente.setDataInicio(new Date());
		manager.refresh(cliente);
		System.out.println(cliente);
	}

}
