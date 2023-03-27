package org.coderpt.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        Function<Integer,Integer> addOneMultTen = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addOneMultTen.apply(1));


        int res = addOneAndMultiply.apply(23,2);
        System.out.println("RES: " + res);
    }


    static BiFunction<Integer,Integer,Integer> addOneAndMultiply = (numberOne, numberTwo) -> (numberOne + 1) * numberTwo;

    static Function<Integer, Integer> multiplyBy10Function = number -> number*10;
    /**
     * They are both the same
     */
    static Function<Integer, Integer> incrementByOneFunction = number -> ++number;

    static int incrementByOne(int number){
        return number++;
    }

}
