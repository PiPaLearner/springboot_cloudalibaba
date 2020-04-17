package com.personal.content_center.controller;

public class Test {public static void main(String[] args) { String hello = "Hello", lo = "lo";
 System.out.println((hello == "Hello") + " "); //true
 System.out.println((Other.hello == hello) + " "); //true
 System.out.println((Other.hello == hello) + " "); //true
 System.out.println((hello == ("Hel"+"lo")) + " "); //true
 System.out.println((hello == ("Hel"+lo)) + " "); //false
 System.out.println(hello == ("Hel"+lo).intern()); //true
 }
}class Other { static String hello = "Hello";
}

