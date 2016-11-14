package model.searchStrategy;

import model.Member;

import java.util.ArrayList;

public class NameFilterStrategy implements IFilter {

    private String searchString;

    public NameFilterStrategy(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public ArrayList<Member> filter(ArrayList<Member> members) {
        ArrayList<Member> filteredMembers;
        filteredMembers = new ArrayList<Member>();
        int i;
        for(i = 0; i<members.size(); i++){
            if(members.get(i).getM_name().startsWith(this.searchString)){
                filteredMembers.add(members.get(i));
            }
        }
        return filteredMembers;
    }
}
