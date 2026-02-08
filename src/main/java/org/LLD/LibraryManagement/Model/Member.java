package org.LLD.LibraryManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Member {
    int memberId;
    String memberName;
    private List<Loan> activeLoans;

    public Member(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
        activeLoans = new ArrayList<>();
    }

}
