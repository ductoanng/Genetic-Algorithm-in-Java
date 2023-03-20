public class Population {

	private Individual[] individuals;
	private double sum;
	private double[] partition;
	private int popSize;
	
	//Constructor
	public Population(Individual[] listIndividuals) {
		individuals = listIndividuals;
		popSize = individuals.length;
		partition = new double[popSize];
		sum=0;
		for (int i=0; i<individuals.length; i++){
			sum = sum+individuals[i].f();
			partition[i]=sum;
		}
	}
	
	//Get the size of the population (each generation)
	public int size() {
		return popSize;
	}

	//Get the list of individual objects
	public Individual[] getIndividual() {
		return individuals;
	}

	//Get the sume of all individual values in one generation
	public double getSum(){
		return sum;
	}
	
	//Partition for Roulette Wheel Selection
	public double[] getPartition(){
		return partition;
	}

	//Print a population (for testing)
	public void printPopulation(){
		for (int i =0; i<individuals.length;i++){
			individuals[i].printChrom();
		}
	}

	//Get the average value of all individual values in one generation
	public double averageF(){
		double sum=0;
		for (int i=0; i<popSize;i++){
			sum = sum+ individuals[i].f();
		}
		return sum/popSize;
	}

	//Get the max value of all individual values in one generation
	public double maxF(){
		double max = -99999;
		for (int i=0; i<popSize;i++){
			if (max <individuals[i].f())
				max = individuals[i].f();
		}
		return max;
	}

}
