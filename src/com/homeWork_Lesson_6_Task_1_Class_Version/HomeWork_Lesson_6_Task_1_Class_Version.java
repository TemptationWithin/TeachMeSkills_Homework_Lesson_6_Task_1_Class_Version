package com.homeWork_Lesson_6_Task_1_Class_Version;

import com.homeWork_Lesson_6_Task_1_Class_Version.division.Division;

/**
 * ЗАДАНИЕ 1
 * 	Представьте, что в джава нет оператора деления.
 * 	Написать класс, который будет содежрать методы для деления одного числа на
 * 	(на вход метода передаем только с целыми числами).
 * 	Счиатаем, что все другие арифметические операции(сложение, вычитание, умножение) есть, нет только деления.
 * 	Класс должен содержать три метода:
 * 	1) метод для деления одного числа на другое без остатка(например, 10 делить на 3 -> метод будет возвращать 3)
 * 	2) метод для деления одного числа на другое с остатком(например, 10 делить на 3 -> метод будет возвращать 3,333)
 * 	3) метод, который возвращает только остаток от деления одного числа на другое, если остаток есть
 * 	(например, 10 делить на 3 -> метод будет возвращать 1)
 *
 * 	Сделать это задание в двух вариантах(как два отдельных проекта):
 * 	1) реализовать все в обычных классах
 *
 * 	Что практикуем в этом задании:
 * 		- управляющие конструкции, операции ветвления
 * 		- построение алгоритмов
 * 		- статические методы и когда они используются
 * 		- продумывание вариантов тестирование кода
 */

public class HomeWork_Lesson_6_Task_1_Class_Version {
    public static void main(String[] args) {
        Division division = new Division();    // creating an object for use methods of the class Division
        System.out.println("Integer division check:");
        System.out.println(division.divisionWithoutRemainder(1,50));     // 0
        System.out.println(division.divisionWithoutRemainder(25,25));    // 1
        System.out.println(division.divisionWithoutRemainder(5,2));      // 2
        System.out.println(division.divisionWithoutRemainder(25,5));     // 5
        System.out.println(division.divisionWithoutRemainder(88888,8));  // 11111
        System.out.println(division.divisionWithoutRemainder(-10000,5)); // -2000
        System.out.println(division.divisionWithoutRemainder(500,-52));  // -9
        System.out.println(division.divisionWithoutRemainder(-17,-7));   // 2
        System.out.println(division.divisionWithoutRemainder(0,-7));     // 0
        // for checking division by zero you should remove the comment mark before the next line
        //System.out.println(division.divisionWithoutRemainder(7,0));          // You cannot divide by zero
        System.out.println(" ");

        System.out.println("Checking the remainder of a division:");
        System.out.println(division.remainderOfDivision(4,9));           // 0
        System.out.println(division.remainderOfDivision(9,9));           // 0
        System.out.println(division.remainderOfDivision(0,9));           // 0
        System.out.println(division.remainderOfDivision(25,4));          // 1
        System.out.println(division.remainderOfDivision(7,4));           // 3
        System.out.println(division.remainderOfDivision(79,10));         // 9
        System.out.println(division.remainderOfDivision(-29,5));         // -4
        System.out.println(division.remainderOfDivision(39,-11));        // -6
        System.out.println(division.remainderOfDivision(-52,-50));       // 2
        // for checking division by zero you should remove the comment mark before the next line
        //System.out.println(division.remainderOfDivision(7,0));               // You cannot divide by zero

        System.out.println("Division test with fractional part:");
        System.out.println(division.divisionWithRemainder(20,3));        // 6.66666
        System.out.println(division.divisionWithRemainder(40,3));        // 13.33333
        System.out.println(division.divisionWithRemainder(-10,-3));      // 3.33333
        System.out.println(division.divisionWithRemainder(1,2));         // 0.5
        System.out.println(division.divisionWithRemainder(-7,4));        // -1.75
        System.out.println(division.divisionWithRemainder(23,-8));       // -2.875
        System.out.println(division.divisionWithRemainder(0,-8));        // -0.0
        // for checking division by zero you should remove the comment mark before the next line
        //System.out.println(division.divisionWithRemainder(7,0));             // You cannot divide by zero

    }
}
