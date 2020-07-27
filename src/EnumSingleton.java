public enum EnumSingleton {
    INSTNACE;
    int age=10;
    String name="JP";
    public int getAge(){
        return age;
    }
    public void setAge(int age) throws NullPointerException{
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public static void main(String[] arg){
        EnumSingleton obj = EnumSingleton.INSTNACE;
        System.out.println(obj.name());
    }
}
