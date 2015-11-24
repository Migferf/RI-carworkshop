package uo.ri.amp.ui.admin.action;

import alb.util.console.Printer;
import alb.util.menu.Action;
import uo.ri.amp.conf.ServicesFactory;
import uo.ri.amp.model.exception.BusinessException;

/**
 * Genera los certificados de experto a los mecánicos apropiados.
 * @author UO223936
 *
 */
public class GenerarCertificadosAction implements Action {

	public void execute() throws Exception {

		try {
			
			ServicesFactory.getAdminService().generarCertificados();

			System.out.println("Certificados de experto realizados");
		} catch (BusinessException e) {
				
			Printer.printBusinessException(e);
		}

	}

}
