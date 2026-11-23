class ProductOfNumbers {
                ArrayList<Integer> lst;
    public ProductOfNumbers() {
        lst = new ArrayList<>();
    }
    
    public void add(int num) {
        lst.add(num);
    }
    
    public int getProduct(int k) {
        int n = lst.size()-k;
        int ans =1;
        for(int i=0; i<lst.size(); i++){
            if(i>=n){
                  ans *= lst.get(i);
            }
        }
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */