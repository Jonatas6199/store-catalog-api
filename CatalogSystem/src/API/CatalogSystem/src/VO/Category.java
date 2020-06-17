package VO;

public class Category extends StandardVO {
    private String name = "";

    public void setName(String categoryName) throws Exception {
        if(categoryName.isEmpty() || categoryName.isBlank())
            throw new Exception("categoryName não pode ser nulo ou vazio");
        else{
            name = categoryName;
        }
    }
    public String getName(){
        return name;
    }
}
