import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Hwang inseong 2016-16322
public class Room {
    //should contains lists of Animals and Foods
    //you can add more fields or methods.
    List<Animal> animals;
    List<Boolean> foods;

    public Room(){
        //default init
        //Initialize your data structures here.
        animals = new LinkedList<>();
        foods = new LinkedList<>();
    }

    //The following two methods should be constructed.
    //do not modify method name and parameters.
    public void addAnimal(Animal ani){
        animals.add(ani);
    }
    public void addFood(boolean food){
        foods.add(food);
    }

    public Animal getAnimal(int index){
        //you should edit this method without changing function parameters and name
        return animals.get(index);
    }
    public boolean getFood(int index){
        //you should edit this method without changing function parameters and name
        return foods.get(index);
    }
    public int getAnimalsSize(){
        //return the size of Animal list, vector, or array
        return animals.size();
    }
    public int getFoodsSize(){
        //return the size of Food list, vector, or array
        return foods.size();
    }

    public boolean foodCheck(){
        boolean cType = false;
        boolean hType = false;
        boolean result = true;
        for (int i=0; i<foods.size(); i++){
            if(foods.get(i))
                cType = true;
            else
                hType = true;
        }

        for (int i=0; i<animals.size(); i++){
//            System.out.println(animals.get(i).type);
            if((animals.get(i).type == 'C' || animals.get(i).type == 'c' ) && !cType){
                result = false;
            }
            else if((animals.get(i).type == 'H' || animals.get(i).type == 'h' ) && !hType){
                result = false;
            }
        }

        return result;
    }

    public boolean agr1Check(){
        boolean result = false;
        for (int i=0; i<animals.size(); i++){
            if (animals.get(i).agr == 1)
                result = true;
        }
        return result;
    }

    public boolean agr2Check(){
        boolean result = false;
        for (int i=0; i<animals.size(); i++){
            if (animals.get(i).agr == 2)
                result = true;
        }
        return result;
    }

}
