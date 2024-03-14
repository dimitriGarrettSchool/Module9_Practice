import java.util.Scanner;

public class SafeInput
{
    public static StringAndLength getNonZeroLenString(Scanner scanner, String prompt)
    {
        StringAndLength temp = new StringAndLength();
        do {
            System.out.printf(prompt);

            temp.string = scanner.nextLine();
            temp.length = temp.string.length();
        } while (temp.length == 0);

        return temp;
    }

    private static void bar(StringAndLength message)
    {
        int length = 60 - message.length % 2;
        for (int i = 0; i < length; ++i)
        {
            System.out.printf("*");
        }
        System.out.println("");
    }

    public static void prettyHeader(StringAndLength message)
    {
        int length = 60 - message.length % 2;

        bar(message);

        System.out.printf("***");

        int middle = length - 6;
        int spaces = (middle - message.length) / 2;

        for (int i = 0; i < spaces; ++i)
        {
            System.out.printf(" ");
        }

        System.out.printf(message.string);

        for (int i = 0; i < spaces; ++i)
        {
            System.out.printf(" ");
        }

        System.out.println("***");
        bar(message);
    }

    public static void prettyHeader(String message)
    {
        StringAndLength string = new StringAndLength();
        string.string = message;
        string.length = message.length();

        prettyHeader(string);
    }

    public static void header(Scanner scanner)
    {
        prettyHeader(getNonZeroLenString(scanner, "What is your message: "));
    }
}
