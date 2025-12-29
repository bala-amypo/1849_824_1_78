// // package com.example.demo.util;

// // public class SkillLevelUtil {

// //     private SkillLevelUtil() {
// //         // utility class
// //     }

// //     // ✅ Converts skill level string to numeric value
// //     private static int levelValue(String level) {
// //         if (level == null) return 0;

// //         switch (level.toUpperCase()) {
// //             case "EXPERT":
// //                 return 3;
// //             case "INTERMEDIATE":
// //                 return 2;
// //             case "BEGINNER":
// //                 return 1;
// //             default:
// //                 return 0;
// //         }
// //     }

// //     // ✅ Used in TaskAssignmentService
// //     public static boolean meetsRequiredLevel(
// //             String volunteerLevel,
// //             String requiredLevel) {

// //         return levelValue(volunteerLevel) >= levelValue(requiredLevel);
// //     }
// // }
// package com.example.demo.util;

// public class SkillLevelUtil {

//     public static int levelRank(String level) {
//         if ("BEGINNER".equals(level)) return 1;
//         if ("INTERMEDIATE".equals(level)) return 2;
//         if ("EXPERT".equals(level)) return 3;
//         return 0;
//     }

//     public static int priorityRank(String p) {
//         if ("LOW".equals(p)) return 1;
//         if ("MEDIUM".equals(p)) return 2;
//         if ("HIGH".equals(p)) return 3;
//         return 0;
//     }
// }
package com.example.demo.util;

public class SkillLevelUtil {
    
    public static int levelRank(String level) {
        if (level == null) return 0;
        
        switch (level.toUpperCase()) {
            case "BEGINNER":
                return 1;
            case "INTERMEDIATE":
                return 2;
            case "EXPERT":
                return 3;
            default:
                return 0;
        }
    }
    
    public static int priorityRank(String priority) {
        if (priority == null) return 0;
        
        switch (priority.toUpperCase()) {
            case "LOW":
                return 1;
            case "MEDIUM":
                return 2;
            case "HIGH":
                return 3;
            default:
                return 0;
        }
    }
    
    public static boolean hasRequiredSkillLevel(String volunteerLevel, String requiredLevel) {
        return levelRank(volunteerLevel) >= levelRank(requiredLevel);
    }
}