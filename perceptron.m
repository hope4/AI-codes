% Implementation of perceptron algorithm (AI Learning algorithm)


clc;
clear all;
close all;


max_iter=100;
Learning_rate=0.1;
num_instances=100;
theta=0;

X=ones(50,2);
Y=ones(50,2);
%Z=ones(50,2);
outputs=ones(50,2);

for i=1:num_instances/2
	X(i,1)=5+rand*(10-5);
	Y(i,1)=4+rand*(8-4);
%	Z(i,1)=2+rand*(9-2);

	outputs(i,1)=1;
end

for i=1:num_instances/2
	X(i,2)=(-1)+rand*(4+1);
	Y(i,2)=(-4)+rand*(2+4);
%	Z(i,2)=(-3)+rand*(5+3);

	outputs(i,2)=0;
end

plot(X(:,1),Y(:,1),'rx')
hold 

plot(X(:,2),Y(:,2),'bx')
grid on


X1=X(:);
Y1=Y(:);
%Z1=Z(:);
outputs1=outputs(:);

w1=0+rand*(1-0)
w2=0+rand*(1-0)
%w3=0+rand*(1-0)
w4=0+rand*(1-0)

K=-(w1/w2)*X1-(w4/w2)*ones(100,1);

plot(X1,K,'c')


iteration=0;
	iteration=iteration+1;
	globalerror=0;
	output=0;
	for p=1:num_instances

		sum=X1(p)*w1+Y1(p)*w2+w4;
		if sum>=theta
			output=1;
		else 
			output=0;
		end
		localerror=outputs1(p)-output;

		w1=w1+Learning_rate*localerror*X1(p);
		w2=w2+Learning_rate*localerror*Y1(p);
		%w3=w3+Learning_rate*localerror*Z1(p);
		w4=w4+Learning_rate*localerror;


		globalerror=globalerror+(localerror^2);

	end
		iteration;
		rmse=sqrt(globalerror);
	

while(globalerror!=0 && iteration<=max_iter)

	iteration=iteration+1;
	globalerror=0;
	output=0;
	for p=1:num_instances

		sum=X1(p)*w1+Y1(p)*w2+w4;
		if sum>=theta
			output=1;
		else 
			output=0;
		end
		localerror=outputs1(p)-output;

		w1=w1+Learning_rate*localerror*X1(p);
		w2=w2+Learning_rate*localerror*Y1(p);
	%	w3=w3+Learning_rate*localerror*Z1(p);
		w4=w4+Learning_rate*localerror;


		globalerror=globalerror+(localerror^2);

		
	end
		iteration
		rmse=sqrt(globalerror);
end



w1
w2
%w3
w4

K=-(w1/w2)*X1-(w4/w2)*ones(100,1);

plot(X1,K,'m')


for p=1:10
	x2=-3+rand*(8);
	y2=-3+rand*(8);
	%z2=-3+rand*(10+10);

	sum=x2*w1+y2*w2+w4;
		if sum>=theta
			output=1;
		else 
			output=0;
		end
	disp('Random point is')
	x2
	y2
	output
	plot(x2,y2,'k*')
end





















