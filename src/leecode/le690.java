package leecode;

import java.util.*;

/**
 * @author Hujf
 * @title: le690
 * @date 2021-05-01 15:16
 * @description: TODO
 */
public class le690 {
    private  static  Map<Integer,Employee> map = new HashMap<>();;
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e :employees){
            map.put(e.id,e);
        }
       return dfs(id);
    }

    private int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subId : subordinates) {
            total+= dfs(subId);
        }
        return total;
    }


}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};