package GenericConceptTests.TestInterface;

/**
 * Created by weizhou on 1/30/16.
 */
public interface ParentInterface {
    /**
     * @return the service id as register by the DiscoveryClient
     */
    public String getServiceId();

    /**
     * @return the hostname of the registered ServiceInstance
     */
    public String getHost();

    /**
     * @return the port of the registered ServiceInstance
     */
    public int getPort();

    /**
     * @return ifthe port of the registered ServiceInstance is https or not
     */
    public boolean isSecure();

}
