package org.LLD.LibraryManagement.Repository;

import org.LLD.LibraryManagement.Model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    List<Member> members = new ArrayList<>();

    public void addMembers(List<Member> members) {
        this.members.addAll(members);
    }
}
