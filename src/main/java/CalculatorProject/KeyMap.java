package CalculatorProject;

import java.util.HashMap;
import java.util.Map;

public class KeyMap {
    private static final Map<Integer,Key> codeMap = new HashMap<Integer,Key>();
    static {
        for (Key key : Key.values()) {
            codeMap.put(key.code, key);
        }
    }

    public static Key keyForCode(int code) {
        return codeMap.get(code);
    }
}
