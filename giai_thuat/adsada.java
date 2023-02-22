public class adsada {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3};
        int s = arr.length;
        boolean a = true;
        int b =0 ;
        for (int i = 0; i <= s; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != arr[j]) {
                    a = true;
                    break;
                }else {
                    a = false;
                    b = i;
                }
            }
            if (!a){
                break;
            }
        }
        System.out.println(b);
    }
}