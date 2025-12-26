package com.example.demo.util;

public class SkillLevelUtil {

    private SkillLevelUtil() {
        // utility class
    }

    // ✅ Converts skill level string to numeric value
    private static int levelValue(String level) {
        if (level == null) return 0;

        switch (level.toUpperCase()) {
            case "EXPERT":
                return 3;
            case "INTERMEDIATE":
                return 2;
            case "BEGINNER":
                return 1;
            default:
                return 0;
        }
    }

    // ✅ Used in TaskAssignmentService
    public static boolean meetsRequiredLevel(
            String volunteerLevel,
            String requiredLevel) {

        return levelValue(volunteerLevel) >= levelValue(requiredLevel);
    }
}
