package Test;

public class Test05200925{

    static class Single{

        public int self(int i) {

                if (i <= 1) {
                    return i;
                }else{
                    return self(i-1)+i;
                }
            
        }
    }
    public static void main(String[] args) {
        Single s = new Single();
       System.out.println(s.self(10));
    }
}  