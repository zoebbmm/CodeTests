package GenericConceptTests.TestInterface;

/**
 * Created by weizhou on 1/30/16.
 */
public class Implementation extends InterfaceAbstract{

    public Implementation(String newHost) {
        super(newHost);
    }

    @Override
    public String getServiceId() {
        return null;
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
