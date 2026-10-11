class StockSpanner {
         Stack<Integer> stock;
         ArrayList<Integer> lst;
         int c;
    public StockSpanner() {
        stock = new Stack<>();
        lst = new ArrayList<>();
       
    }
    
    public int next(int price) {
         c=1;
        while(!stock.isEmpty() && stock.peek()<=price ){
          stock.pop();
          c += lst.remove(lst.size()-1);
        }
        stock.push(price);
        lst.add(c);
        return c;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */