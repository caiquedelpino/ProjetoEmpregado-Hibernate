package prova;

import org.hibernate.Session;

import prova.model.Cliente;
import prova.persistence.ClienteHibernateDAO;
import prova.persistence.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Cliente c1 = new Cliente();
    	c1.setNome("Israel");
    	c1.setEmail("caiquedelpino@gmail.com");
    	c1.setEndereco("Rua Alves Maldonado");
    	c1.setFone("2542-1421");
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	
    	ClienteHibernateDAO<Cliente> clienteDao = new ClienteHibernateDAO<Cliente>(session);
    	clienteDao.beginTransaction();
    	//clienteDao.excluir(1);
    	//Cliente cId1 = clienteDao.encontrarPeloId(1);
    	//System.out.println("Nome: "+cId1.getNome());
    	
    	clienteDao.persistir(c1);
    	clienteDao.commit();
    	clienteDao.closeSession();
    }
}
