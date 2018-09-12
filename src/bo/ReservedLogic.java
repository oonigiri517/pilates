package bo;

import dao.CancelDAO;
import model.Cancel;

public class ReservedLogic {
	public boolean cancelLogic(Cancel cancel) {
		CancelDAO cdao = new CancelDAO();
		return cdao.cancel(cancel);
	}
}