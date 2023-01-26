package com.example.pettivitywatch;

import com.example.pettivitywatch.models.User;

public class VisualizationManager {
    public static final int[][] IMAGES = {
            {R.drawable.dagoestaand1, R.drawable.dagoestaand2},
            {R.drawable.dagoestaand3, R.drawable.dagoestaand4},
            {R.drawable.dagoestaand5, R.drawable.dagoestaand6}
    };
    public static int[][] VIDEOS = {
            {R.drawable.dagoe1_1, R.drawable.dagoe2_1, R.drawable.dagoe3_1},
            {R.drawable.dagoe1_2, R.drawable.dagoe2_2, R.drawable.dagoe3_2},
            {R.drawable.dagoe1_3, R.drawable.dagoe2_3, R.drawable.dagoe3_3},
    };

    public static int getVideo(int intensity, int frequency) {
        intensity = clamp(intensity/2, VIDEOS.length - 1);
        frequency = clamp(frequency/2, VIDEOS[intensity].length - 1);
        return VIDEOS[intensity][frequency];
    }
    public static int getVideo(User.Score score) {
        return getVideo(score.getIntensityScore(), score.getFrequencyScore());
    }

    public static int getImage(User.Score score) {
        return getImage(score.getIntensityScore(), score.getFrequencyScore());
    }

    public static int getImage(int intensity, int frequency) {
        intensity = clamp(intensity, IMAGES.length - 1);
        frequency = clamp(frequency, IMAGES[intensity].length - 1);
        return IMAGES[intensity][frequency];
    }

    private static int clamp(int variable,  int max) {
        return clamp(variable, 0, max);
    }

    private static int clamp(int variable, int min, int max) {
        return Math.min(max, Math.max(variable, min));
    }
}
