package bo;

import dao.CancelDAO;
import model.Cancel;

public class ReservedLogic {
	public static void main(String[] args) {
		Cancel cancel = new Cancel("3", "2018-08-28", "kanemoto@mail.com");
		ReservedLogic rld = new ReservedLogic();
		boolean result = rld.cancelLogic(cancel);
		if (result) {
			System.out.println("ok");
		} else {
			System.out.println("ng");
		}
	}

	public boolean cancelLogic(Cancel cancel) {
		CancelDAO cdao = new CancelDAO();
		return cdao.cancel(cancel);
	}
}