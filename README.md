# 1800PhoneChallenge

This challenge converts the t9 encoding on phones' to words based on the following sample dictionary

2 --- A B C
3 --- D E F
4 --- G H I
5 --- J K L
6 --- M N O
7 --- P Q R S
8 --- T U V
9 --- W X Y Z

Features:
* All punctuations(except period) & whitespaces from the number are removed
* The input numbers is encoded using t9 encoding used in phones
* If a number is not found in the dictionary it is moved AS-IS in the output
* No 2 consecutive digits can remain unchanged. In this case the number is ignored
* The program uses the command line args to specify the file names (which has to reside in the resources folder) separated by 
spaces which can contain phone numbers  OR if the filenames are missing it reads from the standard input console. 



