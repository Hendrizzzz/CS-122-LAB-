/**
 Name of programmer: Bag-eo, Jim Hendrix T.
 Class Code and Schedule: 9322A/B CS 122/122L MTH/TF
 Date: March 16, 2024
 */



package prog2.samcis;

public interface NumberConverter {
    public int binaryToDecimal(String b) throws Exception;
    public int hexadecimalToDecimal(String h);
    public int octalToDecimal(String n);
}
