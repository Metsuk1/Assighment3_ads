package entity;
/**
 * Class for testing MyHashTable with custom hashCode.
 */
public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id,String name){
        this.id=id;
        this.name=name;
    }


    @Override
    public int hashCode() {
       int res = id;
       if(name != null){
           for(int i = 0;i < name.length();i++){
               res = 31 * res + name.charAt(i);
           }
       }

        return res;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
