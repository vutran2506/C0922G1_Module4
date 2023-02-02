public class Main {
    public static void main(String[] args) {

        System.out.println(solution(9,13));
    }
    public  static int solution(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            String number = String.valueOf(i);
            if(number.charAt(0)== number.charAt(number.length()-1)){
                count +=1;
            }
        }     return count;
    }
}