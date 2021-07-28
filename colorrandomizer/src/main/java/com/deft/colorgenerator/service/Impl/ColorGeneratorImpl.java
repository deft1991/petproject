package com.deft.colorgenerator.service.Impl;

import com.deft.colorgenerator.service.ColorGenerator;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Sergey Golitsyn
 * created on 7/27/21
 */

@Service
public class ColorGeneratorImpl implements ColorGenerator {

    private static final String RED_COLOR = "RED";
    private static final String WHITE_COLOR = "WHITE";
    private static final String BLUE_COLOR = "BLUE";

    @Override
    public String getRandomColor(String currentColor) {
        Random random = new Random();
        int rez = random.nextInt(0xffffff + 1);
        return String.valueOf(rez);
    }
}
