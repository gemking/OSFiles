import java.util.Scanner;

public class BankersAlgorithm {

int available[][];		//the available amount of each resource 
int max[][];			//the maximum demand of each customer
int allocation[][]; 	//the amount currently allocated to each customer
int need[][];  			//the remaining need of each customer
int numberOfCustomers;	
int numberOfResources;



public void input(){

Scanner input=new Scanner(System.in);

System.out.println("Enter the number of Customers(A.K.A. Processes) and Resources ");

numberOfCustomers= input.nextInt(); 

numberOfResources =input.nextInt();

max=new int[numberOfCustomers][numberOfResources]; //arrays initialized 

need=new int[numberOfCustomers][numberOfResources];

available=new int[1][numberOfResources];

allocation=new int[numberOfCustomers][numberOfResources];



System.out.println("Please Enter the Allocation Matrix");

for(int i = 0;i < numberOfResources;i++){ //iterate for loop

char letter = (char) ((char) 65+i);

System.out.print(letter+" ");

}

System.out.println(); //After iterating through the for loop, prints letters A-Z depending on need

for(int i=0;i<numberOfCustomers;i++){ //two for loops creating arrays containing  # of Customers and Resources

for(int j=0;j<numberOfResources;j++){

allocation[i][j]=input.nextInt(); //allows input for Allocation Matrix

}

}

System.out.println("Please Enter the Max Matrix");

for(int i=0;i<numberOfResources;i++){ //iterate for loop for letter generation

char c= (char) ((char) 65+i);

System.out.print(c+" ");

}

System.out.println(); //After iterating through the for loop, prints letters A-Z depending on # of Resources

for(int i=0;i<numberOfCustomers;i++){ //two for loops creating arrays containing  # of Customers and Resources

for(int j=0;j<numberOfResources;j++){

max[i][j]=input.nextInt(); //allows input for Max Matrix

}

}

System.out.println("Please Enter the Available Matrix"); //iterate for loop for letter generation

for(int i=0;i<numberOfResources;i++){

char c= (char) ((char) 65+i);

System.out.print(c+" ");

}

System.out.println(); //After iterating through the for loop, prints letters A-Z depending on # of Resources

for(int i=0;i<numberOfResources;i++){

available[0][i]=input.nextInt(); //allows input for Available Matrix 

}

input.close();

}


public void calculateNeed(){

for(int i=0;i<numberOfCustomers;i++){

for(int j=0;j<numberOfResources;j++){

need[i][j]=max[i][j]-allocation[i][j]; //the need matrix is being calculated 

}

}

}



public boolean check(int p){
//This is a check making sure if all the resources for pth process can be allocated
for(int i=0;i<numberOfResources;i++){

if(available[0][i]<need[p][i]){

return false;

}

}

return true;

}



public void alogrithm(){

calculateNeed();

int processesToBeAllocated = 0;

boolean status[]=new boolean[numberOfCustomers];

while(processesToBeAllocated < numberOfCustomers){ //iterates until all the processes have been allocated

boolean allocated=false;

for(int i=0;i<numberOfCustomers;i++){

if( !status[i] && check(i)){ //in the process of still trying to allocate

status[i]=true;

allocated=true;

processesToBeAllocated++;

System.out.println("The Process Allocated: "+i);

for(int j=0;j<numberOfResources;j++){

available[0][j]=available[0][j]+allocation[i][j];

}

}

}

if(!allocated) break; //if there is no allocation 



}

if(processesToBeAllocated == numberOfCustomers) //if all the processes have been allocated

System.out.println("\nSafely allocated; safety algorithm satisfied/bank request accepted");

else

System.out.println("Not all processes can be safely allocated; safety algorithm unsatisfied/bank request denied");

}

    public static void main(String[] args) {
        BankersAlgorithm object = new BankersAlgorithm();

object.input();

object.alogrithm();
    }
    
}
/*
Enter the number of Customers(A.K.A. Processes) and Resources 
5 3
Please Enter the Allocation Matrix
A B C 
0 1 0
2 0 0
3 0 2
2 1 1
0 0 2
Please Enter the Max Matrix
A B C 
7 5 3
3 2 2
9 0 2
2 2 2
4 3 3
Please Enter the Available Matrix
A  B C 
3  3 2
The Process Allocated: 1
The Process Allocated: 3
The Process Allocated: 4
The Process Allocated: 0
The Process Allocated: 2

Safely allocated; safety algorithm satisfied/bank request accepted

*/