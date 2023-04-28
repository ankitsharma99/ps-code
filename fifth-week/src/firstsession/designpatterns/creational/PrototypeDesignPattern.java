package firstsession.designpatterns.creational;

import java.util.ArrayList;
import java.util.List;

class Employees implements Cloneable{

    private List<String> empList;

    public Employees(){
        empList = new ArrayList<String>();
    }

    public Employees(List<String> list){
        this.empList=list;
    }
    public void loadData(){
        //read all employees from database and put into the list
        empList.add("Rahul");
        empList.add("Rohit");
        empList.add("Virat");
        empList.add("Dhoni");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() {
        List<String> temp = new ArrayList<String>();
        for(String s : this.getEmpList()){
            temp.add(s);
        }
        return new Employees(temp);
    }

}

public class PrototypeDesignPattern {
    public static void main(String[] args) {
        Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<String> list = empsNew.getEmpList();
        list.add("Jadeja");
        List<String> list1 = empsNew1.getEmpList();
        list1.remove("Rahul");

        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);
    }
}
