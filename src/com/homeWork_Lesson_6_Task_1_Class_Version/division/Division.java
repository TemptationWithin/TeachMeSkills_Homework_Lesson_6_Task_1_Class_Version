package com.homeWork_Lesson_6_Task_1_Class_Version.division;

import com.homeWork_Lesson_6_Task_1_Class_Version.exceptions.DivisionByZeroException;

public class Division {
    /*
                 Prepating number for division:
     considering the cycles used in the methods of this class,
     all variables must be transformed into positive
    */
    private static int prepareNumberForDivision(int x) {      //converting the number to positive for correct counting
        boolean isXLessThanZero = x < 0;
        if (isXLessThanZero) {
            return -1 * x;
        } else return x;
    }
    /*
                Division sign test method
    */
    private static boolean isResultNegativity(int x, int y) {
        boolean isALessThanZero = x < 0;
        boolean isBLessThanZero = y < 0;
        return ((isALessThanZero && !isBLessThanZero) || (!isALessThanZero && isBLessThanZero));
    }

    /*

                Division without remainder:
     Method implements the process of counting the number of differences between the numbers A and B

    */

    public int divisionWithoutRemainder(int a, int b) {   // первое число делим на второе (a/b);
        int result = 0;
        boolean isNegativity = isResultNegativity(a, b);
        a = prepareNumberForDivision(a);
        b = prepareNumberForDivision(b);
        if (b == 0) {
            throw new DivisionByZeroException("ForbiddenDivisionByZero");
        }
        if (a < b) {
            return 0;
        } else {
            while (a >= b) {
                result++;
                a = a - b;
            }

            if (isNegativity) {     // checking the result for negativity
                return -1 * result;
            } else {
                return result;
            }
        }
    }

    /*
                    Remainder of division:
     the method implements the process of displaying the remainder
     after calculating the number of integer differences of the number A and B
    */

    public int remainderOfDivision(int a, int b) {
        boolean isNegativity = isResultNegativity(a, b);
        a = prepareNumberForDivision(a);
        b = prepareNumberForDivision(b);
        if (b == 0) {
            throw new DivisionByZeroException("ForbiddenDivisionByZero");
        }
        if (a < b) {
            return 0;
        } else {
            int remainder = a - divisionWithoutRemainder(a, b) * b;     // 9/5 = 1(rem 4):   4 = 9-5*1

            if (isNegativity) {                                         // checking the result for negativity
                return -1 * remainder;
            } else {
                return remainder;
            }
        }
    }

    /*
                     Division with Remainder:
     the method uses the integer counting method described above.
     The fractional part is calculated according to the principle of "division into a column"
     with a specified level of counting accuracy (number of decimal places)
    */

    public double divisionWithRemainder(int a, int b){
        boolean isNegativity = isResultNegativity(a,b);
        int beforeDecimalPoint = divisionWithoutRemainder(a,b);   //part of division before decimal point

        if (beforeDecimalPoint < 0){                              //converting beforeDecimalPoint to positive for correct counting
            beforeDecimalPoint = -1 * beforeDecimalPoint;
        }

        a = prepareNumberForDivision(a);
        b = prepareNumberForDivision(b);

        if (b == 0){
            throw new DivisionByZeroException("ForbiddenDivisionByZero");
        }

        a = (a - beforeDecimalPoint * b) * 10;
        int divisionAccuracy = 0;
        double afterDecimalPoint = 0.0;
        double positionCounter = 0.1;
        //!!! QUESTION: what exit condition could be put into the loop for correct operation?!!!
        while (true){
            for (int i = 9; i >= 0; i--) {
                if (b*i <= a){
                    a =  (a - b * i) * 10;
                    afterDecimalPoint = afterDecimalPoint + positionCounter * i;
                    divisionAccuracy++;
                    positionCounter = positionCounter * 0.1;
                    break;
                }
            }
            if (a == 0) {                                           // loop exit condition
                break;
            } else if (divisionAccuracy >= 5){                      // here you can set accuracy of division
                break;
            }
        }

        if (isNegativity) {                                         // checking the result for negativity
            return -1 * (beforeDecimalPoint + afterDecimalPoint);
        } else {
            return (beforeDecimalPoint + afterDecimalPoint);
        }
    }

}
