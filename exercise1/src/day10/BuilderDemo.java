package day10;

public class BuilderDemo {
	public static void main(String[] args) {
		Computer c1 = new Computer.BuildComputer("Ryzen5 4500u", "12 GB").build();
		System.out.println(c1);
		Computer c2 = new Computer.BuildComputer("Ryzen5 4500u", "12 GB").setGraphics_card("RTX 3090").setHdd("2TB").build();
		System.out.println(c2);
		
	}
}

class Computer{
	private String motherboard,ram,hdd,graphics_card;
	
	public String getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(String motherboard) {
		this.motherboard = motherboard;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public String getGraphics_card() {
		return graphics_card;
	}

	public void setGraphics_card(String graphics_card) {
		this.graphics_card = graphics_card;
	}

	public Computer(BuildComputer mycomputer) {
		// TODO Auto-generated constructor stub
		this.motherboard = mycomputer.motherboard;
		this.ram = mycomputer.ram;
		this.graphics_card = mycomputer.getGraphics_card();
		this.hdd = mycomputer.hdd;
	}
	
	@Override
	public String toString() {
		return "Computer [motherboard=" + motherboard + ", ram=" + ram + ", hdd=" + hdd + ", graphics_card="
				+ graphics_card + "]";
	}



	public static class BuildComputer{
		private String motherboard,ram,hdd,graphics_card;
		public BuildComputer(String motherboard,String ram) {
			this.motherboard=motherboard;
			this.ram = ram;
			// TODO Auto-generated constructor stub
		}
		public String getHdd() {
			return hdd;
		}
		public BuildComputer setHdd(String hdd) {
			this.hdd = hdd;
			return this;
		}
		public String getGraphics_card() {
			return graphics_card;
		}
		public BuildComputer setGraphics_card(String graphics_card) {
			this.graphics_card = graphics_card;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
		
		
	}
}
