package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "boat")
@XmlType(propOrder = {"m_boatName", "m_boatType", "m_length"})
public class Boat {

    private String m_boatName;
    private BoatType m_boatType;
    private String m_length;

    public Boat(String m_boatName, BoatType m_boatType, String m_length) {
        this.m_boatName = m_boatName;
        this.m_boatType = m_boatType;
        this.m_length = m_length;
    }

    public Boat(){}

    public String getM_boatName() {
        return m_boatName;
    }

    @XmlElement
    public void setM_boatName(String m_boatName) {
        this.m_boatName = m_boatName;
    }

    public BoatType getM_boatType() {return m_boatType;}

    @XmlElement
    public void setM_boatType(BoatType m_boatType) {this.m_boatType = m_boatType;}

    public String getM_length() {
        return m_length;
    }

    @XmlElement
    public void setM_length(String m_length) {
        this.m_length = m_length;
    }
}

