import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class CustomStack{
	int stack[] = new int[10];
	int top = 0;

	String push(int value){
		if(top == 10) return "Stack is Full. Wait until someone pops an element to push your new element";
		stack[top] = value;
		top += 1;
		return Integer.toString(value) + " pushed onto the stack.";
	}

	String pop(){
		if(top == 0) return "Stack is Empty. Can't pop an element from an empty stack.";
		top -= 1;
		int value = stack[top];
		return Integer.toString(value) + " popped from the stack";
	}

	String getElements(){

		if(top == 0) return "No Elements are present in the stack.";
		String elements = "Elements present in the stack:   ";
		for(int i = 0; i <= top - 1; i++){
			elements = elements + Integer.toString(stack[i]) + "   ";
		}

		return elements;
	}
}

class CustomQueue{
	int queue[] = new int[10];
	int front = -1;
	int rear = -1;

	String enqueue(int value){
		if((rear + 1) % 10 == front) return "Queue is Full. Wait until someone dequeues an element to enqueue your new element";
		else if(front == -1){
        	front = 0;
        	rear = 0;
		}
		else if(rear == 9 && front != 0) rear = 0;
    	else rear = (rear + 1) % 10;

    	queue[rear] = value;
		return Integer.toString(value) + " enqueued onto the queue.";
	}

	String dequeue(){
		if(front == -1) return "Queue is Empty. Can't dequeue an element from an empty queue.";
		int value = queue[front];
		if(front == rear){
        	front = -1;
        	rear = -1;
    	}
    	else if(front == 9) front = 0;
    	else front += 1;
		return Integer.toString(value) + " dequeued from the queue";
	}

	String getElements(){
		if(front == -1) return "No Elements are present in the queue";
		String elements = "Elements present in the queue:   ";
		if(rear >= front){
			for(int i = front; i <= rear; i++){
				elements = elements + Integer.toString(queue[i]) + "   ";
			}
		}
		else{
			for(int i = front; i < 10; i++){
				elements = elements + Integer.toString(queue[i]) + "   ";
			}
			for(int i = 0; i <= rear; i++){
				elements = elements + Integer.toString(queue[i]) + "   ";
			}
		}

		return elements;
	}
}

class Assignment1{

	private static ArrayList<Object> readInputFromFile(){
		ArrayList<Object> input = new ArrayList<Object>();
		
		try {
      		File inputFile = new File("Input.txt");
      		Scanner reader = new Scanner(inputFile);
      		while (reader.hasNextLine()) {
        		String data = reader.nextLine();
        		data = data.trim();
        		input.add(data);
      		}
      		reader.close();
    	} 
    	catch (FileNotFoundException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
    	return input;
	}

	private static void writeOutputToFile(ArrayList<Object> output){
		
    	try {
      		FileWriter writer = new FileWriter("Output.txt");
      		for(int i = 0; i < output.size(); i++){
      			writer.write(output.get(i).toString());
    			if(i != output.size() - 1){
    				writer.write("\n");
    			}
			}
		    writer.close();
		} 
		catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}

	private static ArrayList<Object> implementAlgorithm(ArrayList<Object> input){
		boolean isStack = true;
		boolean isInputToDS = false;
		CustomStack stack = new CustomStack();
		CustomQueue queue = new CustomQueue();
		ArrayList<Object> output = new ArrayList<Object>();

		for(int i = 0; i < input.size(); i++){
			if(i == 0){
				if(input.get(0).equals("Q")){
					isStack = false;
					output.add("Data Structure requested by the user:   Queue");
				}
				else{
					output.add("Data Structure requested by the user:   Stack");
				}
				output.add("\n");
			}
			else{
				if(isInputToDS){
					output.add("Operation Requested:   Add   " + input.get(i).toString());
					if(isStack){
						output.add(stack.push(Integer.parseInt(input.get(i).toString())));
						output.add(stack.getElements());
					}
					else{
						output.add(queue.enqueue(Integer.parseInt(input.get(i).toString())));
						output.add(queue.getElements());
					}
					output.add("\n");
					isInputToDS = false;
				}
				else if(input.get(i).equals("Add")) isInputToDS = true;
				else if(input.get(i).equals("Delete")) {
					output.add("Operation Requested:   Delete");
					if(isStack){
						output.add(stack.pop());
						output.add(stack.getElements());
					}
					else{
						output.add(queue.dequeue());
						output.add(queue.getElements());
					}
					output.add("\n");
				}
				else{
					output.add("You have requested to Exit from the application.");
					output.add("Thank You for using our Stack & Queue application.");
					output.add("Have a good day. Bye Bye....");
				}
			} 
		}

		return output;
	}

	public static void main(String args[]){
		
		ArrayList<Object> input = readInputFromFile();
		ArrayList<Object> output = implementAlgorithm(input);
		writeOutputToFile(output);
	}
}