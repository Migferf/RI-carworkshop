package uo.ri.amp.business.impl;

import uo.ri.amp.model.exception.BusinessException;

public interface Command {

	Object execute()throws BusinessException;

}
