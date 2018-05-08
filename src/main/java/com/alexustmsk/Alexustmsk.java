package com.alexustmsk;

import com.alexustmsk.ws.*;

public class Alexustmsk {
    public static void main(String[] args) {

        ObjectFactory objectFactory = new ObjectFactory();

        NdsRequest2 ndsRequest2 = objectFactory.createNdsRequest2();

        for (int i = 0; i < args.length; i++) {
            NdsRequest2.NP ndsRequest2NP = objectFactory.createNdsRequest2NP();
            ndsRequest2NP.setINN(args[i]);
            ndsRequest2.getNP().add(ndsRequest2NP);
        }

        FNSNDSCAWS2 fnsndscaws2 = new FNSNDSCAWS2();
        NdsResponse2 ndsResponse2 = fnsndscaws2.getFNSNDSCAWS2Port().ndsRequest2(ndsRequest2);

        for (NdsResponse2.NP np : ndsResponse2.getNP()) {
            System.out.println(np.getState());
        }





        }

    }



