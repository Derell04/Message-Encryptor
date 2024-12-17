import java.util.Scanner;

/**
 * 
 * 
 * @author Derell Facey
 * @version 1.0.0 2024-12-13 Initial implementation
 *
 */
public class Encryptor
    {      
      
       
       /**
     * 
     * 
     * @param msg Message
     * @param shift Shift value for Caesar cipher
     * @return encrypted message
     */
    public static String encrypt(String msg, int shift)
       {
           StringBuilder encrypted = new StringBuilder();
           
           for(char c : msg.toCharArray())
               {
                   if(Character.isLetter( c ))
                       {
                           char base = Character.isUpperCase( c ) ? 'A' : 'a';
                           
                           //Encrypt and wrap around alphabet
                           char encryptedChar = (char)((c - base + shift) % 26 + base);
                           encrypted.append( encryptedChar );
                       }
                   else
                       {
                           //If not a letter, do not encrypt
                           encrypted.append( c );
                       }
               }
           
           return encrypted.toString();
       }
      
    
    /**
     * 
     * 
     * @param msg encrypted msg
     * @param shift to reverse Caeser Cipher
     * @return decrypted msg
     */
    public static String decrypt(String msg, int shift)
        {
            StringBuilder decrypted = new StringBuilder();
            
            for(char c : msg.toCharArray())
                {
                    if(Character.isLetter( c ))
                        {
                            char base = Character.isUpperCase( c ) ? 'A' : 'a';
                            
                            //decrypts and wrap around alphabet
                            char decryptedChar = (char)((c - base - shift + 26) % 26 + base);
                            decrypted.append( decryptedChar );
                        }
                    else
                        {
                            //If not a letter, do not decrypt/change
                        decrypted.append( c );
                        }
                }
            
            return decrypted.toString();
        }
       
       
       /**
     * 
     * 
     * @param args 
     * 
     * Take a message from client 1,
     * then encrypts it for transport across communications,
     * then client 2 receives the decrypted version of the encrypted msg (the original msg)
     */
    public static void main (String [] args) 
       {
           Scanner in = new Scanner(System.in);
           
           System.out.print("Enter a message: ");
           String msg = in.nextLine();
           
           System.out.print("Enter encryption shift: ");
           int shift = in.nextInt();
           
           
           shift = shift % 26;
           if(shift < 0)
               {
               shift += 26;
               }
           
           String encryptedMsg = encrypt(msg, shift);
           
           System.out.printf("%n--------------------------------------------------------------------");
           
           System.out.printf( "%nClient 1 (SENT): %s%n%n" +
                               "MESSAGE SENT ACROSS NETWORKS: %s%n%n" +
                               "Client 2 (RECIEVED): %s", msg, encryptedMsg, decrypt(encryptedMsg,shift) );
           
           in.close();
           
       
       }
    }
   // end class encryptor