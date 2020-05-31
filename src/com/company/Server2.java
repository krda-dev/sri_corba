package com.company;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class Server2 {

    public static void main(String[] args) {
        try {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            ArytmetykaServant as = new ArytmetykaServant();
            orb.connect(as);
            org.omg.CORBA.Object objRef = null;
            objRef = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("Arytmetyka", "");
            NameComponent path[] = {nc};
            ncRef.rebind(path, as);
            java.lang.Object sync = new java.lang.Object();
            synchronized (sync) {
                try {
                    sync.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (CannotProceed cannotProceed) {
            cannotProceed.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        }
    }
}
