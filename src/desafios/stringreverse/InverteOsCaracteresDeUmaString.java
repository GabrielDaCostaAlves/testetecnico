package desafios.stringreverse;

import java.util.Scanner;

/*
5) Escreva um programa que inverta os caracteres de um string.

IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;
 */

public class InverteOsCaracteresDeUmaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a string a ser invertida: ");
        String input = scanner.nextLine();

        String reversed = reverseString(input);
        System.out.println("String invertida: " + reversed);

        scanner.close();
    }

    private static String reverseString(String str) {
        char[] chars = str.toCharArray();
        String reversed = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }

        return reversed;
    }
}
