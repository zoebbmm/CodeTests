package GenericConceptTests.TestHashMap;

import java.util.List;

/**
 * Created by weizhou on 2/17/17.
 */
public class Filter {
    private String key;
    private List<String> value;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
