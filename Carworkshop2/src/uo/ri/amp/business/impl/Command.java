package uo.ri.amp.business.impl;

import uo.ri.amp.model.exception.BusinessException;

/**
 * Interfaz de los comandos que se ejecutan en la aplicación.
 * @author UO223936
 *
 */
public interface Command {

	/**
	 * Método a ejecutarse. Puede devolver null dependiendo del método que lo implemente.
	 * @return
	 * @throws BusinessException
	 */
	Object execute()throws BusinessException;

}
