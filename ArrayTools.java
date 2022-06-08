/*
 Name: Shubham Sadashiv Dhamane
Student id: A00257743
Subject: JAV1001
Topic: Methods and Array (LAB2)
Description: Following program helps to perform total operations:
    string encryption, array tools: array average, array reverse, search element in array & max and min value in array
    All these operations have been handled by creating different methods.
 */
import java.util.Arrays;
import java.util.Scanner;

public class ArrayTools {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);                //declaring variables
        float newArray[];
        int numSearch, shiftValue;
        boolean loop=true;

        do {
            System.out.println("Choose option number to do operations:\n1.Encrypt the string\n2.Use Array Tools\n3.Exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1:                                                             //encrypting string
                    System.out.println("Please a string to encrypt: "); 
                    String mainString = sc.nextLine();
                    System.out.println("Enter a value to encrypt with: ");
                    shiftValue = sc.nextInt();
                    sc.nextLine();
                    CeaserCipherEncryption(mainString, shiftValue);                 //calling encryption method
                    break;

                case 2:                                                             //array tools
                    System.out.println("How many numbers do you want to include in array?");
                    int arrayLength = sc.nextInt();
                    sc.nextLine();
                    newArray = new float[arrayLength];
                    System.out.println("enter the numbers:");
                    for (int i = 0;i<arrayLength;i++){                             //taking array from user
                        float temp = sc.nextFloat();
                        newArray[i] = temp;
                    }

                    arrayAvg(newArray);                                            // calling method of  array average

                    System.out.println("Please Enter a no to find in array: ");
                    numSearch=sc.nextInt();
                    arrayContain(newArray,numSearch);                             //calling method to search no in the array

                    arrayReverse(newArray);                                       // calling array reverse method

                    maxMin(newArray);                                             // calling max and min method
                    break;

                case 3:                                             //to exit
                    loop=false;
                    break;
                    
                default:
                    System.out.println("Please enter proper input");
            }

        } while (loop);                                            //adding loop so that user can use this multiple time
    }


    public static void CeaserCipherEncryption(String mainString, int shiftValue){  //CeaserCipher encryption: method will encrypt string and print it
        String encrypted="";
        char letter;

        for(int i=0;i<mainString.length();i++){                         // using for loop so that program can encrypt string char by char
            letter=mainString.charAt(i);

            if(letter>='a' && letter<='z'){                             // handle lower case
                letter=(char)(letter+shiftValue);
                while(letter>'z'){
                  letter=(char)(letter+'a'-1-'z');
                }
                encrypted=(encrypted+letter);

            }

            else if(letter>='A' && letter<='Z') {                       //handle upper case

                letter=(char)(letter+shiftValue);
                while(letter > 'Z'){
                  letter=(char)(letter+'A'-'Z'-1);
                }
                encrypted=encrypted+letter;
                
            }

            else{                                                       // char is other than alphabet is stored as it is.
                encrypted = encrypted + letter;
            }


        }

        System.out.println("Encrypted string is "+encrypted);
        CeaserCipherDecryption(encrypted, shiftValue);                 // calling decryption method


    }



    public static void CeaserCipherDecryption(String encrypted, int shiftValue){  //CeaserCypher decryption will decrypt the string and print it. 
        String decrypted="";
        char letter;
        for(int i=0;i<encrypted.length();i++){
            letter=encrypted.charAt(i);                                             //taking char one by one from the string

            if(letter>='a' && letter<='z'){                                         //lowercase
                letter=(char)(letter-shiftValue);
                while(letter<'a'){
                  letter=(char)(letter-'a'+1+'z');
                }
                decrypted=(decrypted+letter);
            }

            else if(letter>='A' && letter<='Z') {                                   //uppercase

                if(letter>='A' && letter<='Z'){
                letter=(char)(letter-shiftValue);
                while(letter<'A'){
                  letter=(char)(letter-'A'+1+'Z');
                }
                decrypted = decrypted+letter;
                }
            }

            else{
                decrypted = decrypted + letter;                                     //other than alphabets
            }


        }

        System.out.println("Decrypting "+encrypted+" with -"+shiftValue+": "+decrypted);


    }


    public static void arrayAvg(float a[]){                                       //Array Avarage method: for loop will add all the numbers, then average will be calculated and printed
        float sum = 0;      
        float avg = 0;
        for(int i=0;i<a.length;i++){
            sum += a[i];                                                          
        }
        avg = sum/a.length;
        System.out.println("Average is "+avg);

    }


    public static void arrayContain(float a[],int num){                      //method for searching number in array: used for loop to search num in array
        for(int i=0;i<a.length;i++){
            if (a[i]==num){
                System.out.println(num+" is present");
                return;
            }
        }
        System.out.println(num+" is not present");


    }



    public static void arrayReverse(float a[]){                             //method for reverse array: method used one more array and using for loop will stores data in this array backwards
        float reverse[] = new float[a.length];
        for(int i=0;i<a.length;i++){
            int temp = a.length-1-i;                                       
            reverse[temp]=a[i];
        }

        System.out.println("Reverse Array: "+Arrays.toString(reverse));


    }

    public static void maxMin(float a[]){                                   //method which gives max and min value in array 
        float min=a[0],max=a[0];
        for(int i=0;i<a.length;i++){
            if(max<a[i]){
                max=a[i];
            }
            if(min>a[i]){
                min=a[i];
            }
        }
        System.out.println("Maximum value in array: "+max+"\n"+"Minimum value in array: "+min);
    }

}
