package model.searchStrategy;

import model.Member;

import java.util.ArrayList;

public class YoungerThanFilterStrategy implements IFilter {

    private int searchString;

    public YoungerThanFilterStrategy(int searchString) {
        this.searchString = searchString;
    }

    @Override
    public ArrayList<Member> filter(ArrayList<Member> members) {
        ArrayList<Member> filteredMembers;
        filteredMembers = new ArrayList<Member>();
        int i;
        for(i = 0; i<members.size(); i++){
            int age;
            age = Integer.parseInt("19" + members.get(i).getM_personalNumber().substring(0, 2));
            if(this.searchString > (2016 - age)){
                filteredMembers.add(members.get(i));
            }
        }
        return filteredMembers;
    }
}
