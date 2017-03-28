package GenericConceptTests.TestAbstract;

/**
 * Created by weizhou on 4/15/16.
 */
public class ChildA extends Parent{
    private String deviceSerialNumber;

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public ChildA() {
        System.out.println("Child A constructor");
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public void output() {
        System.out.println("ChildA");
    }
}
