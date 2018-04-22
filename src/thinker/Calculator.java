package thinker;

import math.Polynomial;
import math.RationalScalar;
import math.RealScalar;
import math.Scalar;

import java.util.Scanner;

public class Calculator {
    private static Scanner scanner;
    private static char scalarField;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the polynomial calculator.\n" +
                "Please select the scalar field. Rational (Q) or Real (R):");
        scalarField = scanner.next().charAt(0);
        showMenu();
    }

    private static void showMenu() {
//        clearScreen();
        System.out.println("Please select an operation:\n" +
                "1. Addition\n" +
                "2. Multiplication\n" +
                "3. Evaluation\n" +
                "4. Derivate\n" +
                "5. Exit\n");
        int choice = scanner.nextInt();
        System.out.print("You have selected: ");
        switch (choice) {
            case 1:
                System.out.println("Addition");
                Addition();
                showMenu();
                break;
            case 2:
                System.out.println("Multiplication");
                Multiplication();
                showMenu();
                break;
            case 3:
                System.out.println("Evaluation");
                Evaluation();
                showMenu();
                break;
            case 4:
                System.out.println("Derivate");
                Derivate();
                showMenu();
                break;
            case 5:
                System.out.println("Exit. Goodbye...");
                break;
        }
    }

    private static void Addition() {
        System.out.println("Please insert the first polynomial");
        Polynomial firstPoly = new Polynomial(scanner.next(), scalarField);
        System.out.println("Please insert the second polynomial");
        Polynomial secondPoly = new Polynomial(scanner.next(), scalarField);
        System.out.println("The solution is:");
        System.out.println(firstPoly.add(secondPoly));
    }

    private static void Multiplication() {
        System.out.println("Please insert the first polynomial");
        Polynomial firstPoly = new Polynomial(scanner.next(), scalarField);
        System.out.println("Please insert the second polynomial");
        Polynomial secondPoly = new Polynomial(scanner.next(), scalarField);
        System.out.println("The solution is:");
        System.out.println(firstPoly.mul(secondPoly));
    }

    private static void Evaluation() {
        System.out.println("Please insert the polynomial");
        Polynomial poly = new Polynomial(scanner.next(), scalarField);
        System.out.println("Please insert the scalar");
        String strScalar = scanner.next();
        Scalar scalar;
        if (scalarField == 'R') {
            scalar = new RealScalar(strScalar);
        } else {
            scalar = new RationalScalar(strScalar);
        }

        System.out.println("The solution is:");
        System.out.println(poly.evaluate(scalar));
    }

    private static void Derivate(){
        System.out.println("Please insert the polynomial");
        Polynomial poly = new Polynomial(scanner.next(), scalarField);
        System.out.println("The solution is:");
        System.out.println(poly.derivate());
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
