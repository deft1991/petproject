package com.deft.patterns;

import com.deft.patterns.abstractfactory.factory.impl.DefaultFactory;
import com.deft.patterns.abstractfactory.factory.impl.PirateFactory;
import com.deft.patterns.abstractfactory.factory.impl.SpaceFactory;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sergey Golitsyn
 * created on 01.08.2021
 */
public class Main {

    public static void main(String[] args) {
        Application application = new Application(new DefaultFactory());
        print(application);

        application = new Application(new PirateFactory());
        print(application);

        application = new Application(new SpaceFactory());
        print(application);
    }

    private static void print(Application application) {
        System.out.println(Arrays.toString(application.getSkinUrls().toArray(new String[0])));
        System.out.println(convertWithStream(application.getNames()));
    }

    private static String convertWithStream(Map<?, ?> map) {
        String mapAsString = map.keySet().stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }

}
