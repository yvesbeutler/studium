package ch.yvesbeutler.xml.example.numbers.naturals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Succ",
                namespace="http://www.ti.bfh.ch/fileadmin/modules/BTI7055-de.xml")
public final class Succ extends NaturalNumber {
 
    @XmlElement(name="pred")
    private NaturalNumber predecessor;
    public final NaturalNumber getPred() { return predecessor; }
    
    public Succ(NaturalNumber n) { predecessor = n; }
    public Succ() {} // for JAXB only
    
    public final boolean isZero() { return false; }
    public final boolean isOne()  { return getPred().isZero(); }
    
    public final int getDeci() { return 1+getPred().getDeci(); }
    
}