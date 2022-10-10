
//Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
// Для хранения фруктов внутри коробки можно использовать ArrayList;

import java.util.ArrayList;

public class Box {
        private ArrayList<Fruit> deliciousFruits = new ArrayList<>();

        public Box(){
            ArrayList<Fruit> deliciousFruits =new ArrayList<>();
        }

        //Метод для возврата веса коробки
    public double getWeight(){
            double sumFruits = 0.0f;
            for (Fruit e: deliciousFruits){
                sumFruits += e.getWeight();
            }
            return sumFruits;
    }

    //Метод добавляет в коробку один элемент
        public void add (Fruit fruit){
            if (deliciousFruits.size()>1){
                if(identicalFruits(fruit)){        //разные фрукты
                    throw new BoxCustomException("Это разные фрукты."); //Исключение
                }
            }
            deliciousFruits.add(0,fruit);
        }

        //Сравниваем коробки по весу
        public boolean compare(Box box){
            //Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
                return Math.abs(getWeight()-box.getWeight())<0.0001;
        }

    // метод позволяет достать из коробки 1 элемент (без привязки куда его затем класть)
    public void removeSingleItem() {

    }
    // метод позволяет перекладывать из коробки 1 в коробку 2 заданное количество элементов
    // (имеет защиту - проверяет возможность перекладывания, если условие false элемент из коробки не уйдет)
    // метод выполняет задачу поэлементно (можно сделать сразу много или все методом addAll)
    public void shiftSingleItem(Box box2) throws BoxCustomException {
        // цикл foreach не подходит для пересыпания с одновременным контролем и удалением перекладываемых элементов
        // проверка на сопоставимость наполнения коробок
        if (identicalFruits(box2)) {
            throw new BoxCustomException("Внимание! Смешивать товары запрещено, используйте другой товар или коробку!");
        }
        for (int i = deliciousFruits.size() - 1; i >= 0; i--) {
            box2.getProduct().add(deliciousFruits.get(i));
            deliciousFruits.remove(i);
        }
    }
    // Метод создан для предоставления доступа к ArrayList продуктов которые кв коробке (для безопасности)
    public ArrayList<Fruit> getProduct() {
        return deliciousFruits;
    }
    // метод который позволяет определить сопоставимы ли продукты по типу в коробке и вне ее.
    public boolean identicalFruits(Box otherBox) {
        return deliciousFruits.get(0).getClass() != otherBox.getProduct().get(0).getClass();
    }

    // Перегруженный метод (мне понравилось ими пользоваться)
    public boolean identicalFruits(Fruit fruit) {
        return deliciousFruits.get(0).getClass() != fruit.getClass();
    }



}
