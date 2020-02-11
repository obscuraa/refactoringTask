package com.company;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Finder {
    /**
     * Поиск групп людей старше определенного возраста. * * @param groups группы * @param targetAge возраст для поиска * @return список имен групп из списка групп старше возраста targetAge
     */
    public Set<String> findOldMembers(List<MembersGroup> groups, int targetAge) {
        Set<String> groupsNames = new HashSet<>();

        for (MembersGroup membersGroup : groups) {
            for (Member member : membersGroup.getMembers()) {
                if (member.getAge() > targetAge) {
                    String name = member.getName();
                    groupsNames.add(name);
                }
            }
        }

        return groupsNames;
    }

    //Новый метод, но время выполнения 2n^(2)
    public Set<String> newFindOldMembers(List<MembersGroup> groups, int targetAge) {
        Set<String> groupsNames = new HashSet<>();

        groups.stream()
                .forEach(gr -> {
                    gr.getMembers()
                            .forEach(member -> {
                                if (member.getAge() > targetAge) {
                                    groupsNames.add(member.getName());
                                }
                            });
                });

        return groupsNames;
    }

    //Улучшенный метод.
    public Set<String> improvedNewFindOldMembers(List<MembersGroup> groups, int targetAge) {
        //Set<String> groupsNames = new HashSet<>();

        return groups.stream()
                .map(MembersGroup::getMembers)
                .flatMap(Collection::stream)
                .filter(member -> member.getAge() > targetAge)
                .map(Member::getName)
                .collect(Collectors.toSet());
    }
}
