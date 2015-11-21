package uo.ri.amp.business.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import uo.ri.amp.model.exception.BusinessException;
import uo.ri.amp.persistence.util.Jpa;

public class CommandExecutor {

	public Object execute(Command command) throws BusinessException {
		EntityManager em=null;
		EntityTransaction  trx=null;
		Object res = null;
		try {
			em = Jpa.createEntityManager();
			trx = em.getTransaction();
			trx.begin();
			res = command.execute();
			
			trx.commit();
		}catch (BusinessException bex) {
			if(trx!=null)
			{
			if (trx.isActive())
				trx.rollback();
			throw bex;
			}
		} catch (RuntimeException rex) {
			if (trx.isActive())
				trx.rollback();
			throw new BusinessException("Error grave en la ejecución del programa,"
					+ "es posible que la base de datos no esté operativa.");
		}catch (Exception e) {
			throw new BusinessException("Error no esperado");
		}
		finally {
			if (em.isOpen())
				em.close();
		}
		return res;
	}
}
