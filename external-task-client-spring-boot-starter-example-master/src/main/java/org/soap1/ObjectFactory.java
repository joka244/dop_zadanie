
package org.soap1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.soap1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetStoreAssortmentResponse_QNAME = new QName("http://asu.dgtu.donetsk.ua/ex/passexam", "GetStoreAssortmentResponse");
    private final static QName _GetStoreAssortment_QNAME = new QName("http://asu.dgtu.donetsk.ua/ex/passexam", "GetStoreAssortment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.soap1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStoreAssortment }
     * 
     */
    public GetStoreAssortment createGetStoreAssortment() {
        return new GetStoreAssortment();
    }

    /**
     * Create an instance of {@link GetStoreAssortmentResponse }
     * 
     */
    public GetStoreAssortmentResponse createGetStoreAssortmentResponse() {
        return new GetStoreAssortmentResponse();
    }

    /**
     * Create an instance of {@link StoreAssortment }
     * 
     */
    public StoreAssortment createStoreAssortment() {
        return new StoreAssortment();
    }

    /**
     * Create an instance of {@link Clothes }
     * 
     */
    public Clothes createClothes() {
        return new Clothes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStoreAssortmentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://asu.dgtu.donetsk.ua/ex/passexam", name = "GetStoreAssortmentResponse")
    public JAXBElement<GetStoreAssortmentResponse> createGetStoreAssortmentResponse(GetStoreAssortmentResponse value) {
        return new JAXBElement<GetStoreAssortmentResponse>(_GetStoreAssortmentResponse_QNAME, GetStoreAssortmentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStoreAssortment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://asu.dgtu.donetsk.ua/ex/passexam", name = "GetStoreAssortment")
    public JAXBElement<GetStoreAssortment> createGetStoreAssortment(GetStoreAssortment value) {
        return new JAXBElement<GetStoreAssortment>(_GetStoreAssortment_QNAME, GetStoreAssortment.class, null, value);
    }

}
