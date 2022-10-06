import java.util.ArrayList;
import java.util.Arrays; // в данном примере использую чтобы быстро использовать встроенный метод toString


public class Main {
    public static void main(String[] args) {
        //Задание №1
        Integer[] testArr1 = {1, 2, 3, 4};
        System.out.print("Первоначальное состояние массива arr:");
        System.out.println(Arrays.toString(testArr1));
        SwapTwoArrayElements(testArr1, 1, 2);
        System.out.print("Результат работы метода перестановки:");
        System.out.println(Arrays.toString(testArr1));
        String[] testArr2 = {"Первый", "Второй", "Третий", "Четвертый"};
        System.out.print("Первоначальное состояние массива arr:");
        System.out.println(Arrays.toString(testArr2));
        SwapTwoArrayElements(testArr2, 1, 2);
        System.out.print("Результат работы метода перестановки:");
        System.out.println(Arrays.toString(testArr2));
    }

    // Метод работает с обобщенным типом данных, теперь ему все равно какой массив придет на вход.
    public static <T> void SwapTwoArrayElements(T[] modifiableArray, int elemNum1, int elemNum2) {
        T backupElement = modifiableArray[elemNum1];
        modifiableArray[elemNum1] = modifiableArray[elemNum2];
        modifiableArray[elemNum2] = backupElement;
    }
}

    
        
