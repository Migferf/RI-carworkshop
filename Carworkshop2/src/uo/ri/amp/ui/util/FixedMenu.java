package uo.ri.amp.ui.util;

import alb.util.console.Printer;
import alb.util.menu.BaseMenu;
import uo.ri.amp.model.exception.BusinessException;

/**
 * Clase intermedia para impedir el RunTimeException de BaseMenu
 * @see BaseMenu
 * @author UO223936
 *
 */
public class FixedMenu extends BaseMenu {

	@Override
	public void execute() {
		int opt;

		do {
			showMenu();
			opt = getMenuOption();
			try {
				processOption(opt);

			} catch (IndexOutOfBoundsException e) {
				Printer.printBusinessException(new BusinessException(
						"Error en los índices del menú, verifique su opción"));
			} catch (RuntimeException rte) {
				Printer.printRuntimeException(rte);
				throw rte; // Quits the app

			} catch (Exception be) {
				Printer.printBusinessException(be);
			}
		} while (opt != EXIT);

	}

}
