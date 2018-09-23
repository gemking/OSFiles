package producerConsumer;

import java.util.ArrayList;
import java.util.List;

public class producerConsumer {

	public static void main(String[] args) {
		List<Integer> elementList = new ArrayList<Integer>(); //creates an Array of integers
		
		Thread threadProducer = new Thread(new Producer(elementList)); //this thread handles production
		Thread threadConsumer = new Thread(new Consumer(elementList)); //this thread handles consummation 
		threadProducer.start(); //starts threadProducer
		threadConsumer.start(); //starts threadConsumer 
	}
}

class Producer implements Runnable { //runs producerThread

	List<Integer> elementList = null;  //garbage collection
	final int MAXIMUM_SIZE = 4; //maximum amount of elements that can be held in the list
	private int elements = 0; //elements to be produced or consumed 
	
	public Producer(List<Integer> elementList) {
		super();
		this.elementList = elementList; //obtains the elementList 
	}
	public void run() {
		while(elementList.size() >= 0 & elementList.size() <= 4){ //range of elements contained 0-4
			try{
				produce(elements++); //produces elements 
			} catch(InterruptedException exception) { //needed to interrupt Thread
				
			}
		}
	
	}

	public void produce(int elements) throws InterruptedException {
		
		synchronized(elementList){ //makes sure only one thread can access a resource at any given point of time
			while(elementList.size() == MAXIMUM_SIZE) {
				System.out.println("The elementList is full; waiting for Consumer");  
				elementList.wait(); //producer thread must wait for consumer if the elementList is full
				
			}
		}
		synchronized (elementList) {
			System.out.println("an element is produced" + elements); 
			elementList.add(elements); //adds elements to the elementList 
			Thread.sleep(100); //time allocated
			elementList.notify(); //notifies List 
		}
	}
}


class Consumer implements Runnable { //runs consumerThread

	List<Integer> elementList = null; //garbage collection 
	
	public Consumer(List<Integer> elementList) {
		super();
		this.elementList = elementList; //obtains the elementList 
	}
	public void run() {
		while(elementList.size() >= 0 & elementList.size() <= 4){
			try{
				consume(); //begins consuming tokens 
			} catch(InterruptedException exception) { //needed to interrupt thread 
				
			}
		}
	
	}

public void consume() throws InterruptedException {
	
	synchronized(elementList){
		while(elementList.isEmpty()) {
			System.out.println("The elementList is empty; waiting for Producer");
			elementList.wait(); //the consumerThread must wait for the producerThread to produce more elements
		}
	}
	synchronized (elementList) {
		Thread.sleep(1000); //time allocated
		System.out.println("Consumed the element" + elementList.remove(0)); //removes element from elementList after being consumed
		elementList.notify(); //notifies list 
	}
}
}

