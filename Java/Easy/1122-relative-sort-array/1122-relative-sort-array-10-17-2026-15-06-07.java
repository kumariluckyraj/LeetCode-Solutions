class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0; i<arr1.length; i++){
             lst.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            map.put(arr2[i], i );
        }
        Collections.sort(lst, (a,b)->{
            if(map.containsKey(a)&&map.containsKey(b)){
                return map.get(a)-map.get(b);
            }else if(map.containsKey(a)){
                return -1;
            }else if(map.containsKey(b)){
                return 1;
            }else{
                return a-b;
            }
        });

        for(int i=0; i<arr1.length; i++){
            arr1[i] = lst.get(i);
        }
        return arr1;
    }
}