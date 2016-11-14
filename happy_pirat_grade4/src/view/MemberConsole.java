package view;

import model.Boat;
import model.BoatType;
import model.Member;


import java.util.ArrayList;
import java.util.Scanner;


public class MemberConsole implements IView{


    private Scanner in = new Scanner(System.in);
    private int input;


    public int presentMainMenu() {

        System.out.println("1. View members compact");
        System.out.println("2. View members verbose");
        System.out.println("3. View member");
        String menuAlternative = in.nextLine();
        if (isInteger(menuAlternative, 3)){
            return input + 3;
        }else {
            System.out.println("Please provide a Integer.");
            presentMainMenu();
        }

        return 0;
    }

    //Add member functions

    public String presentAddName() {
        //Scanner in = new Scanner(System.in);
        System.out.println("Enter member name:");
        return in.nextLine();
    }

    public String presentAddPersonalNumber() {
        //Scanner in = new Scanner(System.in);
        System.out.println("Enter members personal number/n use the following format YYMMDD-XXXX");
        return in.nextLine();
    }

    //Show members

    public void presentMembers(ArrayList<Member> members) {
        System.out.println("Members:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println(i + 1 + ". " + members.get(i).getM_name() + " " + members.get(i).getM_personalNumber() + " MemberID: " + members.get(i).getM_memberID() + " Boats: " + members.get(i).getM_boats().size());
        }
        System.out.println("---------------------------------------------");
    }

    public void presentMembersVerbose(ArrayList<Member> members) {
        System.out.println("Members:");
        for (int i = 0; i < members.size(); i++) {
            System.out.println(i + 1 + ". " + members.get(i).getM_name() + " " + members.get(i).getM_personalNumber() + " MemberID: " + members.get(i).getM_memberID());
            for (int j = 0; j < members.get(i).getM_boats().size(); j++) {
                System.out.println("     " + (j + 1) + ". Name:" + members.get(i).getM_boats().get(j).getM_boatName());
                System.out.println("        Type:" + members.get(i).getM_boats().get(j).getM_boatType());
                System.out.println("        Length:" + members.get(i).getM_boats().get(j).getM_length() + " m");
            }
        }
        System.out.println("---------------------------------------------");
    }

    public void presentMemberVerbose(Member member) {
        System.out.println("Member:");
        System.out.println(member.getM_name() + " " + member.getM_personalNumber() + " " + member.getM_memberID() + "Boats: " + member.getM_boats().size());
        for (int j = 0; j < member.getM_boats().size(); j++) {
            System.out.println("     " + (j + 1) + ". Name:" + member.getM_boats().get(j).getM_boatName());
            System.out.println("        Type:" + member.getM_boats().get(j).getM_boatType());
            System.out.println("        Length:" + member.getM_boats().get(j).getM_length() + " m");
        }
        System.out.println("---------------------------------------------");
    }

    //Delete member

    /**
     * Present the menu for Deleting member. Accepts input from the user.
     * @param members An arraylist containing Member objects.
     * @return A member found at the provided position.
     */
    public Member presentDeleteMember(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a user to delete by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            presentDeleteMember(members);
        }

        return null;
    }

    //Change member

    public Member presentChangeMember(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a member to change by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            return presentChangeMember(members);
        }

        //return null;
    }

    public Member presentViewMember(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a member to view by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            return presentViewMember(members);
        }

        //return null;
    }

    //Register boat

    public Member presentRegisterBoat(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a member to register boat for by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            presentRegisterBoat(members);
        }

        return null;
    }

    //Register and change boat

    public String presentAddBoatName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter boat name:");
        String name = in.nextLine();
        return name;
    }

    public BoatType presentAddBoatType() {

        BoatType[] boatType = BoatType.values();
        int typeInt;

        Scanner in = new Scanner(System.in);

        for (int i=0; i<boatType.length; i+=1){
            System.out.println((i + 1) + ". "+ boatType[i]);
        }

        String type = in.nextLine();

        if (isInteger(type, 4)){
            typeInt = Integer.parseInt(type);
                return boatType[typeInt - 1];

            } else {
                System.out.println("Please provide a Integer between 1 and " + boatType.length + ".");
                presentAddBoatType();
            }
        return null;
    }

    public String presentAddBoatLength() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Boat length in meters:");
        String length = in.nextLine();
        if (isInteger(length, 101)){
            return length;
        }else {
            System.out.println("Please provide a Integer between 1 and 100.");
            presentAddBoatLength();
        }

        return null;
    }

    //Delete boat

    public Member presentMemberToDeleteBoatFrom(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a member to delete boat from by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            presentMemberToDeleteBoatFrom(members);
        }

        return null;
    }

    public Boat presentDeleteBoat(Member member) {
        presentMemberVerbose(member);
        System.out.println("Choose boat to delete by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, member.getM_boats().size())){
            return member.getM_boats().get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + member.getM_boats().size() + ".");
            presentDeleteBoat(member);
        }
        return null;
    }

    //Change boat

    public Member presentMemberToChangeBoatOn(ArrayList<Member> members) {
        presentMembers(members);
        System.out.println("Choose a member to change boat on by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, members.size())){
            return members.get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + members.size() + ".");
            presentMemberToDeleteBoatFrom(members);
        }
        return null;
    }

    public Boat presentChangeBoat(Member member) {
        presentMemberVerbose(member);
        System.out.println("Choose boat to change by entering the corresponding number:");
        String memberLine = in.nextLine();

        if (isInteger(memberLine, member.getM_boats().size())){
            return member.getM_boats().get(input - 1);
        }else {
            System.out.println("Please provide a Integer between 1 and " + member.getM_boats().size() + ".");
            presentChangeBoat(member);
        }
        return null;
    }

    private boolean isInteger(String s, int max) {
        try {
            input = Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }

        return input > 0 && input <= max;
    }

    public String presentLogin() {

        System.out.println("Enter your username:");
        return in.nextLine();
    }

    @Override
    public String presentSearchString() {
        return null;
    }

    @Override
    public String presentSearchBy() {return null;}

    @Override
    public String presentAndOr() {
        return null;
    }

    @Override
    public boolean presentAddMoreFilters() {
        return false;
    }

}