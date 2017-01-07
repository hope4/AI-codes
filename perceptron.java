import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;


class perceptron{
	static int max_iter=100;
	static double learning_rate=0.1;
	static int num_instances=100;
	static int theta=0;  //threshold

	public static void main(String[] args) {
		double[] x =new double [num_instances];
		double[] y =new double [num_instances];
		double[] z =new double [num_instances];

		int[] outputs=new int [num_instances];


		for(int i=0;i<num_instances/2;i++){

			x[i]=randomnumber(5,10);
			y[i]=randomnumber(4,8);			
			z[i]=randomnumber(2,9);
			outputs[i]=1;

			System.out.println(x[i]+"\t"+y[i]+"\t"+z[i]+"\t"+outputs[i]);
		}
		
		for(int i=50;i<num_instances;i++){

			x[i]=randomnumber(-1,4);
			y[i]=randomnumber(-4,2);			
			z[i]=randomnumber(-3,5);
			outputs[i]=0;

			System.out.println(x[i]+"\t"+y[i]+"\t"+z[i]+"\t"+outputs[i]);
		}
		double[] weights=new double[4];
		double localError,globalError;
		int i,p,iteration,output;


		weights[0]=randomnumber(0,1);

		weights[1]=randomnumber(0,1);

		weights[2]=randomnumber(0,1);

		weights[3]=randomnumber(0,1);		

	
		iteration=0;

		do{
			iteration++;
			globalError=0;

			for(p=0;p<num_instances;p++){

					output=calculateOutput(theta,weights,x[p],y[p],z[p]);
					localError=outputs[p]-output;
					weights[0]+=learning_rate*localError*x[p];

					weights[1]+=learning_rate*localError*y[p];
					weights[2]+=learning_rate*localError*z[p];
					weights[3]+=learning_rate*localError;

					globalError+=(localError*localError);
			}

			System.out.println("Iteration"+iteration+" :Rmse="+Math.sqrt(globalError/num_instances));
		}while(globalError!=0 && iteration<=max_iter);
		
		System.out.println("\n==========\nDecision boundary equation");
		System.out.println(weights[0]+"*x"+weights[1]+"*y + "+weights[2]+"*z +"+weights[3]+"= 0");
	
		for (int j=0; j<10;j++ ) {
			double x1= randomnumber(-10,10);
			double y1= randomnumber(-10,10);
			double z1= randomnumber(-10,10);

			output=calculateOutput(theta,weights,x1,y1,z1);
			System.out.println("\n==========\nNew Random Point:");
			System.out.println("x="+x1+",y="+y1+",z="+z1);
			System.out.println("class= "+output);
		}


	}



		public static double randomnumber(int min,int max){
			DecimalFormat df=new DecimalFormat("#.####");
			double d=min+Math.random()*(max-min);
			String s=df.format(d);
			double x=Double.parseDouble(s);
			return x;

		}

	static int calculateOutput(int theta,double weights[],double x,double y,double z){
		double sum=x*weights[0]+y*weights[1]+z*weights[2]+weights[3];
		return (sum>=theta)? 1: 0;
	}	

}