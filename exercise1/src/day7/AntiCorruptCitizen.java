package day7;

public class AntiCorruptCitizen {
	public static void main(String[] args) {
		Police police = new Police();
		Hospital hospital = new Hospital();
		Corporation corporation = new Corporation();
		FoodDept fooddept = new FoodDept();
		
		Seva seva = new Seva();
		
		LegalProcess dc = new GetDeathCertificate(police, hospital, corporation, fooddept);
		
		LegalProcess oh = new OpenHotel(police, hospital, corporation, fooddept);
		
		seva.setprocess(0, dc);
		seva.setprocess(1, oh);
		
		seva.executeProcess(0);
		seva.executeProcess(1);
	}
}

class Seva{
	LegalProcess p[] = new LegalProcess[5];
	public Seva() {
		for(int i=0;i<3;i++) {
			p[i]=new Dummy();
		}
	}
	
	public void setprocess(int slot, LegalProcess legalprocess) {
		p[slot] = legalprocess;
	}
	
	public void executeProcess(int slot) {
		p[slot].get_approval();
		System.out.println();
	}
	
}

class Dummy extends LegalProcess{

	@Override
	public void get_approval() {
		System.out.println("Dummy process");
		
	}
	
}

abstract class LegalProcess{
	
	public LegalProcess() {
		
	}
	
	private Police police;
	private Hospital hospital;
	private Corporation corporation;
	private FoodDept fooddept;
	
	public LegalProcess(Police police, Hospital hospital, Corporation corporation, FoodDept fooddept) {
		super();
		this.police = police;
		this.hospital = hospital;
		this.corporation = corporation;
		this.fooddept = fooddept;
	}
	
	
	
	public Police getPolice() {
		return police;
	}



	public Hospital getHospital() {
		return hospital;
	}



	public Corporation getCorporation() {
		return corporation;
	}



	public FoodDept getFooddept() {
		return fooddept;
	}



	public abstract void get_approval();
}

class GetDeathCertificate extends LegalProcess{
	public GetDeathCertificate(Police police, Hospital hospital, Corporation corporation, FoodDept fooddept) {
		super(police, hospital, corporation, fooddept);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void get_approval() {
		// TODO Auto-generated method stub
		System.out.println("working on getting death certificate");
		getHospital().getApproval();
		getCorporation().getApproval();
		System.out.println("Approved");
	}
	
}

class OpenHotel extends LegalProcess{
	public OpenHotel(Police police, Hospital hospital, Corporation corporation, FoodDept fooddept) {
		super(police, hospital, corporation, fooddept);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void get_approval() {
		// TODO Auto-generated method stub
		System.out.println("Working on getting approval for hotel");
		getFooddept().getApproval();
		getCorporation().getApproval();
		getPolice().getApproval();
		System.out.println("Approved");
	}
	
}

class Police{
	public void getApproval() {
		System.out.println("approved by police");
	}
}

class Hospital{
	public void getApproval() {
		System.out.println("approved by Hospital");
	}
}

class Corporation{
	public void getApproval() {
		System.out.println("Approved by Corporation");
	}
}

class FoodDept{
	public void getApproval() {
		System.out.println("approved by Food department");
	}
}

