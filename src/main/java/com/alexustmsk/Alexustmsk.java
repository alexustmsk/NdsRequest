package com.alexustmsk;

import com.alexustmsk.ws.FNSNDSCAWS2;
import com.alexustmsk.ws.NdsRequest2;
import com.alexustmsk.ws.NdsResponse2;
import com.alexustmsk.ws.ObjectFactory;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.net.URL;

public class Alexustmsk {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Укажите ИНН");
            return;
        }

        ObjectFactory objectFactory = new ObjectFactory();

        NdsRequest2 ndsRequest2 = objectFactory.createNdsRequest2();

        for (int i = 0; i < args.length; i++) {
            NdsRequest2.NP ndsRequest2NP = objectFactory.createNdsRequest2NP();
            ndsRequest2NP.setINN(args[i]);
            ndsRequest2.getNP().add(ndsRequest2NP);
        }

        FNSNDSCAWS2 fnsndscaws2 = new FNSNDSCAWS2(new URL("http://npchk.nalog.ru/FNSNDSCAWS_2?wsdl"), new QName("http://ws.unisoft", "FNSNDSCAWS2"));
        NdsResponse2 ndsResponse2 = fnsndscaws2.getFNSNDSCAWS2Port().ndsRequest2(ndsRequest2);

        for (NdsResponse2.NP np : ndsResponse2.getNP()) {
            System.out.println(np.getState());
        }
    }
}



