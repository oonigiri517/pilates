package bo;

import java.util.Calendar;

import dao.CustomerDAO;
import dao.LessonDAO;
import model.Schedule;

public class LessonLogic {

	public Schedule showSchedule(int LD) {
		Calendar MC2 = Calendar.getInstance();
		int LY = MC2.get(Calendar.YEAR);
		int LM = MC2.get(Calendar.MONTH);
		MC2.set(Calendar.DATE, LD);
		String sLY = String.valueOf(LY);
		String sLM = String.valueOf(LM+1);
		String sLD = String.valueOf(LD);
		Calendar today = Calendar.getInstance();
		int Y = today.get(Calendar.YEAR);
		int M = today.get(Calendar.MONTH);
		int D = today.get(Calendar.DATE);
		today.set(Y, M, D);
		today.add(D, 1);
		boolean N = MC2.after(today);
		String[] le6 = new String[6];
		String[] le4 = new String[4];
		String[] le3 = new String[3];
		le6[0]=le4[0]=le3[0] = sLM;
		le6[1]=le4[1]=le3[1] = sLD;
		if (N == false) {

			le3[2] = "締切";
			Schedule sle = new Schedule(le3);
			return sle;


		} else {
			String DATE = sLY+"-"+sLM + "/" + sLD;
			LessonDAO LDAO = new LessonDAO();
			String[] FDATE = LDAO.findDay(DATE);
			if ((FDATE[0] != "無し") && (FDATE[1] != "無し")) {
				le6[2] = FDATE[0];
				le6[4] = FDATE[1];
				CustomerDAO CCDAO = new CustomerDAO();
				int CC1 = CCDAO.countCustomer(DATE, le6[2]);
				switch (CC1) {
				case 0:
					le6[3] = "残り2人";
					break;
				case 1:
					le6[3] = "残り1人";
					break;
				case 2:
					le6[3] = "満員";
					break;
				}
				int CC2 = CCDAO.countCustomer(DATE, le6[5]);
				switch (CC2) {
				case 0:
					le6[5] = "残り2人";
					break;
				case 1:
					le6[5] = "残り1人";
					break;
				case 2:
					le6[5] = "満員";
					break;

				}
				Schedule sle = new Schedule(le6);
				return sle;

			} else if ((FDATE[0] == "無し") && (FDATE[1] != "無し")) {
				le4[2] = FDATE[1];
				CustomerDAO CCDAO = new CustomerDAO();
				int CC2 = CCDAO.countCustomer(DATE, le4[2]);
				switch (CC2) {
				case 0:
					le4[3] = "残り2人";
					break;
				case 1:
					le4[3] = "残り1人";
					break;
				case 2:
					le4[3] = "満員";
					break;
				}
				Schedule sle = new Schedule(le4);
				return sle;

			} else if ((FDATE[0] != "無し") && (FDATE[1] == "無し")) {
				le4[2] = FDATE[0];

				CustomerDAO CCDAO = new CustomerDAO();
				int CC1 = CCDAO.countCustomer(DATE, le4[3]);
				switch (CC1) {
				case 0:
					le4[3] = "残り2人";
					break;
				case 1:
					le4[3] = "残り1人";
					break;
				case 2:
					le4[3] = "満員";
					break;
				}
				Schedule sle = new Schedule(le4);
				return sle;

			} else {
				le3[2] = "休み";
				Schedule sle = new Schedule(le3);
				return sle;

			}
		}
	}

}
