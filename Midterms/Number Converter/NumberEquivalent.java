/**
 Name of programmer: Bag-eo, Jim Hendrix T.
 Class Code and Schedule: 9322A/B CS 122/122L MTH/TF
 Date: March 16, 2024
 */



package prog2.samcis;
/**
 *A template for an object representing a whole number with its decimal, binary, octal and hexadecimal form.
 **/
public class EquivalentNumbers implements NumberConverter {
    private int decimalNumber; // decimal number form
    private double floatingDecimalNumber; // floating point decimal number form
    private String hexadecimalString; // hexadecimal number form
    private String binaryString; // binary number form
    private String octalString; // octal number form



    /**
     *Constructs an object representing the number 0
     **/
    public EquivalentNumbers(){
        decimalNumber = 0;
        hexadecimalString = "0";
        binaryString = "0";
        octalString = "0";
    }


    /**
     *Constructs an object representing a q whole number a
     **/
    public EquivalentNumbers(int a, String b, String c, String d){
        decimalNumber = a;
        hexadecimalString = b;
        binaryString = c;
        octalString = d;
    }


    /**
     *Returns the decimal number form of an object of EquivalentNumbers
     **/
    public long getDecimalNumber(){
        return decimalNumber;
    }


    /**
     *Returns the hexadecimal number form of an object of EquivalentNumbers
     **/
    public String getHexadecimalString(){
        return hexadecimalString;
    }


    /**
     *Returns the binary number form of an object of EquivalentNumbers
     **/
    public String getBinaryString(){
        return binaryString;
    }


    /**
     * Returns the floating point decimal number form of an of EquivalentNumbers
     */
    public double getFloatingDecimalNumber() {
        return floatingDecimalNumber;
    }

    /**
     *Returns the octal number form of an object of EquivalentNumbers
     **/
    public String getOctalString(){
        return octalString;
    }


    /**
     *Sets the decimal number; then the hexadecimal number, binary number and octal number
     *are set based on the decimal number.
     */
    public void setDecimalNumber(int d){
        decimalNumber = d;
        hexadecimalString = Integer.toHexString(decimalNumber);
        binaryString = Integer.toBinaryString(decimalNumber);
        octalString = Integer.toOctalString(decimalNumber);
    }


    /**
     *Sets the floating-point decimal number; then the hexadecimal number, binary number and octal number
     *are set based on the decimal number.
     */
    public void setFloatingDecimalNumber(double d){
        floatingDecimalNumber = d;
        hexadecimalString = convertToBase(d, 16);
        binaryString = convertToBase(d, 2);
        octalString = convertToBase(d, 8);
    }



    /**
     * Converts a decimal number to the specified base.
     *
     * @param number the decimal number to convert
     * @param base   the base to convert to
     * @return the string representation of the converted number
     */
    private static String convertToBase(double number, int base) {
        StringBuilder result = new StringBuilder();
        boolean negative = number < 0;
        long integerPart = (long) Math.abs(number);
        double fractionalPart = Math.abs(number) - Math.abs((long) number);

        convertIntegerPart(integerPart, base, result);
        result.append(".");
        convertFractionalPart(fractionalPart, base, result);

        if (negative) {
            result.insert(0, '-');
        }

        return result.toString();
    }



    /**
     * Converts the integer part of a decimal number to the specified base. Helper method
     *
     * @param integerPart the integer part of the decimal number
     * @param base        the base to convert to
     * @param result      the StringBuilder to store the converted result
     */
    private static void convertIntegerPart(long integerPart, int base, StringBuilder result) {
        if (integerPart == 0) {
            result.append('0');
        } else {
            while (integerPart > 0) {
                long remainder = integerPart % base;
                result.insert(0, toChar(remainder));
                integerPart /= base;
            }
        }
    }


    /**
     * Converts the fractional part of a decimal number to the specified base. Helper Method
     *
     * @param fractionalPart the fractional part of the decimal number
     * @param base           the base to convert to
     * @param result         the StringBuilder to store the converted result
     */
    private static void convertFractionalPart(double fractionalPart, int base, StringBuilder result) {
        for (int i = 0; i < 10; i++) {
            fractionalPart *= base;
            int digit = (int) fractionalPart;
            result.append(toChar(digit));
            fractionalPart -= digit;
        }
    }


    /**
     * Converts a numeric value to its character representation.
     *
     * @param value the numeric value to convert
     * @return the character representation of the value
     */
    private static char toChar(long value) {
        return (char) (value < 10 ? '0' + value : 'A' + value - 10);
    }




