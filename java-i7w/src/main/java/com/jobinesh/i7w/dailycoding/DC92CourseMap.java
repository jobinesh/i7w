package com.jobinesh.i7w.dailycoding;

import java.util.*;

/**
 * We're given a hashmap associating each courseId key with a list of courseIds values, which represents that the prerequisites of courseId are courseIds. Return a sorted ordering of courses such that we can finish all courses.
 *
 * Return null if there is no such ordering.
 *
 * For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSCS300'].
 */
public class DC92CourseMap {

    public List getPreRequisite(Map<String, List<String>> courseMap, String courseId){
        List<String> preRequisite = new ArrayList();
        resolveAllDependencies(courseMap,courseId, preRequisite );
        Collections.sort(preRequisite );
        return preRequisite;
    }

    private void resolveAllDependencies(Map<String, List<String>> courseMap, String courseId, List preRequisite){
        List<String> courses= courseMap.get(courseId);
        if(courses==null){
            return;
        }
        preRequisite.add(courses);
         for(String course: courses ){
             resolveAllDependencies(courseMap, courseId, preRequisite);
        }

    }
    public static void main(String[] args){
        HashMap map = new HashMap();
        List list1 =  List.of("CSC100", "CSC200");
        List list2 = List.of("CSC100");
        List list3 = Collections.EMPTY_LIST;
        map.put("CSC300", list1);
        map.put("CSC200", list2);
        map.put("CSC100", list2);
        System.out.println(new DC92CourseMap().getPreRequisite(map, ));
    }
}
