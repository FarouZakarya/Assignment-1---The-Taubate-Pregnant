import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
public class BabyRegister{
	static ArrayList<Baby> babiesList= new ArrayList<Baby>();
	static ArrayList<Gift> giftsList= new ArrayList<Gift>();
	static Scanner scanner = new Scanner(System.in);
	static SimpleDateFormat myFormat= new SimpleDateFormat("dd/MM/yyyyHH:mm");
	public static void main(String args[]){

		String userCommand;
		do{
			System.out.println("Say 'exit' 'Add_new_baby', 'List_babies_by_age', 'List_babies_by_list', 'Add_gift','List_gifts' ");
			userCommand = scanner.next();

			switch(userCommand){
				case "Add_new_baby":
                    addBaby();
					break;
					
				case "List_babies_by_age":
					sortByAge();
					printAll(1);
					break;
					
				case "List_babies_by_list":
					sortByName();
					printAll(1);
					break;
					
                case "Add_gift":
                	addGift();
					break;
					
                case "List_gifts":
                	printAll(2);
					break;

			}
			
		}while(!userCommand.equals("exit"));

		
	}
	
	
	
	
	
	
	
	public void addBaby(Baby b){
		babiesList.add(b);
	}
	public void addGift(Gift g){
		giftsList.add(g);
	}

	public static void printAll(int i){
		if(i==1){
		 for(Baby b: babiesList){
			System.out.println(b.getName());
			System.out.println(b.getBirthday());
			System.out.println(b.getGender());
			System.out.println("-----------------------------------------------");
		 }
		}
		if(i==2){
			for(Gift g: giftsList){
				System.out.println(g.getName());
				System.out.println(g.getDescription());
				System.out.println(g.getDate());
				System.out.println("-----------------------------------------------");
			}
			
		}
	}
	public static void addBaby(){

		System.out.println("Say the name of the Baby");
		String name1 = scanner.next();

		System.out.println("Say the birthday of the baby(dd/MM/yyyyHH:mm)");
		Date day1 = new Date();

		boolean validDate1 = false;
		while(!validDate1){
			try{
				day1 = myFormat.parse(scanner.next());
				validDate1 = true;
			}catch(ParseException e){
				System.out.println("Invalid date, type it again");
				validDate1 = false;
			}
		}
		System.out.println("Say the gender of the Baby");
		Scanner s1= new Scanner(System.in);
		char gender = s1.next().charAt(0);
		Baby baby= new Baby(day1,name1,gender);
		babiesList.add(baby);
		System.out.println("There is : "+babiesList.size()+" registred ");
	
	}
	public static void addGift(){
		SimpleDateFormat myFormat1= new SimpleDateFormat("dd/MM/yyyyHH:mm");
		System.out.println("Say the name of the person who gave the gift");
		String name2 = scanner.next();

		System.out.println("Say the description of the gift");
		String descr= scanner.next();
		
		System.out.println("Say when the gift was given (dd/MM/yyyyHH:mm)");
		Date day2 = new Date();

		boolean validDate2 = false;
		while(!validDate2){
			try{
				day2 = myFormat1.parse(scanner.next());
				validDate2 = true;
			}catch(ParseException e){
				System.out.println("Invalid date, type it again");
				validDate2 = false;
			}
		}
		
		Gift gift= new Gift(name2,descr,day2);
		giftsList.add(gift);
		System.out.println("There is : "+giftsList.size()+" gift ");
	}
	
	public static void sortByName(){	
		for(int i=0; i<babiesList.size()-1; i++){
			for(int j=i+1; j<babiesList.size(); j++){
				Baby b1 = babiesList.get(i);
				Baby b2 = babiesList.get(j);
				if(b1.getName().compareTo(b2.getName())>0){
					Baby aux = b1;
					babiesList.set(j,aux);
					babiesList.set(i, b2);
				}
				
			}
		}
	}
	public static void sortByAge(){	
		for(int i=0; i<babiesList.size()-1; i++){
			for(int j=i+1; j<babiesList.size(); j++){
				Baby b1 = babiesList.get(i);
				Baby b2 = babiesList.get(j);
				if(b1.isOlder(b2)){
					Baby aux = b1;
					babiesList.set(j,aux);
					babiesList.set(i, b2);
				}
				
			}
		}
	}
	



}