    /**
     *Sets the hexadecimal number; then the decimal number, binary number and octal number
     *are set based on the hexadecimal number.
     */
    public void setHexadecimalString(String n){
        hexadecimalString = n;
        decimalNumber = hexadecimalToDecimal(hexadecimalString);
        binaryString =Integer.toBinaryString(decimalNumber);
        /* 2. Use the static method of the Integer class to get the octal string equivalent to the decimal number*/
        octalString = Integer.toOctalString(decimalNumber);
    }



    /**
     *Sets the octal number, then the decimal number, binary number and hexadecimal number
     *are set based on the octal number.
     */
    public void setOctalString(String n){
        octalString = n;
        decimalNumber =octalToDecimal(octalString);
        /*3. Use the static method of the Integer class to get the binary string equivalent to the decimal number*/
        binaryString = Integer.toBinaryString(decimalNumber);
        /*4. Use the static method of the Integer class to get the hexadecimal string equivalent to the decimal
        number */
        hexadecimalString = Integer.toHexString(decimalNumber);
    }




    /**
     *Sets the binary number, then the decimal number, octal number and hexadecimal number
     *are set based on the binary number.
     */
    public void setBinaryString(String b) throws Exception{
        binaryString = b;
        decimalNumber = binaryToDecimal(binaryString);
        octalString = Integer.toOctalString(decimalNumber);
        hexadecimalString = Integer.toHexString(decimalNumber);
    }



    /**
     *Returns the hexadecimal digit corresponding to a given number in the range 0 to 15
     **/
    public char hexDigit(byte digit){
        return switch (digit) {
            case 1 -> '1';
            case 2 -> '2';
            case 3 -> '3';
            case 4 -> '4';
            case 5 -> '5';
            case 6 -> '6';
            case 7 -> '7';
            case 8 -> '8';
            case 9 -> '9';
            case 10 -> 'A';
            case 11 -> 'B';
            case 12 -> 'C';
            case 13 -> 'D';
            case 14 -> 'E';
            case 15 -> 'F';
            default -> '0';
        };
    }



    /**
     *Returns the decimal number corresponding to a given binary number
     **/
    public int binaryToDecimal(String b) throws Exception{
        int result=0;
        if (!isValidBinaryString(b))
            throw new Exception("Invalid Binary Number");
        for (int i=0; i<b.length(); i++){
            result += (int) (Integer.parseInt(""+b.charAt(i))* Math.pow(2, b.length()-1-i));
        }
        return result;
    }



    /**
     *Returns the decimal number corresponding to a given hexadecimal number
     **/
    public int hexadecimalToDecimal(String h){
        int result=0;
        for (int i=0; i<h.length(); i++){
            double pow = Math.pow(16, h.length() - 1 - i);
            switch (h.charAt(i)){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    result += (int) (Integer.parseInt(""+h.charAt(i))* pow);

                    break;
                case 'a':
                case 'A':
                    result += (int) (10* pow);
                    break;
                case 'b':
                case 'B':
                    result += (int) (11* pow);
                    break;
                case 'c':
                case 'C':
                    result += (int) (12* pow);
                    break;
                case 'd':
                case 'D':
                    result += (int) (13* pow);
                    break;
                case 'e':
                case 'E':
                    result += (int) (14* pow);
                    break;
                case 'f':
                case 'F':
                    result += (int) (15* pow);
                    break;
            }
        }
        return (result);
    }



    /**
     *Returns the decimal number corresponding to a given octal number
     **/
    public int octalToDecimal(String n){
        int result=0;
        for (int i=0; i<n.length(); i++){
            result += (int) (Integer.parseInt(""+n.charAt(i))* Math.pow(8, n.length()-1-i));
        }
        return (result);
    }



    /**
     *Returns a string showing a whole number with its decimal, binary, octal and hexadecimal form.
     **/
    public String toString(){
        return ("Decimal Value = "+decimalNumber+"\nBinary Value = " + binaryString +"\nOctal Value = " +
                octalString + "\nHexadecimal Value = " + hexadecimalString);
    }




    /**
     *Returns true if this number is equivalent to another number.
     **/
    public boolean equals(EquivalentNumbers another){
        return (this.decimalNumber == another.getDecimalNumber());
    }




    /**
     * Checks if a string represents a valid binary number.
     *
     * @param s the string to check
     * @return true if the string represents a valid binary number, false otherwise
     */
    private boolean isValidBinaryString(String s){
        boolean result = true;
        for (int index = 0; index< s.length(); index++ ){
            if (s.charAt(index) != '0' && s.charAt(index) != '1') {
                result = false;
                break;
            }
        }
        return result;
    }


} // end of the class
