
package org.soap2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.soap2 package. 
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

    private final static QName _ReserveClothes_QNAME = new QName("http://asu.dgtu.donetsk.ua/ex/students", "ReserveClothes");
    private final static QName _ReserveClothesResponse_QNAME = new QName("http://asu.dgtu.donetsk.ua/ex/students", "ReserveClothesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.soap2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReserveClothes }
     * 
     */
    public ReserveClothes createReserveClothes() {
        return new ReserveClothes();
    }

    /**
     * Create an instance of {@link ReserveClothesResponse }
     * 
     */
    public ReserveClothesResponse createReserveClothesResponse() {
        return new ReserveClothesResponse();
    }

    /**
     * Create an instance of {@link UserReserve }
     * 
     */
    public UserReserve createUserReserve() {
        return new UserReserve();
    }

    /**
     * Create an instance of {@link Clothes }
     * 
     */
    public Clothes createClothes() {
        return new Clothes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveClothes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://asu.dgtu.donetsk.ua/ex/students", name = "ReserveClothes")
    public JAXBElement<ReserveClothes> createReserveClothes(ReserveClothes value) {
        return new JAXBElement<ReserveClothes>(_ReserveClothes_QNAME, ReserveClothes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveClothesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://asu.dgtu.donetsk.ua/ex/students", name = "ReserveClothesResponse")
    public JAXBElement<ReserveClothesResponse> createReserveClothesResponse(ReserveClothesResponse value) {
        return new JAXBElement<ReserveClothesResponse>(_ReserveClothesResponse_QNAME, ReserveClothesResponse.class, null, value);
    }

}
