package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Member> listOfStudents = new ArrayList<Member>();
        List<Member> listOfTeachers = new ArrayList<Member>();
        List<Member> listOfStaff = new ArrayList<Member>();

        listOfStudents.add(new Member("John", 18));
        listOfStudents.add(new Member("Jim", 28));
        listOfStudents.add(new Member("Jeb", 22));

        listOfTeachers.add(new Member("Anna", 45));
        listOfTeachers.add(new Member("Ann", 25));
        listOfTeachers.add(new Member("Lisa", 55));

        listOfStaff.add(new Member("Ivan", 55));
        listOfStaff.add(new Member("Boris", 35));
        listOfStaff.add(new Member("Sergey", 25));

        MembersGroup firstGroup = new MembersGroup("Students", listOfStudents);
        MembersGroup secondGroup = new MembersGroup("Teachers", listOfTeachers);
        MembersGroup thirdGroup = new MembersGroup("Staff", listOfStaff);

        List<MembersGroup> groups = new ArrayList<MembersGroup>();
        groups.add(firstGroup);
        groups.add(secondGroup);
        groups.add(thirdGroup);

        Finder finder = new Finder();

        System.out.println(finder.findOldMembers(groups, 30));
        System.out.println(finder.newFindOldMembers(groups, 30));
        System.out.println(finder.improvedNewFindOldMembers(groups, 30));
    }
}
