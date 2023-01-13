package org.soap1;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

public class StoreClient {

    public final static QName SHOWASSORTMENT_QNAME = new QName(
            "http://asu.dgtu.donetsk.ua/ex/passexam", "DisplayAssortment"
    );

    public static URL getWSDLURL(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return url;
    }

    public void printStoreAssortment(StoreAssortment assortment) {
        for (int i = 0; i < assortment.getClothes().size(); i++) {
            Clothes clothes = assortment.getClothes().get(i);
            int quantity = assortment.getQuantity().get(i);
            System.out.println(clothes.company + " | " +
                    clothes.type + " | " +
                    clothes.name + " | " +
                    clothes.size + " | " +
                    clothes.price + "P" +
                    " | Amount: " + quantity);
        }
    }

    public void process(URL url) {
        DisplayAssortment service = new DisplayAssortment(url, SHOWASSORTMENT_QNAME);
        StoreService storeSvcPort = service.getDisplayAssortmentPort();
        StoreAssortment assortment = storeSvcPort.getStoreAssortment();
        System.out.println("    Shop Catalog  \n -----------------------");
        printStoreAssortment(assortment);
    }
/*
    public static void main(String[] args) {
        URL url = getWSDLURL("http://localhost:8081/StoreSvcWeb/displayassortment?wsdl");
        StoreClient client = new StoreClient();
        client.name(url);
    }
*/

}
