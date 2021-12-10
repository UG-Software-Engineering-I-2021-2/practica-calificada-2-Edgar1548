package org.example;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Principal {
    static final Logger logger = Logger.getLogger(Principal.class.getName());

    final private Map<Integer, List<Pair<String, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( "Josefina", true),
                            new Pair<>( "Edonisio", true),
                            new Pair<>( "Edufasio", false)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( "Eduarda", false),
                            new Pair<>( "Abelardo", false),
                            new Pair<>( "Francisca", false)
                    )
            )
    );
    private final int yearToCalculate;

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }

    public boolean PtosExtraTeachers(){
        boolean value = false;
        for (Map.Entry<Integer, List<Pair<String, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (yearToCalculate == yearlyTeachers.getKey()) {
                List<Pair<String, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<String, Boolean> teacher : teachers) {
                    if (teacher.second()) {
                        logger.info(teacher.first());
                        value = true;
                    }
                }
            }
        }
       return value;
    }

    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (!examsStudents.isEmpty()) {
            boolean hasToIncreaseOneExtraPoint = PtosExtraTeachers();
            float gradesSum       = 0f;
            int   gradesWeightSum = 0;

            for (Pair<Integer, Float> examGrade : examsStudents) {
                gradesSum += (examGrade.first() * examGrade.second() / 100);
                gradesWeightSum += examGrade.first();
            }
            if (gradesWeightSum == 100) {
                if (hasReachedMinimumClasses) {
                    if (hasToIncreaseOneExtraPoint) {
                        return Float.min(10f, gradesSum + 1);
                    } else {
                        return gradesSum;
                    }
                } else {
                    return 0f;
                }
            } else if (gradesWeightSum > 100) {
                return -1f;
            } else {
                return -2f;
            }
        } else {
            return 0f;
        }
    }
    public static void main(String[] args) {
     System.out.println("Hola");
    }
}
