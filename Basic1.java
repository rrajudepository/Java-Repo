import java.util.*;
import java.lang.*;
import java.io.*;

class Basic1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		char ch1 = 'A';
        char ch2 = '9';
        char ch3 = '$';
        char ch4 = '\n'; // newline character
        System.out.print(ch1+" "+ch2+" "+ch3+" "+ch4);
        char ch = 'A';
        System.out.println((int) ch); // Output: 65 
        
        //char->String
        char c = 'X';
        String s = Character.toString(c);
        
        System.out.println(s);
        
        //String -> Character
        String s1 = "Hello";
        char c1 = s1.charAt(0);
        System.out.println(c1);
        
        //char-> Integer
        c= 'A';
        int val = (int)c; //65
        System.out.println(val);
        c= 'a';
        val = (int)c; //97
        System.out.println(val);
        
        //int->char
        val = 66;
        c = (char)val; //B
        System.out.println(c);
        
        val=64;
        c= (char)val; //@
        System.out.println(c);
        
        c = 'A';
        System.out.println(Character.isLetter(c)); //true 
        System.out.println(Character.isDigit('5')); //true
        System.out.println(Character.isLetterOrDigit('@')); //false;
        System.out.println(Character.isUpperCase('A')); //true;
        System.out.println(Character.isLowerCase('a')); //true;
        System.out.println(Character.toUpperCase('a')); //'A'
        System.out.println(Character.toLowerCase('I')); //i 
        System.out.println(Character.getNumericValue('9')); // 9 
        System.out.println(Character.getNumericValue('b'));//11 numeric value of 'b' is 11
        
        System.out.println(Character.compare('a','b')); //-1
        System.out.println(Character.compare('b','a')); //1
        System.out.println(Character.compare('a','a')); //0
        
        char c2 = 'a';
        System.out.println(c2=='a');//print true
        
        String str = "Hello123 @World";
        int upper =0, lower =0, digit=0, space=0, special=0;
        
        for( char c4 : str.toCharArray()){
            if(Character.isUpperCase(c4)) upper++;
            if(Character.isLowerCase(c4)) lower++;
            if(Character.isDigit(c4)) digit++;
            if(Character.isWhitespace(c4)) space++;
            else special++;
            
        }
        
        System.out.println("Uppercase: "+ upper+ " LowerCase: " + lower+ "Digit: "+ digit+ "Spaces: "+ space+ " Special"+special);
        
        
        
        
        
        
        
        
        


	}
}
/*

| **Method**                       | **Description**                                                      | **Example**                              |
| -------------------------------- | -------------------------------------------------------------------- | ---------------------------------------- |
| `isLetter(ch)`                   | Checks if the char is a letter (A–Z or a–z or other Unicode letters) | `Character.isLetter('A') → true`         |
| `isDigit(ch)`                    | Checks if the char is a digit                                        | `Character.isDigit('5') → true`          |
| `isLetterOrDigit(ch)`            | Checks if letter or digit                                            | `Character.isLetterOrDigit('@') → false` |
| `isWhitespace(ch)`               | Checks if whitespace (space, tab, newline)                           | `Character.isWhitespace(' ') → true`     |
| `isUpperCase(ch)`                | Checks if uppercase                                                  | `Character.isUpperCase('A') → true`      |
| `isLowerCase(ch)`                | Checks if lowercase                                                  | `Character.isLowerCase('a') → true`      |
| `toUpperCase(ch)`                | Converts to uppercase                                                | `Character.toUpperCase('b') → 'B'`       |
| `toLowerCase(ch)`                | Converts to lowercase                                                | `Character.toLowerCase('M') → 'm'`       |
| `isAlphabetic(ch)`               | Checks if alphabetic (supports Unicode)                              | `Character.isAlphabetic('δ') → true`     |
| `isDefined(ch)`                  | Checks if the char is a defined Unicode char                         | `Character.isDefined('©') → true`        |
| `isSpaceChar(ch)`                | Checks if the char is a space according to Unicode                   | `Character.isSpaceChar(' ') → true`      |
| `getNumericValue(ch)`            | Returns numeric value if the char is a number                        | `Character.getNumericValue('9') → 9`     |
| `forDigit(int digit, int radix)` | Converts a digit to char in a specific base                          | `Character.forDigit(10, 16) → 'a'`       |
| `compare(ch1, ch2)`              | Compares two chars (returns int)                                     | `Character.compare('a', 'b') → -1`       |
| `toString(ch)`                   | Converts char to string                                              | `Character.toString('A') → "A"`          |
| `isTitleCase(ch)`                | Checks if the char is title case                                     | Rarely used                              |
| `charCount(int codePoint)`       | Returns the number of `char`s needed for a Unicode code point        | `Character.charCount(0x10400)`           |

*/