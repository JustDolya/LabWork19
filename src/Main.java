interface ClothesForMen{
    void dressAMan();
}

interface ClothesForWomen{
    void dressAWoman();
}

public class Main {

    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(Size.L, 1000, "white"),
                new Pants(Size.L, 2000, "black"),
                new Skirt(Size.S, 9999, "yellow"),
                new Tie(100000, "Bugs Bunny print")
        };
        Studio studio = new Studio(clothes);
        studio.dressAMan(studio.wardrobe);
        studio.dressAWoman(studio.wardrobe);
    }
}

enum Size{
    XXS(32),
    XS(34),
    S(36),
    M(38),
    L(40);
    int euroSize;
    Size(int euroSize){
        this.euroSize = euroSize;
    }
    public void getDescription(){
        System.out.println("Взрослый размер");
    }
    public void getDescription(Size XXS){
        System.out.println("Детский размер");
    }
}

abstract class Clothes{
    Size size;
    int price;
    String color;
}

class TShirt extends Clothes implements ClothesForMen, ClothesForWomen{
    TShirt(Size size, int price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }
    public void dressAMan() {
        System.out.println("Футболка цвета " + color + " размера " + size + " по цене " + price);
    }
    public void dressAWoman() {
        System.out.println("Футболка цвета " + color + " размера " + size + " по цене " + price);
    }
}

class Pants extends Clothes implements ClothesForMen, ClothesForWomen{
    Pants(Size size, int price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }
    public void dressAMan() {
        System.out.println("Штаны цвета " + color + " размера " + size + " по цене " + price);
    }
    public void dressAWoman() {
        System.out.println("Штаны цвета " + color + " размера " + size + " по цене " + price);
    }
}

class Skirt extends Clothes implements ClothesForWomen{
    Skirt(Size size, int price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }
    public void dressAWoman() {
        System.out.println("Юбка цвета " + color + " размера " + size + " по цене " + price);
    }
}

class Tie extends Clothes implements ClothesForMen{
    Tie(int price, String color){
        this.price = price;
        this.color = color;
    }
    public void dressAMan() {
        System.out.println("Галстук цвета " + color + " по цене " + price);
    }
}

class Studio{
    Clothes[] wardrobe;
    Studio(Clothes[] wardrobe){
        this.wardrobe = wardrobe;
    }
    public void dressAMan(Clothes[] wardrobe){
        System.out.println("Мужской гардероб:");
        for (Clothes clothes : wardrobe){
            if (clothes instanceof ClothesForMen){
                ((ClothesForMen) clothes).dressAMan();
            }
        }
    }
    public void dressAWoman(Clothes[] wardrobe){
        System.out.println("Женский гардероб: ");
        for (Clothes clothes : wardrobe){
            if (clothes instanceof ClothesForWomen){
                ((ClothesForWomen) clothes).dressAWoman();
            }
        }
    }
}