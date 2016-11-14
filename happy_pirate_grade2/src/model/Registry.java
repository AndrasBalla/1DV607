package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Registry")
public class Registry {
    private ArrayList<Member> members = new ArrayList<Member>();
    private int count = 0;

    public ArrayList<Member> getMembers() {
        return members;
    }

    @XmlElement(name = "member")
    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public void addMember(String name, String personalNumber) {
        Member member = new Member(name, this.getCount(), personalNumber);
        this.members.add(member);
        this.setCount(this.getCount() + 1);
    }

    public void deleteMember(Member memberToDelete) {
        this.members.remove(memberToDelete);
    }

    public void changeMember(Member memberToChange, String name, String personalNumber) {
        memberToChange.setM_name(name);
        memberToChange.setM_personalNumber(personalNumber);
    }
    @XmlAttribute
    public int getCount() {return count;}

    public void setCount(int count) {this.count = count;}

    public void addBoat(Member memberToAddBoatTo, String boatName, String boatLength, BoatType boatType) {
        memberToAddBoatTo.addBoat(boatName, boatType, boatLength);
    }

    public void deleteBoat(Member memberToDeleteBoatFrom, Boat boatToDelete) {
        memberToDeleteBoatFrom.deleteBoat(boatToDelete);
    }

    public void changeBoat(Member memberToChangeBoatOn, Boat boatToChange, String boatName, String boatLength, BoatType boatType) {
        memberToChangeBoatOn.changeBoat(boatToChange, boatName, boatLength, boatType);
    }
}

