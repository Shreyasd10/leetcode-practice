import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> courseMap = new HashMap<>();
        Set<Integer> path = new HashSet<>();
        Set<Integer> checked = new HashSet<>();

        for(int i = 0; i<numCourses ;i++){
            courseMap.put(i,new ArrayList<>());
        }

        for(int i = 0; i<prerequisites[1].length; i++){
            courseMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int course = 0; course < numCourses ; course++){
            if(hasCycle(course,courseMap,path,checked)){
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(int course, Map<Integer, List<Integer>> courseMap, Set<Integer> path, Set<Integer> checked) {

        if(path.contains(course)) return true;
        if(checked.contains(course)) return false;

        path.add(course);

        for(int prerequisite : courseMap.get(course)){
            if(hasCycle(prerequisite,courseMap,path,checked)){
                return true;
            }
        }

        path.remove(course);
        checked.add(course);

        return false;
    }
}
