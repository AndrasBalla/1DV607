package model.searchStrategy;

import model.Member;

import java.util.ArrayList;

public interface IFilter {
    public ArrayList<Member> filter(ArrayList<Member> members);
}
