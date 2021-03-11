package Day4;

public class Question21 {
	public int days_in_a_month(String m,int y){
		switch(m) {
		case "Jan":
			return 31;	
		case "Feb":
			if (y%4==0) {
				return 29;
			}
			else
				return 28;
		case "Mar":
			return 31;
		case "Apr":
			return 30;
		case "May":
			return 31;
		case "Jun":
			return 30;
		case "Jul":
			return 31;
		case "Aug":
			return 31;
		case "Sept":
			return 30;
		case "Oct":
			return 31;
		case "Nov":
			return 30;
		case "Dec":
			return 31;
		default:
			System.out.println("Enter valid month");
	
		}
		return -1;
	}
	public static void main(String[] args) {
		Question21 o = new Question21();
		System.out.println(o.days_in_a_month("Feb", 2000));
	}
}
