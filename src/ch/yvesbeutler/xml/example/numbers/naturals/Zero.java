package ch.yvesbeutler.xml.example.numbers.naturals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="Zero",
                namespace="http://www.ti.bfh.ch/fileadmin/modules/BTI7055-de.xml")
public final class Zero extends NaturalNumber {
    
    public final boolean isZero() { return true; }
    public final boolean isOne()  { return false; }

    public final NaturalNumber getPred() { return null; }
    public final int getDeci() { return 0; }

}