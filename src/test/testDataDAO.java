package test;

import dao.DataDAO;
import model.Lesson;
import model.MailData;
import model.ReserveData;

public class testDataDAO {
	public static void main(String[] args) {
//		LessonLogic SLC=new LessonLogic();
//		Schedule SLL=SLC.showSchedule(5);
//		String[] SL=SLL.getSchedule();
//		int sll=SL.length;
//		System.out.println(sll);
//
//		switch(sll){
//
//		case 3:
//			System.out.print(SL[2]);
//			break ;
//		case 4:
//			if(SL[3]=="満員"){
//				System.out.print(SL[3]);
//			}else{
//			}
//			break;
//		case 6:
//			if(SL[3]=="満員"){
//				System.out.print(SL[5]);
//				}else{
//			}
//
//			if(SL[5]=="満員"){
//			}else{
//			break;}
//		default :
//			break ;
//		}
//
		Lesson lesson=new Lesson("2018/09/21","10:00");
		ReserveData rData=new ReserveData("山田","花子","yamada@imail.com","yamada@imail.com","090-0000-9999","test");

		testInsertOK(lesson, rData);
//		testFindNum(lesson, rData);
//		testcheckOK(lesson, rData);

	}

	public static void testFindNum(Lesson lesson, ReserveData rData){
		DataDAO dataDAO=new DataDAO();
		MailData mailData = null;

		mailData = dataDAO.findNum(lesson, rData);

		if(mailData != null){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}

	public static void testcheckOK(Lesson lesson, ReserveData rData){
		DataDAO dataDAO=new DataDAO();

		boolean result=dataDAO.check(lesson, rData);
		if(!result){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}

	public static void testInsertOK(Lesson lesson, ReserveData rData){
		DataDAO dataDAO=new DataDAO();

		boolean result=dataDAO.insert(lesson, rData);

		if(result){
			System.out.println("成功");
		}else{
			System.out.println("失敗");
		}
	}

}
