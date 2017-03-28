package GenericConceptTests.TestInterface;

/**
 * Created by weizhou on 1/30/16.
 */
public abstract class InterfaceAbstract implements ParentInterface{

    protected String host;

    public InterfaceAbstract(String newHost) {
//        host = newHost;

        switch (newHost) {
            case "testHost-Wei":
                host = "Wei";
                break;

            case "testHost-Zhou":
                host = "Zhou";
                break;

            case "" :
                break;

            default :
                break;
        }
    }

    public String getHost() {
        return host;
    }
}
