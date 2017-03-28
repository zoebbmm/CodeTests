package AlgorithmAndDataStructureTests.LeetCode;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Org_Employee {
    final String name;
    List<Org_Employee> reporters;

    public Org_Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Org_Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Amazon
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    // RETURN "null" IF THERE IS NO CLOSEST COMMON MANAGER OR THE GIVEN EMPLOYEES ARE NOT THE PART OF THE COMPANY

    public Org_Employee closestCommonManager(Org_Employee ceo, Org_Employee employee1, Org_Employee employee2)
    {
        // WRITE YOUR CODE HERE
        if (ceo == null || employee1 == null || employee2 == null) {
            return null;
        }

        if (!covers(ceo, employee1) && covers(ceo, employee2)) {
            return null;
        }

        Queue<Org_Employee> workingQueue = new LinkedList<>();
        workingQueue.offer(ceo);

        Org_Employee closestKnownManager = null;

        while (!workingQueue.isEmpty()) {
            Org_Employee employee = workingQueue.poll();
            if (covers(employee, employee1) && covers(employee, employee2)) {
                closestKnownManager = employee;
                if (employee.reporters != null && (!employee.reporters.isEmpty())) {
                    for (Org_Employee em : employee.reporters) {
                        workingQueue.offer(em);
                    }
                }
            }
        }

        return closestKnownManager;
    }

    private boolean covers(final Org_Employee manager, final Org_Employee employee) {
        if (manager == null) {
            return false;
        }

        if (manager.name.equals(employee.name)) {
            return true;
        }

        if (manager.reporters == null) {
            return false;
        }

        boolean covers = false;
        for (Org_Employee em : manager.reporters) {
            covers = covers || covers(em, employee);
        }
        return covers;
    }
    // METHOD SIGNATURE ENDS
}