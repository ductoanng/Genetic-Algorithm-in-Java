import java.util.Random;

public class GeneticAlgorithm {
    
	private Random rand = new Random();
	private Population pop;
	private int size;

	//Genetic Algorithm constructor requires an object from population class to evolve a new one.
	public GeneticAlgorithm(Population population) {
		pop=population;
		size=population.size();
	}
	
	//Random Selection using Roulette Wheel method
	public Individual[] randomSelection(){
		Individual[] list = new Individual[size];

		double[] part = pop.getPartition();
		double sum = pop.getSum();
		Individual[] inds = pop.getIndividual();

		int j = 0;
		while(j<size){
			double ran = rand.nextDouble()*sum;
			if (ran<part[0])
					list[j] = inds[0];
			else {
					for (int i=1; i<inds.length;i++){
						if (ran >= part[i-1] && ran < part[i])
							list[j] = inds[i];
					}
			}
			j++;
		}
		return list;
	}

	//Crossover method to contruct a new chromosome from two given chromosomes
	public String Crossover(String chrom1, String chrom2, int cr){
		String Newchrom1 = chrom1.substring(0, cr)+chrom2.substring(cr);
		return Newchrom1;
	}

	//Using crossover for reproduction
	public Population Reproduction(){
		Individual[] newInds = new Individual[size];
		Individual[] selectList = randomSelection();
		int rancross = rand.nextInt(selectList[0].getLength());
		if (size %2 != 0){
			newInds[size-1] = selectList[rand.nextInt(size)];
			size = size -1;
		}
		for (int i=0; i<(size/2); i++){
			int r1 = rand.nextInt(size);
			int r2 = rand.nextInt(size);
			String chromA = selectList[r1].getChrom();
			String chromB = selectList[r2].getChrom();
			Individual ind1 = new Individual(Crossover(chromA, chromB, rancross),selectList[0]);
			Individual ind2 = new Individual(Crossover(chromB, chromA, rancross),selectList[0]);
			newInds[2*i] = ind1;
			newInds[2*i+1] = ind2;
		}
		Population newPop = new Population(newInds);
		return newPop;
	}
}
