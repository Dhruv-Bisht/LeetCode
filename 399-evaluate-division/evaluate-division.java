class Solution {

    public double DFS(String src, String target, double prod, 
        HashSet<String> visited,
        HashMap<String, HashMap<String,Double >> map
    ){
        double res = -1.0;
        visited.add(src);

        // if next to neighbour
        if(map.get(src).containsKey(target))
        {
            res = prod * map.get(src).get(target);
        }
        else{
            for(String neighbour: map.get(src).keySet()){
                if(! visited.contains(neighbour)){
                    res = DFS(neighbour, 
                            target, 
                            prod*map.get(src).get(neighbour), 
                            visited,
                            map
                    );
                    
                    if(res != -1.0){
                        break;
                    }
                }
            }
        }
        visited.remove(src);
        return res;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // create adjancey matrix.
        HashMap<String,HashMap<String, Double>> map = new HashMap<>();

        for(int i=0; i<equations.size(); i++){
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];
            
            // creating the relation.
            // a -> (b, 2.0) 
            if(!map.containsKey(dividend)){
                map.put(dividend, new HashMap<String, Double>());
            }
            // b -> (a, 1/2.0)
            if(!map.containsKey(divisor)){
                map.put(divisor, new HashMap<String, Double>());
            }

            // inserting the value
            map.get(dividend).put(divisor, value);
            map.get(divisor).put(dividend, 1/value);

        }

        // double array to store result of each query
        double[] res = new double[queries.size()];

        for(int i=0; i<queries.size(); i++){
            
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            // ex:- e or x.
            if(!map.containsKey(dividend) || !map.containsKey(divisor)){
                res[i] = -1.0;
            }

            // ex:- a/a
            else if(dividend.equals(divisor)){
                res[i] = 1.0;
            }

            // Multiply
            else{
                HashSet<String> visited = new HashSet<>();
                res[i] = DFS(dividend, divisor, 1, visited, map);
            }
        }

        return res;
    }
}