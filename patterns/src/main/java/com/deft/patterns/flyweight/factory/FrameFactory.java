package com.deft.patterns.flyweight.factory;

import com.deft.patterns.flyweight.heavy.FrameType;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Golitsyn
 * created on 30.08.2021
 */
public class FrameFactory {
    static Map<String, FrameType> treeTypes = new HashMap<>();

    public static FrameType getFrameType(String name, Color color, String otherTreeData) {
        FrameType result = treeTypes.get(name);
        if (result == null) {
            result = new FrameType(name, color, otherTreeData);
            treeTypes.put(name, result);
        }
        return result;
    }
}
