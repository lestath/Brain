package Basic;

import java.util.Vector;

public class NeuronNet {
 

  private int[] net;
  private double[] x;
  private Vector<Neuron>[] layer;
  private byte func;
  private double beta;
  private int in;

  public NeuronNet(int in,int[] net, byte func,double beta){
	 this.net = net;
	 this.beta=beta;
	 this.in = in;
	 this.x = new double[this.in];
	 this.layer = new Vector[net.length];
	 this.func = func;
	 for(int i=0;i<net.length;i++){
		 this.layer[i]=new Vector<Neuron>(net[i]);
		  for(int j = 0;j<net[i];j++){
			 if(i==0){
				 this.layer[i].add(new Neuron(i,j,this.x.length,this.func,this.beta));
			 }else{
				 this.layer[i].add(new Neuron(i,j,this.net[i-1],this.func,this.beta));
			 }
		  }
	 }
  }
 
  public void setX(double[] x){
	  this.x = x;
  }
  public void calc(){
	  switch(this.func){
	  case 1 :
	  }
  }
  
  public static void main(String[] args){
	  NeuronNet speak = new NeuronNet(10,new int[]{10,5,3},(byte)1,(0.50));
  }
}
