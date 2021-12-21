package com.deft.patterns.flyweight.factory;

import com.deft.patterns.flyweight.heavy.Icon;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 30.08.2021
 */
public class IconFactory {
    static Map<String, Icon> icons = new HashMap<>();

    public static Icon getIcon(String type, int height, int length, byte[] data) {
        Icon result = icons.get(type);
        if (result == null) {
            result = new Icon(type, height, length, data);
            icons.put(type, result);
        }
        return result;
    }
}
