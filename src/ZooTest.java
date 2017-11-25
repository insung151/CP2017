import java.util.Vector;

public class ZooTest {
    public static void main(String args[]){
//        Animal ani = new Animal('H',"elephant","poo", 1);
//        Animal ani2 = new Animal('H',"elephant","poo", 1);
//        Herbivore ani3 = new Herbivore('C',"h","ee",2);
//        System.out.println(ani.getName() );
//        System.out.println(ani.getSpeciesName());
//        Vector<Room> v = new Vector<>();
//        Room room = new Room();
//        room.addAnimal(ani);
//        room.addAnimal(ani2);
//        room.addAnimal(ani3);
//        System.out.println(room.animals.size());
//        room.addFood(false);
//        v.add(room);
//        ManageInfo manageInfo = new ManageInfo(v);
//        System.out.println(manageInfo.rooms.size());
//        Manage manage = new Manage(manageInfo);
//        manage.report().printAll();
//        System.out.println(manage.manageInfo.getAnimal(0,1).getSpeciesName());
//        System.out.println("sagagas, ".endsWith(", "));

        Vector<Room> roomVec = new Vector<>();
        Room temp = new Room();
        temp.addAnimal(new Carnivore('c', "Lion", "ID:0001", 2) );
        temp.addAnimal(new Carnivore('c', "Lion", "ID:0001", 1) );
        temp.addFood( false );
        temp.addFood(true);
        roomVec.add(temp);
        Room temp2 = new Room();
        temp2.addAnimal(new Herbivore('H', "cow", "Jow das", 0) );
        temp2.addAnimal(new Omnivore('O', "Homo siphens", "Yeonil Yool(not yeonil yoo)", 1 ));
        temp2.addAnimal(new Carnivore('c', "Lion", "ID:0001", 2) );
        temp2.addFood(false);
        roomVec.add(temp2);
        Manage runner = new Manage(new ManageInfo(roomVec)); //will be new Manager(); for those prefer default ctor
        Report output = runner.report();
        output.printAll();
        System.out.println(runner.manageInfo.getRoom(1).getAnimal(1).getSpeciesName());
    }
}
