//Hwang inseong 2016-16322
public class Animal {
    char type;    //Carnivore, Herbivore, or Omnivore
    String speciesName;  //Name of species
    String name;  //Name of ID of individual
    int agr; //agressive level of an Animal
    //you can add more here

    //You should use this constructor.
    public Animal(char _type, String _speciesName, String _name, int _agr){
        type = _type; speciesName = _speciesName;
        name = _name;  agr = _agr;
    }

    public String getSpeciesName(){
        //should return speciesName
        //you should edit this method without changing function parameters and name
        if (type == 'C' || type == 'c'){
            Carnivore carnivore = new Carnivore(type, speciesName, name, agr);
            return carnivore.getSpeciesName();
        }
        else if (type == 'H' || type == 'h'){
            Herbivore herbivore = new Herbivore(type, speciesName, name, agr);
            return herbivore.getSpeciesName();
        }else {
            Omnivore omnivore = new Omnivore(type, speciesName, name, agr);
            return omnivore.getSpeciesName();
        }
    }
    public String getName(){
        //should return name
        //you should edit this method without changing function parameters and name
        return name;
    }
    //you can add more here
}
