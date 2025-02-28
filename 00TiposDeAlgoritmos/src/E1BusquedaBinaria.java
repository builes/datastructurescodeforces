public class E1BusquedaBinaria {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 8 , 14, 25, 64, 95};

        System.out.println(binarySearch(numbers, 64));
    }

    static int binarySearch(int[] numbers, int target){
        int left = 0;
        int right = numbers.length -1;

        while (left <= right){
            int halfValue = (left + right) /2;

            if(numbers[halfValue] == target){
                return halfValue;
            } else if (numbers[halfValue] > target) {
                right = halfValue - 1;
            }else if(numbers[halfValue] < target){
                left = halfValue + 1;
            }
        }


        return -1;
    }
}
