package Basic;

import java.util.Random;

public class Neuron {
	private int layer;
	private int position;
	private double[] x;
	private double[] w;
	private double u;
	private double y;
	private byte func; // 1-sigmoidal
	private int in;
	private double beta;
	
	public Neuron(int layer,int pos,int in,byte func,double beta){
		this.layer=layer;
		this.position=pos;
		this.func=func;
		this.beta=beta;
		this.u=0.00;
		this.y=0.00;
		this.setIn(in);
		this.w = new double[in+1];
		this.x = new double[in+1];
		initW();
	}
	
	public int getLayer() {
		return layer;
	}
	
	public void setLayer(int layer) {
		this.layer = layer;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public double getX(int i) {
		return x[i];
	}
	public void setX(double x,int i) {
		if(i>0 && i<=this.in){
		  this.x[i] = x;
		}
	}
	public double getW(int i) {
		return w[i];
	}
	public void setW(double w,int i) {
		this.w[i] = w;
	}

	public double getY() {
		return y;
	}
	
	private void initW(){
		Random generator = new Random();
		this.x[0]=1;
		this.w[0]=-0.5;
		for(int i =1;i<this.in;i++){
			this.w[i]=generator.nextDouble()*2-1;
		}
	}
	
	public int getIn() {
		return in;
	}

	public void setIn(int in) {
		this.in = in;
	}
	
	private double f(double x){
		switch(this.func){
		 case 1 :
			return 1/(1+(Math.pow(Math.E,(-this.beta*x))));
		 default :
		    return 0.00;
		 
		}
	}
	
	public double d(double x){
		switch(this.func){
		 case 1 :
			double f =f(x);
			return this.beta*(1-f)*f;
		 default: 
			return 0.00;
		 
		}
	}
	
	private void sum(){
		for(int i=0;i<this.in;i++){
			this.u = this.u+(this.w[i]*this.x[i]);
		}
	}
	
	public void calculate(){
	 sum();
	 this.y= f(this.u);
	}
	
	

}
