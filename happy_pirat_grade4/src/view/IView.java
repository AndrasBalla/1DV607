package view;

import model.Boat;
import model.BoatType;
import model.Member;

import java.util.ArrayList;

/**
 * Created by fredrik on 11/4/16.
 */
public interface IView {
    int presentMainMenu();

    String presentAddName();

    String presentAddPersonalNumber();

    Member presentDeleteMember(ArrayList<Member> members);

    Member presentChangeMember(ArrayList<Member> members);

    void presentMembers(ArrayList<Member> members);

    void presentMembersVerbose(ArrayList<Member> members);

    Member presentViewMember(ArrayList<Member> members);

    void presentMemberVerbose(Member memberToView);

    Member presentRegisterBoat(ArrayList<Member> members);

    String presentAddBoatName();

    BoatType presentAddBoatType();

    String presentAddBoatLength();

    Member presentMemberToDeleteBoatFrom(ArrayList<Member> members);

    Boat presentDeleteBoat(Member memberToDeleteBoatFrom);

    Member presentMemberToChangeBoatOn(ArrayList<Member> members);

    Boat presentChangeBoat(Member memberToChangeBoatOn);

    String presentLogin();

    String presentSearchString();

    String presentSearchBy();

    String presentAndOr();

    boolean presentAddMoreFilters();
}
