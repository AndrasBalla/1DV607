package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "member")
@XmlType(propOrder = {"m_name", "m_boats", "m_memberID", "m_personalNumber"})
public class Member {

    private String m_name;
    private ArrayList<Boat> m_boats;
    private int m_memberID;
    private String m_personalNumber;

    public Member(String name,int idIn, String personalNumber) {
        this.m_name = name;
        this.m_memberID = idIn;
        this.m_personalNumber = personalNumber;
        m_boats = new ArrayList<>();
    }

    public Member(){}

    public String getM_name() {
        return m_name;
    }

    @XmlElement
    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public ArrayList<Boat> getM_boats() {
        return m_boats;
    }
    @XmlElementWrapper(name = "boats")
    @XmlElement(name = "boat")
    public void setM_boats(ArrayList<Boat> m_boats) {
        this.m_boats = m_boats;
    }
    @XmlAttribute
    public int getM_memberID() {
        return m_memberID;
    }

    public void setM_memberID(int m_memberID) {
        this.m_memberID = m_memberID;
    }

    public String getM_personalNumber() {
        return m_personalNumber;
    }
    @XmlElement
    public void setM_personalNumber(String m_personalNumber) {
        this.m_personalNumber = m_personalNumber;
    }

    public void addBoat(Boat inBoat){
        m_boats.add(inBoat);
    }

    @Override
    public String toString() {
        return "MemberID: " + this.m_memberID + "\nName: " + this.m_name + "\nPersonalNumber: " + m_personalNumber;
    }

    public void deleteBoat(Boat boatToDelete) {
        m_boats.remove(boatToDelete);
    }

    public void changeBoat(Boat boatToChange, String boatName, String boatLength, BoatType boatType) {
        boatToChange.setM_boatName(boatName);
        boatToChange.setM_boatType(boatType);
        boatToChange.setM_length(boatLength);
    }

    public void addBoat(String boatName, BoatType boatType, String boatLength) {
        Boat boat = new Boat(boatName, boatType, boatLength);
        this.addBoat(boat);
    }
}

