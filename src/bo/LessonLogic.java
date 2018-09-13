package bo;

import java.util.Calendar;

import dao.CustomerDAO;
import dao.LessonDAO;
import model.Lesson;
import model.Schedule;

public class LessonLogic {

	public Schedule showSchedule(int LD) {
		// public static void main(String[] args) {
		Lesson lesson = new Lesson();
		// int LD=18;
		Calendar myC = Calendar.getInstance();
		int LY = myC.get(Calendar.YEAR);
		int LM = myC.get(Calendar.MONTH);
		myC.set(Calendar.YEAR, LY);
		myC.set(Calendar.MONTH, LM);
		myC.set(Calendar.DATE, LD);
		// System.out.println(sdf.format(myC.getTime()));
		String sLY = String.valueOf(LY);
		String sLM = String.valueOf(LM + 1);
		String sLD = String.valueOf(LD);
		Calendar today = Calendar.getInstance();
		int Y = today.get(Calendar.YEAR);
		int M = today.get(Calendar.MONTH);
		int D = today.get(Calendar.DATE);
		// System.out.println(sdf.format(today.getTime()));
		today.set(Y, M, D);
		// System.out.println(sdf.format(today.getTime()));
		today.add(Calendar.DAY_OF_MONTH, 1);
		boolean N = myC.after(today);
		// System.out.println(sdf.format(today.getTime()));
		String[] le6 = new String[6];
		String[] le4 = new String[4];
		String[] le3 = new String[3];
		le6[0] = le4[0] = le3[0] = sLM;
		le6[1] = le4[1] = le3[1] = sLD;
		if (N == false) {

			le3[2] = " 締切 ";
			Schedule sle = new Schedule(le3);

			// System.out.println(1);

			return sle;

		} else {
			int LMM=LM+1;
			// String DATE = sLY+"-"+sLM + "-" + sLD;
			String DATE = String.format("%04d-%02d-%02d", LY, LMM, LD);
			lesson.setDate(DATE);
			LessonDAO LDAO = new LessonDAO();
			String[] FDATE = LDAO.findDay(DATE);
			for(String i:FDATE){
				System.out.println(i);
			}
			if ((FDATE[0] != "無し") && (FDATE[1] != "無し")) {
				le6[2] = FDATE[0];
				le6[4] = FDATE[1];
				lesson.setTime(FDATE[0]);
				CustomerDAO CCDAO = new CustomerDAO();
				int CC1 = CCDAO.countCustomer(lesson);
				switch (CC1) {
				case 0:
					le6[3] = "残り2人";
					break;
				case 1:
					le6[3] = "残り1人";
					break;
				case 2:
					le6[3] = " 満員 ";
					break;
				}
				lesson.setTime(FDATE[1]);
				int CC2 = CCDAO.countCustomer(lesson);
				switch (CC2) {
				case 0:
					le6[5] = "残り2人";
					break;
				case 1:
					le6[5] = "残り1人";
					break;
				case 2:
					le6[5] = " 満員 ";
					break;

				}

				// System.out.println(2);

				Schedule sle = new Schedule(le6);
				return sle;

			} else if ((FDATE[0] == "無し") && (FDATE[1] != "無し")) {
				// System.out.println("ok");
				le4[2] = FDATE[1];
				lesson.setTime(FDATE[1]);
				CustomerDAO CCDAO = new CustomerDAO();
				int CC2 = CCDAO.countCustomer(lesson);
				switch (CC2) {
				case 0:
					le4[3] = "残り2人";
					break;
				case 1:
					le4[3] = "残り1人";
					break;
				case 2:
					le4[3] = " 満員 ";
					break;
				}

				Schedule sle = new Schedule(le4);
				return sle;

			} else if ((FDATE[0] != "無し") && (FDATE[1] == "無し")) {
				le4[2] = FDATE[0];
				lesson.setTime(FDATE[0]);
				CustomerDAO CCDAO = new CustomerDAO();
				int CC1 = CCDAO.countCustomer(lesson);
				switch (CC1) {
				case 0:
					le4[3] = "残り2人";
					break;
				case 1:
					le4[3] = "残り1人";
					break;
				case 2:
					le4[3] = " 満員 ";
					break;
				}
				Schedule sle = new Schedule(le4);

				// System.out.println(3);

				return sle;

			} else if ((FDATE[0] == "無し") && (FDATE[1] == "無し")) {
				le3[2] = " 休み ";
				Schedule sle = new Schedule(le3);

				// System.out.println(4);

				return sle;

			}
		}return null;
	}
	public Schedule showSchedule2(int LD) {
		//public static void main(String[] args) {
		Lesson lesson = new Lesson();
		 //int LD=18;
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar myC = Calendar.getInstance();
		int LY = myC.get(Calendar.YEAR);
		myC.add(Calendar.MONTH,1);
		int LM=myC.get(Calendar.MONTH);
		myC.set(Calendar.YEAR, LY);
		myC.set(Calendar.MONTH, LM);
		myC.set(Calendar.DATE, LD);
		//System.out.println(sdf.format(myC.getTime()));
		String sLY = String.valueOf(LY);
		String sLM = String.valueOf(LM + 1);
		String sLD = String.valueOf(LD);
		//System.out.println(sLM);
		Calendar today = Calendar.getInstance();
		int Y = today.get(Calendar.YEAR);
		int M = today.get(Calendar.MONTH);
		int D = today.get(Calendar.DATE);
		// System.out.println(sdf.format(today.getTime()));
		today.set(Y, M, D);
		// System.out.println(sdf.format(today.getTime()));
		today.add(Calendar.DAY_OF_MONTH, 1);
		boolean N = myC.after(today);
		// System.out.println(sdf.format(today.getTime()));
		String[] le6 = new String[6];
		String[] le4 = new String[4];
		String[] le3 = new String[3];
		le6[0] = le4[0] = le3[0] = sLM;
		le6[1] = le4[1] = le3[1] = sLD;
		if (N == false) {

			le3[2] = " 締切 ";
			Schedule sle = new Schedule(le3);

			// System.out.println(1);

			return sle;

		} else {
			int LMM=LM+1;
			// String DATE = sLY+"-"+sLM + "-" + sLD;
			String DATE = String.format("%04d-%02d-%02d", LY, LMM, LD);
			lesson.setDate(DATE);
			LessonDAO LDAO = new LessonDAO();
			String[] FDATE = LDAO.findDay(DATE);
			for(String i:FDATE){
				System.out.println(i);
			}
			if ((FDATE[0] != "無し") && (FDATE[1] != "無し")) {
				le6[2] = FDATE[0];
				le6[4] = FDATE[1];
				lesson.setTime(FDATE[0]);
				CustomerDAO CCDAO = new CustomerDAO();
				int CC1 = CCDAO.countCustomer(lesson);
				switch (CC1) {
				case 0:
					le6[3] = "残り2人";
					break;
				case 1:
					le6[3] = "残り1人";
					break;
				case 2:
					le6[3] = " 満員 ";
					break;
				}
				lesson.setTime(FDATE[1]);
				int CC2 = CCDAO.countCustomer(lesson);
				switch (CC2) {
				case 0:
					le6[5] = "残り2人";
					break;
				case 1:
					le6[5] = "残り1人";
					break;
				case 2:
					le6[5] = " 満員 ";
					break;

				}

				// System.out.println(2);

				Schedule sle = new Schedule(le6);
				return sle;

			} else if ((FDATE[0] == "無し") && (FDATE[1] != "無し")) {
				// System.out.println("ok");
				le4[2] = FDATE[1];
				lesson.setTime(FDATE[1]);
				CustomerDAO CCDAO = new CustomerDAO();
				int CC2 = CCDAO.countCustomer(lesson);
				switch (CC2) {
				case 0:
					le4[3] = "残り2人";
					break;
				case 1:
					le4[3] = "残り1人";
					break;
				case 2:
					le4[3] = " 満員 ";
					break;
				}

				Schedule sle = new Schedule(le4);
				return sle;

			} else if ((FDATE[0] != "無し") && (FDATE[1] == "無し")) {
				le4[2] = FDATE[0];
				lesson.setTime(FDATE[0]);
				CustomerDAO CCDAO = new CustomerDAO();
				int CC1 = CCDAO.countCustomer(lesson);
				switch (CC1) {
				case 0:
					le4[3] = "残り2人";
					break;
				case 1:
					le4[3] = "残り1人";
					break;
				case 2:
					le4[3] = " 満員 ";
					break;
				}
				Schedule sle = new Schedule(le4);

				// System.out.println(3);

				return sle;

			} else if ((FDATE[0] == "無し") && (FDATE[1] == "無し")) {
				le3[2] = " 休み ";
				Schedule sle = new Schedule(le3);

				// System.out.println(4);

				return sle;

			}
		}return null;
	}

}
