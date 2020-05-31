package com.company;

import arytmetykaPackage.DzieleniePrzezZero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Client {
    public static void main(String[] args) {
//        8
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
        ArytmetykaServant as = new ArytmetykaServant();
        orb.connect(as);
//        9 i 10
        FileReader fr = null;
        try {
            fr = new FileReader("ref.ior");
            BufferedReader br = new BufferedReader(fr);
            String ior = br.readLine();
            org.omg.CORBA.Object obj = orb.string_to_object(ior);
            arytmetyka proxy = arytmetykaHelper.narrow(obj);
//        11
            proxy.s1(1);
            proxy.s2(0);
//            proxy.Suma();
            try {
                proxy.Iloraz();
            } catch (DzieleniePrzezZero dzieleniePrzezZero) {
                dzieleniePrzezZero.printStackTrace();
            }
            System.out.println(proxy.wynik());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}