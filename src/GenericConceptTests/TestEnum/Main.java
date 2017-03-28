package GenericConceptTests.TestEnum;

/**
 * Created by weizhou on 2/11/16.
 */
public class Main {
    public static void main(String[] args) {

        Activity activity = new Activity();

        activity.setActivitySourceType(ActivitySourceType.valueOf("MemoryCard"));
        System.out.println(activity.getActivitySourceType());
    }
}
