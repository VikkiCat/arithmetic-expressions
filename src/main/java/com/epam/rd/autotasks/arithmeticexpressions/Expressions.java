package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.StringJoiner;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        Expression val = new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                String nValue = Integer.toString(value);
                if (value<0) return "(" + nValue + ")";
                return nValue;
            }
        };
        return val;
    }

    public static Expression sum(Expression... members){
        Expression eSum = new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;
                for (Expression expr: members) {
                    sum += expr.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                String sum = "(";
                for (Expression x:
                     members) {
                    sum += (x.toExpressionString() + " + ");
                }
                sum = sum.substring(0,(sum.length()-3));
                sum += ")";
                return sum;
            }
        };
        return eSum;
    }

    public static Expression product(Expression... members){
        Expression product = new Expression() {
            @Override
            public int evaluate() {
                int num = 1;
                for (Expression product:
                     members) {
                    num *= product.evaluate();
                }
                return num;
            }

            @Override
            public String toExpressionString() {
                String prod = "(";
                for (Expression x:
                        members) {
                    prod += (x.toExpressionString() + " * ");
                }
                prod = prod.substring(0,(prod.length()-3));
                prod += ")";
                return prod;
            }
        };
        return product;
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        Expression difference = new Expression() {
            @Override
            public int evaluate() {
                int A = minuend.evaluate() - subtrahend.evaluate();
                return A;
            }

            @Override
            public String toExpressionString() {
                String A = minuend.toExpressionString();
                String B = subtrahend.toExpressionString();
                return "(" + A + " - " + B + ")";
            }
        };
        return difference;
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        Expression fraction = new Expression() {
            @Override
            public int evaluate() {
                int a = dividend.evaluate();
                int b = divisor.evaluate();
                return a/b;
            }

            @Override
            public String toExpressionString() {
                String A = dividend.toExpressionString();
                String B = divisor.toExpressionString();
                return "(" + A + " / " + B + ")";
            }
        };
        return fraction;
    }

}
