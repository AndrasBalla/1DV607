package model.searchStrategy;
import model.Member;

import java.util.ArrayList;

public class FilterFacade {

    private ArrayList<Member> members;
    private ArrayList<Member> filteredMembers;
    private ArrayList<String> searchParams;
    private ArrayList<Member> temporaryMembers;

    public FilterFacade(ArrayList<Member> members, ArrayList<String> searchParams) {
        this.filteredMembers = new ArrayList<Member>();
        this.members = members;
        this.searchParams = searchParams;
        this.temporaryMembers = members;

        }
    public ArrayList<Member> filter() {
        int i;
        boolean and = false;
        for(i = 0; i < searchParams.size(); i++){
            if(this.searchParams.get(i).equals("or")){
                and=false;
                temporaryMembers = members;
            } else if (this.searchParams.get(i).equals("and")){
                and=true;
                //temporaryMembers = filteredMembers;
                temporaryMembers = new ArrayList<Member>(filteredMembers);
            }

            if(this.searchParams.get(i).equals("byName")){
                if(and==true){
                    filteredMembers.clear();
                }
                filteredMembers.addAll(new NameFilterStrategy(this.searchParams.get(i+1)).filter(this.temporaryMembers));
                //skipping one loop if it is a
                i++;
            }else if(this.searchParams.get(i).equals("overAge")){
                if(and==true){
                    filteredMembers.clear();
                }
                filteredMembers.addAll(new OlderThanFilterStrategy(Integer.parseInt(this.searchParams.get(i+1))).filter(this.temporaryMembers));
                //skipping one loop if it is a
                i++;
            }else if(this.searchParams.get(i).equals("underAge")){
                if(and==true){
                    filteredMembers.clear();
                }
                filteredMembers.addAll(new YoungerThanFilterStrategy(Integer.parseInt(this.searchParams.get(i+1))).filter(this.temporaryMembers));
                //skipping one loop if it is a
                i++;
            }
        }
        return this.filteredMembers;

    }

    }


