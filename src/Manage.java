//Hwang inseong 2016-16322
import java.util.Vector;

public class Manage {
    //you can add more
    ManageInfo manageInfo;
    public Manage(){
        //default init
        manageInfo = new ManageInfo();
    }
    public Manage(ManageInfo info){
        //general constructor you may use
        manageInfo = info;
    }
    public void set(ManageInfo info){
        //if you prefer default constructor and setting later, you can use this.
        manageInfo = info;
    }
    public Report report(){
        //your final report result must be returned by this method.
        //you should edit this method without changing function parameters and name
        Report report = new Report();
        Vector<String> s = new Vector<>();
        s.add(""+manageInfo.getLength());
        for (int i=0; i<manageInfo.getLength(); i++){
            s.add("Room " + (i+1) + " : ");
            if(manageInfo.getRoom(i).agr1Check())
                s.set(i+1,s.get(i+1)+"CareTreat, ");
            if(manageInfo.getRoom(i).agr2Check())
                s.set(i+1,s.get(i+1) + "Dangerous, ");
                if (!manageInfo.getRoom(i).foodCheck())
                s.set(i+1, s.get(i+1) + "FoodType");
            if(s.get(i+1).endsWith(", "))
                s.set(i+1, s.get(i+1).substring(0, s.get(i+1).length()-2));
        }
        report.set(s);
        return report;
    }
}
