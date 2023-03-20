import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class ControlGA extends JFrame implements ActionListener 

{   
    Random rand = new Random();
    JLabel lb1,lb2,lb3,lb4,lb5,lb6, lb7, lb8, lb9, lb10, lb11,lb12,lb13,lb14,lb15, lb16, lba, label1, label2, label3, label4;
    JPanel pn1, pn2, pn3, pn4, pn5, pn6, pn7, pn8, pn9, pn10, pn11,pn12,pn13,pn14,pn15,pn16, pna, pnb, pnc, pnd, pne, pnf, png, pnh, pni, pnj, pnl, panel1, panel2,panel3,panel4,pnz;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11,tf12,tf13,tf14;
    JButton bt1,bt2;
    JTextArea ta1, ta2;
    JScrollPane scroll1, scroll2;
    double maxX,maxY,maxZ, minX, minY, minZ;
    int geneX, geneY, geneZ, popsize;
    String maxText, aveText;
    List<Double> scores = new ArrayList<Double>();
    List<Double> avescores = new ArrayList<Double>();
    DrawGraph maxPanel,avePanel;


  
    public  ControlGA () {  
    	setSize(1100, 650);
		setTitle("Genetic Algorithm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(0,5));
        pna = new JPanel(new GridLayout(17,1));
        makeFunction();
        makeRange();
        makeBit();
        makePop();
        lastTwoCondition();
        button();
        add(pna,BorderLayout.WEST);
        result();
        
        plot();

        setVisible(true);
    }

    public void makeFunction(){
        pn1 = new JPanel(new FlowLayout());
        lb1 = new JLabel("Function f(x,y,z) = 10*(cos((x^2)yz)+1)");
        pn1.add(lb1);
        pna.add(pn1);
    }

    public void makeRange(){
        
        pn2 = new JPanel(new FlowLayout());
        lb2 = new JLabel("Range of x,y,z");
        pn2.add(lb2);
        pna.add(pn2);

        pn3 = new JPanel(new FlowLayout());
        lb3 = new JLabel("Max_X:");
        pnb = new JPanel(new FlowLayout());
        tf3 = new JTextField(10);
        pn3.add(lb3);
        pn3.add(tf3);
        pna.add(pn3);

        pn4 = new JPanel(new FlowLayout());
        lb4 = new JLabel("Min_X:");
        tf4 = new JTextField(10);
        pn4.add(lb4);
        pn4.add(tf4);
        pna.add(pn4);

        pn5 = new JPanel(new FlowLayout());
        lb5 = new JLabel("Max_Y:");
        tf5 = new JTextField(10);
        pn5.add(lb5);
        pn5.add(tf5);
        pna.add(pn5);

        pn6 = new JPanel(new FlowLayout());
        lb6 = new JLabel("Min_Y");
        tf6 = new JTextField(10);
        pn6.add(lb6);
        pn6.add(tf6);
        pna.add(pn6);

        pn7 = new JPanel(new FlowLayout());
        lb7 = new JLabel("Max_Z");
        tf7 = new JTextField(10);
        pn7.add(lb7);
        pn7.add(tf7);
        pna.add(pn7);

        pn8 = new JPanel(new FlowLayout());
        lb8 = new JLabel("Min_Z");
        tf8 = new JTextField(10);
        pn8.add(lb8);
        pn8.add(tf8);
        pna.add(pn8);
    }
	
    public void makeBit(){
        pn9 = new JPanel(new FlowLayout());
        lb9 = new JLabel("Bit per gene (x,y,z)");
        pn9.add(lb9);
        pna.add(pn9);

        pn10 = new JPanel(new FlowLayout());
        lb10 = new JLabel("Num_Bit_X");
        tf10 = new JTextField(10);
        pn10.add(lb10);
        pn10.add(tf10);
        pna.add(pn10);

        pn11 = new JPanel(new FlowLayout());
        lb11 = new JLabel("Num_Bit_Y");
        tf11 = new JTextField(10);
        pn11.add(lb11);
        pn11.add(tf11);
        pna.add(pn11);

        pn12 = new JPanel(new FlowLayout());
        lb12 = new JLabel("Num_Bit_Z");
        tf12 = new JTextField(10);
        pn12.add(lb12);
        pn12.add(tf12);
        pna.add(pn12);

    }

    public void makePop(){
        pn14 = new JPanel(new FlowLayout());
        lb14 = new JLabel("Population per Generation");
        pn14.add(lb14);
        pna.add(pn14);

        pn13 = new JPanel(new FlowLayout());
        lb13 = new JLabel("Population");
        tf13 = new JTextField(10);
        pn13.add(lb13);
        pn13.add(tf13);
        pna.add(pn13);
    }

    public void lastTwoCondition(){
        pn15 = new JPanel(new FlowLayout());
        lb15 = new JLabel("Crossing anywhere");
        pn15.add(lb15);
        pna.add(pn15);

        pn16 = new JPanel(new FlowLayout());
        lb16 = new JLabel("Number of generations is 100");
        pn16.add(lb16);
        pna.add(pn16);
    }

    public void button(){
        bt1 = new JButton("Generate");
        bt1.addActionListener(this);

        bt2 = new JButton("Reset");
        bt2.addActionListener(this);
        pne = new JPanel(new FlowLayout());
        pne.add(bt1);
        pne.add(bt2);
        pna.add(pne);
        


    }

    public void result(){
        pnb = new JPanel(new BorderLayout());

        pnc = new JPanel(new FlowLayout());
        lba = new JLabel("Result");
        pnc.add(lba);
        pnb.add(pnc, BorderLayout.NORTH);

        pnj = new JPanel(new GridLayout(2,1));

        pnd = new JPanel(new FlowLayout());
        ta1 = new JTextArea(15,23);
        scroll1 = new JScrollPane(ta1);
        pnd.add(scroll1);
        pnj.add(pnd);

        pnl = new JPanel(new FlowLayout());
        ta2 = new JTextArea(15,23);
        scroll2 = new JScrollPane(ta2);
        pnl.add(scroll2);
        pnj.add(pnl);

        pnb.add(pnj, BorderLayout.CENTER);
        add(pnb,BorderLayout.EAST);
    }

    public void plot(){
        pnz = new JPanel(new GridLayout(2,1));

        pnh = new JPanel(new BorderLayout());
        panel1 = new JPanel(new FlowLayout());
        label1 = new JLabel("Graph for max values");
        panel1.add(label1);

        panel2 = new JPanel(new FlowLayout());
        maxPanel = new DrawGraph(scores);
        panel2.add(maxPanel);

        pnh.add(panel2, BorderLayout.CENTER);
        pnh.add(panel1, BorderLayout.NORTH);
        pnz.add(pnh);

        pnf = new JPanel(new BorderLayout());
        panel3 = new JPanel(new FlowLayout());
        label2 = new JLabel("Graph for average values");
        panel3.add(label2);

        panel4 = new JPanel(new FlowLayout());
        avePanel = new DrawGraph(avescores);
        panel4.add(avePanel);

        pnf.add(panel4, BorderLayout.CENTER);
        pnf.add(panel3, BorderLayout.NORTH);
        pnz.add(pnf);

        add(pnz, BorderLayout.CENTER);

    }

	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
        if (o == bt1){  //generate the algorithm
            generate();
        } else if (o == bt2){ //reset
            reset();
        }
	}   

    public void reset(){
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf5.setText("");
        tf6.setText("");
        tf7.setText("");
        tf8.setText("");
        tf10.setText("");
        tf11.setText("");
        tf12.setText("");
        tf13.setText("");
        ta1.setText("");
        ta2.setText("");
        maxText="";
        aveText="";

        panel2.remove(maxPanel);
        scores = new ArrayList<Double>();
        maxPanel = new DrawGraph(scores);
        panel2.add(maxPanel);

        panel4.remove(avePanel);
        avescores = new ArrayList<Double>();
        avePanel = new DrawGraph(avescores);
        panel4.add(avePanel);

        setVisible(true); 
    }

    //method generating a random binary number given number of bits
    public static String RandomBin(int DigitNum){
		Random r = new Random();
		int b = ((int) Math.pow(2, DigitNum))-1;
		int ranint = r.nextInt(b);
		String s = Integer.toBinaryString(ranint);
		int n = s.length();
		if (s.length()<DigitNum){
			for (int i = 0; i<(DigitNum-n); i++){
				s = "0"+s;
			}
		}
		return s;
	}

    public void generate(){
        try{
        panel2.remove(maxPanel);
        scores = new ArrayList<Double>();

        panel4.remove(avePanel);
        avescores = new ArrayList<Double>();
        //get range inputs
        maxX = Double.parseDouble(tf3.getText());
        minX = Double.parseDouble(tf4.getText());
        maxY = Double.parseDouble(tf5.getText());
        minY = Double.parseDouble(tf6.getText());
        maxZ = Double.parseDouble(tf7.getText());
        minZ = Double.parseDouble(tf8.getText());

        //get number of bit 
        geneX = Integer.parseInt(tf10.getText());
        geneY = Integer.parseInt(tf11.getText());
        geneZ = Integer.parseInt(tf12.getText());

        popsize = Integer.parseInt(tf13.getText()); 
        
        maxText="";
        aveText="";
        //Genetic Algorithm

        //Create random initial population
        Individual[] inds = new Individual[popsize];
	    for (int i=0; i<popsize; i++){
		    inds[i] = new Individual(RandomBin(geneX+geneY+geneZ),geneX,geneY,geneZ,maxX,minX,maxY,minY,maxZ,minZ);
	    }
        Population popu = new Population(inds);
        maxText=maxText+popu.maxF()+"\n";
        aveText = aveText+popu.averageF()+"\n";
        scores.add(popu.maxF());
        avescores.add(popu.averageF());

        //Selection and Reproduction
        for (int count=0; count<99; count++){
		    GeneticAlgorithm ga = new GeneticAlgorithm(popu);
		    popu  = ga.Reproduction();
		    maxText= maxText+popu.maxF()+"\n";
            aveText = aveText+popu.averageF()+"\n";
            scores.add(popu.maxF());
            avescores.add(popu.averageF());
        }

        

        //output
        ta1.setText(maxText);
        ta2.setText(aveText);
     
        maxPanel = new DrawGraph(scores);
        panel2.add(maxPanel);

        avePanel = new DrawGraph(avescores);
        panel4.add(avePanel);
        
	    }
        catch(Exception e){
            ta1.setText("Error! Please reset!");
            ta2.setText("Error! Please reset!");
            panel2.remove(maxPanel);
            scores = new ArrayList<Double>();
            maxPanel = new DrawGraph(scores);
            panel2.add(maxPanel);

            panel4.remove(avePanel);
            avescores = new ArrayList<Double>();
            avePanel = new DrawGraph(avescores);
            panel4.add(avePanel);
        }
        setVisible(true);
    }

    //main method
    public static void main(String args[]) {  
        new ControlGA();
    }   
    
} // end  


