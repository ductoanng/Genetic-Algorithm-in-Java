public class Individual {

	//Inputs for an individual
	private int Num_bit_X;
	private int Num_bit_Y;
	private int Num_bit_Z;
	private double max_x;
	private double min_x;
	private double max_y;
	private double min_y;
	private double max_z;
	private double min_z;

	private String chromosome;
	private String x_gene;
	private String y_gene;
	private String z_gene;
	private double x_value;
	private double y_value;
	private double z_value;
	private int chromLen;

	//Contructor based on the initial conditions for an individual
	public Individual(String chrom, int Num_bit_X, int Num_bit_Y, int Num_bit_Z, double max_x, double min_x, double max_y, double min_y, double max_z, double min_z) {
		chromosome = chrom;

		this.Num_bit_X = Num_bit_X;
		this.Num_bit_Y = Num_bit_Y;
		this.Num_bit_Z = Num_bit_Z;

		this.max_x = max_x;
		this.min_x = min_x;
		this.max_y = max_y;
		this.min_y = min_y;
		this.max_z = max_z;
		this.min_z = min_z;

		chromLen = chromosome.length();
		x_gene=chrom.substring(0,Num_bit_X);
		y_gene=chrom.substring(Num_bit_X,Num_bit_X+Num_bit_Y);
		z_gene=chrom.substring(Num_bit_X+Num_bit_Y);

		x_value = min_x + (max_x-min_x)*(Integer.parseInt(x_gene,2))/(Math.pow(2,Num_bit_X)-1);
		y_value = min_y + (max_y-min_y)*(Integer.parseInt(y_gene,2))/(Math.pow(2,Num_bit_Y)-1);
		z_value = min_z + (max_z-min_z)*(Integer.parseInt(z_gene,2))/(Math.pow(2,Num_bit_Z)-1);
	}

	//Copy constructor with the change in chromosome only
	public Individual(String chrom, Individual ind){
		chromosome = chrom;

		this.Num_bit_X = ind.getNum_bit_X();
		this.Num_bit_Y = ind.getNum_bit_Y();
		this.Num_bit_Z = ind.getNum_bit_Z();

		this.max_x = ind.getmax_x();
		this.min_x = ind.getmin_x();
		this.max_y = ind.getmax_y();
		this.min_y = ind.getmin_y();
		this.max_z = ind.getmax_z();
		this.min_z = ind.getmin_z();

		chromLen = chromosome.length();
		x_gene=chrom.substring(0,this.Num_bit_X);
		y_gene=chrom.substring(this.Num_bit_X,this.Num_bit_X+this.Num_bit_Y);
		z_gene=chrom.substring(this.Num_bit_X+this.Num_bit_Y);

		x_value = this.min_x + (this.max_x-this.min_x)*(Integer.parseInt(x_gene,2))/(Math.pow(2,this.Num_bit_X)-1);
		y_value = this.min_y + (this.max_y-this.min_y)*(Integer.parseInt(y_gene,2))/(Math.pow(2,this.Num_bit_Y)-1);
		z_value = this.min_z + (this.max_z-this.min_z)*(Integer.parseInt(z_gene,2))/(Math.pow(2,this.Num_bit_Z)-1);
	}

	//Get values for the fields of each individual
	public int getNum_bit_X(){
		return Num_bit_X;
	}

	public int getNum_bit_Y(){
		return Num_bit_Y;
	}

	public int getNum_bit_Z(){
		return Num_bit_Z;
	}

	public double getmax_x(){
		return max_x;
	}

	public double getmin_x(){
		return min_x;
	}

	public double getmax_y(){
		return max_y;
	}

	public double getmin_y(){
		return min_y;
	}

	public double getmax_z(){
		return max_z;
	}

	public double getmin_z(){
		return min_z;
	}

	public double getX(){
		return x_value;
	}

	public double getY(){
		return y_value;
	}

	public double getZ(){
		return z_value;
	}

	public int getLength(){
		return chromLen;
	}

	public void printChrom(){
		System.out.println(x_gene+"|"+y_gene+"|"+z_gene);
	}

	//Get the value 
	public double f(){
		return 10*(Math.cos(x_value*x_value*y_value*z_value)+1);   // f(x,y,z) = cos((x^2)yz)
	}

	public String getChrom(){
		return chromosome;
	}

}





